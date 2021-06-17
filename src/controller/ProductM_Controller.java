package controller;

import java.util.List;

import view.View_Product;
import model.Product;

public class ProductM_Controller {

	public static List<Product> getAllProduct(){ 
		return Product.getAllProducts();
	}
	
	public static int addProduct(Integer id, String name, String description, Integer price, Integer stock) {
		 Product prod = new Product();
		 prod = Product.AddProduct(product);
		
		
		
		return addProduct;
		
	}
}
