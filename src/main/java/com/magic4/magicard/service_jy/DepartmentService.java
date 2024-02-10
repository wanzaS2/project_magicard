package com.magic4.magicard.service_jy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magic4.magicard.repository_jy.DepartmentRepo;

import lombok.RequiredArgsConstructor;

/**
 * DepartmentService
 */
@RequiredArgsConstructor
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo deptRepo;


    // public List<DepartmentDto> findAllDept(){
    //     List<Department> deptList = deptRepo.selectAllDeptOrder();
    //     List<DepartmentDto> departments = new ArrayList<>();
    //     for(Department dept : deptList){
    //         departments.add(convertToDto(dept));
    //     }
    //     return departments;
    // }

    // //department 를 dto로 변경해서 받는 함수
    // private DepartmentDto convertToDto(Department department){
    //     DepartmentDto dto = new DepartmentDto();
    //     dto.setDepartmentId(department.getDepartmentId());
    //     dto.setDepartmentName(department.getDepartmentName());
    //     dto.setAdminDepartment(department.isAdminDepartment());
    //     if(department.getSuperDepartment() != null){
    //         dto.setSuperDepartmentID(department.getSuperDepartment().getDepartmentId());
    //     }
    //     return dto;
    // }
    
}