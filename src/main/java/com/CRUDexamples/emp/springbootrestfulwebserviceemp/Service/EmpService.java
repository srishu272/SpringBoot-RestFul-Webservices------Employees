package com.CRUDexamples.emp.springbootrestfulwebserviceemp.Service;

import java.util.List;

import com.CRUDexamples.emp.springbootrestfulwebserviceemp.Entity.Employee;

public interface EmpService {

	Employee createEmp(Employee emp);
	Employee getEmpById(Long empId);
	Employee updateEmp(Employee emp);
	void deleteEmp(Long empId);
	
	List<Employee> getAllEmp();
	List<Employee> getEmpByName(String firstName, String lastName);
}
