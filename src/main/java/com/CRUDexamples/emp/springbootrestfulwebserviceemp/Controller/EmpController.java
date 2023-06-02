package com.CRUDexamples.emp.springbootrestfulwebserviceemp.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import com.CRUDexamples.emp.springbootrestfulwebserviceemp.Entity.Employee;
import com.CRUDexamples.emp.springbootrestfulwebserviceemp.Service.EmpService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmpController {

	@Autowired
	EmpService empService;

	public EmpService getEmpService() {
		return empService;
	}

	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

	@PostMapping
	public ResponseEntity<Employee> createEmp(@RequestBody Employee emp) {
		Employee newEmp = empService.createEmp(emp);
		return new ResponseEntity<>(newEmp, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("id") Long empId) {
		Employee emp = empService.getEmpById(empId);
		return new ResponseEntity<>(emp, HttpStatus.FOUND);
	}
	
	@GetMapping("/name")
	public ResponseEntity<List<Employee>> getEmpByname(@RequestBody HashMap<String,String> name){
		List<Employee> emp = empService.getEmpByName(name.get("firstName"), name.get("lastName"));
		return new ResponseEntity<>(emp, HttpStatus.OK);
		
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmp() {
		List<Employee> empList = empService.getAllEmp();
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Employee> updateEmp(@PathVariable("id") Long empId, @RequestBody Employee emp) {
		emp.setId(empId);
		Employee updatedEmp = empService.updateEmp(emp);
		return new ResponseEntity<>(updatedEmp,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable("id") Long empId){
		empService.deleteEmp(empId);
		return new ResponseEntity<>("Employee is deleted", HttpStatus.OK);
	}

}
