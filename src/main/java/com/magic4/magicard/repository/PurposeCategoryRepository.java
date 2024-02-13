package com.magic4.magicard.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


import com.magic4.magicard.vo.Company;
import com.magic4.magicard.vo.PurposeCategory;
import java.util.List;




public interface PurposeCategoryRepository extends JpaRepository<PurposeCategory,UUID>{
    
        //회사에 해당하는 카테고리 찾기
        List<PurposeCategory> findByCompany(Company company);

        //해당 카테고리가 DB에 존재하는지
        PurposeCategory findByPurposeCategory(String purposeCategory);
    
} 