package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public Employee() {
		
	}
	public Employee(Integer id, Integer roleID, String name, String username, Integer salary, String status, String password) {
		this.id = id;
		this.roleID = roleID;
		this.name = name;
		this.username = username;
		this.salary = salary;
		this.status = status;
		this.password = password;
	}
	
	public static List<Employee> getAllEmployee(){
		List<Employee> EmployeeList = new ArrayList<Employee>();
		
		try {
			Statement st = Connect.connect().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM employee");
			
			while (rs.next()) {
				Employee employee = new Employee(rs.getInt("id"), rs.getInt("roleID"), rs.getString("name"), rs.getString("username"), rs.getInt("salary"), rs.getString("status"), rs.getString("password"));
				EmployeeList.add(employee);
			}
		} catch (SQLException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		return EmployeeList;
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
