package com.magic4.magicard.mk.service;

import com.magic4.magicard.mk.dto.EmployeeEmailDto;
import com.magic4.magicard.mk.dto.EmployeeInfoDto;
import com.magic4.magicard.mk.repository.EmployeeRankRepo;
import com.magic4.magicard.mk.repository.EmployeeRepo;
import com.magic4.magicard.vo.Employee;
import com.magic4.magicard.vo.EmployeeRank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final EmployeeRankRepo employeeRankRepo;

    public List<Employee> getAllEmpList(EmployeeEmailDto employeeEmailDto){

        // 세션이나 어딘가에 등록되어 있는 직원 이메일로 직원 조회
        Employee employee=employeeRepo.findById(employeeEmailDto.getEmployeeEmail()).orElse(null);

        // 직원 직급 조회
        EmployeeRank employeeRank=employeeRankRepo.findById(employee.getEmployeeRank().getEmployeeRankId()).orElse(null);

        // 해당 회사의 직급들 조회
        List<EmployeeRank> employeeRankList=employeeRankRepo.findEmployeeRanksByCompany(employeeRank.getCompany());

        // 해당 직급의 직원 조회
        List<Employee> employees=employeeRepo.findAllByEmployeeRankIn(employeeRankList);

        System.out.println(employees.toString());

        return employees;
    }


}
