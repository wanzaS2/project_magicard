package com.magic4.magicard.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table
public class MisuseMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int messageId;

    @OneToOne
    @JoinColumn(name = "company_id")
    Company company;
    // (최종반려처리)오사용 안내 메세지(1개)는 1개의 company_id를 참조

    private String messageContent;
}
