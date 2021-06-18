package controller;

import java.util.Vector;

import view.View_Product;
import model.Product;
import model.TransactionItem;

public class ProductM_Controller {

	public static Vector<Product> getAllProduct(){ 
		return Product.getAllProducts();
	}
	
	public static String AddProduct(int id, String name, String description, int price, int stock) {
		//validation
		if (id == 0) return "ID cannot be null";
		if (name.isEmpty()) return "Name cannot be empty";
		if (description.isEmpty()) return "Description cannot be empty";
		if (price <= 0) return "Price must be above 0";
		if (stock <= 0) return "Stock must be above 0";
		
		Product p = new Product(id, name, description, price, stock);
		boolean isSuccess = p.AddProduct();
		
		
	}
	
	public static String updateStock() {
		Product i = new Product(0,"","",0,0);
		boolean isSuccess = i.updateStock();
		if(isSuccess == false) {
			return "Insert Failed";
			}
			else {
				return null;
			}
	}
	
	
	
}
