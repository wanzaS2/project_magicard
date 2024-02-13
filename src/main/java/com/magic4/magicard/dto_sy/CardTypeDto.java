package com.magic4.magicard.dto_sy;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CardTypeDto {
    private String cardCode;

    private String cardName;
    private int minimumAmount;

}
