package CONTROL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		
		f.getBtnDomanda().addActionListener(this);
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
