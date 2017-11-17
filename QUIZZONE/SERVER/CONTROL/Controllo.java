package CONTROL;

import java.net.InetAddress;
import java.net.UnknownHostException;
import MODEL.Gestione;
import VIEW.Finestra;

public class Controllo{

	private Finestra f;
	private Gestione g;
	
	public Controllo(Finestra f, Gestione g) {
		this.f = f;
		this.g = g;

		f.setVisible(true);
		Server s = new Server(f.getDefaultListModel(), 9999, g);
		s.start();
		
		f.getTextFieldIp().setEditable(false);
		try {
			
			f.getTextFieldIp().setText(InetAddress.getLocalHost().getHostAddress().toString());
			
		} catch (UnknownHostException et) {
			// TODO Auto-generated catch block
			et.printStackTrace();
		}
	}	
}
