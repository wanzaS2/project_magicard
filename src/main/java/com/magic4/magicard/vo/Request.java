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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
@Builder
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID requestID;

    @ManyToOne
    @JoinColumn(name = "request_employee_email")
    private Employee employee;

    private String responseEmployeeEmail;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private PaymentInfo paymentInfo;

    @ManyToOne
    @JoinColumn(name = "purpose_item_uid")
    private PurposeItem purposeItem;
    private String participant;
    private String receiptUrl;
    private String memo;

    @ManyToOne
    @JoinColumn(name = "approval_status_code")
    private ApprovalSteps approvalSteps;

    private Integer refuseCount;
    private Integer requestLevel;

}
