package com.magic4.magicard.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table // company_register_request
public class RegisterDocumentCode {
    /*
     * document_code integer [primary key]
     * document_type String [not null]
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int documentCode;

    @Column(unique = true)
    private String documentName;
}
