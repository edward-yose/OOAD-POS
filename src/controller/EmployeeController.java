package controller;

import model.Employee;
import model.Role;

public class EmployeeController {
	
	public static int logEmployeeIn (String username, String password) {
		// TO-DO Login validation
		
		Employee user = new Employee();
		user = Employee.getEmployeeByUsername(username);
		
//		System.out.println("Name is: " + user.getName());
//		System.out.println("Password is: " + user.getPassword() + ". Entered password is: " + password);
		
		if(username.length() > 0 && password.length() > 0) {
			if(user.getPassword() != null && user.getPassword().equals(password)) {
				
				switch(Role.getRole(user.getRoleID()).getName()) {
				
					case "Transaction Management": {
						return 1;
					}
					
					case "Product Management": {
						return 2;
					}
					
					case "Human Resource Management": {
						return 3;
					}
					
					case "Manager": {
						return 4;
					}
				}
				
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
