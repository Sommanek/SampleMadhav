package com.EHR.DAO;

import com.EHR.bean.Patient;
import java.util.List;

public abstract interface PatientDAO
{
  public abstract List<Patient> getPatientList();
  
  public abstract void savePatient(Patient paramPatient);
  
  public abstract Patient getPatient(String paramString);
  
  public abstract void deletePatient(String paramString);
}
