package com.magic4.magicard.mk.controller;

import com.magic4.magicard.mk.dto.EmployeeEmailDto;
import com.magic4.magicard.mk.dto.EmployeeInfoDto;
import com.magic4.magicard.mk.response.service.ResponseService;
import com.magic4.magicard.mk.service.EmployeeService;
import com.magic4.magicard.vo.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<Employee> getAllEmpList(){

        EmployeeEmailDto employeeEmailDto=EmployeeEmailDto.builder()
                .employeeEmail("ㅁㅁ@ㅁㅁ")
                .build();
        return employeeService.getAllEmpList(employeeEmailDto);
    }

//    @GetMapping("/list/dept/{#}")
//    public ResponseEntity<EmpDto> getEmpListByDept(){
//
//    }
//
//    @GetMapping("/list/rank/{#}")
//    public ResponseEntity<EmpDto> getEmpListByRank(){
//
//    }
}
