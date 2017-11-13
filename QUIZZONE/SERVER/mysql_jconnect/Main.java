/**
 * Scarica e installa il MySQL Connector dal link
 * @link https://dev.mysql.com/downloads/connector/j/
 * dal quel a fronte del download del file mysql-connector-java-<version>.zip
 * estrarre il file mysql-connector-java-<verion>-bin.jar
 * ed copiarlo nella cartella ./Libreries del progetto Java
 */

package mysql_jconnect;

//import java.sql.*;			// potevo scrivere sinteticamente questo
import java.sql.Connection;		// crea oggetto Connessione
import java.sql.DriverManager;	// gestisce i DBMS nel nostro caso MySQL/MariaDB
import java.sql.SQLException;		// Eccezioni/errori in SQL
//import java.sql.Statement;		// crea uno statement
import java.sql.ResultSet;		// gestisce i resultset

public class Main {
	static Connection con = null;		// oggetto connessione con DBMS
	//static Statement stmt = null;
	static ResultSet rs = null;		// oggetto risultati query
	
	public static void main(String[] args) {
		try {	// cattura errore e provvede a gestire il caso di non errore
			/**
			 * jdbc: --> driver per connettersi ad uno specifico DBMS
			 * mysql:// --> DBMS usato (non funziona senza MySQL Connector)
			 * localhost:3306/  --> indirizzo della risorsa e porta
			 * world --> nome del DB usato
			 */
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/world",
				"root",
				"");
			rs = con.createStatement().executeQuery (
				"SELECT P.Name Paese, C.Name Capitale " +
				"FROM country P INNER JOIN city C ON C.ID = P.capital " +
				"WHERE P.Name = C.Name " +
				"ORDER by P.Name ASC;"
			);
			
/* 
			* rs.last() sposta il cursore sull’ultima riga in modo che
			* sia possibile contarla attraverso rs.getRows()
			* Dopo aver contato il n.ro di righe devo riportare il cursore
			* in cima attraverso rs.beforeFirs() in modo da poter poi stampare
			* tutti gli elementi della tabella
			* NB: Se non c’era la necessità di dover contare il n.ro di righe,
			* potevo benissimo evitare rs.last(), rs.getRow(), rs.beforeFirst()
			*/
			rs.last();
			
			// stampa intestazione della tabella e n.ro di righe
			System.out.print(
				rs.getRow() + " righe coinvolte!\nN\tCapitale\t|\tPaese\n"	
			);
			rs.beforeFirst();			// riporta il cursore in cima

			for ( ; rs.next();) {
				System.out.println(
					rs.getRow() + ")\t" +
					rs.getString("Capitale") + "\t|\t" +
					rs.getString("Paese")
				);
			}
			
			// distrugge ResultSet e Connessione
			rs.close();
			con.close();
		}
		catch (SQLException ex){	// cattura eccezioni / errori e li gestisce
			System.err.print(
				"\n* SQLException: " + ex.getMessage() +
				"\n* SQLState: " + ex.getSQLState() +
				"\n* VendorError: " + ex.getErrorCode() +
				"\n"
			);
		}
		finally {
		/*
		* porzione di codice facoltativa
		* viene eseguita a prescindere dalla presenza di un errore
		*/
			System.out.println("\nEnding of Program, Enjoy your self!! :)\n");
		}
	}
	
}
