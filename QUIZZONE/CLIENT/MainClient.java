import java.io.IOException;

import CONTROL.Control;
import VIEW.Frame;
import VIEW.Indirizzo;
import VIEW.Intro;
import VIEW.Vittoria;

public class MainClient {

	public static void main(String[] args) throws IOException {
		Frame f=new Frame();
		f.setVisible(false);
		Intro i=new Intro();
		i.setVisible(false);
		Indirizzo ind=new Indirizzo();
		ind.setVisible(true);
		Vittoria v =new Vittoria();
		v.setVisible(false);
		Control c=new Control(f,i,ind,v);
	}

}
