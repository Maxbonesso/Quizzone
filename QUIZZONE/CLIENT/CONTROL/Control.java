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

public class Control implements ActionListener{

	private Frame f;
	private Intro i;
	private Indirizzo ind;
	private Client c;
	private String luogo;

	public Control(Frame f, Intro i, Indirizzo ind) throws IOException {
		this.f=f;
		this.i=i;
		this.ind = ind;

		f.getRisp1().addActionListener(this);
		f.getRisp2().addActionListener(this);
		f.getRisp3().addActionListener(this);
		f.getRisp4().addActionListener(this);
		i.getBtnPlay().addActionListener(this);
		ind.getBtnInserisci().addActionListener(this);
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
			try {
				c.invio("$1$5$");
				this.domanda();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(evt.getSource()==f.getRisp2()){
			try {
				c.invio("$2$5$");
				this.domanda();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(evt.getSource()==f.getRisp3()){
			try {
				c.invio("$3$5$");
				this.domanda();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(evt.getSource()==f.getRisp4()){
			try {
				c.invio("$4$5$");
				this.domanda();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void domanda(){
		
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
	
	
}