package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
                                                   //pojo     primary key id type
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
