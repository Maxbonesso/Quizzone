package MODEL;

import java.util.ArrayList;
import java.util.Random;

public class Domanda {

	private int id, rispG;
	private String domanda, risposta_1, risposta_2, risposta_3, risposta_4;
	private Random rand = new Random();
	
	public Domanda(int id, String domanda, String risposta_1, String risposta_2, String risposta_3, String risposta_4) {
		super();
		this.id = id;
		this.domanda = domanda;
		this.risposta_1 = risposta_1;
		this.risposta_2 = risposta_2;
		this.risposta_3 = risposta_3;
		this.risposta_4 = risposta_4;
		rispG = 1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDomanda() {
		return domanda;
	}

	public void setDomanda(String domanda) {
		this.domanda = domanda;
	}

	public String getRisposta_1() {
		return risposta_1;
	}

	public void setRisposta_1(String risposta_1) {
		this.risposta_1 = risposta_1;
	}

	public String getRisposta_2() {
		return risposta_2;
	}

	public void setRisposta_2(String risposta_2) {
		this.risposta_2 = risposta_2;
	}

	public String getRisposta_3() {
		return risposta_3;
	}

	public void setRisposta_3(String risposta_3) {
		this.risposta_3 = risposta_3;
	}

	public String getRisposta_4() {
		return risposta_4;
	}

	public void setRisposta_4(String risposta_4) {
		this.risposta_4 = risposta_4;
	}

	@Override
	public String toString() {
		return "Domanda [id=" + id + ", domanda=" + domanda + ", risposta_1=" + risposta_1 + ", risposta_2="
				+ risposta_2 + ", risposta_3=" + risposta_3 + ", risposta_4=" + risposta_4 + "]";
	}
	
	public String codifica()
	{
		return  "$" + domanda + "$" + risposta_1 + "$" + risposta_2 + "$" + risposta_3 + "$" + risposta_4 + "$";
	}
	
	public String codificaCasuale()
	{
		ordineCasuale();
		return  "$" + domanda + "$" + risposta_1 + "$" + risposta_2 + "$" + risposta_3 + "$" + risposta_4 + "$";
	}
	
	public int getRispG()
	{
		return rispG;
	}
	
	private void ordineCasuale()
	{
		int flag = 1, n;
		ArrayList<Integer> ind = new ArrayList<Integer>();
		while(flag<4)
		{
			do
			{
				n = rand.nextInt(3) + 1;
			} while(ind.contains(n) && flag == n);
			
			if(flag == rispG)
				this.rispG = n;
			else if(n == rispG)
				this.rispG = flag;
			
			scambio(flag, n);
			ind.add(n);
			flag++;
		}
	}
	private boolean scambio(int n, int n2)
	{
		boolean ret = false;
		String app;
		
		switch(n)
		{
			case 1:
				app = risposta_1;
				switch(n2)
				{
					case 1:
						risposta_1 = risposta_1;
						risposta_1 = app;
						ret = true;
					break;
					case 2:
						risposta_1 = risposta_2;
						risposta_2 = app;
						ret = true;
					break;
					case 3:
						risposta_1 = risposta_3;
						risposta_3 = app;
						ret = true;
					break;
					case 4:
						risposta_1 = risposta_4;
						risposta_4 = app;
						ret = true;
					break;
				}
			break;
			case 2:
				app = risposta_2;
				switch(n2)
				{
					case 1:
						risposta_2 = risposta_1;
						risposta_1 = app;
						ret = true;
					break;
					case 2:
						risposta_2 = risposta_2;
						risposta_2 = app;
						ret = true;
					break;
					case 3:
						risposta_2 = risposta_3;
						risposta_3 = app;
						ret = true;
					break;
					case 4:
						risposta_2 = risposta_4;
						risposta_4 = app;
						ret = true;
					break;
				}
			break;
			case 3:
				app = risposta_3;
				switch(n2)
				{
					case 1:
						risposta_3 = risposta_1;
						risposta_1 = app;
						ret = true;
					break;
					case 2:
						risposta_3 = risposta_2;
						risposta_2 = app;
						ret = true;
					break;
					case 3:
						risposta_3 = risposta_3;
						risposta_3 = app;
						ret = true;
					break;
					case 4:
						risposta_3 = risposta_4;
						risposta_4 = app;
						ret = true;
					break;
				}
			break;
			case 4:
				app = risposta_4;
				switch(n2)
				{
					case 1:
						risposta_4 = risposta_1;
						risposta_1 = app;
						ret = true;
					break;
					case 2:
						risposta_4 = risposta_2;
						risposta_2 = app;
						ret = true;
					break;
					case 3:
						risposta_4 = risposta_3;
						risposta_3 = app;
						ret = true;
					break;
					case 4:
						risposta_4 = risposta_4;
						risposta_4 = app;
						ret = true;
					break;
				}
		}
		return ret;
	}
}
