package com.EHR.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.EHR.Service.PatientService;
import com.EHR.bean.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/Patient"})
@Controller
public class PatientController
{
  @Autowired
  PatientService patientService;
  
  @InitBinder
  protected void initBinder(WebDataBinder webDataBinder){
	  SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	  dateFormat.setLenient(false);
	  webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
  }
  
  @RequestMapping({"/addPatient"})
  public String addPatient(ModelMap map)
  {
    Patient patient = new Patient();
    map.put("patient", patient);
    return "AddPatient";
  }
  
  @RequestMapping({"/editPatient/{id}"})
  public String editPatient(ModelMap map, @PathVariable String id)
  {
    Patient patient = new Patient();
    
    patient = this.patientService.getPatient(id);
    map.put("patient", patient);
    map.put("mode", "edit");
    return "AddPatient";
  }
  
  @RequestMapping({"/patientAddEditSubmit"})
  public String submitPatient(ModelMap map, @ModelAttribute("patient") Patient patient)
  {
	 try{
		 patient.setStatus(1);
		 patientService.savePatient(patient);
    
		 patient = new Patient();
		 map.put("patient", patient);
		 map.put("message", "Patient Added Successfully");
	 }catch(Exception e){
		 System.out.println(e);
		 map.put("message", "Patient cannot be added");
		 
	 }
    return "AddPatient";
  }
  
  @RequestMapping({"/searchPatient"})
  public String searchPatient(ModelMap map)
  {
	  Patient patient = new Patient();
	  map.put("patient", patient);
	    
	  return "SearchPatient";
  }
  
  @RequestMapping({"/searchPatientResult"})
  public String searchPatientResult(ModelMap map, @ModelAttribute Patient patient)
  {
	List<Patient> patientList = new ArrayList<Patient>();
	
	patientList = patientService.getPatientList(patient);
	
	map.addAttribute("patientList", patientList);
    return "SearchPatientResult";
  }
  
  @RequestMapping({"/deletePatient/{id}"})
  public String deletePatient(ModelMap map, @PathVariable String id)
  {
    this.patientService.deletePatient(id);
    
    	return "redirect:/Patient/searchPatient";
  }
}
