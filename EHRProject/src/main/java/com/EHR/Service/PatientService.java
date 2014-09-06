package com.EHR.Service;

import com.EHR.bean.Patient;
import java.util.List;

public abstract interface PatientService
{
  public abstract List<Patient> getPatientList();
  
  public abstract void savePatient(Patient paramPatient);
  
  public abstract Patient getPatient(String paramString);
  
  public abstract void deletePatient(String paramString);
}
