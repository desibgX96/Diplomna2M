package com.diplomna2m.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomna2m.model.Bill;
import com.diplomna2m.model.Detail;
import com.diplomna2m.model.ListBillDetail;
import com.diplomna2m.model.Vzemi;
import com.diplomna2m.repository.BillRepository;
import com.diplomna2m.repository.DetailsRepository;
import com.diplomna2m.repository.HeaderRepository;

@Transactional
@Service
public class DetailsService implements DetailsServiseInterface {

	@Autowired
	private DetailsRepository detailsRepository;
	@Autowired
	private HeaderRepository headerRepository;
	@Autowired
	private BillRepository billRepository;

	@Override
	public void save(Detail object) {
		detailsRepository.save(object);

	}

	@Override
	public List<Detail> findDDSMistakenEntry() {
		return detailsRepository.findDDSMistake();
	}

	@Override
	public List<Detail> findDDSMistakenSale() {
		return detailsRepository.findDDSMistake2();
	}

	@Override
	public List<Detail> findMistakeInCostAccounts() {
		return detailsRepository.findCostAccounts();
	}

	@Override
	public List<Detail> findMistakeInUnitCosts() {
		return detailsRepository.findUnitCosts();
	}

	@Override
	public List<Detail> findMistakeInExpensesMaterialAccounts() {
		return detailsRepository.findExpensesMaterialAccounts();
	}

	@Override
	public List<Detail> findMistakeInSaleAccount() {
		return detailsRepository.findSaleAccount();
	}
	
	@Override
	public List<Detail> findCustomDetail(String credit, String debit) {
		return detailsRepository.findCustom(credit, debit);
	}

	@Override
	public ListBillDetail chekForRequest(Vzemi vz) {
		List<Detail> allDetails = new ArrayList<>();
		List<Bill> allBills = new ArrayList<>();
		if(vz.isMistake1()) {
			allDetails.addAll(detailsRepository.findDDSMistake());
		}
		if(vz.isMistake2()) {
			allDetails.addAll(detailsRepository.findDDSMistake2());
		}
		if(vz.isMistake3()) {
			allDetails.addAll(detailsRepository.findCostAccounts());
		}
		if(vz.isMistake4()) {
			allDetails.addAll(detailsRepository.findUnitCosts());
		}
		if(vz.isMistake5()) {
			allDetails.addAll(detailsRepository.findExpensesMaterialAccounts());
		}
		if(vz.isMistake6()) {
			allDetails.addAll(detailsRepository.findSaleAccount());
		}
		
		if(!(vz.getCredit() == null && vz.getDebit() == null)) {
			allDetails.addAll(detailsRepository.findCustom(vz.getCredit(), vz.getDebit()));
			allBills.addAll(billRepository.findBills(vz.getCredit(), vz.getDebit()));
		}
		if(vz.getFrom()!= null && vz.getTo() != null) {
		for (int count = 0; count < allDetails.size(); count++) {//for (Detail dt : allDetails)
			if(vz.getFrom().isAfter(allDetails.get(count).getAccHeaderId().getPeriod())||
					vz.getTo().isBefore(allDetails.get(count).getAccHeaderId().getPeriod())) {
				allDetails.remove(count);
				count--;
			}
		}
		}
		ListBillDetail mylist = new ListBillDetail();
		mylist.setAllDetails(allDetails);
		for (int count = 0; count < allBills.size();count ++){
			for (int j = count + 1 ; j < allBills.size(); j++) {
				if (allBills.get(count).getBill().equals(allBills.get(j).getBill())) {
					allBills.remove(count);
					j--;
					}
				}
			}
		mylist.setAllBills(allBills);
		return mylist;
	}
	
    @Override
    public Detail findById(int id) {

        return detailsRepository.findById(id);
    }
    
    @Override
    public void updateUser(Detail oldDetail,Detail newInfo) {
    	if(!(newInfo.getLine() == 0)) {
    		oldDetail.setLine(newInfo.getLine());
    	}
    	if(!newInfo.getDebit().isEmpty()) {
    		oldDetail.setDebit(newInfo.getDebit());
    	}
    	if(!newInfo.getCredit().isEmpty()) {
    		oldDetail.setCredit(newInfo.getCredit());
    	}
    	if(!newInfo.getTextOfEntry().isEmpty()) {
    		oldDetail.setTextOfEntry(newInfo.getTextOfEntry());
    	}
    	if(!(newInfo.getChangedOn() == null)) {
    		oldDetail.setChangedOn(newInfo.getChangedOn());
    	}
    	if(!(newInfo.getAccHeaderId().getJournalNumber() == 0.0)) {
    		oldDetail.getAccHeaderId().setJournalNumber(newInfo.getAccHeaderId().getJournalNumber());
    	}
    	if(!newInfo.getAccHeaderId().getPeriod().toString().isEmpty()) {
    		oldDetail.getAccHeaderId().setPeriod(newInfo.getAccHeaderId().getPeriod());
    	}
    	if(!newInfo.getAccHeaderId().getRefName().isEmpty()) {
    		oldDetail.getAccHeaderId().setRefName(newInfo.getAccHeaderId().getRefName());
    	}
    	detailsRepository.updateDetail(oldDetail.getLine(),oldDetail.getDebit(),oldDetail.getCredit(),
    			oldDetail.getTextOfEntry(),oldDetail.getChangedOn(),oldDetail.getId());
    	
    	headerRepository.updateHeader(oldDetail.getAccHeaderId().getJournalNumber(), oldDetail.getAccHeaderId().getPeriod(), oldDetail.getAccHeaderId().getRefName(), oldDetail.getAccHeaderId().getId());
    }

}
