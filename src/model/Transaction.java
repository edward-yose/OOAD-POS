package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import connect.Connector;

public class Transaction {
	
	private Integer id;
	private Date purchaseDate;
	private Integer employeeId;
	private String paymentType;
	
	private Connector con;
	

	public Transaction() {
		// TODO Auto-generated constructor stub
	}


	public Transaction(int id, Date purchaseDate, int employeeId, String paymentType) {
		this.id = id;
		this.purchaseDate = purchaseDate;
		this.employeeId = employeeId;
		this.paymentType = paymentType;
	}
	
	public static Vector<Transaction> getAllTransaction(){
		Vector<Transaction> results = new Vector<Transaction>();
		
		try {
			Statement st = Connector.connect().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM transaction");
			
			while(rs.next()) {
				results.add(new Transaction(
							rs.getInt("id"),
							rs.getDate("purchaseDate"),
							rs.getInt("employeeId"),
							rs.getString("paymentType")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return results;
	}
	
	public static Vector<Transaction> viewTransactionReport(int month, int year) {
		Vector<Transaction> results = new Vector<Transaction>();
		String query = "SELECT * FROM transaction WHERE MONTH(purchaseDate) = ? AND YEAR(purchaseDate) = ? ";	
		
		try {
			PreparedStatement ps = Connector.connect().prepareStatement(query);
			ps.setInt(1, month);
			ps.setInt(2, year);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				results.add(new Transaction(
						rs.getInt("id"),
						rs.getDate("purchaseDate"),
						rs.getInt("employeeId"),
						rs.getString("paymentType")
					));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return results;
	}
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public Integer getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}


	public String getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}


	public Connector getCon() {
		return con;
	}


	public void setCon(Connector con) {
		this.con = con;
	}
	
	
	
}
