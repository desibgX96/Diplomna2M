package com.diplomna2m.model;

import java.util.List;

public class ListBillDetail {

	List<Detail> allDetails;
	List<Bill> allBills;
	
	public List<Detail> getAllDetails() {
		return allDetails;
	}
	public void setAllDetails(List<Detail> allDetails) {
		this.allDetails = allDetails;
	}
	public List<Bill> getAllBills() {
		return allBills;
	}
	public void setAllBills(List<Bill> allBills) {
		this.allBills = allBills;
	}
	
}
