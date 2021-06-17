package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import connect.Connect;

public class Employee {

	private Integer id;
	private Integer roleID;
	private String name;
	private String username;
	private Integer salary;
	private String status;
	private String password;
	
	private Connect connect;
	
	
	public Employee(Integer id, Integer roleID, String name, String username, Integer salary, String status, String password) {
		this.id = id;
		this.roleID = roleID;
		this.name = name;
		this.username = username;
		this.salary = salary;
		this.status = status;
		this.password = password;
	}
	
	public Employee() {
		
	}
	
	public static Vector<Employee> getEmployee(int id) {
		Vector<Employee> results = new Vector<Employee>();
		String query = "SELECT * FROM Employee WHERE id = ? ";	
		
		try {
			PreparedStatement ps = Connect.connect().prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				results.add(new Employee(
						rs.getInt("id"),
						rs.getInt("roleID"),
						rs.getString("name"),
						rs.getString("username"),
						rs.getInt("salary"),
						rs.getString("status"),
						rs.getString("password")
					));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return results;
	}
	
	public static Vector<Employee> getEmployeeByUsername(String username) {
		Vector<Employee> results = new Vector<Employee>();
		String query = "SELECT * FROM Employee WHERE username = ? ";	
		
		try {
			PreparedStatement ps = Connect.connect().prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				results.add(new Employee(
						rs.getInt("id"),
						rs.getInt("roleID"),
						rs.getString("name"),
						rs.getString("username"),
						rs.getInt("salary"),
						rs.getString("status"),
						rs.getString("password")
					));				
			}
			
			if(results.size() == 0) {
				results.add(new Employee(0,null,null,null,null,null,null));
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
	public Integer getRoleID() {
		return roleID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Connect getConnect() {
		return connect;
	}
	public void setConnect(Connect connect) {
		this.connect = connect;
	}
}
