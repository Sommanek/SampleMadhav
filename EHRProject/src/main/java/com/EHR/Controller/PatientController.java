package com.EHR.Controller;

import com.EHR.Service.PatientService;
import com.EHR.bean.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/Patient"})
@Controller
public class PatientController
{
  @Autowired
  PatientService patientService;
  
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
    return "AddPatient";
  }
  
  @RequestMapping({"/patientAddEditSubmit"})
  public String submitPatient(ModelMap map, @ModelAttribute("patient") Patient patient)
  {
    this.patientService.savePatient(patient);
    return "";
  }
  
  @RequestMapping({"/searchPatient"})
  public String searchPatient(ModelMap map)
  {
    return "SearchPatient";
  }
  
  @RequestMapping({"/searchPatientResult"})
  public String searchPatientResult(ModelMap map)
  {
    return "SearchPatientResult";
  }
  
  @RequestMapping({"/deletePatient/{id}"})
  public String deletePatient(ModelMap map, @PathVariable String id)
  {
    this.patientService.deletePatient(id);
    
    return "";
  }
}
