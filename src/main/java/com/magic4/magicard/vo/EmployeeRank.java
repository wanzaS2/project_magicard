package com.magic4.magicard.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(
    uniqueConstraints = {
        @UniqueConstraint(
            name = "employeeRank",
            columnNames = {"company_ticker","rank_priority"}
        )
    }
)
public class EmployeeRank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeRankId;

    @ManyToOne
    @JoinColumn(name = "company_ticker")
    private Company company;

    @Column(name = "rank_priority",nullable = false)
    private int rankPriority;

    @Column(name = "rank_name")
    private String rankName;

}
