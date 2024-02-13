package com.magic4.magicard.sg.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class IssueCardFormDto {
    private String cardCode;
    private String rank;
    private int maxLimit;
    private int cardCount;
}
