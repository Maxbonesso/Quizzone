package CONTROL;

import java.util.Timer;
import java.util.TimerTask;

import VIEW.Frame;

public class Contatore extends Thread{
	
	private Frame f;

	public Contatore(Frame f) throws InterruptedException {
		
		this.f = f;
	}
	
	public void run() {
		Timer timer = new Timer();

	    TimerTask task = new TimerTask(){
	        private int i = 0;
	        public void run(){
	            if (i <= 30) {
	                f.getContatore().setText("" + i++);
	            }
	        }
	    };
	    timer.scheduleAtFixedRate(task, 0, 1000);
	}

}
