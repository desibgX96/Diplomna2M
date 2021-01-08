package com.diplomna2m.model;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Vzemi {

	boolean mistake1;
	boolean mistake2;
	boolean mistake3;
	boolean mistake4;
	boolean mistake5;
	boolean mistake6;

	String debit;
	String credit;

	@DateTimeFormat(pattern = "dd.MM.yyyy")
	LocalDate from;
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	LocalDate to;
	public boolean isMistake1() {
		return mistake1;
	}
	public void setMistake1(boolean mistake1) {
		this.mistake1 = mistake1;
	}
	public boolean isMistake2() {
		return mistake2;
	}
	public void setMistake2(boolean mistake2) {
		this.mistake2 = mistake2;
	}
	public boolean isMistake3() {
		return mistake3;
	}
	public void setMistake3(boolean mistake3) {
		this.mistake3 = mistake3;
	}
	public boolean isMistake4() {
		return mistake4;
	}
	public void setMistake4(boolean mistake4) {
		this.mistake4 = mistake4;
	}
	public boolean isMistake5() {
		return mistake5;
	}
	public void setMistake5(boolean mistake5) {
		this.mistake5 = mistake5;
	}
	public boolean isMistake6() {
		return mistake6;
	}
	public void setMistake6(boolean mistake6) {
		this.mistake6 = mistake6;
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
	public LocalDate getFrom() {
		return from;
	}
	public void setFrom(LocalDate from) {
		this.from = from;
	}
	public LocalDate getTo() {
		return to;
	}
	public void setTo(LocalDate to) {
		this.to = to;
	}

}
