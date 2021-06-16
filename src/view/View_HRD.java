package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class View_HRD extends JFrame{
	
	private JTable table;
	private DefaultTableModel utm;
	private JButton add_user;
	private JButton edit_user;
	private JButton delete_user;
	private JPanel panel_HRD;
	
	private void setFrame() {
		setSize(800, 600);
		setTitle("ItemList");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void setField() {
		table = new JTable();
		
	}

	public void setAddButton() {
		add_user = new JButton("Add User");
		add(add_user, BorderLayout.NORTH);
	}
	
	private void setUpDataModel() {
		utm = new DefaultTableModel(
				new String[] { "id", "role_id", "name","username", "salary", "status"},
				0
			);
			table.setModel(utm);
	}
	
	public View_HRD() {
		setAddButton();
		setFrame();
		setField();
		setUpDataModel();
		setVisible(true);
	}
	
	
}
