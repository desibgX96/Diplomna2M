package com.diplomna2m.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.format.annotation.DateTimeFormat;

@XmlAccessorType(XmlAccessType.FIELD)
public class HeaderXML implements Serializable{

	private static final long serialVersionUID = 1L;

	@XmlElement
	private double id;
	
	@XmlElement
	private short firm;

	@XmlElement
	private double journalNumber;

	@XmlElement
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date period;
	
	@XmlElement
	private short docType;
	
	@XmlElement
	private String docNr;
	
	@XmlElement
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date docDate;
	
	@XmlElement
	private short operationKind;
	
	@XmlElement
	private short status;
	
	@XmlElement
	private String textOFEntry;
	
	@XmlElement
	private String refNr;
	
	@XmlElement
	private String refName;
	
	@XmlElement
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date createdOn;
	
	@XmlElement
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date changededOn;

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public short getFirm() {
		return firm;
	}

	public void setFirm(short firm) {
		this.firm = firm;
	}

	public double getJournalNumber() {
		return journalNumber;
	}

	public void setJournalNumber(double journalNumber) {
		this.journalNumber = journalNumber;
	}

	public Date getPeriod() {
		return period;
	}

	public void setPeriod(Date period) {
		this.period = period;
	}

	public short getDocType() {
		return docType;
	}

	public void setDocType(short docType) {
		this.docType = docType;
	}

	public String getDocNr() {
		return docNr;
	}

	public void setDocNr(String docNr) {
		this.docNr = docNr;
	}

	public Date getDocDate() {
		return docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

	public short getOperationKind() {
		return operationKind;
	}

	public void setOperationKind(short operationKind) {
		this.operationKind = operationKind;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getTextOFEntry() {
		return textOFEntry;
	}

	public void setTextOFEntry(String textOFEntry) {
		this.textOFEntry = textOFEntry;
	}

	public String getRefNr() {
		return refNr;
	}

	public void setRefNr(String refNr) {
		this.refNr = refNr;
	}

	public String getRefName() {
		return refName;
	}

	public void setRefName(String refName) {
		this.refName = refName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getChangededOn() {
		return changededOn;
	}

	public void setChangededOn(Date changededOn) {
		this.changededOn = changededOn;
	}
	
}
