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
public class OnBoardingVideo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID videoId;

    private String videoUrl;

    @ManyToOne
    @JoinColumn(name = "company_ticker")
    Company company;
    // ex. 삼성의 직원 교육 영상이 2개,
    // LG의 직원 교육 영상이 3개
    // 여러 개의 video가 1개의 company_id를 참조

}
