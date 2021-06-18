package controller;

import connect.Connect;

import java.util.Vector;

import model.Employee;
import model.Role;

public class HRDController {
	
	public static Vector<Employee> getAllEmployee(){
		return Employee.getAllEmployee();
	}
	
	public static int addEmployee (Integer id, Integer roleID, String name, String username, Integer salary, String password) {
		
		if(name.length()>0 && password.length()>0 && salary > 0) {
			if(password.length()>0) {
				password = username;
				Employee.AddEmployee(roleID, name, username, salary, password);
			}
		}else {
			return -1;
		}
		return 0;
	}
	public static int updateEmployee (Integer id, Integer roleID, String name, String username, Integer salary, String password) {
		
		if(name.length()>0 && password.length()>0 && salary > 0) {
			if(password.length()>0) {
				password = username;
				Employee.EditEmployee(id, roleID, name, username, salary, password);
			}
		}else {
			return -1;
		}
		return 0;
	}
	public static int deleteEmployee (Integer id, Integer roleID, String name, String username, Integer salary, String password) {
		
		if(name.length()>0 && password.length()>0 && salary > 0) {
			if(password.length()>0) {
				password = username;
				Employee.DeleteEmployee(roleID, "Not Active");
			}
		}else {
			return -1;
		}
		return 0;
	}
	public HRDController() {
		
	}
}
