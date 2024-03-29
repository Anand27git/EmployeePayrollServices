package com.bridgelab.employeePayrollservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * this is main class EmployeePayrollService
 */
public class EmployeePayrollService {
	public enum IoService{CONSOLE_IO,FILE_IO,DB_IO,REST_IO}
	
	// Declaration of list employeePayrollList
	private List<EmployeePayrollData> employeePayrollList;

	// this is constructor to initialize employeePayrollList List.
	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(consoleInputReader);
		employeePayrollService.writeEmployeePayrollData();
	}

	// this is method to read employee data form console by using Scanner class
	private void readEmployeePayrollData(Scanner consoleInputReader) {
		System.out.print("Welcome to Employee PayRollService\n");
		System.out.print("Enter Employee ID:\n ");
		int id = consoleInputReader.nextInt();
		System.out.print("Enter the Employee Name:\n ");
		String name = consoleInputReader.next();
		System.out.print("Enter the Employee Salary:\n ");
		Double salary = consoleInputReader.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}

	// this is method to write employee data into console.
	private void writeEmployeePayrollData() {
		System.out.println("\nWriting Employee Payroll Roaster to Console\n" + employeePayrollList);
	}

public void writeEmployeePayrollData(IoService ioService) 
{
		if (ioService.equals(IoService.FILE_IO)) {
			new EmployeePayrollFileIOService().writeData(employeePayrollList);
		}
}
// count the entries
public long countEntries(IoService ioService) 
{
		if (ioService.equals(IoService.FILE_IO))
			return new EmployeePayrollFileIOService().countEntries();
		return 0;
}
//prints file data
public void printData(IoService ioService) {
	if (ioService.equals(IoService.FILE_IO))
		new EmployeePayrollFileIOService().printData();
}
}
