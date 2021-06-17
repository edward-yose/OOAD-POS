package controller;

import view.View_TransactionManagement;

import java.util.ArrayList;
import java.util.List;

import model.Cart;
import model.Product;


public class CartController {
	
	private static int grandTotal=0;

	public static String addItem(int productid, int qty) {
		if(productid==0) {
			return "cannot be empty";
		}
		if(Product.selectExist(productid)==false) {
			return "must exist in database!";
		}

		if(qty <=0) {
			return "Cannot below zero";
		}
		if(Product.stockCheck(productid)<qty)
		{
			return "Insufficient stock";
<<<<<<< Updated upstream
<<<<<<< Updated upstream
		}
		if(Cart.exist(productid)==false) {
			Cart i = new Cart(productid, qty);
			boolean isSuccess = i.insert();
			if(isSuccess == false) {
				return "Insert Failed";
				}
				else {
					grandTotal+=Product.getPrice(productid)*qty;
					return null;
				}
		}
		else {
			Cart i = new Cart(productid, qty);
			boolean isSuccess = i.update();
			if(isSuccess == false) {
				return "Adding Failed";
				}
				else {
					grandTotal+=Product.getPrice(productid)*qty;
					return null;
				}
		}
=======
=======
>>>>>>> Stashed changes
		}
		
		Cart i = new Cart(0, qty);
		boolean isSuccess = i.insert();
		
		if(isSuccess == false) {
		return "Insert Failed";
<<<<<<< Updated upstream
		}
		else {
			return null;
		}
=======
		}
		else {
			return null;
		}
>>>>>>> Stashed changes
			
		

		
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
	}

	
	public static String removeItem(int productid,int qty) {
		if(productid==0) {
			return "cannot be empty";
		}
		if(Product.selectExist(productid)==false) {
			return "must exist in database!";
		}
		int cartqty=Cart.getQty(productid);
		
		Cart i = new Cart(productid,qty);
		boolean isSuccess = i.delete();
		
		if(isSuccess == false) {
			return "remove Failed";
		}
		else {
			grandTotal-=Product.getPrice(productid)*cartqty;
			
			return null;
		}
	}


	public static int getGrandTotal() {
		return grandTotal;
	}


}
