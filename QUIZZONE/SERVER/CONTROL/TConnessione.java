package CONTROL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultListModel;

import MODEL.Domanda;
import MODEL.Gestione;

public class TConnessione extends Thread {
	
	private Socket s;
	private Socket s1;
	private int numero;
	private int flag;
	private DefaultListModel dlm;
	private Gestione g;
	private ArrayList<Integer> indici;
	private Random rand = new Random();
	private Domanda d;
	private String str1;
	private String str2;
	private ArrayList<Integer> vittorie;
	private InputStreamReader isr;
	private PrintWriter out;
	
	public TConnessione(Socket socket, Socket s1, DefaultListModel dlm, Gestione g)
	{
		this.g = g;
		s = socket;
		this.s1 = s1;
		flag = 0;
		this.dlm = dlm;
		indici = new ArrayList<Integer>();
		vittorie = new ArrayList<Integer>();
		vittorie.add(0);
		vittorie.add(0);
	}
	
	@Override
	public void run(){
		
		//scrive ai client che inizia il gioco
		try {
			out = new PrintWriter(s.getOutputStream(), true);
			out.println("Iniziamo!");
			
			out = new PrintWriter(s1.getOutputStream(), true);
			out.println("Iniziamo!");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Errore inizio gioco");
			System.exit(2);
		}
		
		
		while(flag<10)
		{	
			try {
				int n;
				do
				{
					n = rand.nextInt(19) + 1;
				}while(indici.contains(n));
				Domanda domanda = g.getDomanda(n);
				
				//manda al primo client la domanda
				String invio = domanda.codifica();
				out = new PrintWriter(s.getOutputStream(), true);
				out.println(invio);
				
				//manda al secondo client la domanda
				out = new PrintWriter(s1.getOutputStream(), true);
				out.println(invio);
				
				//riceve la risposta dal primo client
				isr = new InputStreamReader(s.getInputStream());
				BufferedReader in = new BufferedReader(isr);
				str1 = in.readLine();
				
				//riceve la risposta dal secodno client
				isr = new InputStreamReader(s1.getInputStream());
				in = new BufferedReader(isr);
				str2 = in.readLine();
				
				haiVinto();
				
				flag++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			try {
				
				if(vittorie.get(0) > vittorie.get(1))
				{
					out = new PrintWriter(s.getOutputStream(), true);
					out.println("Hai vinto il gioco, congraturazioni!!");
				}
				else if(vittorie.get(0) < vittorie.get(1))
				{
					out = new PrintWriter(s1.getOutputStream(), true);
					out.println("Hai vinto il gioco, congraturazioni!!");
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private void haiVinto()
	{
		String str1 = "$2$8$";
		
		if(haIndovinato(str1) && haIndovinato(str2))
		{
			if(tempo(str1) < tempo(str2))
			{
				comVittoria(0);
				comSconfitta(1);
			}
			else if(tempo(str1) > tempo(str2))
			{
				comVittoria(1);
				comSconfitta(1);
			}
			else
			{
				comVittoria(0);
				comVittoria(1);
			}
		}
		else if (haIndovinato(str1))
		{
			comVittoria(0);
			comSconfitta(1);
		}
		else if (haIndovinato(str2))
		{
			comVittoria(1);
			comSconfitta(0);
		}
		else
		{
			comSconfitta(0);
			comSconfitta(1);
		}
		
	}
	
	private boolean haIndovinato(String s)
	{
		boolean ret = false;
		
		int n = str1.indexOf("$", 1);
		if(Integer.parseInt(str1.substring(1, n)) == d.getRispG())
			ret = true;
		
		return ret;
	}
	
	private int tempo(String z)
	{
		int n = str1.indexOf("$", 1);
		int n1 = str1.indexOf("$", n+1);
		String stringa1 = str1.substring(n+1, n1);
		
		return Integer.parseInt(stringa1);
	}
	
	private boolean comVittoria(int n)
	{
		boolean ret = false;

			try {
				
				if(n == 0)
				{
					out = new PrintWriter(s.getOutputStream(), true);
					out.println("Congraturazioni hai vinto!!!");
					ret = true;
				}
				else if (n == 1)
				{
					out = new PrintWriter(s1.getOutputStream(), true);
					out.println("Congraturazioni hai vinto!!!");
					ret = true;
				}
				
				vittorie.set(n, vittorie.get(n)+1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return ret;
	}
	
	private boolean comSconfitta(int n)
	{
		boolean ret = false;

		try {
			
			if(n == 0)
			{
				out = new PrintWriter(s.getOutputStream(), true);
				out.println("Risposta errata");
				ret = true;
			}
			else if (n == 1)
			{
				out = new PrintWriter(s1.getOutputStream(), true);
				out.println("Risposta errata");
				ret = true;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return ret;
	}
}