package com.EHR.Service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.EHR.bean.TemplateField;
import com.EHR.bean.TemplateMasterBean;

public interface TemplateService {
	
	public TemplateMasterBean getTemplate(int categoryId);
	
	public abstract Map<Integer, String> createUnitMap();
	
	 public abstract List<TemplateField> getTemplateFieldBeanList(HttpServletRequest paramHttpServletRequest);
	 
	 public abstract boolean disablePatientTemplate(String caseDocumentId, String appointmentId);
	 
	 public void insertTemplateFieldValue(List<TemplateField> fieldList);
	 
	 public String checkTemplateMode(int category, String appointmentId);
	 
	 public List<Map<String, String>> getPatientTemplateValues(Long templateId,String appointmentId,String caseDocumentId,String templateCode);
	 
	 public void setValueForEdit(TemplateMasterBean templateMasterBean, List<Map<String, String>> templateFieldLis);

}
