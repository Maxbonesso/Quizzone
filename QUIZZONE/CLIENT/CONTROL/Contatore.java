package CONTROL;

import java.util.Timer;
import java.util.TimerTask;

import VIEW.Frame;

public class Contatore extends Thread{
	
	private Frame f;
	private boolean flag;

	public Contatore(Frame f, boolean flag){
		this.flag = flag;
		this.f = f;
	}
	
	public void run() {
		/*try{
			
		}
		Timer timer = new Timer();

	    TimerTask task = new TimerTask(){
	        private int i = 20;
	        public void run(){
	            if (i >= 0) {
	                f.getContatore().setText("" + i--);
	            }
	        }
	    };
	    timer.scheduleAtFixedRate(task, 0, 1000);*/
		
		long T0 = System.currentTimeMillis();
		while(System.currentTimeMillis() - T0 < 20000 && !flag){
			int secondsLeft = (int)(System.currentTimeMillis() - T0) / 1000;
			f.getContatore().setText(""+secondsLeft);
		}
	}

}
