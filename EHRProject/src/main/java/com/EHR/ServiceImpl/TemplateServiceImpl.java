package com.EHR.ServiceImpl;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EHR.DAO.TemplateDAO;
import com.EHR.Service.TemplateService;
import com.EHR.bean.PDCTTemplateMOU;
import com.EHR.bean.TemplateField;
import com.EHR.bean.TemplateMasterBean;

@Service
public class TemplateServiceImpl implements TemplateService{
	
	@Autowired
	TemplateDAO templateDAO;

	public TemplateMasterBean getTemplate(int categoryId) {
		
		TemplateMasterBean templateMasterBean = null;
		
		templateMasterBean = templateDAO.getTemplate(categoryId);
		
		return templateMasterBean;
	}
	
	  public Map<Integer, String> createUnitMap()
	  {
	    List<PDCTTemplateMOU> templateMouList = new ArrayList<PDCTTemplateMOU>();
	    Map<Integer, String> templateMouMap = new HashMap<Integer, String>();
	    try
	    {
	      templateMouList = templateDAO.createUnitMap1();
	      for (PDCTTemplateMOU pdctTemplateMOU : templateMouList) {
	        templateMouMap.put(pdctTemplateMOU.getUnitId(), pdctTemplateMOU.getUnitName());
	      }
	    }
	    finally
	    {
	      if (templateMouList != null) {
	        templateMouList = null;
	      }
	    }
	    return templateMouMap;
	  }

	public List<TemplateField> getTemplateFieldBeanList(HttpServletRequest request) {
		
		   List<TemplateField> fields = null;
		    TemplateField field = null;
		    Enumeration<String> enumeration = null;
		    Long caseDocId = 1l;
		    
		    
		    try
		    {
		      fields = new ArrayList();
		      
		      enumeration = request.getParameterNames();
		      
		      caseDocId =templateDAO.saveCaseDocs(request.getParameter("appointmentId"),request.getParameter("templateId"),request.getParameter("templateId"), request.getParameter("templateId"));
		      
		      while(enumeration.hasMoreElements()){
		    	  field = new TemplateField();
		    	  
		    	  String paramName = (String)enumeration.nextElement();
		    	  String paramValues = request.getParameter(paramName);
		    	  
		    	  if(paramName.startsWith("VIT")){
			    	  field.setAppointmentId(request.getParameter("appointmentId"));
			    	  field.setCaseDocumentId(caseDocId);
			    	  field.setFieldName(paramName);
			    	  field.setFieldValue(paramValues);
			    	  field.setTemplateCode(request.getParameter("templateCode"));
			    	  field.setTemplateId(Long.parseLong(request.getParameter("templateId")));
		    	  
		    	  
			    	  fields.add(field);
		    	  }
		    	  
		      }
		    }finally{
		    	field = null;
		    	enumeration = null;
		    	
		    }

		return fields;
	}

	public boolean disablePatientTemplate(String caseDocumentId, String appointmentId) {

		boolean flag = false;
		
		flag = templateDAO.disablePatientTemplate(caseDocumentId, appointmentId);
		
		return false;
	}

	public void insertTemplateFieldValue(List<TemplateField> fieldList) {
		
		templateDAO.insertTemplateFieldValue(fieldList);
		
	}

	public String checkTemplateMode(int category, String appointmentId) {

		return templateDAO.checkTemplateMode(category,appointmentId);
	}

}
