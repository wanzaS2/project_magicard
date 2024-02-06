package com.magic4.magicard.vo;

import java.sql.Timestamp;
import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @ManyToOne
    @JoinColumn(name = "card_code")
    private CardType cardType;

    private String cardNumber;
    private String cardPassword;

    private int cardCvc;
    private Timestamp expireDate;
    private String status;
    private int maximumAmount;

    @OneToOne
    @JoinColumn(name = "employee_email")
    Employee employee;

    // 자식 엔티티의 변경이 있다면
    // JPA 에서 자식엔티티의 수정은 insert update update delete 순으로 이어지는데
    // 변경된 자식을 먼저 insert 하고
    // 기존의 자식을 NULL로 update 한다.
    // 그리고 orphanRemoval 옵션을 true 로 하면 기존 NULL처리된 자식을 DELETE 한다. 
    // PK(JoinColumn)값이 NULL로 변한 자식은 고아객체라고 하여 연결된 점이 없는 객체이다. 
    // orphanRemoval옵션은 바로 이 고아객체를 삭제해주는 역활을 한다.
    // 양방향 매핑
    @OneToMany(mappedBy = "issuedCard", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<IssuedCardBenefit> benefit;// = new ArrayList<>();
    
    // 연관관계 편의 메서드
    public void setBenefit(List<IssuedCardBenefit> list) {
        if(this.benefit == null) {
            this.benefit = list;
            return;
        }

        for (IssuedCardBenefit issuedCardBenefit : list) {
            if (!this.benefit.contains(issuedCardBenefit)) {
                this.benefit.add(issuedCardBenefit);
                issuedCardBenefit.setParent(this);
            }
        }
    }
}
