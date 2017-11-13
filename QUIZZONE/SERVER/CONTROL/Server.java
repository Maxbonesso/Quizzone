package CONTROL;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.DefaultListModel;

import MODEL.Gestione;

public class Server extends Thread {
	
	private ServerSocket ss;
	private DefaultListModel dlm;
	private int connessioni;
	private Gestione g;
	
	public Server(DefaultListModel dlm, int porta, Gestione g)
	{
		this.g = g;
		this.dlm = dlm;
		try {
			ss = new ServerSocket(porta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Errore nella creazione del serversocket");
			System.exit(1);
		}
		connessioni = 0;
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			stampaDati();
			
			//riceve la connessione
			Socket s;
			Socket s1;
			try {
				s = ss.accept();
				connessioni++;
				
				stampaDati();
				
				s1 = ss.accept();
				connessioni++;
				TConnessione tc = new TConnessione(s, s1, g, dlm);
				tc.start();
				
				stampaDati();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	private void stampaDati()
	{
		String s;
		
		s= new String("Si sono connessi " + connessioni +" client al server");
		dlm.addElement(s);
	}
}
