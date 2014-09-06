package com.EHR.DAOImpl;

import com.EHR.DAO.PatientDAO;
import com.EHR.bean.Patient;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDAOImpl
  extends DaoSupport
  implements PatientDAO
{
  @Autowired
  public PatientDAOImpl(SessionFactory factory) {}
  
  public List<Patient> getPatientList()
  {
    return null;
  }
  
  public void savePatient(Patient patient) {}
  
  protected void checkDaoConfig()
    throws IllegalArgumentException
  {}
  
  public Patient getPatient(String id)
  {
    Patient patient = new Patient();
    






    return patient;
  }
  
  public void deletePatient(String id) {}
}
