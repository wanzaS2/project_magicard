package com.magic4.magicard.vo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Embeddable
public class IssuedCardBenefitPk implements Serializable {
  @ManyToOne
  @JoinColumn(name = "issued_card_id")
  private IssuedCard issuedCard;

  @ManyToOne
  @JoinColumn(name = "benefit_code")
  private CardBenefit cardBenefit;

}
