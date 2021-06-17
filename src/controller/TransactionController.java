package controller;

import java.util.Vector;

import model.Cart;
import model.Product;
import model.Transaction;
import model.TransactionItem;

public class TransactionController {
	
	
	public static Vector<Transaction> getAllTransactions() {
		return Transaction.getAllTransaction();
	}
	
	public static Vector<Transaction> viewTransactionReport(int month, int year) {
		return Transaction.viewTransactionReport(month, year);
	}
	
	public static Vector<TransactionItem> getAllTransactionItem(int transactionId) {
		return TransactionItem.getTransactionItem(transactionId);
	}
	
	public static String pushTransaction(int employeeid,String paymentType) {
		Transaction i = new Transaction(0, null,employeeid, paymentType);
		boolean isSuccess = i.pushTransaction();
		if(isSuccess == false) {
			return "Insert Failed";
			}
			else {
				model.Cart.deleteAll();
				controller.CartController.setGrandTotal(0);
				return null;
			}
	}

	public TransactionController() {
		// TODO Auto-generated constructor stub
	}

}
