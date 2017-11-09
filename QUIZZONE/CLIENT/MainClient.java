import java.io.IOException;

import CONTROL.Control;
import VIEW.Frame;
import VIEW.Indirizzo;
import VIEW.Intro;

public class MainClient {

	public static void main(String[] args) throws IOException {
		Frame f=new Frame();
		f.setVisible(false);
		Intro i=new Intro();
		i.setVisible(false);
		Indirizzo ind=new Indirizzo();
		ind.setVisible(true);
		Control c=new Control(f,i,ind);
	}

}
