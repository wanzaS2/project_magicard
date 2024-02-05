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

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable // 나는 복합키다. Entity가 아니다.
@Builder
public class EmployeeRankPk implements Serializable {
    @ManyToOne
    @JoinColumn(name = "company_ticker")
    private Company company;

    private Integer rankPriority;
}
