package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View_HRD extends JFrame{
	
	private JTable table;
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
	
	}

	public void setAddButton() {
		add_user = new JButton("Add User");
		add(add_user, BorderLayout.NORTH);
		
	}
	
	public View_HRD() {
		setAddButton();
		setFrame();  
		setField();
		setVisible(true);
	}
	
	
}
