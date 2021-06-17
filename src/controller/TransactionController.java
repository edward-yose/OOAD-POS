package controller;

import java.util.Vector;

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

	public TransactionController() {
		// TODO Auto-generated constructor stub
	}

}
