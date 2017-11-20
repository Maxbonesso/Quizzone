package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField domanda;
	private JLabel lblNewLabel, contatore;
	private JButton risp1, risp2, risp3, risp4;

	public Frame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 440);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("QUIZZONE");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
		lblNewLabel.setBounds(138, 11, 234, 53);
		contentPane.add(lblNewLabel);
		
		domanda = new JTextField();
		domanda.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		domanda.setHorizontalAlignment(SwingConstants.CENTER);
		domanda.setEditable(false);
		domanda.setBounds(10, 75, 504, 63);
		contentPane.add(domanda);
		domanda.setColumns(10);
		
		risp1 = new JButton("");
		risp1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		risp1.setBounds(26, 205, 474, 34);
		contentPane.add(risp1);
		
		risp2 = new JButton("");
		risp2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		risp2.setBounds(26, 255, 474, 34);
		contentPane.add(risp2);
		
		risp3 = new JButton("");
		risp3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		risp3.setBounds(26, 305, 474, 34);
		contentPane.add(risp3);
		
		risp4 = new JButton("");
		risp4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		risp4.setBounds(26, 355, 474, 34);
		contentPane.add(risp4);
		
		contatore = new JLabel("");
		contatore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contatore.setHorizontalAlignment(SwingConstants.CENTER);
		contatore.setBounds(170, 160, 187, 34);
		contentPane.add(contatore);
	}

	public JTextField getDomanda() {
		return domanda;
	}

	public void setDomanda(JTextField domanda) {
		this.domanda = domanda;
	}

	public JLabel getContatore() {
		return contatore;
	}

	public void setContatore(JLabel contatore) {
		this.contatore = contatore;
	}

	public JButton getRisp1() {
		return risp1;
	}

	public void setRisp1(JButton risp1) {
		this.risp1 = risp1;
	}

	public JButton getRisp2() {
		return risp2;
	}

	public void setRisp2(JButton risp2) {
		this.risp2 = risp2;
	}

	public JButton getRisp3() {
		return risp3;
	}

	public void setRisp3(JButton risp3) {
		this.risp3 = risp3;
	}

	public JButton getRisp4() {
		return risp4;
	}

	public void setRisp4(JButton risp4) {
		this.risp4 = risp4;
	}
}
