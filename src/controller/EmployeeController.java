package controller;

import java.util.Vector;

import model.Employee;

public class EmployeeController {
	
	public static Vector<Employee> getAllEmployee(){
		return Employee.getAllEmployee();
	}
	
	public static int logEmployeeIn (String username, String password) {
		// TO-DO Login validation
		
		Employee user = new Employee();
		user = Employee.getEmployeeByUsername(username);
		
		System.out.println("Name is: " + user.getName());
		System.out.println("Password is: " + user.getPassword() + ". Entered password is: " + password);
		
		if(username.length() > 0 && password.length() > 0) {
			if(user.getPassword() != null && user.getStatus().equals("Active") && user.getPassword().equals(password)) {
				return user.getRoleID();
			} else {
				return -1;			
			}			
		} else {
			return -2;
		}
	}

	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}

}
