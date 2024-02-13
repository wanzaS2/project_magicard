package com.magic4.magicard.controller_sh;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.magic4.magicard.dto_sh.PurposeDto;
import com.magic4.magicard.service_sh.PurposeService;




@RestController
@RequestMapping("/pur")
public class PurposeController {

    @Autowired
    PurposeService purService;




    //대분류만 가져오기
     @GetMapping("/catelist.do")
     public List<PurposeDto> getCateList1(){
        return purService.getCateList1();
     };

    // 대분류 소분류  가져오기
    @GetMapping("/list.do")
    public List<PurposeDto> getCateList2(){
        return purService.getCateList2();
    };

  
    @PostMapping("/insert.do")
    public int inserCategory(@RequestBody Map<String, String> requestData){
    String purposeCategory = requestData.get("purposeCategory");
    String purposeItem = requestData.get("purposeItem");
    return  purService.insertCategory(purposeCategory, purposeItem);

}
}