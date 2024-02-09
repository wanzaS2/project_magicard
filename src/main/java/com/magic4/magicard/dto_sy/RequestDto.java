package com.magic4.magicard.dto_sy;

import com.magic4.magicard.vo.Employee;
import com.magic4.magicard.vo.PaymentInfo;
import com.magic4.magicard.vo.PurposeItem;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class RequestDto {
    private UUID requestID;
    private Employee employee;
    private PaymentInfo paymentiInfo;
    private PurposeItem purposeItem;
    private String participant;
    private String receiptUrl;
    private String memo;
    private Integer approvalStatusCode;
    private Integer refuseCount;
    private Integer requestLevel;
}
