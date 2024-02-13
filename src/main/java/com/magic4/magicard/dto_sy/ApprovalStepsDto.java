package com.magic4.magicard.dto_sy;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalStepsDto {
    private Integer approvalStatusCode;
    private String approvalStep;
}
