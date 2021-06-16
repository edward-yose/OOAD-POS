package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class View_Product extends JFrame implements ActionListener{
	private JTable table;
	private DefaultTableModel dtm;
	private JButton buttonAdd;
	private JButton buttonDelete;
	private JButton buttonUpdate;
	private JButton buttonSave;
	private JFrame productFrame; 
	private JLabel Id_Label;
	private JLabel Name_Label;
	private JLabel Desc_Label;
	private JLabel Price_Label;
	private JLabel Stock_Label;
	private JPanel Add_Panel;
	private JTextField Name_field;
	private JTextField Desc_field;
	private JTextField Id_field;
	private JTextField Price_field;
	private JTextField Stock_field;
	
	public View_Product() {
		initLayout();
		setUpData();
		AddProduct();
		
	}
	
	private void initLayout() {
		//JFrame
		setTitle("Product Management");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new GridLayout(2, 1, 10, 10));
		setContentPane(contentPane);
	
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
		
		setVisible(true);
	}
	
	private void setUpData() {
		dtm = new DefaultTableModel(new String[] {"Product ID", "Name", "Description", "Price", "Stock"}, 0);
		table.setModel(dtm);
	}
	
	private void AddProduct() {
		
		productFrame = new JFrame();
		
		productFrame.setTitle("Add Product");
		productFrame.setSize(300, 600);
		productFrame.setLocationRelativeTo(null);
		productFrame.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		Add_Panel = new JPanel(new GridLayout(2, 5));
		Id_Label = new JLabel("Product ID: ");
		Name_Label = new JLabel("Name: ");
		Desc_Label = new JLabel("Description: ");
		Price_Label = new JLabel("Price: ");
		Stock_Label = new JLabel("Stock: ");
		Id_field = new JTextField();
		Name_field = new JTextField();
		Desc_field = new JTextField();
		Price_field = new JTextField();
		Stock_field = new JTextField();
		
		Add_Panel.add(Id_Label);
		Add_Panel.add(Id_field);
		
		Add_Panel.add(Name_Label);
		Add_Panel.add(Name_field);
		
		Add_Panel.add(Desc_Label);
		Add_Panel.add(Desc_field);
		
		Add_Panel.add(Price_Label);
		Add_Panel.add(Price_field);
		
		Add_Panel.add(Stock_Label);
		Add_Panel.add(Stock_field);
		
		add(Add_Panel, BorderLayout.CENTER);
		
		buttonSave = new JButton("Add");
		add(buttonSave, BorderLayout.SOUTH);
	}
	
	private void DeleteProduct() {
		productFrame = new JFrame();
		
		productFrame.setTitle("Delete Product");
		productFrame.setSize(300, 600);
		productFrame.setLocationRelativeTo(null);
		productFrame.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		Add_Panel = new JPanel(new GridLayout(2, 1));
		
		Id_Label = new JLabel("Product ID: ");
		Id_field = new JTextField();
		
		Add_Panel.add(Id_Label);
		Add_Panel.add(Id_field);
		
		buttonDelete = new JButton("Delete");
		add(buttonDelete, BorderLayout.SOUTH);
	}
	
	private void UpdateProduct() {
		productFrame = new JFrame();

		productFrame.setTitle("Add Product");
		productFrame.setSize(300, 600);
		productFrame.setLocationRelativeTo(null);
		productFrame.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		Add_Panel = new JPanel(new GridLayout(2, 5));
		Id_Label = new JLabel("Product ID: ");
		Name_Label = new JLabel("Name: ");
		Desc_Label = new JLabel("Description: ");
		Price_Label = new JLabel("Price: ");
		Stock_Label = new JLabel("Stock: ");
		Id_field = new JTextField();
		Name_field = new JTextField();
		Desc_field = new JTextField();
		Price_field = new JTextField();
		Stock_field = new JTextField();
		
		Add_Panel.add(Id_Label);
		Add_Panel.add(Id_field);
		
		Add_Panel.add(Name_Label);
		Add_Panel.add(Name_field);
		
		Add_Panel.add(Desc_Label);
		Add_Panel.add(Desc_field);
		
		Add_Panel.add(Price_Label);
		Add_Panel.add(Price_field);
		
		Add_Panel.add(Stock_Label);
		Add_Panel.add(Stock_field);
		
		add(Add_Panel, BorderLayout.CENTER);
		
		buttonSave = new JButton("Save");
		add(buttonSave, BorderLayout.SOUTH);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonAdd) {
			AddProduct();
		} else if (e.getSource() == buttonDelete) {
			DeleteProduct();
		} else if (e.getSource() == buttonUpdate) {
			UpdateProduct();
		}
		
	}
}
