package com.magic4.magicard.mk.controller;

import com.magic4.magicard.mk.dto.EmployeeEmailDto;
import com.magic4.magicard.mk.dto.EmployeeInfoDto;
import com.magic4.magicard.mk.response.service.ResponseService;
import com.magic4.magicard.mk.service.EmployeeService;
import com.magic4.magicard.vo.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/emp")
public class EmployeeController {

    private final EmployeeService employeeService;

    // 회사의 전체 직원 조회
    @GetMapping("/list/all")
    public List<EmployeeInfoDto> getAllEmpList(){

        return employeeService.getAllEmpList();
    }

    // 회사의 특정 부서 소속 직원 조회
    @GetMapping("/list/dept/{deptId}")
    public List<EmployeeInfoDto> getEmpListByDept(@PathVariable("deptId") int deptId){
        return employeeService.getEmpListByDept(deptId);
    }

    // 회사의 특정 직급 직원 조회
    @GetMapping("/list/rank/{employeeRankId}")
    public List<EmployeeInfoDto> getEmpListByRank(@PathVariable("employeeRankId") int employeeRankId){
        return employeeService.getEmpListByRank(employeeRankId);
    }
    
    // 특정 직원 검색
}
