package VIEW;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Color;
import javax.swing.JButton;

public class Intro extends JFrame implements WindowListener{

	private JPanel contentPane;
	private JLabel lblQ;
	private JButton btnPlay;
	private JLabel gifIntro;

	public Intro() {
		setResizable(false);
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
		lblQ.setBounds(73, 11, 343, 101);
		contentPane.add(lblQ);
		
		btnPlay = new JButton("PLAY\r\n");
		btnPlay.setForeground(new Color(255, 0, 0));
		btnPlay.setFont(new Font("Comic Sans MS", Font.BOLD, 45));
		btnPlay.setBounds(83, 289, 321, 96);
		contentPane.add(btnPlay);
		
		gifIntro = new JLabel("");
		gifIntro.setBounds(65, 103, 355, 174);
		contentPane.add(gifIntro);
	}

	public JButton getBtnPlay() {
		return btnPlay;
	}

	public void setBtnPlay(JButton btnPlay) {
		this.btnPlay = btnPlay;
	}

	public JLabel getGifIntro() {
		return gifIntro;
	}

	public void setGifIntro(JLabel gifIntro) {
		this.gifIntro = gifIntro;
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		int i = JOptionPane.showConfirmDialog(null, "Vuoi davvero uscire dal programma?", "USCITA", JOptionPane.YES_NO_OPTION);
		
		if(i == JOptionPane.YES_OPTION)
			System.exit(0);
		else
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
