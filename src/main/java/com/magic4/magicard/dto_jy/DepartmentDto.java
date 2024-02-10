package com.magic4.magicard.dto_jy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DepertmentDto
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private int departmentId;
    private String departmentName;
    private boolean isAdminDepartment;
    private int superDepartmentID;
    
}