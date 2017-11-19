package CONTROL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

import MODEL.Domanda;
import MODEL.Gestione;

public class TConnessione extends Thread {
	
	private Socket s;
	private Socket s1;
	private int flag;
	private Gestione g;
	private ArrayList<Integer> indici;
	private Random rand = new Random();
	private Domanda d;
	private String str1;
	private String str2;
	private ArrayList<Integer> vittorie;
	private InputStreamReader isr;
	private PrintWriter out;
	
	public TConnessione(Socket socket, Socket socket1, Gestione g)
	{
		this.s = socket;
		this.g = new Gestione();
		this.s1 = socket1;
		flag = 0;
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
			out.println("$Iniziamo!$");
			
			out = new PrintWriter(s1.getOutputStream(), true);
			out.println("$Iniziamo!$");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Errore inizio gioco");
			System.exit(2);
		}
		
		
		while(flag<10)
		{	
			try {
				
				//ricava domanda casuale dal database
				int n;
				do
				{
					n = rand.nextInt(19) + 1;
				}while(indici.contains(n));
				d = g.getDomanda(n);
				String invio = d.codificaCasuale();
				
				//manda al primo client la domanda
				out = new PrintWriter(s.getOutputStream(), true);
				out.println(invio);
				
				//manda al secondo client la domanda
				out = new PrintWriter(s1.getOutputStream(), true);
				out.println(invio);
				
				//riceve la risposta dal primo client
				isr = new InputStreamReader(s.getInputStream());
				BufferedReader in = new BufferedReader(isr);
				str1 = in.readLine();
				
				//riceve la risposta dal secondo client
				isr = new InputStreamReader(s1.getInputStream());
				in = new BufferedReader(isr);
				str2 = in.readLine();
				
				haiVinto();		//metodo che controllo chi ha indovinato ed assegna i punteggi
				
				flag++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//comunicazioni delle vittorie, delle sconfitte e dei pareggi ai client
		}
		
			try {
				
				if(vittorie.get(0) > vittorie.get(1))
				{
					
					out = new PrintWriter(s.getOutputStream(), true);
					out.println("$vinto$" + vittorie.get(0) + "$");
					
					out = new PrintWriter(s1.getOutputStream(), true);
					out.println("$perso$" + vittorie.get(1) + "$");
				}
				else if(vittorie.get(0) < vittorie.get(1))
				{
					
					out = new PrintWriter(s1.getOutputStream(), true);
					out.println("$vinto$" + vittorie.get(1) + "$");
					
					out = new PrintWriter(s.getOutputStream(), true);
					out.println("$perso$" + vittorie.get(0) + "$");
				}
				else
				{
					
					out = new PrintWriter(s.getOutputStream(), true);
					out.println("$pareggio$" + vittorie.get(0) + "$");
					
					out = new PrintWriter(s1.getOutputStream(), true);
					out.println("$pareggio$" + vittorie.get(1) + "$");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	} //termina run del thread
	
	private void haiVinto()
	{	
		if(haIndovinato(str1) && haIndovinato(str2))	//tutti e due i giocatori hanno indovinato
		{
			if(tempo(str1) > tempo(str2))			//calcola chi ha risposto nel tempo minore
			{
				comVittoria(0);
			}
			else if(tempo(str1) < tempo(str2))
			{
				comVittoria(1);
			}
			else						//in caso di tempo uguale assegna a tutti e due
			{
				comVittoria(0);
				comVittoria(1);
			}
		}
		else if (haIndovinato(str1))		//uno solo ha indovinato
		{
			comVittoria(0);
		}
		else if (haIndovinato(str2))		//uno solo ha indovinato
		{
			comVittoria(1);
		}
		
	}
	
	private boolean haIndovinato(String s)			//capisce se il client ha indovinato la risposta
	{
		boolean ret = false;
		
		int n = s.indexOf("$", 1);
		
		if(Integer.parseInt(s.substring(1, n)) == d.getRispG())
			ret = true;
		
		return ret;
	}
	
	private int tempo(String z)						//ritorna il tempo di risposta
	{
		int n = z.indexOf("$", 1);
		int n1 = z.indexOf("$", n+1);
		String stringa1 = z.substring(n+1, n1);
		
		return Integer.parseInt(stringa1);
	}
	
	private boolean comVittoria(int n)				//gestisce il punteggio totale
	{
		boolean ret = true;

		vittorie.set(n, vittorie.get(n) + 1);
			
		return ret;
	}
}