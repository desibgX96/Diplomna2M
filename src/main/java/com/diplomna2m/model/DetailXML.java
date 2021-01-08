package com.diplomna2m.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.format.annotation.DateTimeFormat;

@XmlAccessorType(XmlAccessType.FIELD)
public class DetailXML implements Serializable{

	private static final long serialVersionUID = 1L;

	@XmlElement
	private int id;
	

	@XmlElement
    private HeaderXML accHeaderId;
	
	@XmlElement
    private int line;
    

	@XmlElement
	String debit;
	
	@XmlElement
	String credit;

	@XmlElement
	double amount;

	@XmlElement
	String textOfEntry;

	@XmlElement
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date createdOn;

	@XmlElement
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date changedOn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HeaderXML getAccHeaderId() {
		return accHeaderId;
	}

	public void setAccHeaderId(HeaderXML accHeaderId) {
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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getChangedOn() {
		return changedOn;
	}

	public void setChangedOn(Date changedOn) {
		this.changedOn = changedOn;
	}

}
