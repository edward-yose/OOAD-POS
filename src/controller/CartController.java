package controller;

import view.View_TransactionManagement;

import java.util.ArrayList;
import java.util.List;

import model.Cart;
import model.Product;


public class CartController {

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
		}
		
<<<<<<< Updated upstream
		Cart i = new Cart(productid, qty);
=======
		Cart i = new Cart(0, qty);
>>>>>>> Stashed changes
		boolean isSuccess = i.insert();
		
		if(isSuccess == false) {
		return "Insert Failed";
		}
		else {
			return null;
		}
			
		

		
	}
	
	public static String removeItem(int productid,int qty) {
		if(productid==0) {
			return "cannot be empty";
		}
		if(Product.selectExist(productid)==false) {
			return "must exist in database!";
		}
		
		Cart i = new Cart(productid,qty);
		boolean isSuccess = i.delete();
		
		if(isSuccess == false) {
			return "remove Failed";
		}
		else return null;
	}
	

}
