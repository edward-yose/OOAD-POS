package controller;

import java.util.List;
import model.Employee;
import model.Transaction;
import model.TransactionItem;


public class EmployeeController {
	
	public static List<Employee> getAllEmployee() {
		return Employee.getAllEmployee();
	}
	
	public EmployeeController() {
		
	}
}
