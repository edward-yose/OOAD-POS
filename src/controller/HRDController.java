package controller;

import model.Employee;
import model.Role;

public class HRDController {
	public static int addEmployee (Integer id, String name, String username, Integer salary, String password) {
		Employee user = new Employee();
		user = Employee.getEmployee(id);
		
		if(name.length()>0 && password.length()>0 && salary > 0) {
			if(password.length()>0) {
				password = username;
			}
		}else {
			return -1;
		}
		return 0;
	}
	public HRDController() {
		
	}
}
