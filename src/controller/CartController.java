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
		}
		if(Cart.exist(productid)==false) {
			Cart i = new Cart(productid, qty);
			boolean isSuccess = i.insert();
			if(isSuccess == false) {
				return "Insert Failed";
				}
				else {
					grandTotal+=Product.getPrice(productid);
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
					grandTotal+=Product.getPrice(productid);
					return null;
				}
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
		else {
			grandTotal-=Product.getPrice(productid);
			return null;
		}
	}


	public static int getGrandTotal() {
		return grandTotal;
	}


}
