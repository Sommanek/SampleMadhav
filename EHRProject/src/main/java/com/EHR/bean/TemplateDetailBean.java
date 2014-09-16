package com.EHR.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TemplateDetailTable")
public class TemplateDetailBean {

	private Long templateElementId;
	private TemplateMasterBean templateMasterBean;
	//private PDCTTemplateMOU PDCTTemplateMOU;
	private String elementTitle;
	private String elementName;
	private String elementCode;
	private String elementOptions;
	private Integer elementIndex;
	private String parentElement;
	private String childElements;
	private String defaultValue;
	private Integer primaryControlType;
	private Integer secondaryControlType;
	private Integer unitId;
	//private PDCTVitalSetupRange pdctVitalSetupRange;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "templateElementId", unique = true, nullable = false)
	public Long getTemplateElementId() {
		return this.templateElementId;
	}

	public void setTemplateElementId(Long templateElementId) {
		this.templateElementId = templateElementId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "templateId", nullable = false)
	public TemplateMasterBean getTemplateMasterBean() {
		return this.templateMasterBean;
	}

	public void setTemplateMasterBean(TemplateMasterBean templateMasterBean) {
		this.templateMasterBean = templateMasterBean;
	}

/*	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unitid")
	public PDCTTemplateMOU getPDCTTemplateMOU() {
		return this.PDCTTemplateMOU;
	}

	public void setPDCTTemplateMOU(PDCTTemplateMOU PDCTTemplateMOU) {
		this.PDCTTemplateMOU = PDCTTemplateMOU;
	}*/

	@Column(name = "elementTitle", nullable = false, length = 128)
	public String getElementTitle() {
		return this.elementTitle;
	}

	public void setElementTitle(String elementTitle) {
		this.elementTitle = elementTitle;
	}

	@Column(name = "elementName", nullable = false, length = 128)
	public String getElementName() {
		return this.elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	@Column(name = "elementCode", nullable = false, length = 128)
	public String getElementCode() {
		return this.elementCode;
	}

	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
	}

	@Column(name = "elementOptions", length = 2000)
	public String getElementOptions() {
		return this.elementOptions;
	}

	public void setElementOptions(String elementOptions) {
		this.elementOptions = elementOptions;
	}

	@Column(name = "elementIndex", nullable = false)
	public Integer getElementIndex() {
		return this.elementIndex;
	}

	public void setElementIndex(Integer elementIndex) {
		this.elementIndex = elementIndex;
	}

	@Column(name = "parentElement", length = 64)
	public String getParentElement() {
		return this.parentElement;
	}

	public void setParentElement(String parentElement) {
		this.parentElement = parentElement;
	}

	@Column(name = "childElements", length = 512)
	public String getChildElements() {
		return this.childElements;
	}

	public void setChildElements(String childElements) {
		this.childElements = childElements;
	}

	@Column(name = "defaultValue", length = 64)
	public String getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	@Column(name = "primaryControlType", nullable = false)
	public Integer getPrimaryControlType() {
		return this.primaryControlType;
	}

	public void setPrimaryControlType(Integer primaryControlType) {
		this.primaryControlType = primaryControlType;
	}

	@Column(name = "secondaryControlType")
	public Integer getSecondaryControlType() {
		return this.secondaryControlType;
	}

	public void setSecondaryControlType(Integer secondaryControlType) {
		this.secondaryControlType = secondaryControlType;
	}

	@Column(name = "unitId")
	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

}
