package com.magic4.magicard.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
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
public class Company {
    // @Id
    // private String dummy;
    // master_account와 company는 식별자관계 (pk => company_id)
    // JPA에는 반드시 Id가 필요함.
    // 부모테이블 master_account의 PK를 아무 변수로 선언
    @Id
    private String companyTicker;

    // @MapsId
    // @OneToOne
    // @JoinColumn(name = "company_ticker")
    @OneToOne
    @JoinColumn(name = "master_account_id")
    private MasterAccount masterAccount; // ==companyId

    // @OneToOne
    // @JoinColumn(name="company_name") //registerId
    // private CompanyRegisterRequest companyRegisterRequest;

    @Column(unique = true)
    private String companyName;

    // 1개의 회사는 1개의 고유한 회사 이름을 갖는다.
    // 서류제출 시 등록한 회사이름(company_name)을 참조.

    @CreationTimestamp
    private Timestamp registerDate;
}
