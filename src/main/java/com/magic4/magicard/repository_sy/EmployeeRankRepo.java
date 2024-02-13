package com.magic4.magicard.repository_sy;

import com.magic4.magicard.vo.Company;
import com.magic4.magicard.vo.EmployeeRank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmployeeRankRepo extends JpaRepository<EmployeeRank, Integer> {
    List<EmployeeRank> findByCompany(Company company);
}
