package com.magic4.magicard.repository_jy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.magic4.magicard.vo.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{
@Query(value = "select * from department order by department_id asc", nativeQuery = true)
public List<Department> selectAllDeptOrder();

@Query(value = "select d.department_id, d.is_admin_department, d.department_name, dep.department_name as super_department from department d " +
        "join department dep on d.super_department_id = dep.department_id " +
        "where d.department_id=:department_id", nativeQuery = true)
public Department selectDetail(int departmentId);

@Query(value = """
    select * from(
        select ee.employee_email, ee.employee_code, ee.employee_name, emin.department_name, emin.department_id, emin.super_department_id from employee ee
        join (
            SELECT MIN(e.rank_priority) as rank_priority, d.department_id, d.is_admin_department, d.department_name, d.super_department_id
            FROM department d
            JOIN employee e ON d.department_id = e.department_id
            GROUP BY d.department_id
        ) as emin
        on  emin.rank_priority = ee.rank_priority
        where emin.rank_priority = ee.rank_priority and ee.department_id = emin.department_id
    ) as manager
    join department
    on department.department_id = manager.super_department_id
    where manager.department_id = :department_id
    """, nativeQuery=true)
    public Department selectManager(int departmentId);


    @Query(value = "select ee.employee_email, ee.employee_code, ee.employee_name, emin.department_name, emin.department_id, emin.super_department_id from employee ee\r\n" + //
                "join (\r\n" + //
                "\r\n" + //
                " SELECT MIN(e.rank_priority) as rank_priority, d.department_id, d.is_admin_department, d.department_name, d.super_department_id\r\n" + //
                "    FROM department d\r\n" + //
                "    JOIN employee e ON d.department_id = e.department_id\r\n" + //
                "    GROUP BY d.department_id\r\n" + //
                ") as emin\r\n" + //
                "\r\n" + //
                "on  emin.rank_priority = ee.rank_priority\r\n" + //
                "where emin.rank_priority = ee.rank_priority and ee.department_id = emin.department_id and emin.super_department_id is null", nativeQuery = true)
    public Department selectFirstManager();
}