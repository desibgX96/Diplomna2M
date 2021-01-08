package com.diplomna2m.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.diplomna2m.model.Detail;

@Repository
public interface DetailsRepository extends JpaRepository< Detail, Integer> {	
	
	@Query("Select d from Detail as d inner join d.accHeaderId as h where d.credit LIKE '%4531%' AND NOT (d.debit LIKE '%4532%' OR d.debit LIKE '%4538%')")
	List<Detail> findDDSMistake();
	
	@Query("Select d from Detail as d inner join d.accHeaderId as h where d.debit LIKE '%4532%' AND NOT (d.credit LIKE '%4531%' OR d.credit LIKE '%4539%')")
	List<Detail> findDDSMistake2();
	
	@Query("Select d from Detail as d inner join d.accHeaderId as h where d.credit LIKE '%60%' AND NOT (d.debit LIKE '%61%')")
	List<Detail> findCostAccounts();
	
	@Query("Select d from Detail as d inner join d.accHeaderId as h where d.credit LIKE '%61%' AND NOT (d.debit LIKE '%70%')")
	List<Detail> findUnitCosts();
	
	@Query("Select d from Detail as d inner join d.accHeaderId as h where d.credit LIKE '%30%' AND NOT (d.debit LIKE '%70%' OR d.debit LIKE '%60%' OR d.debit LIKE '%30%')")
	List<Detail> findExpensesMaterialAccounts();
	
	@Query("Select d from Detail as d inner join d.accHeaderId as h where d.debit LIKE '%70%' AND NOT (d.credit LIKE '%20%' OR d.credit LIKE '%30%' OR d.credit LIKE '%61%')")
	List<Detail> findSaleAccount();
	
	@Query("Select d from Detail as d inner join d.accHeaderId as h where  d.credit LIKE :credit  AND d.debit LIKE :debit")
	List<Detail> findCustom(@Param(value = "credit") String credit, @Param(value = "debit") String debit);

  @Transactional
  @Modifying
	@Query("DELETE FROM Detail WHERE id LIKE :id")
	void deleteById(@Param(value = "id") int id);
	
	@Query("Select d from Detail as d inner join d.accHeaderId as h where  d.id LIKE :id")
	Detail findById(@Param(value = "id")int id);
	
	  @Transactional
	  @Modifying
	@Query("UPDATE Detail SET line=:line, debit=:debit, credit=:credit,textOfEntry=:textOfEntry,changedOn=:changedOn WHERE id LIKE :id")
	void updateDetail(@Param(value = "line") int line,@Param(value = "debit") String debit,@Param(value = "credit") String credit,
			@Param(value = "textOfEntry") String textOfEntry,@Param(value = "changedOn") LocalDate changedOn, @Param(value = "id") int id);

}
