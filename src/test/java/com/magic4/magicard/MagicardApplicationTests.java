package com.magic4.magicard;

import java.util.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.magic4.magicard.repository_sy.*;
import com.magic4.magicard.vo.*;

@SpringBootTest
class MagicardApplicationTests {

	@Autowired
	RequestRepo requestRepo;

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	PurposeCategoryRepo purposeCategoryRepo;

	@Autowired
	PurposeItemRepo purposeItemRepo;

	@Autowired
	CompanyRepo companyRepo;

	@Test
	void contextLoads() {
		// insertRequest();
		// insertPurposeCategory();
		// insertPurposeItem();
	}
	
	void insertPurposeItem(){
		String[][] itemArray = {{"급여", "4대보험", "식대", "포상금", "상여금", "경조사비"}, {"사무실 차임 보증금"}, 
		{"난방 시설 교체", "창틀 교체", "도배", "장판 교체"}, {"보험료", "수리비", "주차요금", "통행료"},
		 {"사무실 전화 요금","인터넷 요금", "팩스 요금"}, {"교통비", "회의비", "통신비", "식비", "유류비"}, 
		 {"교통비", "숙박비", "식비"}, {"사무 용품비","행사 용품비"}, {"거래처", "경조사비"}, {"기타"}};

		List<PurposeCategory> categoryList = purposeCategoryRepo.findAll();

		for(int i = 0; i < categoryList.size(); i++) {
			for(String item : itemArray[i]){
				PurposeItem purposeItem = PurposeItem.builder()
																					.purposeCategory(categoryList.get(i))
																					.purposeItem(item)
																					.build();
				purposeItemRepo.save(purposeItem);
			}
		}

		
	}

	void insertPurposeCategory(){
		// String[] categoryList = {"인건비","사업장 임대료", "인테리어 비용", "차량유지비", "통신비", "활동비", "출장비", "비품 구입비", "접대비"};
		// Company company = companyRepo.findById("SHDS").orElse(null);
		// for(String category : categoryList){
		// 	PurposeCategory purposeCategory = PurposeCategory.builder()
		// 																									.company(company)
		// 																									.purposeCategory(category)
		// 																									.build();
		// 	purposeCategoryRepo.save(purposeCategory);
		// }
		Company company = companyRepo.findById("SHDS").orElse(null);
			PurposeCategory purposeCategory = PurposeCategory.builder()
																											.company(company)
																											.purposeCategory("기타")
																											.build();
			purposeCategoryRepo.save(purposeCategory);
	}

	void insertRequest(){
		Employee employee = employeeRepo.findById("aa2@naver.com").orElse(null);
		

		Request request = Request.builder()
															.employee(employee)
															.paymentiInfo(null)
															.purposeItem(null)
															.participant(null)
															.receiptUrl(null)
															.memo(null)
															.approvalStatusCode(null)
															.refuseCount(null)
															.requestLevel(1)
															.build();

		requestRepo.save(request);
	}

}
