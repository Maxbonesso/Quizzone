package VIEW;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class Finestra extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JList list;
	private DefaultListModel defaultListModel;
	private JButton btnDomanda;
	
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
		scrollPane.setBounds(31, 33, 365, 155);
		contentPane.add(scrollPane);
		
		list = new JList();
		defaultListModel = new DefaultListModel();
		list.setModel(defaultListModel);
		scrollPane.setViewportView(list);
		
		btnDomanda = new JButton("Domanda");
		btnDomanda.setBounds(164, 213, 89, 23);
		contentPane.add(btnDomanda);
	}

	public DefaultListModel getDefaultListModel() {
		return defaultListModel;
	}

	public JButton getBtnDomanda() {
		return btnDomanda;
	}
}
