package com.magic4.magicard.dto;

import com.magic4.magicard.vo.Company;
import com.magic4.magicard.vo.Department;
import com.magic4.magicard.vo.EmployeeRank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

private String employeeEmail;

private String employeeName;

private String phone;

private String userId;

private EmployeeRank employeeRank;

private Department department;

private Company company;
    
}
