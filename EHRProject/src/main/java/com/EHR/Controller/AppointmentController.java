package com.EHR.Controller;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.EHR.bean.Patient;

@Controller
@RequestMapping("/Appointment")
public class AppointmentController {
	@RequestMapping("/AddAppointment")
	public String addAppointmentHandler(ModelMap modelMap) {
		Patient patient = new Patient();
		System.out.println("123123::"+patient.getPatientId());
		return "AddAppointment";
	} 
	
	
}
