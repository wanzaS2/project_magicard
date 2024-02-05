package com.magic4.magicard.vo;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "company")
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class PurposeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID purposeCategoryUid;

    @ManyToOne
    @JoinColumn(name = "company_ticker")
    // @JoinTable(name="company",
    // joinColumns = @JoinColumn(name="company_ticker"))
    private Company company;

    @NonNull
    private String purposeCategory;

}
