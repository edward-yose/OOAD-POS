package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.TransactionController;
import model.Transaction;
import model.TransactionItem;

public class View_Manager extends JFrame implements ActionListener {
	
	private JTable table;
	private DefaultTableModel dtm;
	private JComboBox<String> comboBoxMonth;
	private JSpinner spinnerYear;	
	private JButton buttonQuery;
	
	private JFrame productFrame;
	private JTable productTable;
	private DefaultTableModel productDtm;
	
	private void initLayout() {
		// JFrame
		setTitle("Transaction Report View");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JPanel
		JPanel contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new GridLayout(2, 1, 10, 10));
		setContentPane(contentPane);

		// JScrollPane
		JScrollPane scrollPane = new JScrollPane();
		
		// JTable
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		
		scrollPane.setViewportView(table);
		add(scrollPane);
		
		// JTable MouseListener
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int row = table.rowAtPoint(evt.getPoint());
				int transactionid = (int) table.getValueAt(row, 0);
				System.out.println("Row: " + row + ", transactionID: " + transactionid);
				getAllTransactionItem(transactionid);
			}
		});
		
		// JPanel Control
		JPanel panelControl = new JPanel();
		panelControl.setLayout(new GridLayout(1, 2, 10, 10));
		
		// JPanel Range
		JPanel panelRange = new JPanel();
		panelRange.setLayout(new GridLayout(2, 2));
		
		// JLabel Month
		JLabel labelMonth = new JLabel("Month: ");
		labelMonth.setHorizontalAlignment(SwingConstants.RIGHT);
		panelRange.add(labelMonth);
		
		// JComboBox Month
		DefaultComboBoxModel<String> boxMonth = new DefaultComboBoxModel<String>();
		boxMonth.addElement("January");
		boxMonth.addElement("February");
		boxMonth.addElement("March");
		boxMonth.addElement("April");
		boxMonth.addElement("May");
		boxMonth.addElement("June");
		boxMonth.addElement("July");
		boxMonth.addElement("August");
		boxMonth.addElement("September");
		boxMonth.addElement("October");
		boxMonth.addElement("November");
		boxMonth.addElement("December");
		comboBoxMonth = new JComboBox<>(boxMonth);
		panelRange.add(comboBoxMonth);
				
		// JLabel Year
		JLabel labelYear = new JLabel("Year: ");
		labelYear.setHorizontalAlignment(SwingConstants.RIGHT);
		panelRange.add(labelYear);
		
		// JSpinner Year
		spinnerYear = new JSpinner();
		panelRange.add(spinnerYear);

		
		// JPanel Buttons
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.Y_AXIS));
		
		// JButton Insert
		buttonQuery = new JButton("Go");
		buttonQuery.addActionListener(this);
		panelButtons.add(buttonQuery);
		
		panelControl.add(panelRange);
		panelControl.add(panelButtons);
		
		
		
		add(panelControl);
		
		
		setVisible(true);
	}

	public View_Manager() {
		initLayout();
		setUpDataModel();
		refreshData();
		prepProductFrame();
	}
	
	private void setUpDataModel() {
		dtm = new DefaultTableModel(
			new String[] { "id", "purchase_date", "employee_id", "payment_type" },
			0
		);
		table.setModel(dtm);
	}
	
	private void refreshData() {
		dtm.setRowCount(0);
		Vector<Transaction> transactions = TransactionController.getAllTransactions();
		
		for (Transaction i : transactions) {
			dtm.addRow(new Object[] {
				i.getId(),
				i.getPurchaseDate(),
				i.getEmployeeId(),
				i.getPaymentType()		
			});
		}
	}
	
	private void prepProductFrame() {
				
		productFrame = new JFrame();
		
		productFrame.setTitle("TransactionItem View");
		productFrame.setSize(600, 400);
		productFrame.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		// JScrollPane
		JScrollPane scrollPane = new JScrollPane();
		
		// JTable
		productTable = new JTable();
		productTable.setDefaultEditor(Object.class, null);
		
		// JPanel
		JPanel contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new GridLayout(1, 1, 10, 10));
		productFrame.setContentPane(contentPane);
		
		// TableModel_TransactionItem
		productDtm = new DefaultTableModel(
			new String[] { "transaction_id", "product_id", "quantity" },
			0
		);
		productTable.setModel(productDtm);
				
		scrollPane.setViewportView(productTable);
		productFrame.add(scrollPane);
		
	}
	
	private void getTransactionReport() {		
		int month = comboBoxMonth.getSelectedIndex() + 1;
		int year = (int)spinnerYear.getValue();
		
//		System.out.println("Month: " + month + ", and year: " + year);
		
		dtm.setRowCount(0);
		Vector<Transaction> transactions = TransactionController.viewTransactionReport(month, year);
		
		for (Transaction i : transactions) {
			dtm.addRow(new Object[] {
				i.getId(),
				i.getPurchaseDate(),
				i.getEmployeeId(),
				i.getPaymentType()		
			});
		}
		
		return;
	}
	
	private void getAllTransactionItem(int transactionId) {
		Vector<TransactionItem> transactionitems = TransactionController.getAllTransactionItem(transactionId);
				
		// Get table contents
		productDtm.setRowCount(0);
		
		for (TransactionItem i : transactionitems) {
			productDtm.addRow(new Object[] {
				i.getTransactionid(),
				i.getProductid(),
				i.getQuantity()
			});
		}
				
		productFrame.setVisible(true);		
		
		return;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == buttonQuery) {		
			getTransactionReport();
		}
	}
		
}
