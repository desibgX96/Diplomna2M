package com.diplomna2m;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.diplomna2m.model.Detail;
import com.diplomna2m.service.DetailsService;

@SpringBootTest
class Diplomna2MApplicationTests {
	
	@Autowired
	private DetailsService detailsService;

	@SuppressWarnings("deprecation")
	@Test
	void contextLoads() {
		 Random rand = new Random(); 
	      int upperbound = 1000;// 1 to 24
	      int int_random = rand.nextInt(upperbound); 
		Detail dt = detailsService.findById(int_random);
		Assert.notNull(dt);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void mainWindowCheckbox() { 
		List<Detail> dt1 = detailsService.findDDSMistakenEntry();
		Assert.notNull(dt1);
		List<Detail> dt2 = detailsService.findDDSMistakenSale();
		Assert.notNull(dt2);
		List<Detail> dt3 = detailsService.findMistakeInCostAccounts();
		Assert.notNull(dt3);
		List<Detail> dt4 = detailsService.findMistakeInExpensesMaterialAccounts();
		Assert.notNull(dt4);
		List<Detail> dt5 = detailsService.findMistakeInSaleAccount();
		Assert.notNull(dt5);
		List<Detail> dt6 = detailsService.findMistakeInUnitCosts();
		Assert.notNull(dt6);
	}

}
