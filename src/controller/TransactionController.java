package controller;

import java.util.Vector;

import model.Transaction;

public class TransactionController {
	
	public static Vector<Transaction> getAllTransactions() {
		return Transaction.getAllTransaction();
	}
	
	public static Vector<Transaction> viewTransactionReport(int month, int year) {
		return Transaction.viewTransactionReport(month, year);
	}

	public TransactionController() {
		// TODO Auto-generated constructor stub
	}

}
