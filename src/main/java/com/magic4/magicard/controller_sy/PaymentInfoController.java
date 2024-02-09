package com.magic4.magicard.controller_sy;

import java.util.*;

import com.magic4.magicard.dto_sy.CompanyDto;
import com.magic4.magicard.dto_sy.PaymentInfoDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  CompanyDto companyDto = CompanyDto.builder().companyName("SHDS").companyTicker("SHDS").build();
  EmployeeDto employeeInfo = EmployeeDto.builder()
                                          .employeeEmail("aa2@naver.com")
                                          .employeeName("신서영")
                                          .phone("1111111111111")    
                                          .department(null)
                                          .employeeRank(null)
                                          .company(companyDto)
                                          .build();
  @GetMapping("/getList")
  public List<PaymentInfoDto> getPaymentInfoList(HttpSession session) {
      return paymentInfoService.getPaymentInfoList(employeeInfo);
  }
  
}
