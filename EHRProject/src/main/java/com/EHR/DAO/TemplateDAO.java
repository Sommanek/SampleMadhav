package com.EHR.DAO;

import java.util.List;

import com.EHR.bean.PDCTTemplateMOU;
import com.EHR.bean.TemplateField;
import com.EHR.bean.TemplateMasterBean;

public interface TemplateDAO {

	public TemplateMasterBean getTemplate(int categoryId);
	
	public abstract List<PDCTTemplateMOU> createUnitMap1();
	
	public Long saveCaseDocs(String caseDocumentId,String appointmentId, String templateId, String templateCategoryId);
	
	public abstract boolean disablePatientTemplate(String caseDocumentId, String appointmentId);
	
	public void insertTemplateFieldValue(List<TemplateField> fieldList);
	
	public String checkTemplateMode(int category, String appointmentId);
}
