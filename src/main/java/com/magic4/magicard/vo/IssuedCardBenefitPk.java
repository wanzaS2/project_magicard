package com.magic4.magicard.vo;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
@NoArgsConstructor
@Embeddable
public class IssuedCardBenefitPk implements Serializable{

    @Column(name = "issued_card_id")
    private UUID issuedCardId;

    @Column(name = "benefit_code")
    private int benefitCode;

    public IssuedCardBenefitPk(UUID issuedCardId, int benefitCode) {
        this.issuedCardId = issuedCardId;
        this.benefitCode = benefitCode;
    }

  
}
