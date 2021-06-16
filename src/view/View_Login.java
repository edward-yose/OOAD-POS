package view;

import view.View_HRD;
import view.View_Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View_Login extends JFrame implements ActionListener {
	
	private JButton buttonViewHRD;
	private JButton buttonViewManager;

	public View_Login() {
		// JFrame
		setTitle("Login View");
		setSize(800, 600);
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
		
		add(panelButtons);

		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == buttonViewHRD) {
			new View_HRD();
		}
		else if (e.getSource() == buttonViewManager) {
			new View_Manager();
		}
//		else if (e.getSource() == button) {
//			
//		}
		
	}

}