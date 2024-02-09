package com.magic4.magicard.dto_sy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
public class CompanyDto {
    private String companyTicker;
    // private MasterAccount masterAccount;
    // private CompanyRegisterRequest companyRegisterRequest;
    private String companyName;
    // private Timestamp registerDate;
}
