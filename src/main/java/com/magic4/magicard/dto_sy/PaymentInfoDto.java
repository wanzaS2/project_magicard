package com.magic4.magicard.dto_sy;

import com.magic4.magicard.vo.IssuedCard;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Builder
public class PaymentInfoDto {
    private UUID paymentId;
    private IssuedCard issuedCard;
    private int payAmount;
    private String merchant;
    private Timestamp paymentTime;
}
