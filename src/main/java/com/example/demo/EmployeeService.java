package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
@Autowired     //creates the object automatically 
 	EmployeeRepo repo;

//insert my data 
public Employee insert(Employee e) {
	return repo.save(e);
}

//retrieve the records 
public List<Employee> getall(){
	return repo.findAll();
}
public Employee updatebyName(Employee e) {
    Employee ee = repo.findById(e.getEid()).orElse(null); // old object details
    // which setter you want to change?
    ee.setEname(e.getEname());
    return repo.save(ee);
    // if data is available save will perform update process,
    // if it is not available then it performs insert
}
public List<Employee> deleteById(int id) {
    repo.deleteById(id); // delete the employee by ID
    return repo.findAll(); // return the updated list of employees
}

public Employee getEmployeeById(int id) {
	// TODO Auto-generated method stub
	return null;
}

	
}