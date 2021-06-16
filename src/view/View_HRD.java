package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class View_HRD extends JFrame{
	
	private JTable table;
	private DefaultTableModel utm;
	private JButton add_user;
	private JButton edit_user;
	private JButton delete_user;
	private JPanel panel_HRD;
	
	private void initLayout() {
		setSize(800, 600);
		setTitle("ItemList");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new GridLayout(2, 1, 10, 10));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		add(scrollPane);
		
		setVisible(true);
	}
	
	private void setUpDataModel() {
		utm = new DefaultTableModel(
				new String[] { "id", "role_id", "name","username", "salary", "status"},
				0
			);
			table.setModel(utm);
	}
	
	public View_HRD() {
		initLayout();
		setUpDataModel();
	}
}
