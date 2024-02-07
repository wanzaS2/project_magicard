package com.magic4.magicard.mk.repository;

import com.magic4.magicard.vo.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company, String> {
}
