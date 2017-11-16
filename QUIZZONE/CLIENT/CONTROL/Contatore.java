package CONTROL;

import java.util.Timer;
import java.util.TimerTask;

import VIEW.Frame;

public class Contatore extends Thread{
	
	private Frame f;

	public Contatore(Frame f){
		this.f = f;
	}
	
	public void run() {
		
		long T0 = System.currentTimeMillis();
		while(System.currentTimeMillis() - T0 < 20000){
			int secondsLeft = (int)(System.currentTimeMillis() - T0) / 1000;
			f.getContatore().setText(""+(20-secondsLeft));
		}
	}

}
