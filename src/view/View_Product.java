package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class View_Product extends JFrame implements ActionListener{
	private JTable table;
	private DefaultTableModel dtm;
	private JButton buttonAdd;
	private JButton buttonDelete;
	private JButton buttonUpdate;
	private JButton buttonAddToCart;
	private JFrame Add;
	private JFrame Delete;
	private JFrame Update;
	private View_TransactionManagement viewCart;
	
	public View_Product(int roleID) {
		initLayout(roleID);
		setUpData();
		AddProduct();
		DeleteProduct();
		UpdateProduct();
		prepCartFrame();
	
	}

	private void initLayout(int roleID) {
		//JFrame
		setTitle("Product Management");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new GridLayout(2, 1, 10, 10));
		setContentPane(contentPane);
		
		JScrollPane scroll = new JScrollPane();
		
		table = new JTable();
		
		scroll.setViewportView(table);
		contentPane.add(scroll);
	
		JPanel panelCtrl = new JPanel();
		panelCtrl.setLayout(new GridLayout(1, 2, 10, 10));
		
		JPanel panelP = new JPanel();
		panelP.setLayout(new GridLayout(3,2));
		
		// JPanel Buttons
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.Y_AXIS));
				
		// JButton Add
		buttonAdd = new JButton("Add Product");
		buttonAdd.addActionListener(this);
		panelButtons.add(buttonAdd);
		
		// JButton Delete
		buttonDelete = new JButton("Delete Product");
		buttonDelete.addActionListener(this);
		panelButtons.add(buttonDelete);
		
		//JButton Update
		buttonUpdate = new JButton("Update Product");
		buttonUpdate.addActionListener(this);
		panelButtons.add(buttonUpdate);
		
		
		JPanel panelCashierButtons = new JPanel();
		panelCashierButtons.setLayout(new BoxLayout(panelCashierButtons, BoxLayout.Y_AXIS));
		
		// JButton AddToCart
		buttonAddToCart = new JButton("Add to Cart");
		buttonAddToCart.addActionListener(this);
		panelCashierButtons.add(buttonAddToCart);		
		
		panelCtrl.add(panelP);
		
		if (roleID == 1) {
			// IF CASHIER
			panelCtrl.add(panelCashierButtons);			
		} else if (roleID == 2) {
			// IF NOT CASHIER
			panelCtrl.add(panelButtons);			
		}
		
		contentPane.add(panelCtrl);
		
		contentPane.setVisible(true);
	}
	
	private void setUpData() {
		dtm = new DefaultTableModel(
			new String[] {"Product ID", "Name", "Description", "Price", "Stock"}, 
			0
		);
		table.setModel(dtm);
	}
	
	private void prepCartFrame() {
		
		viewCart = new View_TransactionManagement();
		viewCart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

	
	private void AddProduct() {
		
		Add = new JFrame();
		
		Add.setTitle("Add Product");
		Add.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		Add.setBounds(200, 200, 400, 300);
		
		Container Cont = Add.getContentPane();
		Cont.setLayout(null);
		
		JLabel Title = new JLabel("Add Product");
		Title.setBounds(120, 5, 200, 30);
		
		JLabel Id_Label = new JLabel("Product ID: ");
		Id_Label.setBounds(20, 30, 200, 30);
		
		JLabel Name_Label = new JLabel("Name: ");
		Name_Label.setBounds(20, 60, 200, 30);
		
		JLabel Desc_Label = new JLabel("Description: ");
		Desc_Label.setBounds(20, 90, 200, 30);
		
		JLabel Price_Label = new JLabel("Price: ");
		Price_Label.setBounds(20, 120, 200, 30);
		
		JLabel Stock_Label = new JLabel("Stock: ");
		Stock_Label.setBounds(20, 150, 200, 30);
		
		JSpinner Id_Field = new JSpinner();
		Id_Field.setBounds(100, 30, 200, 30);
		
		JTextField Name_Field = new JTextField();
		Name_Field.setBounds(100, 60, 200, 30);
		
		JTextField Desc_Field = new JTextField();
		Desc_Field.setBounds(100, 90, 200, 30);
		
		JSpinner Price_Field = new JSpinner();
		Price_Field.setBounds(100, 120, 200, 30);
		
		JSpinner Stock_Field = new JSpinner();
		Stock_Field.setBounds(100, 150, 200, 30);

		JButton AddBtn = new JButton("Add");
		AddBtn.setBounds(150, 200, 100, 30);
		
		Cont.add(Title);
		Cont.add(Id_Label);
		Cont.add(Name_Label);
		Cont.add(Desc_Label);
		Cont.add(Price_Label);
		Cont.add(Stock_Label);
		Cont.add(Id_Field);
		Cont.add(Name_Field);
		Cont.add(Desc_Field);
		Cont.add(Price_Field);
		Cont.add(Stock_Field);
		Cont.add(AddBtn);
		
		int id = (int) Id_Field.getValue();
		String name = Name_Field.getText();
		String desc = Desc_Field.getText();
		int price = (int) Price_Field.getValue();
		int stock = (int) Stock_Field.getValue();	
	}
	


	private void DeleteProduct() {
		Delete = new JFrame();
		
		Delete.setTitle("Delete Product");
		Delete.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		Delete.setBounds(200, 200, 400, 200);
		
		Container Cont = Delete.getContentPane();
		Cont.setLayout(null);
		
		JLabel Title = new JLabel("Delete Product");
		Title.setBounds(100, 5, 200, 30);
		
		JLabel Id_Label = new JLabel("Product ID: ");
		Id_Label.setBounds(20, 30, 200, 30);
		
		JSpinner Id_Field = new JSpinner();
		Id_Field.setBounds(100, 30, 200, 30);
		
		JButton DelBtn = new JButton("Delete");
		DelBtn.setBounds(120, 90, 100, 30);
		
		Cont.add(Title);
		Cont.add(Id_Label);
		Cont.add(Id_Field);
		Cont.add(DelBtn);
		
		int id = (int) Id_Field.getValue();
				
		
	}
	
	private void UpdateProduct() {
		
		Update = new JFrame();
		
		Update.setTitle("Update Product");
		Update.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		Update.setBounds(200, 200, 400, 300);
		
		Container Cont = Update.getContentPane();
		Cont.setLayout(null);
		
		JLabel Title = new JLabel("Update Product");
		Title.setBounds(120, 5, 200, 30);
		
		JLabel Id_Label = new JLabel("Product ID: ");
		Id_Label.setBounds(20, 30, 200, 30);
		
		JLabel Name_Label = new JLabel("Name: ");
		Name_Label.setBounds(20, 60, 200, 30);
		
		JLabel Desc_Label = new JLabel("Description: ");
		Desc_Label.setBounds(20, 90, 200, 30);
		
		JLabel Price_Label = new JLabel("Price: ");
		
		Price_Label.setBounds(20, 120, 200, 30);
		
		JLabel Stock_Label = new JLabel("Stock: ");
		Stock_Label.setBounds(20, 150, 200, 30);
		
		JSpinner Id_Field = new JSpinner();
		Id_Field.setBounds(100, 30, 200, 30);
		
		JTextField Name_Field = new JTextField();
		Name_Field.setBounds(100, 60, 200, 30);
		
		JTextField Desc_Field = new JTextField();
		Desc_Field.setBounds(100, 90, 200, 30);
		
		JSpinner Price_Field = new JSpinner();
		Price_Field.setBounds(100, 120, 200, 30);
		
		JSpinner Stock_Field = new JSpinner();
		Stock_Field.setBounds(100, 150, 200, 30);

		JButton SaveBtn = new JButton("Save");
		SaveBtn.setBounds(150, 200, 100, 30);
		
		Cont.add(Title);
		Cont.add(Id_Label);
		Cont.add(Name_Label);
		Cont.add(Desc_Label);
		Cont.add(Price_Label);
		Cont.add(Stock_Label);
		Cont.add(Id_Field);
		Cont.add(Name_Field);
		Cont.add(Desc_Field);
		Cont.add(Price_Field);
		Cont.add(Stock_Field);
		Cont.add(SaveBtn);
		
		int id = (int) Id_Field.getValue();
		String name = Name_Field.getText();
		String desc = Desc_Field.getText();
		int price = (int) Price_Field.getValue();
		int stock = (int) Stock_Field.getValue();
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonAdd) {
			AddProduct();
			Add.setVisible(true);
		} else if (e.getSource() == buttonDelete) {
			DeleteProduct();
			Delete.setVisible(true);
		} else if (e.getSource() == buttonUpdate) {
			UpdateProduct();
			Update.setVisible(true);
		} else if (e.getSource() == buttonAddToCart) {
			viewCart.setVisible(true);
		} 
		
	}
}
