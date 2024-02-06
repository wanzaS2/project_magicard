package com.magic4.magicard.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magic4.magicard.vo.Company;
import com.magic4.magicard.vo.PurposeCategory;
import java.util.List;


public interface PurposeCategoryRepository extends JpaRepository<PurposeCategory,UUID>{

    List<PurposeCategory> findByCompanyTicker(String companyTicker);
    
} 