package com.magic4.magicard.vo;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class IssuedCard {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID issuedCardId;

    // 하나의 카드가 발생되어야 하나 이상의 혜택이 생긴다.
    // @OneToMany(mappedBy = "issuedCard")
    // private IssuedCardBenefit issuedCardBenefit;

    @ManyToOne
    @JoinColumn(name = "card_code")
    private CardType cardType;

    private String cardNumber;
    private String cardPassword;

    private int cardCvc;
    private Timestamp expireDate;
    private String status;

    @OneToOne
    @JoinColumn(name = "employee_uid")
    Employee employee;
}
