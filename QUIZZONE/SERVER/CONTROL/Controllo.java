package CONTROL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;

import MODEL.Domanda;
import MODEL.Gestione;
import VIEW.Finestra;

public class Controllo implements ActionListener{

	private Finestra f;
	private Gestione g;
	private ArrayList<Integer> indici;
	private Random rand = new Random();
	
	public Controllo(Finestra f, Gestione g) {
		this.f = f;
		this.g = g;

		f.setVisible(true);
		indici = new ArrayList<Integer>();
		Server s = new Server(f.getDefaultListModel(), 9999, g);
		s.start();
		
		f.getBtnDomanda().addActionListener(this);
		f.getTextFieldIp().setEditable(false);
		try {
			
			f.getTextFieldIp().setText(InetAddress.getLocalHost().getHostAddress().toString());
			
		} catch (UnknownHostException et) {
			// TODO Auto-generated catch block
			et.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getSource() == f.getBtnDomanda())
		{
			int i;
			do
			{
				i = rand.nextInt(19) + 1;
			}while(indici.contains(i));
			
			indici.add(i);
			Domanda d = g.getDomanda(i);
			f.getDefaultListModel().addElement(d.toString()); 
			f.getDefaultListModel().addElement(d.codificaCasuale() + "  " + Integer.toString(d.getRispG()));
			
		}
	}
	
	
}
