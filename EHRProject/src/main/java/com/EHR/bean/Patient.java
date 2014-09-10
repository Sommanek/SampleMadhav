package com.EHR.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patienttable")
public class Patient implements Serializable{
	
	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PatientId")
	private int patientId;
	
	@Column(name="PatientFirstName")
	private String patientFirstName;
	
	@Column(name="PatientLastName")
	private String patientLastName;
	
	@Column(name="DateOfBirth")
	private Date dateOfBirth;
	
	@Column(name="Sex")
	private String sex;
	
	@Column(name="AddressLine1")
	private String addressLine1;
	
	@Column(name="AddressLine2")
	private String addressLine2;
	
	@Column(name="City")
	private String city;
	
	@Column(name="ContactDetail")
	private String contactDetail;
	
	@Column(name="AlternateContact")
	private String alternateContact;
	
	@Column(name="PrimaryPhysician")
	private String primaryPhysician;
	
	@Column(name="ReferringPhysician")
	private String referringPhysician;
	
	@Column(name="Status")
	private int status;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactDetail() {
		return contactDetail;
	}

	public void setContactDetail(String contactDetail) {
		this.contactDetail = contactDetail;
	}

	public String getAlternateContact() {
		return alternateContact;
	}

	public void setAlternateContact(String alternateContact) {
		this.alternateContact = alternateContact;
	}

	public String getPrimaryPhysician() {
		return primaryPhysician;
	}

	public void setPrimaryPhysician(String primaryPhysician) {
		this.primaryPhysician = primaryPhysician;
	}

	public String getReferringPhysician() {
		return referringPhysician;
	}

	public void setReferringPhysician(String referringPhysician) {
		this.referringPhysician = referringPhysician;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
} 
