package com.magic4.magicard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.magic4.magicard.dto.PurposeDto;
import com.magic4.magicard.repository.PurposeCategoryRepository;
import com.magic4.magicard.repository.PurposeItemRepository;
import com.magic4.magicard.vo.Company;
import com.magic4.magicard.vo.PurposeCategory;
import com.magic4.magicard.vo.PurposeItem;

@Service
public class PurposeService {


    //대분류 
    @Autowired
    PurposeCategoryRepository purCateRepo;

    //소분류
    @Autowired
    PurposeItemRepository purItemRepo;

    


    //대분류 조회
    public List<PurposeDto> getCateList1(){

      List<PurposeDto> purposeDtoList = new ArrayList<>();

      Company company = Company.builder()
      .companyTicker("TEST1").build();

      List<PurposeCategory> cateList =   purCateRepo.findByCompany(company);

      for(int i = 0 ;  i < cateList.size() ; i ++){
        PurposeDto purposeDto = new PurposeDto();
        purposeDto.setPurposeCategory(cateList.get(i).getPurposeCategory());
        purposeDtoList.add(purposeDto);
       }

      return purposeDtoList;
    }

      // 대분류 , 소분류 조회
    public List<PurposeDto> getCateList2(){

      
      // 대분류  + 소분류 DTO List
      List<PurposeDto> purposeDtoList = new ArrayList<>();

      //Login 한 Company 정보 
      Company company = Company.builder()
      .companyTicker("TEST1").build();

  
      //대분류 조회
      List<PurposeCategory> cateList =   purCateRepo.findByCompany(company);

      List<PurposeItem> itemList = purItemRepo.findAllByPurposeCategoryIn(cateList);


      for(int i = 0 ;  i < itemList.size() ; i ++){
           PurposeDto purposeDto = new PurposeDto();
           purposeDto.setPurposeCategory(itemList.get(i).getPurposeCategory().getPurposeCategory());
           purposeDto.setPurposeItem(itemList.get(i).getPurposeItem());
           purposeDtoList.add(purposeDto);
      }

      return purposeDtoList;
    };


      // 우리 기업 대분류 넣기
    public void insertCategory(@RequestBody PurposeCategory purposeCategory){


      //session에서 company를 찾는다?
      Company company = Company.builder()
      .companyTicker("TEST1").build();


      // PurposeCategory newpur = PurposeCategory.builder()
      // .company(company)

      // purposeCategory.builder().build();

      PurposeCategory  category = PurposeCategory.builder()
      .company(company).purposeCategory(purposeCategory.getPurposeCategory()).build();

      purCateRepo.save(category);

    };
    
}
