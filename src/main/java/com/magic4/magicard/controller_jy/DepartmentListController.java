package com.magic4.magicard.controller_jy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magic4.magicard.repository_jy.DepartmentRepo;
import com.magic4.magicard.vo.Department;



@RequestMapping("/rest/departments")
@RestController
public class DepartmentListController {
    
    // @Autowired
    //     private DepartmentService deptService;

    @Autowired
    private DepartmentRepo deptRepo;

    @GetMapping("/list")
    public List<Department> getAllDepartment(){
        return (List<Department>)deptRepo.selectAllDeptOrder();
    }

    @GetMapping("/detail/{departmentId}")
    public Department deptDetail(@PathVariable Integer departmentId){
        return deptRepo.selectDetail(departmentId);
    }

    @GetMapping("/detailmanager/{departmentId}")
    public Department selectManager(@PathVariable Integer departmentId) {
        return deptRepo.selectManager(departmentId);
    }

    @GetMapping("/detailfirstmanager")
    public Department selectFirstManager() {
        return deptRepo.selectFirstManager();
    }
    
    
    
}
