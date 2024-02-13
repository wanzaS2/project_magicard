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
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Builder
public class PurposeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer purposeItemUid;

    @ManyToOne
    @JoinColumn(name = "purpose_category_id")
    private PurposeCategory purposeCategory;

    @NonNull
    private String purposeItem;

}
