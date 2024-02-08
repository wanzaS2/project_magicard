package com.magic4.magicard.repository_sy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magic4.magicard.vo.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,String>{
  
}
