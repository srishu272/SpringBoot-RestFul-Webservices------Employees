package com.CRUDexamples.emp.springbootrestfulwebserviceemp.Service.Impl;

import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRUDexamples.emp.springbootrestfulwebserviceemp.Entity.Employee;
import com.CRUDexamples.emp.springbootrestfulwebserviceemp.Repository.EmpRepository;
import com.CRUDexamples.emp.springbootrestfulwebserviceemp.Service.EmpService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpRepository empRepository;

	@Override
	public Employee createEmp(Employee emp) {
		return empRepository.save(emp);
	}

	@Override
	public Employee getEmpById(Long empId) {
		Optional<Employee> optemp = empRepository.findById(empId);
//		List<Employee> getbyid = new ArrayList<>();
//		getbyid.add(optemp.get());
		return optemp.get();
	}

	@Override
	public Employee updateEmp(Employee emp) {
		Employee updateEmp = empRepository.findById(emp.getId()).get();
		updateEmp.setEmail(emp.getEmail());
		updateEmp.setFirstName(emp.getFirstName());
		updateEmp.setLastName(emp.getLastName());
		updateEmp.setSalary(emp.getSalary());
		updateEmp.setAddress(emp.getAddress());
		updateEmp.setDob(emp.getDob());
		updateEmp.setGender(emp.getGender());
		updateEmp.setPhonenumber(emp.getPhonenumber());
		updateEmp.setPincode(emp.getPincode());
		updateEmp.setMarital_status(emp.getMarital_status());
		return updateEmp;
	}

	@Override
	public void deleteEmp(Long empId) {
		empRepository.deleteById(empId);
		
	}

	@Override
	public List<Employee> getAllEmp() {
		return empRepository.findAll();
	}

	@Override
	public List<Employee> getEmpByName(String firstName, String lastName) {
		return empRepository.getEmpByName(firstName,lastName);
	}

}
