package com.EHR.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PatientTable")
public class Patient implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PatientId")
	private int patientId;
	@Column(name="PatientFirstName")
	private String patientFirstName;
	@Column(name="PatientLastName")
	private String patientLastName;
	
	public Patient() {
		// TODO Auto-generated constructor stub
	}
} 
