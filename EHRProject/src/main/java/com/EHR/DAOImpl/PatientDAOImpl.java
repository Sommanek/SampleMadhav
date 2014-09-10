package com.EHR.DAOImpl;

import com.EHR.DAO.PatientDAO;
import com.EHR.bean.Patient;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDAOImpl extends HibernateDaoSupport  implements PatientDAO
{
	
	@Autowired
	private SessionFactory sessionFactory;
  
/*	public void setSessionFactory(SessionFactory factory){
		this.sessionFactory = factory;
	}*/
	
/*	@Autowired
	public PatientDAOImpl(SessionFactory sess){
		super.setSessionFactory(sess);
	}*/
	
	  public List<Patient> getPatientList()
	  {
		  return null;
	  }
	  
	  public List<Patient> getPatientList(Patient patient)
	  {
		  Session session = sessionFactory.openSession();
		  List<Patient> patientList = new ArrayList<Patient>();
		  
		  try{
			  Criteria criteria = session.createCriteria(Patient.class);
			  
			  criteria.add(Restrictions.like("", ""));
		  }catch(RuntimeException re){
			  throw re;
		  }
		  
		  return patientList;
	  }
	  
	  public void savePatient(Patient patient) {
		  
		 Session session = sessionFactory.openSession();
		 
		 try{
			session.save(patient);
		 }catch(RuntimeException re){
			 System.out.println(re);
			 throw re;
		 }
	  }
	  
	  public Patient getPatient(String id)
	  {
	    Patient patient = new Patient();
	    
	
	
	
	
	
	
	    return patient;
	  }
	  
	  public void deletePatient(String id) {
		  
		  
	  }
}
