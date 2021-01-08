package com.diplomna2m.model;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.format.annotation.DateTimeFormat;

import com.google.gson.annotations.Expose;


@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "acc_detail")
public class Detail implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@XmlElement
	@Expose
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@XmlElement
	@Expose
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "ACC_HEADER_ID")
    private Header accHeaderId;
	
	@XmlElement
	@Expose
	@Column(name = "LINE")
    private int line;
    

	@XmlElement
	@Expose
	@Column(name = "DEBIT")
	String debit;
	
	@XmlElement
	@Expose
	@Column(name = "CREDIT")
	String credit;

	@XmlElement
	@Expose
	@Column(name = "AMOUNT")
	double amount;

	@XmlElement
	@Expose
	@Column(name = "TEXT_OF_ENTRY")
	String textOfEntry;

	@XmlElement
	@Expose
	@Column(name = "CREATED_ON",nullable = true)
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private LocalDate createdOn;

	@XmlElement
	@Expose
	@Column(name = "CHANGED_ON",nullable = true)
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private LocalDate changedOn;

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDate getChangedOn() {
		return changedOn;
	}

	public void setChangedOn(LocalDate changedOn) {
		this.changedOn = changedOn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Header getAccHeaderId() {
		return accHeaderId;
	}

	public void setAccHeaderId(Header accHeaderId) {
		this.accHeaderId = accHeaderId;
	}

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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTextOfEntry() {
		return textOfEntry;
	}

	public void setTextOfEntry(String textOfEntry) {
		this.textOfEntry = textOfEntry;
	}
	
}
