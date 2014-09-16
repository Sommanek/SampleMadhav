package com.EHR.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ElementTable")
public class ElementBean {

	private String elementId;
	private String elementCode;
	private String elementName;
	private String templateCategoryId;
	private String childElements;
	private String parentElement;
	private Integer primaryControlType;
	private Integer secondaryControlType;
	private Integer unit;
	private String elementOptions;
	private Integer elementIndex;
	private String defaultValue;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ElementId")
	public String getElementId() {
		return elementId;
	}
	public void setElementId(String elementId) {
		this.elementId = elementId;
	}
	
	@Column(name="ElementCode")
	public String getElementCode() {
		return elementCode;
	}
	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
	}
	
	@Column(name="ElementName")
	public String getElementName() {
		return elementName;
	}
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}
	
	@Column(name="TemplateCategoryId")
	public String getTemplateCategoryId() {
		return templateCategoryId;
	}
	public void setTemplateCategoryId(String templateCategoryId) {
		this.templateCategoryId = templateCategoryId;
	}
	
	@Column(name="ChildElement")
	public String getChildElements() {
		return childElements;
	}
	public void setChildElements(String childElements) {
		this.childElements = childElements;
	}
	
	@Column(name="ParentElement")
	public String getParentElement() {
		return parentElement;
	}
	public void setParentElement(String parentElement) {
		this.parentElement = parentElement;
	}
	
	@Column(name="PrimaryControlType")
	public Integer getPrimaryControlType() {
		return primaryControlType;
	}
	public void setPrimaryControlType(Integer primaryControlType) {
		this.primaryControlType = primaryControlType;
	}
	
	@Column(name="SecondaryControlType")
	public Integer getSecondaryControlType() {
		return secondaryControlType;
	}
	public void setSecondaryControlType(Integer secondaryControlType) {
		this.secondaryControlType = secondaryControlType;
	}
	
	@Column(name="Unit")
	public Integer getUnit() {
		return unit;
	}
	public void setUnit(Integer unit) {
		this.unit = unit;
	}
	
	@Column(name="ElementOptions")
	public String getElementOptions() {
		return elementOptions;
	}
	public void setElementOptions(String elementOptions) {
		this.elementOptions = elementOptions;
	}
	
	@Column(name="ElementIndex")
	public Integer getElementIndex() {
		return elementIndex;
	}
	public void setElementIndex(Integer elementIndex) {
		this.elementIndex = elementIndex;
	}
	
	@Column(name="DefaultValue")
	public String getDefaultValue(){
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue){
		this.defaultValue = defaultValue;
	}
	
}
	