package com.diplomna2m.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class VzemiNewDetail {

	int line;

	String debit;

	String credit;

	String textOfEntry;

	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private LocalDate changedOn;
	
	private double journalNumber;

	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private LocalDate period;
	
	private String refName;

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public String getDebit() {
		return debit;
	}

	public void setDebit(String debit) {
		this.debit = debit;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getTextOfEntry() {
		return textOfEntry;
	}

	public void setTextOfEntry(String textOfEntry) {
		this.textOfEntry = textOfEntry;
	}

	public LocalDate getChangedOn() {
		return changedOn;
	}

	public void setChangedOn(LocalDate changedOn) {
		this.changedOn = changedOn;
	}

	public double getJournalNumber() {
		return journalNumber;
	}

	public void setJournalNumber(double journalNumber) {
		this.journalNumber = journalNumber;
	}

	public LocalDate getPeriod() {
		return period;
	}

	public void setPeriod(LocalDate period) {
		this.period = period;
	}

	public String getRefName() {
		return refName;
	}

	public void setRefName(String refName) {
		this.refName = refName;
	}
	
	
}
