package controller;

import java.util.List;

import view.View_Product;
import model.Product;
import model.TransactionItem;

public class ProductM_Controller {

	public static List<Product> getAllProduct(){ 
		return Product.getAllProducts();
	}
	
	public static int addProduct(Integer id, String name, String description, Integer price, Integer stock) {
		Product prod = new Product();
		prod = Product.AddProduct(id, name, description, price, stock);
		
		
		
		return 0;
		
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
