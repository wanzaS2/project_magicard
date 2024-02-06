package com.magic4.magicard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.magic4.magicard.repository.PurposeCategoryRepository;
import com.magic4.magicard.service.PurposeService;
import com.magic4.magicard.vo.PurposeCategory;

@RestController
@RequestMapping("/pur")
public class PurposeController {

    @Autowired
    PurposeService purService;


    @Autowired
    PurposeCategoryRepository purCateRepo;


    @PostMapping("/list.do")
    public List<PurposeCategory> findMyCategory(String companyTicker){
        return  purService.findMyCategory(companyTicker);
    }

    
}
