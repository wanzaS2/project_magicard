package com.magic4.magicard.vo;

import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table
@Entity
@Slf4j
public class IssuedCardBenefit implements Persistable<IssuedCardBenefitPk>{
  @EmbeddedId
  private IssuedCardBenefitPk issuedCardBenefitPK;
  
  @MapsId("issuedCardId")
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "issued_card_id")
  private IssuedCard issuedCard;

  @MapsId("benefitCode")
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "benefit_code")
  private CardBenefit cardBenefit;

  //@Transient
  //@CreatedDate
  //private Timestamp created;
  //private int created = 1;

  public void setParent(IssuedCard issuedCard) {
    this.issuedCard = issuedCard;
    this.issuedCardBenefitPK = new IssuedCardBenefitPk(issuedCard.getIssuedCardId(), cardBenefit.getBenefitCode());
  }

  @Override
    public IssuedCardBenefitPk getId() {
        return issuedCardBenefitPK;
    }

    @Override
    public boolean isNew() {
      log.info("is new called");
      if(issuedCardBenefitPK == null) {
        log.info("issuedCardBenefitPK null");
      }

      return issuedCardBenefitPK == null;
       // return created == null;
    }
}


