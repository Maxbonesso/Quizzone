package VIEW;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Finestra extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JList list;
	private DefaultListModel defaultListModel;
	private JButton btnDomanda;
	private JTextField textFieldIp;
	
	/**
	 * Create the frame.
	 */
	public Finestra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 62, 365, 155);
		contentPane.add(scrollPane);
		
		list = new JList();
		defaultListModel = new DefaultListModel();
		list.setModel(defaultListModel);
		scrollPane.setViewportView(list);
		
		btnDomanda = new JButton("Domanda");
		btnDomanda.setBounds(164, 228, 89, 23);
		contentPane.add(btnDomanda);
		
		JLabel lblLindirizzoDelServer = new JLabel("L'indirizzo del server \u00E8:");
		lblLindirizzoDelServer.setBounds(30, 22, 160, 14);
		contentPane.add(lblLindirizzoDelServer);
		
		textFieldIp = new JTextField();
		textFieldIp.setBounds(210, 19, 141, 20);
		contentPane.add(textFieldIp);
		textFieldIp.setColumns(10);
	}

	public DefaultListModel getDefaultListModel() {
		return defaultListModel;
	}

	public JButton getBtnDomanda() {
		return btnDomanda;
	}

	public JTextField getTextFieldIp() {
		return textFieldIp;
	}
}
