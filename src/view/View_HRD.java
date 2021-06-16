package view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class View_HRD extends JFrame{
	
	private JTable table;
	private DefaultTableModel utm;
	private JButton add_user;
	private JButton edit_user;
	private JButton delete_user;
	private JSpinner spinnerID;
//	private JSpinner spinnerRoleID;
//	private JTextField textFieldName;
//	private JTextField textFileUsername;
//	private JTextField textFileSalary;
//	private JPasswordField textFilePassword;
	
	private void initLayout() {
		setSize(800, 600);
		setTitle("Employee List");
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
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 2, 10, 10));
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3, 2));
		
		JLabel labelId = new JLabel("Product Id: ");
		labelId.setVerticalAlignment(SwingConstants.CENTER);
		panel1.add(labelId);
		
		spinnerID = new JSpinner();
		panel1.add(spinnerID);
		
		panel1.add(panel2);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.Y_AXIS));
		
		edit_user = new JButton("Edit User by ID");
		edit_user.addActionListener(null);
		panel2.add(edit_user);
		
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
