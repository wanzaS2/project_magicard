package com.magic4.magicard.service_sy;

import java.util.List;

import com.magic4.magicard.dto_sy.PaymentInfoDto;
import com.magic4.magicard.vo.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.magic4.magicard.dto_sy.EmployeeDto;
import com.magic4.magicard.repository_sy.IssuedCardRepo;
import com.magic4.magicard.repository_sy.PaymentInfoRepo;
import com.magic4.magicard.vo.IssuedCard;
import com.magic4.magicard.vo.PaymentInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentInfoService {
  IssuedCardRepo issuedCardRepo;
  PaymentInfoRepo paymentInfoRepo;
  ModelMapper model = new ModelMapper();
  public List<PaymentInfoDto> getPaymentInfoList(EmployeeDto employeeDto) {
    Employee employee = model.map(employeeDto, Employee.class);
    IssuedCard issuedCard = issuedCardRepo.findByEmployee(employee);
    List<PaymentInfo> paymentInfoList = paymentInfoRepo.findByIssuedCard(issuedCard);

    return null;
  }

  
  
}
