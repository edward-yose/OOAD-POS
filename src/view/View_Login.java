package view;

import view.View_HRD;
import view.View_Manager;
import view.View_TransactionManagement;

import controller.EmployeeController;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class View_Login extends JFrame implements ActionListener {
	
	private JButton buttonViewHRD;
	private JButton buttonViewManager;
	private JButton buttonViewTransactionManagement;
	private JButton buttonViewProduct;
	
	private JTextField fieldUsername;
	private JPasswordField fieldPassword;
	private JButton buttonLogin;

	public View_Login() {
		// JFrame
		setTitle("Login View");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JPanel contentPane
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(2, 1, 10, 10));
		setContentPane(contentPane);
				
		// JPanel Buttons
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.Y_AXIS));
		
		// JButton HRD
		buttonViewHRD = new JButton("View_HRD");
		buttonViewHRD.addActionListener(this);
		panelButtons.add(buttonViewHRD);
				
		// JButton Product
		buttonViewProduct = new JButton("View_Product");
		buttonViewProduct.addActionListener(this);
		panelButtons.add(buttonViewProduct);
		
		// JButton Manager
		buttonViewManager = new JButton("View_Manager");
		buttonViewManager.addActionListener(this);
		panelButtons.add(buttonViewManager);
		
		// JButton Transaction Management
		buttonViewTransactionManagement = new JButton("View_TransactionManagement");
		buttonViewTransactionManagement.addActionListener(this);
		panelButtons.add(buttonViewTransactionManagement);

		add(panelButtons);
		
		
		// JPanel Login
		JPanel panelLogin = new JPanel();
		panelLogin.setLayout(new FlowLayout());
		
		// JLabel Username
		JLabel labelUsername = new JLabel("Username: ");
		labelUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLogin.add(labelUsername);
		
		// JTextField Username
		fieldUsername = new JTextField();
		fieldUsername.setPreferredSize(new Dimension(100, 20));
		panelLogin.add(fieldUsername);
		
		// JLabel Password
		JLabel labelPassword = new JLabel("Password: ");
		labelPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLogin.add(labelPassword);
		
		// JTextField Password
		fieldPassword = new JPasswordField();
		fieldPassword.setPreferredSize(new Dimension(100, 20));
		panelLogin.add(fieldPassword);
		
		// JButton Login
		buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(this);
		panelLogin.add(buttonLogin);
		
		add(panelLogin);
		

		setVisible(true);

		fieldUsername.requestFocusInWindow();
		
	}
	
	private void loginEmployee() {
		String username = fieldUsername.getText();
		String password = fieldPassword.getText();
				
		System.out.println(EmployeeController.logEmployeeIn(username, password));
		
		switch(EmployeeController.logEmployeeIn(username, password)) {
			case 1: {
				dispose();
				new View_Manager();
				break;
			}
			case 2: {
				dispose();
				new View_Product();
				break;
			}
			case 3: {
				dispose();
				new View_HRD();
				break;
			}
			case 4: {
				dispose();
				new View_TransactionManagement();
				break;
			}
			
			case -1: {
				JOptionPane.showMessageDialog(null, "Invalid username or password.");
				break;
			}
			
			case -2: {
				JOptionPane.showMessageDialog(null, "Fields cannot be empty.");
				break;
			}
		}
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == buttonViewHRD) {
			dispose();
			new View_HRD();
		}
		else if (e.getSource() == buttonViewProduct) {
			dispose();
			new View_Product();
		}
		else if (e.getSource() == buttonViewManager) {
			dispose();
			new View_Manager();
		}
		else if (e.getSource() == buttonViewTransactionManagement) {
			dispose();
			new View_TransactionManagement();
		}
//		else if (e.getSource() == button) {
//		
//		}
		
		else if (e.getSource() == buttonLogin){
			// TO-DO LOGIN STUFF
			loginEmployee();
		}
	}
}