package model;

//package 
import connect.Connect;

import java.sql.*;
import java.util.Vector;


public class Cart {
	private int productid;
	private int qty;
	
	public Cart(int productid, int qty) {
		this.productid = productid;
		this.qty = qty;
	}
	public static Vector <Cart> view(){
		Vector<Cart> itemm = new Vector<Cart>();
		try {
			Statement st = Connect.connect().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM cartitem");
			
			while(rs.next()) {
				itemm.add(new Cart(rs.getInt("productid"), rs.getInt("quantity")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error show cart item");
		}
		return itemm;
	}
	
	public boolean insert() {
		try {
			PreparedStatement ps = Connect.connect().prepareStatement("INSERT INTO cartitem values(?,?)");
			ps.setInt(1, productid);
			ps.setInt(2, qty);
			return (ps.executeUpdate() == 1);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error insert cart item");
			return false;
		}
		
	}
	
	public boolean update() {
		try {
			PreparedStatement ps = Connect.connect().prepareStatement("update cartitem set quantity=? where productid=?");
			ps.setInt(1, qty);
			ps.setInt(2, productid);
			return ps.executeUpdate() ==1;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error update cart item");
			return false;
		}
	}
	
	public boolean delete() {
		try {
			PreparedStatement ps = Connect.connect().prepareStatement("delete from cartitem where productid=?");
			ps.setInt(1, productid);
			return ps.executeUpdate() ==1;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error delete cart item");
			return false;
		}	
	}
	
	public boolean deleteAll() {
		try {
			PreparedStatement ps = Connect.connect().prepareStatement("delete from cartitem");
			return ps.executeUpdate() ==1;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error delete all");
			return false;
		}	
	}
	
	public int select() {
		try {
			PreparedStatement ps = Connect.connect().prepareStatement("Select * from cartitem where productid=?");
			ps.setInt(1, productid);
			ResultSet rs = ps.executeQuery();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}

