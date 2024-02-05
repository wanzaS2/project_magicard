package com.magic4.magicard.vo;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table // company_register_request
public class RegisterDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID documentId;

    // private int documentCode;
    @ManyToOne
    @JoinColumn(name = "document_code")
    private RegisterDocumentCode registerDocumentCode;
    // ex. 3개 기업의 사업자 등록증들이 있다.
    // (삼성의 사업자 등록증 , LG의 사업자 등록증, 현대의 사업자 등록증)
    // 3개(many)의 사업자 등록증이 1개(one)의 document_code(1)를 참조

    private String documentPath;
    private boolean isValid;

    @ManyToOne
    @JoinColumn(name = "register_id") // default:
    // company_register_request_register_id
    private CompanyRegisterRequest companyRegisterRequest;
    // 사업자등록증(1), 법인인감증명서(2), 대표자신분증사본(3), 제무재표(4), 기타서류(5)
    // 5개(many)의 document들이 1개(one)의 register_id를 참조
}
