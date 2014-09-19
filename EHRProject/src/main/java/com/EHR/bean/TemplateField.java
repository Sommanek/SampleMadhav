package com.EHR.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TemplateField")
public class TemplateField {

	private Integer templateFieldId;
	private String appointmentId;
	private Long templateId;
	private String templateCode;
	private String fieldName;
	private String fieldValue;
	private Long caseDocumentId;
	private Integer groupIndex;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TemplateFieldId", unique = true, nullable = false)
	public Integer getTemplateFieldId() {
		return this.templateFieldId;
	}

	public void setTemplateFieldId(Integer templateFieldId) {
		this.templateFieldId = templateFieldId;
	}

	@Column(name = "appointmentId", length = 36)
	public String getAppointmentId() {
		return this.appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	@Column(name = "templateId", nullable = false)
	public Long getTemplateId() {
		return this.templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	@Column(name = "templateCode", nullable = false, length = 32)
	public String getTemplateCode() {
		return this.templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	@Column(name = "fieldName", nullable = false, length = 64)
	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Column(name = "fieldValue", nullable = false)
	public String getFieldValue() {
		return this.fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	@Column(name = "caseDocumentId", nullable = false)
	public Long getCaseDocumentId() {
		return this.caseDocumentId;
	}

	public void setCaseDocumentId(Long caseDocumentId) {
		this.caseDocumentId = caseDocumentId;
	}

	@Column(name = "groupIndex")
	public Integer getGroupIndex() {
		return groupIndex;
	}

	public void setGroupIndex(Integer groupIndex) {
		this.groupIndex = groupIndex;
	}
	
/*	SELECT PTFT.appointmentId, PTFT.caseDocumentId, PTFT.templateId, PTFT.templateCode, PTFT.fieldName,PTDT.elementName, PTDT.unitId, PTFT.fieldValue, 
	FROM TemplateDetailTable PTDT
	INNER JOIN TemplateField PTFT ON PTDT.templateId = PTFT.templateId  AND (PTDT.elementCode = PTFT.fieldName) 
	WHERE PTFT.TemplateId = :templateId AND PTFT.appointmentId = :appointmentId AND PTFT.caseDocumentId = :caseDocumentId AND templateCode = :templateCode 
	Order By TemplateFieldId*/
}