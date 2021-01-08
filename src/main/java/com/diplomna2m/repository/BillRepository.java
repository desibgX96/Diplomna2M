package com.diplomna2m.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.diplomna2m.model.Bill;

@Repository
public interface BillRepository extends JpaRepository< Bill, String> {

	@Query("Select b from Bill as b where  bill LIKE :credit  OR bill LIKE :debit")
	List<Bill> findBills(@Param(value = "credit") String credit, @Param(value = "debit") String debit);
}
