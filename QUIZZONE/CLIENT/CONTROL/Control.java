package CONTROL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import VIEW.Frame;
import VIEW.Indirizzo;
import VIEW.Intro;

public class Control implements ActionListener{

	private Frame f;
	private Intro i;
	private Indirizzo ind;
	private String luogo;

	public Control(Indirizzo ind) throws IOException {
		this.ind = ind;
		
		ind.getBtnInserisci().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==ind.getBtnInserisci()){
			luogo=ind.getIndirizzo().getText();
			
			ind.close();
			i=new Intro();
			i.getBtnPlay().addActionListener(this);
			
			try {
				ServerSocket ss=new ServerSocket(9999);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		if(evt.getSource()==i.getBtnPlay()){
			try {
				Socket s=new Socket(luogo, 9999);
				i.getBtnPlay().setEnabled(false);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			f=new Frame();
			f.getRisp1().addActionListener(this);
			f.getRisp2().addActionListener(this);
			f.getRisp3().addActionListener(this);
			f.getRisp4().addActionListener(this);
		}
		
	}
	
	
}


class Grafica1 extends Thread{
	
}