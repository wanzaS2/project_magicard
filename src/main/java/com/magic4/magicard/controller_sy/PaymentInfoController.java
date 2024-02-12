package com.magic4.magicard.controller_sy;

import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magic4.magicard.dto_sy.PaymentInfoDto;
import com.magic4.magicard.dto_sy.CompanyDto;
import com.magic4.magicard.dto_sy.EmployeeDto;
import com.magic4.magicard.service_sy.PaymentInfoService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paymentInfo")
public class PaymentInfoController {
  private final PaymentInfoService paymentInfoService;

  CompanyDto companyDto = CompanyDto.builder().companyName("신한DS").companyTicker("SHDS").build();
  EmployeeDto employeeInfo = EmployeeDto.builder()
          .employeeEmail("aa15@naver.com")
          .employeeName("박지원")
          .phone("01012344321")
          .company(companyDto)
          .build();

  @GetMapping("/getList")
  public List<PaymentInfoDto> getPaymentInfoList(HttpSession session) {
      return paymentInfoService.getPaymentInfoList(employeeInfo);
  }

  @GetMapping("/getTotalAmount")
  public int getTotalAmount(HttpSession session) {
    return paymentInfoService.getTotalAmount(employeeInfo);
  }
  
}
