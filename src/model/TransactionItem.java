package model;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import connect.Connect;

public class TransactionItem {
	private int transactionid;
	private int productid;
	private int quantity;
	
	public TransactionItem(int transactionid, int productid, int quantity) {
		this.transactionid = transactionid;
		this.productid=productid;
		this.quantity=quantity;
	}

	public boolean insert() {
		try {
			PreparedStatement ps = Connect.connect().prepareStatement("INSERT INTO transactionitem values(?,?,?)");
			ps.setInt(1,transactionid);
			ps.setInt(2,productid);
			ps.setInt(3, quantity);
			return (ps.executeUpdate() == 1);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error insert");
			return false;
		}
		
	}
	
	public static Vector<TransactionItem> getTransactionItem(int transactionId) {
		Vector<TransactionItem> results = new Vector<TransactionItem>();
		String query = "SELECT * FROM TransactionItem WHERE transactionID = ? ";	
		
		try {
			PreparedStatement ps = Connect.connect().prepareStatement(query);
			ps.setInt(1, transactionId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				results.add(new TransactionItem(
						rs.getInt("transactionID"),
						rs.getInt("productID"),
						rs.getInt("quantity")
					));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return results;
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
