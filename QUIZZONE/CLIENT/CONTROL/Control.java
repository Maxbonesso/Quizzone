package CONTROL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;

import VIEW.Frame;
import VIEW.Indirizzo;
import VIEW.Intro;
import VIEW.Vittoria;

public class Control implements ActionListener{

	private Frame f;
	private Intro i;
	private Indirizzo ind;
	private Vittoria v;
	private Client c;
	private String luogo;
	private int cont=0;
	private Thread conta;

	public Control(Frame f, Intro i, Indirizzo ind, Vittoria v) throws IOException {
		this.f=f;
		this.i=i;
		this.ind = ind;
		this.v = v;

		f.getRisp1().addActionListener(this);
		f.getRisp2().addActionListener(this);
		f.getRisp3().addActionListener(this);
		f.getRisp4().addActionListener(this);
		i.getBtnPlay().addActionListener(this);
		ind.getBtnInserisci().addActionListener(this);
		v.getBtnRicomincia().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==ind.getBtnInserisci()){
			luogo=ind.getIndirizzo().getText();
			c=new Client(luogo);
			ind.setVisible(false);
			i.setVisible(true);
		}
		else if(evt.getSource()==i.getBtnPlay()){
			i.getBtnPlay().setEnabled(false);
			
			c.creaConnessione();
			
			try {
				c.attendi();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.domanda();
			
			i.setVisible(false);
			f.setVisible(true);
		}
		else if(evt.getSource()==f.getRisp1()){
			this.risposta(1);
		}
		else if(evt.getSource()==f.getRisp2()){
			this.risposta(2);
		}
		else if(evt.getSource()==f.getRisp3()){
			this.risposta(3);
		}
		else if(evt.getSource()==f.getRisp4()){
			this.risposta(4);
		}
		else if(evt.getSource()==v.getBtnRicomincia()) {
			v.setVisible(false);
			i.setVisible(true);
			c.close();
		}
	}
	
	public void risposta(int num){
		
		conta.interrupted();
		cont++;
		if(cont<10) {
			try {
				c.invio("$"+num+"$"+f.getContatore().getText()+"$");
				this.domanda();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				c.invio("$5$5$");
				this.risultato();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void domanda(){
		
		try {
			conta=new Contatore(f);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		conta.start();
		
		String text="";
		try {
			text = c.getText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<JButton> risposte=new ArrayList<JButton>();
		risposte.add(f.getRisp1());
		risposte.add(f.getRisp2());
		risposte.add(f.getRisp3());
		risposte.add(f.getRisp4());
		
		int n1,n = text.indexOf("$", 1);
		String stringa = text.substring(1, n);
		f.getDomanda().setText(stringa);
		
		for(int i=0; i<risposte.size();i++){
			n1 = text.indexOf("$", n+1);
			stringa = text.substring(n+1, n1);
			risposte.get(i).setText(stringa);
			n = n1;
		}
	}
	
	public void risultato() {
		String text="";
		try {
			text = c.getText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int n1,n = text.indexOf("$", 1);
		String stringa = text.substring(1, n);
		f.getDomanda().setText(stringa);
		
		f.setVisible(false);
		v.setVisible(true);
		v.getRisultato().setText(stringa);
	}
	
	
	
}