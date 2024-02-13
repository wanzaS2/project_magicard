package com.magic4.magicard.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.KeySelector.Purpose;

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

    public int insertCategory(String purposeCategory, String  purposeItem){

         Company company = Company.builder().companyTicker("TEST1").build();


         PurposeCategory  existingCategory  = purCateRepo.findByPurposeCategory(purposeCategory);

         PurposeItem existingItem = purItemRepo.findByPurposeItem(purposeItem);


         if(existingCategory == null && existingItem == null){

          PurposeCategory category = PurposeCategory.builder().company(company).purposeCategory(purposeCategory).build();
          purCateRepo.save(category);


          PurposeItem item = PurposeItem.builder().purposeCategory(category).purposeItem(purposeItem).build();
          purItemRepo.save(item);

          return 2;

         }
         else if(existingCategory != null  && existingItem == null){

          PurposeItem item = PurposeItem.builder().purposeCategory(existingCategory).purposeItem(purposeItem).build();
          
          purItemRepo.save(item);

          return 1;
         }
         else {
          return 0;
         }




    }
    
}
