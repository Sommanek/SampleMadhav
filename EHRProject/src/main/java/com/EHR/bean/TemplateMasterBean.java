package com.EHR.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TemplateMaster")
public class TemplateMasterBean {

	private Long templateId;
	//private Provider provider;
	private String templateCode;
	private String templateName;
	private Integer templateCategoryId;
	private Integer clinicCode;
	private List<TemplateDetailBean> templateDetails = new ArrayList<TemplateDetailBean>(0);
	//private List<PDCTVitalRangeMaster> PDCTVitalRangeMasters = new ArrayList<PDCTVitalRangeMaster>();

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "templateId", unique = true, nullable = false)
	public Long getTemplateId() {
		return this.templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

/*	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctorId")
	public Provider getProvider() {
		return this.provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}*/

	@Column(name = "templateCode", nullable = false, length = 32)
	public String getTemplateCode() {
		return this.templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	@Column(name = "templateName", nullable = false, length = 128)
	public String getTemplateName() {
		return this.templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	@Column(name = "templateCategoryId", nullable = false)
	public Integer getTemplateCategoryId() {
		return this.templateCategoryId;
	}

	public void setTemplateCategoryId(Integer templateCategoryId) {
		this.templateCategoryId = templateCategoryId;
	}

	@Column(name = "clinicCode")
	public Integer getClinicCode() {
		return this.clinicCode;
	}

	public void setClinicCode(Integer clinicCode) {
		this.clinicCode = clinicCode;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "templateMasterBean")
	public List<TemplateDetailBean> getTemplateDetails() {
		return this.templateDetails;
	}

	public void setTemplateDetails(List<TemplateDetailBean> templateDetails) {
		this.templateDetails = templateDetails;
	}
	
/*	@OneToMany(fetch = FetchType.LAZY, mappedBy = "PDCTTemplateMaster")
	public List<PDCTVitalRangeMaster> getPDCTVitalRangeMasters(){
		return this.PDCTVitalRangeMasters;
	}
	
	public void setPDCTVitalRangeMasters(List<PDCTVitalRangeMaster> PDCTVitalRangeMasters){
		this.PDCTVitalRangeMasters = PDCTVitalRangeMasters;
	}*/
}
