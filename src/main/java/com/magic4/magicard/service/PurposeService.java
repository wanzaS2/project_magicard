package com.magic4.magicard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magic4.magicard.repository.PurposeCategoryRepository;
import com.magic4.magicard.vo.PurposeCategory;

@Service
public class PurposeService {


    @Autowired
    PurposeCategoryRepository purCateRepo;


      public List<PurposeCategory> findMyCategory(String companyTicker){
        return  purCateRepo.findByCompanyTicker(companyTicker);
      }
    
    
}
