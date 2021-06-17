package view;

import java.awt.GridLayout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class View_HRD extends JFrame implements ActionListener{
	
	private JTable table;
	private DefaultTableModel utm;
	private JButton add_user;
	private JButton edit_user;
	private JButton delete_user;
	
	public View_HRD() {
		initLayout();
		setUpDataModel();
	}
	
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
		
		JPanel panelCtrl = new JPanel();
		panelCtrl.setLayout(new GridLayout(1, 2, 10, 10));
		
		JPanel panelP = new JPanel();
		panelP.setLayout(new GridLayout(3,2));
		
		// JPanel Buttons
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.Y_AXIS));
				
		// JButton Add
		add_user = new JButton("Add User");
		add_user.addActionListener(this);
		panelButtons.add(add_user);
		
		// JButton Edit
		edit_user = new JButton("Edit User");
		edit_user.addActionListener(this);
		panelButtons.add(edit_user);
		
		// JButton Delete
		delete_user = new JButton("Delete user");
		delete_user.addActionListener(this);
		panelButtons.add(delete_user);
		
		panelCtrl.add(panelP);
		panelCtrl.add(panelButtons);
		
		add(panelCtrl);
		
		setVisible(true);
	}
	
	private void setUpDataModel() {
		utm = new DefaultTableModel(
				new String[] { "id", "role_id", "name","username", "salary", "status"},
				0
			);
			table.setModel(utm);
	}
	
	
}
