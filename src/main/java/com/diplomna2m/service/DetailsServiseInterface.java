package com.diplomna2m.service;

import java.util.List;

import javax.validation.Valid;

import com.diplomna2m.model.Detail;
import com.diplomna2m.model.ListBillDetail;
import com.diplomna2m.model.Vzemi;

public interface DetailsServiseInterface {

	public void save(Detail object);

	List<Detail> findDDSMistakenEntry();

	List<Detail> findDDSMistakenSale();

	List<Detail> findMistakeInCostAccounts();

	List<Detail> findMistakeInUnitCosts();

	List<Detail> findMistakeInExpensesMaterialAccounts();

	List<Detail> findMistakeInSaleAccount();
	
	List<Detail> findCustomDetail(String credit, String debit);
	
	ListBillDetail chekForRequest(Vzemi vz) ;

	Detail findById(int id);

	void updateUser(Detail oldDetail,@Valid Detail newInfo);
}
