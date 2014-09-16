package com.EHR.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EHR.Service.TemplateService;
import com.EHR.bean.TemplateField;
import com.EHR.bean.TemplateMasterBean;

@Controller
@RequestMapping("/Template")
public class TemplateController {
	
	@Autowired
	TemplateService templateService;
	
	@RequestMapping("/Vital")
	public String goToVital(ModelMap map, @RequestParam("apptId") String apptId){
		
		TemplateMasterBean templateMasterBean = null;
		String mode = null;
		
		templateMasterBean = templateService.getTemplate(1);
		mode = templateService.checkTemplateMode(1, apptId);
		
		if(mode != null && mode.equals("add")){
			map.addAttribute("mode","add");
		}else{
			map.addAttribute("mode","edit");
			map.addAttribute("caseDocumentId", mode);
		}
		
		Map<Integer, String> templateMOUMap = null;
		templateMOUMap = templateService.createUnitMap();
		
		map.addAttribute("AppointmentId", apptId);
		map.addAttribute("templateMasterBean", templateMasterBean);
		map.addAttribute("templateMOUMap", templateMOUMap);
		map.addAttribute("redirectFlag", "HPI");
		
		return "PatientTemplateAddEdit";
	}
	
	@RequestMapping("/HPI")
	public String goToHPI(ModelMap map){
		TemplateMasterBean templateMasterBean = null;
		
		templateMasterBean = templateService.getTemplate(2);
		
		Map<Integer, String> templateMOUMap = null;
		templateMOUMap = templateService.createUnitMap();
		
		map.addAttribute("templateMasterBean", templateMasterBean);
		map.addAttribute("templateMOUMap", templateMOUMap);
		
		return "PatientTemplateAddEdit";
	}
	
	@RequestMapping("/ROS")
	public String goToROS(ModelMap map){
		TemplateMasterBean templateMasterBean = null;
		
		templateMasterBean = templateService.getTemplate(3);
		
		map.addAttribute("templateMasterBean", templateMasterBean);
		
		return "PatientTemplateAddEdit";
	}
	
	@RequestMapping("/TRP")
	public String goToTRP(ModelMap map){
		TemplateMasterBean templateMasterBean = null;
		
		templateMasterBean = templateService.getTemplate(4);
		
		map.addAttribute("templateMasterBean", templateMasterBean);
		
		return "PatientTemplateAddEdit";
	}
	
	@RequestMapping("/SubmitTemplateData")
	public String submitTemplate(ModelMap map, HttpServletRequest request, HttpServletResponse response){
		
		  List<TemplateField> fields = null;
		    String appointmentId = null;
		    String caseDocumentId = null;
		    String mode = null;
		    Map<Integer, String> templateMOUMap = null;
		    String redirectFlag = null;
		    
		    try
		    {
		      templateMOUMap = new HashMap<Integer, String>();
		      appointmentId = request.getParameter("appointmentId");
		      caseDocumentId = request.getParameter("caseDocumentId");
		      mode = request.getParameter("mode");
		      redirectFlag = request.getParameter("redirectFlag");
		      
		      if ("edit".equalsIgnoreCase(mode)) {
		    	  templateService.disablePatientTemplate(caseDocumentId, appointmentId);
		      }
		      
		      fields = templateService.getTemplateFieldBeanList(request);
		      
		      templateService.insertTemplateFieldValue(fields);
		      
		      templateMOUMap = templateService.createUnitMap();
		      
		      System.out.println("redi:::"+redirectFlag);
		      
			    if(redirectFlag != null && !redirectFlag.equals("")){
			    	return "redirect:/Template/"+redirectFlag;
			    }else{
			    	map.put("fields", fields);
			    }
		    }finally{
		    	
		    }
		    
		return "PatientTemplateView";
	}
	

}
