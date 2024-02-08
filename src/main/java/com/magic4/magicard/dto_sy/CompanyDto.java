package com.magic4.magicard.dto_sy;

import com.magic4.magicard.vo.MasterAccount;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
public class CompanyDto {
    private String companyTicker;
    private MasterAccount masterAccount;
    // private CompanyRegisterRequest companyRegisterRequest;
    private String companyName;
    private Timestamp registerDate;
}
