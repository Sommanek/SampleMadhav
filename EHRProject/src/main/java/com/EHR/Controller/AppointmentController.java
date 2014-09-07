package com.EHR.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Appointment")
public class AppointmentController {
	@RequestMapping("/AddAppointment")
	public String addAppointmentHandler(ModelMap modelMap) {
		return "AddAppointment";
	} 
}
