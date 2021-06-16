package view;

import view.View_HRD;
import view.View_Manager;
import view.View_TransactionManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View_Login extends JFrame implements ActionListener {
	
	private JButton buttonViewHRD;
	private JButton buttonViewManager;
	private JButton buttonViewTransactionManagement;

	public View_Login() {
		// JFrame
		setTitle("Login View");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		// JPanel Buttons
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.Y_AXIS));
		
		// JButton Insert
		buttonViewHRD = new JButton("View_HRD");
		buttonViewHRD.addActionListener(this);
		panelButtons.add(buttonViewHRD);
		
		// JButton Insert
		buttonViewManager = new JButton("View_Manager");
		buttonViewManager.addActionListener(this);
		panelButtons.add(buttonViewManager);
		
		// JButton Insert
		buttonViewTransactionManagement = new JButton("View_TransactionManagement");
		buttonViewTransactionManagement.addActionListener(this);
		panelButtons.add(buttonViewTransactionManagement);
		
		add(panelButtons);

		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == buttonViewHRD) {
			dispose();
			new View_HRD();
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
		
	}

}