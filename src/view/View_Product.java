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
import javax.swing.JScrollPane;
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
	private JFrame productFrame1;
	private JFrame productFrame2;
	private JFrame productFrame3;
	private JPanel Add_Panel;
	private JPanel Delete_Panel;
	private JPanel Edit_Panel;
	private JTextField Name_field;
	private JTextField Desc_field;
	private JTextField Id_field;
	private JTextField Price_field;
	private JTextField Stock_field;
	
	public View_Product() {
		initLayout();
		setUpData();
		AddProduct();
		DeleteProduct();
		UpdateProduct();
	
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
		
		JScrollPane scroll = new JScrollPane();
		
		table = new JTable();
		
		scroll.setViewportView(table);
		add(scroll);
	
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
		
		panelCtrl.add(panelP);
		panelCtrl.add(panelButtons);
		
		add(panelCtrl);
		
		setVisible(true);
	}
	
	private void setUpData() {
		dtm = new DefaultTableModel(
			new String[] {"Product ID", "Name", "Description", "Price", "Stock"}, 
			0
		);
		table.setModel(dtm);
	}

	
	private void AddProduct() {
		
		productFrame1 = new JFrame();
		
		productFrame1.setTitle("Add Product");
		productFrame1.setSize(300, 600);
		productFrame1.setLocationRelativeTo(null);
		productFrame1.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		Add_Panel = new JPanel(new GridLayout(2, 5));
		JLabel Id_Label = new JLabel("Product ID: ");
		JLabel Name_Label = new JLabel("Name: ");
		JLabel Desc_Label = new JLabel("Description: ");
		JLabel Price_Label = new JLabel("Price: ");
		JLabel Stock_Label = new JLabel("Stock: ");
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
		productFrame2 = new JFrame();
		
		productFrame2.setTitle("Delete Product");
		productFrame2.setSize(300, 600);
		productFrame2.setLocationRelativeTo(null);
		productFrame2.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		Delete_Panel = new JPanel(new GridLayout(2, 1));
		
		JLabel Id_Label = new JLabel("Product ID: ");
		Id_field = new JTextField();
		
		Delete_Panel.add(Id_Label);
		Delete_Panel.add(Id_field);
		
		add(Delete_Panel, BorderLayout.CENTER);
		
		buttonDelete = new JButton("Delete");
		add(buttonDelete, BorderLayout.SOUTH);
		
		
	}
	
	private void UpdateProduct() {
		productFrame3 = new JFrame();

		productFrame3.setTitle("Edit Product");
		productFrame3.setSize(300, 600);
		productFrame3.setLocationRelativeTo(null);
		productFrame3.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		Edit_Panel = new JPanel(new GridLayout(2, 5));
		JLabel Id_Label = new JLabel("Product ID: ");
		JLabel Name_Label = new JLabel("Name: ");
		JLabel Desc_Label = new JLabel("Description: ");
		JLabel Price_Label = new JLabel("Price: ");
		JLabel Stock_Label = new JLabel("Stock: ");
		Id_field = new JTextField();
		Name_field = new JTextField();
		Desc_field = new JTextField();
		Price_field = new JTextField();
		Stock_field = new JTextField();
		
		Edit_Panel.add(Id_Label);
		Edit_Panel.add(Id_field);
		
		Edit_Panel.add(Name_Label);
		Edit_Panel.add(Name_field);
		
		Edit_Panel.add(Desc_Label);
		Edit_Panel.add(Desc_field);
		
		Edit_Panel.add(Price_Label);
		Edit_Panel.add(Price_field);
		
		Edit_Panel.add(Stock_Label);
		Edit_Panel.add(Stock_field);
		
		add(Edit_Panel, BorderLayout.CENTER);
		
		buttonSave = new JButton("Save");
		add(buttonSave, BorderLayout.SOUTH);
		
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonAdd) {
			AddProduct();
			productFrame1.setVisible(true);
		} else if (e.getSource() == buttonDelete) {
			DeleteProduct();
			productFrame2.setVisible(true);
		} else if (e.getSource() == buttonUpdate) {
			UpdateProduct();
			productFrame3.setVisible(true);
		}
		
	}
}
