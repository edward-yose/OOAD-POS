package view;

import model.Cart;
import model.Product;
import controller.CartController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;



public class View_TransactionManagement extends JFrame implements ActionListener{
	private JTable table;
	private DefaultTableModel dtm;
	private JSpinner spinnerId;
	private JSpinner spinnerQuantity;
	private JButton buttonAdd;
	private JButton buttonRemove;
	private JButton buttonCheckOut;
	private JLabel totalprice=new JLabel(); 

	
	public View_TransactionManagement() {
		initLayout();
		setUpDataModel();
		refreshData();
	}
	
	private void initLayout() {
		// JFrame
		setTitle("Transaction Management");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JPanel ContentPane
		JPanel contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new GridLayout(2, 1, 10, 10));
		setContentPane(contentPane);

		// JScrollPane
		JScrollPane scrollPane = new JScrollPane();
		
		// JTable
		table = new JTable();
		
		scrollPane.setViewportView(table);
		add(scrollPane);
		
		// JPanel CUD
		JPanel panelCud = new JPanel();
		panelCud.setLayout(new GridLayout(1, 2, 10, 10));
		
		// JPanel Fields
		JPanel panelFields = new JPanel();
		panelFields.setLayout(new GridLayout(3, 2));
		
		// JLabel Id
		JLabel labelId = new JLabel("Product Id: ");
		labelId.setHorizontalAlignment(SwingConstants.RIGHT);
		panelFields.add(labelId);
	
		
		// JLabel Quantity
		JLabel labelQuantity = new JLabel("Quantity: ");
		labelQuantity.setHorizontalAlignment(SwingConstants.RIGHT);
		panelFields.add(labelQuantity);
		
		// JSpinner ID
		spinnerId = new JSpinner();
		panelFields.add(spinnerId);
		
		// JSpinner Quantity
		spinnerQuantity = new JSpinner();
		panelFields.add(spinnerQuantity);
		
		panelCud.add(panelFields);
		
		// JLabel price
		JLabel labeltotalprice = new JLabel("Total Price: ");
		labeltotalprice.setHorizontalAlignment(SwingConstants.RIGHT);
		panelFields.add(labeltotalprice);
		
		totalprice.setHorizontalAlignment(SwingConstants.RIGHT);
		panelFields.add(totalprice);

		// JPanel Buttons
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.Y_AXIS));
		
		// JButton Add
		buttonAdd = new JButton("Add item");
		buttonAdd.addActionListener(this);
		panelButtons.add(buttonAdd);
		
		// JButton Remove
		buttonRemove = new JButton("Remove item");
		buttonRemove.addActionListener(this);
		panelButtons.add(buttonRemove);
		
		// JButton checkout
		buttonCheckOut = new JButton("Check Out");
		buttonCheckOut.addActionListener(this);
		panelButtons.add(buttonCheckOut);
		
		panelCud.add(panelButtons);
		
		add(panelCud);
		
		setVisible(true);
	}
	
	private void setUpDataModel() {
		dtm = new DefaultTableModel(
			new String[] {"Product ID","Quantity"},
			0
		);
		table.setModel(dtm);
	}
	
	private void refreshData() {
		dtm.setRowCount(0);
		Vector<Cart> cart = Cart.view();
		
		for(Cart i:cart) {
			dtm.addRow(new Object[] {
					i.getProductid(),
					i.getQty()
			});
		}
		totalprice.setText(String.valueOf(CartController.getGrandTotal()));
	
	}
	private void add() {
		int productid = (int)spinnerId.getValue();
		int qty = (int)spinnerQuantity.getValue();
		
		String error = CartController.addItem(productid, qty);
		if(error == null) {
			refreshData();
		}else {
			JOptionPane.showMessageDialog(this, error);
		}
	}
	
	private void remove() {
		int productid = (int)spinnerId.getValue();
		String error =  CartController.removeItem(productid, 0);
		if(error ==null) {
			refreshData();
		}else {
			JOptionPane.showMessageDialog(this, error);
		}
}
	
	private void checkout() {
		Object[]opt= {"Cash", "Credit Card"};
		int opsi=JOptionPane.showOptionDialog(this, "Choose the payment method","Payment Method",
				JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,
				opt, opt[0]);
		if(opsi==0) {
			//cash
		}
		else if(opsi==1){
			//CC
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonAdd) {
			add();
		} else if (e.getSource() == buttonRemove) {
			remove();
		} else if (e.getSource() == buttonCheckOut) {
			checkout();
		}
		
	}
}
