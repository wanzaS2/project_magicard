package com.magic4.magicard.mk.repository;

import com.magic4.magicard.vo.Employee;
import com.magic4.magicard.vo.EmployeeRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {

    // 회사의 전체 직원 조회
    List<Employee> findAllByEmployeeRankIn(List<EmployeeRank> employeeRank);
}
