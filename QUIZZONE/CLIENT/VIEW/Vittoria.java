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
	private JLabel gifVittoria;
	private JLabel esatte;
	private JLabel congrat;

	public Vittoria() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		risultato = new JLabel("");
		risultato.setForeground(new Color(0, 128, 128));
		risultato.setHorizontalAlignment(SwingConstants.CENTER);
		risultato.setFont(new Font("Tahoma", Font.BOLD, 33));
		risultato.setBounds(29, 24, 373, 63);
		contentPane.add(risultato);
		
		btnRicomincia = new JButton("RICOMINCIA");
		btnRicomincia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRicomincia.setBounds(103, 394, 231, 47);
		contentPane.add(btnRicomincia);
		
		gifVittoria = new JLabel("");
		gifVittoria.setBounds(65, 224, 304, 149);
		contentPane.add(gifVittoria);
		
		esatte = new JLabel("");
		esatte.setFont(new Font("Tahoma", Font.PLAIN, 17));
		esatte.setHorizontalAlignment(SwingConstants.CENTER);
		esatte.setBounds(65, 166, 304, 47);
		contentPane.add(esatte);
		
		congrat = new JLabel("");
		congrat.setHorizontalAlignment(SwingConstants.CENTER);
		congrat.setForeground(new Color(0, 128, 128));
		congrat.setFont(new Font("Tahoma", Font.BOLD, 23));
		congrat.setBounds(29, 98, 373, 63);
		contentPane.add(congrat);
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

	public JLabel getGifVittoria() {
		return gifVittoria;
	}

	public void setGifVittoria(JLabel gifVittoria) {
		this.gifVittoria = gifVittoria;
	}

	public JLabel getEsatte() {
		return esatte;
	}

	public void setEsatte(JLabel esatte) {
		this.esatte = esatte;
	}

	public JLabel getCongrat() {
		return congrat;
	}

	public void setCongrat(JLabel congrat) {
		this.congrat = congrat;
	}
}
