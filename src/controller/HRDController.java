package controller;

import java.util.Vector;

import model.Employee;
import model.Role;

public class HRDController {
	
	public static Vector<Employee> getAllEmployee(){
		return Employee.getAllEmployee();
	}
	
//	public static String addEmployee (Integer id, Integer roleID, String name, String username, Integer salary, String password) {
//		
//		if(name.length()>0 && password.length()>0 && salary > 0) {
//			if(password.length()>0) {
//				password = username;
//				Employee.AddEmployee(id, roleID, name, username, salary, password);
//			}
//		}else {
//			return "add failed";
//		}
//		return null;
//	}
//	public static String updateEmployee (Integer id, Integer roleID, String name, String username, Integer salary, String password) {
//		if(name.length()>0 && password.length()>0 && salary > 0) {
//			if(password.length()>0) {
//				password = username;
//				Employee.EditEmployee(id, roleID, name, username, salary, password);
//			}
//		}else {
//			return "edit failed";
//		}
//		return null;
//	}
//	public static String deleteEmployee (Integer id, Integer roleID, String name, String username, Integer salary, String password) {
//		
//		if(name.length()>0 && password.length()>0 && salary > 0) {
//			if(password.length()>0) {
//				password = username;
//				Employee.DeleteEmployee(roleID, "Not Active");
//			}
//		}else {
//			return "delete failed";
//		}
//		return null;
//	}
	
	public static String addUser(Integer id, Integer roleID, String name, String username, Integer salary, String status, String password) {
		if(roleID<0) return "roleID must not be empty";
		if(name.isEmpty()) return "name must not be empty";
		if(username.isEmpty()) return "username must not be empty";
		if(salary<=0) return "salary must not be 0 nor negaive value";
		if(password.isEmpty()) password = username;
		
		Employee e = new Employee(id, roleID, name, username, salary, status, password);
		boolean isSuccess = e.add_user();
		
		if(!isSuccess) return "add failed"; 
		else return null;
		
	}
	public static String editUser(Integer id, Integer roleID, String name, String username, Integer salary, String status, String password) {
		if(roleID<0) return "roleID must not be empty";
		if(name.isEmpty()) return "name must not be empty";
		if(username.isEmpty()) return "username must not be empty";
		if(salary<=0) return "salary must not be 0 nor negaive value";
		
		Employee e = new Employee(id, roleID, name, username, salary, status, password);
		boolean isSuccess = e.add_user();
		
		if(!isSuccess) return "add failed"; 
		else return null;
		
	}
	
	public static String deleteUser(Integer id) {
		
		Employee e = new Employee(id, null, null, null, null, "Not Active", null);
		boolean isSuccess = e.add_user();
		
		if(!isSuccess) return "add failed"; 
		else return null;
		
	}
	
	
	public HRDController() {
		
	}
}
