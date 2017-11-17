package VIEW;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Finestra extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JList<String> list;
	private DefaultListModel<String> defaultListModel;
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
		
		list = new JList<String>();
		defaultListModel = new DefaultListModel<String>();
		list.setModel(defaultListModel);
		scrollPane.setViewportView(list);
		
		JLabel lblLindirizzoDelServer = new JLabel("L'indirizzo del server \u00E8:");
		lblLindirizzoDelServer.setBounds(30, 22, 160, 14);
		contentPane.add(lblLindirizzoDelServer);
		
		textFieldIp = new JTextField();
		textFieldIp.setBounds(210, 19, 141, 20);
		contentPane.add(textFieldIp);
		textFieldIp.setColumns(10);
	}

	public DefaultListModel<String> getDefaultListModel() {
		return defaultListModel;
	}

	public JTextField getTextFieldIp() {
		return textFieldIp;
	}
}
