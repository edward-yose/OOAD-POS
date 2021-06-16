package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import Connect.Connect;

public class Product {
	private Integer id;
	private String name;
	private String description;
	private Integer price;
	private Integer stock;
	
	private Connect conn;
	
	public Product(Integer id, String name, String description, Integer price, Integer stock) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}
	
	public Product View() {
		
		String q = "SELECT * FROM Product";
		PreparedStatement ps = conn.PrepareStatement(q);
		
		
		try {
			ps.setInt(1, this.id);
			ps.setString(2, name);
			ps.setString(3, this.description);
			ps.setInt(4, this.price);
			ps.setInt(5, this.stock);
			ResultSet rs = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Connect getConn() {
		return conn;
	}

	public void setConn(Connect conn) {
		this.conn = conn;
	}
	
	
}

