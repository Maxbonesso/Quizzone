package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class Intro extends JFrame {

	private JPanel contentPane;
	private JLabel lblQ;
	private JButton btnPlay;
	private JLabel label;

	public Intro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblQ = new JLabel("QUIZZONE");
		lblQ.setForeground(new Color(0, 128, 128));
		lblQ.setFont(new Font("Comic Sans MS", Font.BOLD, 54));
		lblQ.setHorizontalAlignment(SwingConstants.CENTER);
		lblQ.setBounds(73, 11, 343, 122);
		contentPane.add(lblQ);
		
		btnPlay = new JButton("PLAY\r\n");
		btnPlay.setForeground(new Color(255, 0, 0));
		btnPlay.setFont(new Font("Comic Sans MS", Font.BOLD, 45));
		btnPlay.setBounds(83, 263, 321, 122);
		contentPane.add(btnPlay);
		
		label = new JLabel("");
		label.setBounds(29, 119, 414, 133);
		contentPane.add(label);
	}

	public JButton getBtnPlay() {
		return btnPlay;
	}

	public void setBtnPlay(JButton btnPlay) {
		this.btnPlay = btnPlay;
	}

}
