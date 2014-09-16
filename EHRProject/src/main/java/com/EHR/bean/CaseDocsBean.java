package com.EHR.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CaseDocsTable")
public class CaseDocsBean {

	private Long caseDocumentId;
	private int templateId;
	private int templateCategoryId;
	private Long appointmentId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="caseDocumentId")
	public Long getCaseDocumentId() {
		return caseDocumentId;
	}
	public void setCaseDocumentId(Long caseDocumentId) {
		this.caseDocumentId = caseDocumentId;
	}
	
	@Column(name="templateId")
	public int getTemplateId() {
		return templateId;
	}
	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}
	
	@Column(name="templateCategoryId")
	public int getTemplateCategoryId() {
		return templateCategoryId;
	}
	public void setTemplateCategoryId(int templateCategoryId) {
		this.templateCategoryId = templateCategoryId;
	}
	
	@Column(name="appointmentId")
	public Long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	
}
