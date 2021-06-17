package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import connect.Connect;

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
	
	public Product() {
		
	}
	
	public static List<Product> getAllProducts() {
		
		List<Product> ProductList = new ArrayList<Product>();
		
		try {
			Statement st = Connect.connect().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM product");
			
			while (rs.next()) {
				Product product = new Product(rs.getInt("id"), rs.getString("name"), 
						rs.getString("description"), rs.getInt("price"), rs.getInt("stock"));
				ProductList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ProductList;
	}
	
	public static Product AddProduct(int id, String name, String description, int price, int stock) {
		List<Product> prod = new ArrayList<Product>();
		
		try {
			PreparedStatement ps = Connect.connect().prepareStatement("INSERT INTO product VALUES(?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, description);
			ps.setInt(4, price);
			ps.setInt(5, stock);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				prod.add(new Product(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("description"),
						rs.getInt("price"),
						rs.getInt("stock")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prod.get(0);
	}
		
	public static int UpdateProduct(Product product) {
		int status = 0;
		
		try {
			PreparedStatement ps = Connect.connect().prepareStatement("UPDATE product SET name=?, description=?, price=?, stock=? WHERE id=?");
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setInt(3, product.getPrice());
			ps.setInt(4, product.getStock());
			ps.setInt(5, product.getId());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static int DeleteProduct(int id) {
		
		int status = 0;
		
		try {
			PreparedStatement ps = Connect.connect().prepareStatement("DELETE FROM product WHERE id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public static boolean selectExist(int productid) {
		try {
			PreparedStatement ps = Connect.connect().prepareStatement("Select * FROM product WHERE id=?");
			ps.setInt(1, productid);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static int stockCheck(int productid) {
		try {
			PreparedStatement ps = Connect.connect().prepareStatement("SELECT * FROM product WHERE id=?");
			ps.setInt(1, productid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(5);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static int getPrice(int productid) {
		try {
			PreparedStatement ps = Connect.connect().prepareStatement("SELECT * FROM product WHERE id=?");
			ps.setInt(1, productid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(4);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;

		}	
	}
	
	public boolean updateStock() {
		try {
			Statement st = Connect.connect().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM cartitem");
			while(rs.next()) {
				int productidtemp;
				int qtytemp;
				productidtemp=rs.getInt("productid");
				qtytemp=rs.getInt("quantity");
				PreparedStatement ps = Connect.connect().prepareStatement("update product set stock=stock-? where id=?");
				ps.setInt(1,qtytemp);
				ps.setInt(2, productidtemp);
				ps.executeUpdate();
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
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

