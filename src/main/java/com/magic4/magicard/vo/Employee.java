package com.magic4.magicard.vo;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Entity
@Table
public class Employee {
    @Id
    private String employeeEmail;

    @OneToOne
    @JoinColumn(name = "rank_priority")
    private EmployeeRank employeeRank;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(nullable = false)
    private String employeeName;

    private Timestamp hireDate;

    @Column(unique = true)
    private String phone;

    private String userPassword; // if not null, then login is possible

    @ColumnDefault(value = "false")
    private boolean isApproved; // 가입 후 승인 여부
}
