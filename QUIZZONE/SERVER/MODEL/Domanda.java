package MODEL;

public class Domanda {

	private int id;
	private String domanda, risposta_1, risposta_2, risposta_3, risposta_4;
	
	public Domanda(int id, String domanda, String risposta_1, String risposta_2, String risposta_3, String risposta_4) {
		super();
		this.id = id;
		this.domanda = domanda;
		this.risposta_1 = risposta_1;
		this.risposta_2 = risposta_2;
		this.risposta_3 = risposta_3;
		this.risposta_4 = risposta_4;
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
}
