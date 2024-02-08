package com.magic4.magicard.dto_sy;

import java.sql.Timestamp;

import com.magic4.magicard.vo.Company;
import com.magic4.magicard.vo.Department;
import com.magic4.magicard.vo.EmployeeRank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeDto {
    private String employeeEmail;
    private String employeeName;
    private String phone;
    private String userId;
    private EmployeeRank employeeRank;
    private Department department;
    private Company company;
}
