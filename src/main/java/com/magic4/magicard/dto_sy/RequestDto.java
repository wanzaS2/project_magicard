package com.magic4.magicard.dto_sy;

import com.magic4.magicard.vo.PaymentInfo;
import com.magic4.magicard.vo.PurposeItem;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    private UUID requestID;
    private EmployeeDto employee;
    private String responseEmployeeEmail;
    private PaymentInfoDto paymentInfo;
    private PurposeItemDto purposeItem;
    private String participant;
    private String receiptUrl;
    private String memo;
    private Integer refuseCount;
    private Integer requestLevel;
    private ApprovalStepsDto approvalSteps;
    private String sendRequest;
}
