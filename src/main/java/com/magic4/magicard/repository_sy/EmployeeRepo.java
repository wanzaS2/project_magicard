package com.magic4.magicard.repository_sy;

import com.magic4.magicard.vo.Department;
import com.magic4.magicard.vo.EmployeeRank;
import org.springframework.data.jpa.repository.JpaRepository;

import com.magic4.magicard.vo.Employee;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,String>{
  List<Employee> findByEmployeeRank(EmployeeRank employeeRank);
  List<Employee> findByEmployeeRankAndDepartment(EmployeeRank employeeRank, Department department);

  List<Employee> findByDepartment(Department department);
}
