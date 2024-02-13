package com.magic4.magicard.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class ApprovalSteps {
    @Id
    private Integer approvalStatusCode;

    private String approvalStep;
}
