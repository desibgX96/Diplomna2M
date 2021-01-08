package com.diplomna2m.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.diplomna2m.model.Header;

@Repository
public interface HeaderRepository extends JpaRepository< Header, Double> {

	@Transactional
	  @Modifying
	@Query("UPDATE Header SET journalNumber=:journalNumber, period=:period, refName=:refName WHERE id LIKE :id")
	void updateHeader(@Param(value = "journalNumber") double journalNumber,@Param(value = "period") LocalDate period,@Param(value = "refName") String refName, @Param(value = "id") double id);
}
