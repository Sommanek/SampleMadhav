package com.EHR.ServiceImpl;

import com.EHR.DAO.PatientDAO;
import com.EHR.Service.PatientService;
import com.EHR.bean.Patient;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImple
  implements PatientService
{
  @Autowired
  PatientDAO patientDAO;
  
  public List<Patient> getPatientList()
  {
    List<Patient> patientList = new ArrayList();
    try
    {
      patientList = this.patientDAO.getPatientList();
      return patientList;
    }
    finally
    {
      if (patientList != null)
      {
        patientList.clear();
        patientList = null;
      }
    }
  }
  
  public void savePatient(Patient patient)
  {
    this.patientDAO.savePatient(patient);
  }
  
  public Patient getPatient(String id)
  {
    Patient patient = new Patient();
    
    patient = this.patientDAO.getPatient(id);
    
    return patient;
  }
  
  public void deletePatient(String id)
  {
    this.patientDAO.deletePatient(id);
  }
}
