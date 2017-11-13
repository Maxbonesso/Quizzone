package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Indirizzo extends JFrame {

	private JPanel contentPane;
	private JTextField indirizzo;
	private JLabel lblInserisciLindirizzoDel;
	private JButton btnInserisci;

	public Indirizzo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblInserisciLindirizzoDel = new JLabel("Inserisci l'indirizzo del server");
		lblInserisciLindirizzoDel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInserisciLindirizzoDel.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisciLindirizzoDel.setBounds(10, 11, 314, 40);
		contentPane.add(lblInserisciLindirizzoDel);
		
		indirizzo = new JTextField();
		indirizzo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		indirizzo.setHorizontalAlignment(SwingConstants.CENTER);
		indirizzo.setBounds(43, 62, 246, 40);
		contentPane.add(indirizzo);
		indirizzo.setColumns(10);
		
		btnInserisci = new JButton("INSERISCI");
		btnInserisci.setBounds(111, 133, 119, 23);
		contentPane.add(btnInserisci);
	}

	public JTextField getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(JTextField indirizzo) {
		this.indirizzo = indirizzo;
	}

	public JButton getBtnInserisci() {
		return btnInserisci;
	}

	public void setBtnInserisci(JButton btnInserisci) {
		this.btnInserisci = btnInserisci;
	}
	
	public void close(){
		System.exit(0);
	}

}
