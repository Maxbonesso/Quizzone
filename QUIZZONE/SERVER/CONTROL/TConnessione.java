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
	
	public TConnessione(Socket socket, Socket s1, DefaultListModel dlm, Gestione g)
	{
		this.g = g;
		s = socket;
		this.s1 = s1;
		flag = 0;
		this.dlm = dlm;
		indici = new ArrayList<Integer>();
	}
	
	@Override
	public void run(){
		
		String ret = new String();
		Double d = Math.random()*100;
		numero = d.intValue();
		InputStreamReader isr;
		PrintWriter out;
		dlm.addElement("Nuovo client connesso al server!!!");	
		
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
				
				//riceve la rispsota dal primo client
				isr = new InputStreamReader(s.getInputStream());
				BufferedReader in = new BufferedReader(isr);
				haiVinto(in.readLine());
				
				//riceve la risposta dal secodno client
				isr = new InputStreamReader(s1.getInputStream());
				in = new BufferedReader(isr);
				haiVinto(in.readLine());
				
				ret = "Ciao";
				
				flag++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void controlloNumero(int n)
	{
		
	}
}