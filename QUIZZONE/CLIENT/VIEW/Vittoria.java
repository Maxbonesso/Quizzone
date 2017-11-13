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
import javax.swing.JButton;

public class Vittoria extends JFrame {

	private JPanel contentPane;
	private JLabel risultato;
	private JButton btnRicomincia;

	public Vittoria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		risultato = new JLabel("");
		risultato.setForeground(new Color(0, 128, 128));
		risultato.setHorizontalAlignment(SwingConstants.CENTER);
		risultato.setFont(new Font("Tahoma", Font.BOLD, 29));
		risultato.setBounds(29, 24, 373, 99);
		contentPane.add(risultato);
		
		btnRicomincia = new JButton("RICOMINCIA");
		btnRicomincia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRicomincia.setBounds(108, 204, 231, 47);
		contentPane.add(btnRicomincia);
	}

	public JLabel getRisultato() {
		return risultato;
	}

	public void setRisultato(JLabel risultato) {
		this.risultato = risultato;
	}

	public JButton getBtnRicomincia() {
		return btnRicomincia;
	}

	public void setBtnRicomincia(JButton btnRicomincia) {
		this.btnRicomincia = btnRicomincia;
	}
}
