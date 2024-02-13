package com.magic4.magicard.mk.service;

import com.magic4.magicard.mk.dto.EmployeeInfoDto;
import com.magic4.magicard.mk.dto.LoginRequestDto;
import com.magic4.magicard.mk.dto.LoginResponseDto;
import com.magic4.magicard.mk.repository.CompanyRepo;
import com.magic4.magicard.mk.repository.EmployeeRepo;
import com.magic4.magicard.vo.Company;
import com.magic4.magicard.vo.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final EmployeeRepo employeeRepo;

    public LoginResponseDto login(LoginRequestDto loginRequestDto){

        Employee employee=employeeRepo.findById(loginRequestDto.getEmployeeEmail()).orElse(null);

        return LoginResponseDto.builder()
                .employeeEmail(employee.getEmployeeEmail())
                .employeeName(employee.getEmployeeName())
                .employeeRank(employee.getEmployeeRank())
                .employeeCode(employee.getEmployeeCode())
                .phone(employee.getPhone())
                .company(employee.getEmployeeRank().getCompany())
                .department(employee.getDepartment())
                .build();
    }
}
