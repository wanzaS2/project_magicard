package com.magic4.magicard.repository_sy;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magic4.magicard.vo.IssuedCard;
import com.magic4.magicard.vo.PaymentInfo;
import java.util.List;


public interface PaymentInfoRepo extends JpaRepository<PaymentInfo, UUID> {
  List<PaymentInfo> findByIssuedCard(IssuedCard issuedCard);
}
