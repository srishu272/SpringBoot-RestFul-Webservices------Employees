package com.CRUDexamples.emp.springbootrestfulwebserviceemp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.CRUDexamples.emp.springbootrestfulwebserviceemp.Entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT e FROM Employee e WHERE e.firstName LIKE %:fName% and e.lastName LIKE %:lName%")
	List<Employee> getEmpByName(@Param("fName")String fName, @Param("lName")String lName);
}
