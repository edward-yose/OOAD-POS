package model;

import connect.Connect;
import java.sql.*;


public class Product {
	private int id;
	
	public int price() {
		try {
			PreparedStatement ps = Connect.connect().prepareStatement("Select * from product where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			return rs.getInt(4);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int stock() {
		try {
			PreparedStatement ps = Connect.connect().prepareStatement("Select * from product where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			return rs.getInt(5);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public boolean available() {
		try {
			PreparedStatement ps = Connect.connect().prepareStatement("Select * from product where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateStock(int stockMin, int id) {
		try {
			PreparedStatement ps = Connect.connect().prepareStatement("update product set stock=? where id=?");
			ps.setInt(1, stockMin );
			ps.setInt(2, id);
			return ps.executeUpdate() ==1;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error update cart item");
			return false;
		}
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}
