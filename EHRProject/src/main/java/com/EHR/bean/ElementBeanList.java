package com.EHR.bean;

public class ElementBeanList {
	
		private String templateId = null;
		private String templateName = null;
		private Integer templateCategoryId = null;
		private String isDefault = null;
		private String templateCode = null;
		private String mode = null;
		private Integer version = null;
		private Long templateParentId = null;
		private Integer isActive = null;
		//private List<PDCTElementMaster> elementBeanList;
		
		public String getTemplateId() {
			return templateId;
		}

		public void setTemplateId(String templateId) {
			this.templateId = templateId;
		}

		public String getTemplateName() {
			return templateName;
		}

		public void setTemplateName(String templateName) {
			this.templateName = templateName;
		}

		public Integer getTemplateCategoryId() {
			return templateCategoryId;
		}

		public void setTemplateCategoryId(Integer templateCategoryId) {
			this.templateCategoryId = templateCategoryId;
		}

		public String getIsDefault() {
			return isDefault;
		}

		public void setIsDefault(String isDefault) {
			this.isDefault = isDefault;
		}

		public String getTemplateCode() {
			return templateCode;
		}

		public void setTemplateCode(String templateCode) {
			this.templateCode = templateCode;
		}

		public String getMode() {
			return mode;
		}

		public void setMode(String mode) {
			this.mode = mode;
		}

		public Integer getVersion() {
			return version;
		}

		public void setVersion(Integer version) {
			this.version = version;
		}

		public Long getTemplateParentId() {
			return templateParentId;
		}

		public void setTemplateParentId(Long templateParentId) {
			this.templateParentId = templateParentId;
		}

		public Integer getIsActive(){
			return isActive;
		}
		
		public void setIsActive(Integer isActive){
			this.isActive = isActive;
		}
		
		//public List<PDCTElementMaster> getElementBeanList() {
			//return elementBeanList;
		//}

		//public void setElementBeanList(List<PDCTElementMaster> elementBeanList) {
			//this.elementBeanList = elementBeanList;
		//}
		
}
