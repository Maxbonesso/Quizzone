package CONTROL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	
	private Socket s;
	private String ip;

	public Client(String ip)
	{
		this.ip = ip;
	}
	
	public void creaConnessione()
	{
		try {
			s= new Socket (ip, 9999);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void attendi() throws IOException{
		boolean flag=false;
		while(!flag){
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			String t = new String (in.readLine());
			if(t.equals("$Iniziamo!$")){
				System.out.println("inizia");
				flag=true;
			}
		}
	}
	
	public String getText() throws IOException{
		String t="";
		boolean flag=false;
		while(!flag){
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			t = new String (in.readLine());
			if(t.indexOf("$")==0){
				System.out.println("messaggio arrivato");
				flag=true;
			}
		}
		return t;
	}
	
	public void invio(String n) throws IOException
	{
		PrintWriter out = new PrintWriter (s.getOutputStream(), true);
		out.println(n);
	}
	
	public void close() {
		try {
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
