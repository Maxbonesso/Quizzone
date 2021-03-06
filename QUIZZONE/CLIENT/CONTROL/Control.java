package CONTROL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

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
	private int cont=1;
	private Thread conta;
	private boolean flag;
	private Clip clip1;

	public Control(Frame f, Intro i, Indirizzo ind, Vittoria v) throws IOException {
		this.f=f;
		this.i=i;
		this.ind = ind;
		this.v = v;
		conta = null;

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
			sceltaImmagine(0);
			suonoIntro();
		}
		else if(evt.getSource()==i.getBtnPlay()){
			JOptionPane.showMessageDialog(null, "Attendi che si connetta un altro client per giocare","ATTESA",1);
			clip1.stop();
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
			this.risposta(1,false);
		}
		else if(evt.getSource()==f.getRisp2()){
			this.risposta(2,false);
		}
		else if(evt.getSource()==f.getRisp3()){
			this.risposta(3,false);
		}
		else if(evt.getSource()==f.getRisp4()){
			this.risposta(4,false);
		}
		else if(evt.getSource()==v.getBtnRicomincia()) {
			v.setVisible(false);
			i.setVisible(true);
			i.getBtnPlay().setEnabled(true);
			suonoIntro();
			cont=1;
			c.close();
		}
	}
	
	public void risposta(int num, boolean flag){
		
		if(conta != null && flag==false)
			conta.stop();
		
		try {
			c.invio("$"+num+"$"+f.getContatore().getText()+"$");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(num == -1){
			c.close();
			System.exit(0);
		}
		
		if(cont<10) {
			this.domanda();
			cont++;
		}else {
			
			this.risultato();
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
		
		if(f.getChiudi()){
			risposta(-1,false);
		}
		
		ArrayList<JButton> risposte=new ArrayList<JButton>();
		risposte.add(f.getRisp1());
		risposte.add(f.getRisp2());
		risposte.add(f.getRisp3());
		risposte.add(f.getRisp4());
		
		int n1,n = text.indexOf("$", 1);
		String stringa = text.substring(1, n);
		if(stringa.equals("vinto")){
			cont=10;
			risultato(text);
		}
		else{

			conta=new Contatore(f, this);
			conta.start();
			
			f.getDomanda().setText(stringa);
			
			for(int i=0; i<risposte.size();i++){
				n1 = text.indexOf("$", n+1);
				stringa = text.substring(n+1, n1);
				risposte.get(i).setText(stringa);
				n = n1;
			}
		}
	}
	
	private void risultato() {
		String text="";
		try {
			text = c.getText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int n1,n = text.indexOf("$", 1);
		String stringa, ris = text.substring(1, n);
		n1 = text.indexOf("$", n+1);
		stringa = text.substring(n+1, n1);
		v.getEsatte().setText("Numero risposte indovinate: "+stringa);
		
		
		if(ris.equals("vinto")){
			v.getRisultato().setText("HAI VINTOO!!");
			v.getCongrat().setText("Congratulazioniii!!");
			media("/media/APPLAU22.WAV");
			sceltaImmagine(1);
		}
		else if(ris.equals("pareggio")){
			v.getRisultato().setText("PAREGGIO!");
			v.getCongrat().setText("Ritenta,sarai pi� fortunato");
			media("/media/I-QUIT2.wav");
			sceltaImmagine(2);
		}
		else{
			v.getRisultato().setText("HAI PERSO!");
			v.getCongrat().setText("Ritenta,sarai pi� fortunato");
			media("/media/I-QUIT2.wav");
			sceltaImmagine(3);
		}

		f.setVisible(false);
		v.setVisible(true);
	}
	
	private void risultato(String s){
		int n1,n = s.indexOf("$", 1);
		String stringa, ris = s.substring(1, n);
		n1 = s.indexOf("$", n+1);
		stringa = s.substring(n+1, n1);
		v.getEsatte().setText("Numero risposte indovinate: "+stringa);
		
		
		if(ris.equals("vinto")){
			
			v.getRisultato().setText("HAI VINTOOO!!");
			if(cont==9){
				v.getCongrat().setText("Congratulazioniii!!");
			}
			else{
				v.getCongrat().setText("L'avversario si � ritirato");
			}
			media("/media/APPLAU22.WAV");
			sceltaImmagine(1);
		}
		else if(ris.equals("pareggio")){
			v.getRisultato().setText("PAREGGIO!");
			v.getCongrat().setText("Ritenta,sarai pi� fortunato");
			media("/media/I-QUIT2.wav");
			sceltaImmagine(2);
		}
		else{
			v.getRisultato().setText("HAI PERSO!");
			v.getCongrat().setText("Ritenta,sarai pi� fortunato");
			media("/media/I-QUIT2.wav");
			sceltaImmagine(3);
		}

		f.setVisible(false);
		v.setVisible(true);
	}
	
	//audio
	
	public void media(String path){
		try {
			AudioInputStream audioIn1;
			audioIn1 = AudioSystem.getAudioInputStream(this.getClass().getResource(path));
			Clip clip1 = AudioSystem.getClip();
	        clip1.open(audioIn1);
	        clip1.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void scadutoTimer(){
		if(f.getChiudi()){
			risposta(-1,true);
		}
		else{
			this.risposta(0,true);
		}
	}
	
	//immagine random
	
	public void sceltaImmagine(int num) {
		int rand;
		ImageIcon img;
		
		switch(num) {
			case 0:
				rand = (int) (Math.random() * 4)+1;
				img=new ImageIcon(Client.class.getResource("/media/intro"+rand+".gif"));	        
				i.getGifIntro().setIcon(img);
				break;
			case 1:
				rand = (int) (Math.random() * 4)+1;
				img=new ImageIcon(Client.class.getResource("/media/vittoria"+rand+".gif"));
				v.getGifVittoria().setIcon(img);
				break;
			case 2:
				rand = (int) (Math.random() * 4)+1;
				img=new ImageIcon(Client.class.getResource("/media/pareggio"+rand+".gif"));
				v.getGifVittoria().setIcon(img);
				break;
			case 3:
				rand = (int) (Math.random() * 4)+1;
				img=new ImageIcon(Client.class.getResource("/media/perso"+rand+".gif"));
				v.getGifVittoria().setIcon(img);
				break;
		}
	}
	
	
	//suono intro
	public void suonoIntro() {
		try {
			AudioInputStream audioIn1;
			audioIn1 = AudioSystem.getAudioInputStream(this.getClass().getResource("/media/canzone.wav"));
			clip1 = AudioSystem.getClip();
	        clip1.open(audioIn1);
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        clip1.start();
	}
	
	
}