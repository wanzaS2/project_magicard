package com.magic4.magicard.repository_sy;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magic4.magicard.vo.Employee;
import com.magic4.magicard.vo.IssuedCard;

public interface IssuedCardRepo extends JpaRepository<IssuedCard, UUID>{
  IssuedCard findByEmployee(Employee employee);
}
