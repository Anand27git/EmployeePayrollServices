package com.bridgelab.employeePayrollservices;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class EmployeePayrollTest {


	@Test
	public void givenThreeEmpData_whenWrittenToFile_shouldMatchEmpEntriesCount() {
		EmployeePayrollData[] empsArray = { 
				new EmployeePayrollData(1, "anand Kumar v", 35000.0),
				new EmployeePayrollData(2, "vinay ", 18000.0), 
				new EmployeePayrollData(3, "raj", 25000.0) 
			};
		EmployeePayrollService empPayrollService = new EmployeePayrollService(Arrays.asList(empsArray));
		empPayrollService.writeEmployeePayrollData(EmployeePayrollService.IoService.FILE_IO);
		long entriesCount = empPayrollService.countEntries(EmployeePayrollService.IoService.FILE_IO);
		Assert.assertEquals(3, entriesCount);
	}
}


