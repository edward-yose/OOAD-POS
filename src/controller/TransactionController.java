package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import connect.Connect;
import model.Transaction;
import model.TransactionItem;

public class TransactionController {
	
	private int id=0;
	private int date=0;
	private int employeeid=0;
	private String paymentMethod;
	
	public TransactionController(int id, int date, int employeeid, String paymentMethod) {
		this.id=id;
		this.date=date;
		this.employeeid=employeeid;
		this.paymentMethod=paymentMethod;
	}
	
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
	
	public boolean insertTransaction() {
		try {
			PreparedStatement ps = Connect.connect().prepareStatement("INSERT INTO transaction values(?,?,?,?)");
			ps.setInt(1, id);
			ps.setInt(2, date);
			ps.setInt(3, employeeid);
			ps.setString(4, paymentMethod);
			return (ps.executeUpdate() == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error insert transaction");
			return false;
		}
		
	}

}
