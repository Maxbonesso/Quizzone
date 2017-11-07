import java.io.IOException;

import CONTROL.Control;
import VIEW.Frame;
import VIEW.Indirizzo;
import VIEW.Intro;

public class MainClient {

	public static void main(String[] args) throws IOException {
		Indirizzo ind=new Indirizzo();
		Control c=new Control(ind);
	}

}
