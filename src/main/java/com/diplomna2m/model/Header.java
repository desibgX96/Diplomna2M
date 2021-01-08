package com.diplomna2m.model;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.format.annotation.DateTimeFormat;

import com.google.gson.annotations.Expose;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "AccHeader")
public class Header implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@XmlElement
	@Expose
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private double id;
	
	@XmlElement
	@Expose
	@Column(name = "FIRM")
	private short firm;

	@XmlElement
	@Expose
	@Column(name = "JOURNAL_NUMBER")
	private double journalNumber;

	@XmlElement
	@Expose
	@Column(name = "PERIOD")
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private LocalDate period;
	
	@XmlElement
	@Expose
	@Column(name = "DOC_TYPE")
	private short docType;
	
	@XmlElement
	@Expose
	@Column(name = "DOC_NR")
	private String docNr;
	
	@XmlElement
	@Expose
	@Column(name = "DOC_DATE")
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private LocalDate docDate;
	
	@XmlElement
	@Expose
	@Column(name = "OPERATION_KIND")
	private short operationKind;
	
	@XmlElement
	@Expose
	@Column(name = "STATUS")
	private short status;
	
	@XmlElement
	@Expose
	@Column(name = "TEXT_OF_ENTRY")
	private String textOFEntry;
	
	@XmlElement
	@Expose
	@Column(name = "REF_NR")
	private String refNr;
	
	@XmlElement
	@Expose
	@Column(name = "REF_NAME")
	private String refName;
	
	@XmlElement
	@Expose
	@Column(name = "CREATED_ON")
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private LocalDate createdOn;
	
	@XmlElement
	@Expose
	@Column(name = "CHANGED_ON",nullable = true)
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private LocalDate changededOn;

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public LocalDate getChangededOn() {
		return changededOn;
	}

	public void setChangededOn(LocalDate changededOn) {
		this.changededOn = changededOn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public short getFirm() {
		return firm;
	}

	public void setFirm(short firm) {
		this.firm = firm;
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

	public LocalDate getDocDate() {
		return docDate;
	}

	public void setDocDate(LocalDate docDate) {
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

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	
}