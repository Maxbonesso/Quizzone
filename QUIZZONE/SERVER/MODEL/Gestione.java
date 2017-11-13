package MODEL;

//import java.sql.*;			// potevo scrivere sinteticamente questo
import java.sql.Connection;		// crea oggetto Connessione
import java.sql.DriverManager;	// gestisce i DBMS nel nostro caso MySQL/MariaDB
import java.sql.SQLException;		// Eccezioni/errori in SQL
//import java.sql.Statement;		// crea uno statement
import java.sql.ResultSet;		// gestisce i resultset

public class Gestione {
	
	private String ip;
	private String porta;
	static Connection con = null;		// oggetto connessione con DBMS
	//static Statement stmt = null;
	static ResultSet rs = null;		// oggetto risultati query
	
	public Gestione()
	{	
		ip = "localhost";
		porta = "3306";
	}
	
	public Gestione(String ip, String porta)
	{	
		this.ip = ip;
		this.porta = porta;
	}
	
	public Domanda getDomanda(int n) {
		
		Domanda d = null;
		
		try {	// cattura errore e provvede a gestire il caso di non errore
			
			/**
			 * jdbc: --> driver per connettersi ad uno specifico DBMS
			 * mysql:// --> DBMS usato (non funziona senza MySQL Connector)
			 * localhost:3306/  --> indirizzo della risorsa e porta
			 * world --> nome del DB usato
			 */
			con = DriverManager.getConnection(
					"jdbc:mysql://" + ip + ":" + porta + "/quizzone",
					"root",
					"");
			
			rs = con.createStatement().executeQuery (
					"SELECT * " +
					"FROM quiz " +
					"WHERE id='" + n + "'"
				);
			
			// inserimento nell'array degli elementi

			rs.first();
			
			d = new Domanda(Integer.parseInt(rs.getString("id")),rs.getString("Domanda"),rs.getString("risposta"),rs.getString("risposta_1"),rs.getString("risposta_2"),rs.getString("Risposta_3"));
			
			// distrugge ResultSet e Connessione
			rs.close();
			con.close();
		}
		catch (SQLException ex){	
			// cattura eccezioni / errori e li gestisce
			System.out.println("Ciao");
			System.err.print(
				"\n* SQLException: " + ex.getMessage() +
				"\n* SQLState: " + ex.getSQLState() +
				"\n* VendorError: " + ex.getErrorCode() +
				"\n"
			);
		}
		
		return d;
	}
	
}