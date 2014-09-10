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
			  
			  if(patient != null){
				  if(patient.getPatientFirstName()!=null && !patient.getPatientFirstName().equals("")){
					  criteria.add(Restrictions.like("patientFirstName", patient.getPatientFirstName()));
				  }
				  if(patient.getPatientLastName()!=null && !patient.getPatientLastName().equals("")){
					  criteria.add(Restrictions.like("patientLastName", patient.getPatientLastName()));
				  }
				  if(patient.getDateOfBirth()!=null && !patient.getDateOfBirth().equals("")){
					  criteria.add(Restrictions.eq("dateOfBirth", patient.getDateOfBirth()));
				  }
				  if(patient.getSex()!=null && !patient.getSex().equals("")){
					  criteria.add(Restrictions.eq("sex", patient.getSex()));
				  }
				  if(patient.getAddressLine1()!=null && !patient.getAddressLine1().equals("")){
					  criteria.add(Restrictions.like("addressLine1", patient.getAddressLine1()));
				  }
				  if(patient.getAddressLine2()!=null && !patient.getAddressLine2().equals("")){
					  criteria.add(Restrictions.like("addressLine2", patient.getAddressLine2()));
				  }				  
				  if(patient.getCity()!=null && !patient.getCity().equals("")){
					  criteria.add(Restrictions.eq("city", patient.getCity()));
				  }
				  if(patient.getContactDetail()!=null && !patient.getContactDetail().equals("")){
					  criteria.add(Restrictions.eq("contactDetail", patient.getContactDetail()));
				  }
				  if(patient.getAlternateContact()!=null && !patient.getAlternateContact().equals("")){
					  criteria.add(Restrictions.eq("alternateContact", patient.getAlternateContact()));
				  }
				  if(patient.getPrimaryPhysician()!=null && !patient.getPrimaryPhysician().equals("")){
					  criteria.add(Restrictions.eq("primaryPhysician", patient.getPrimaryPhysician()));
				  }
				  if(patient.getReferringPhysician()!=null && !patient.getReferringPhysician().equals("")){
					  criteria.add(Restrictions.eq("referringPhysician", patient.getAlternateContact()));
				  }
			  }
			  
			  criteria.add(Restrictions.eq("status", 1));
			  
			  patientList = criteria.list();
		  }catch(RuntimeException re){
			  throw re;
		  }finally{
			  if(session != null){
				  session.close();
			  }
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
		 }finally{
			 if(session != null){
				 session.flush();
				 session.close();
			 }
		 }
	  }
	  
	  public Patient getPatient(String id)
	  {
		List<Patient> listPatient = new ArrayList<Patient>();
	    Patient patient = new Patient();
	    Session session = sessionFactory.openSession();
	    
	    try{
	    	Query query = session.createQuery("from Patient where patientId=:id");
	    	query.setParameter("id", id);
	    	
	    	listPatient = query.list();
	    	
	    	if(listPatient != null && listPatient.size()>0){
	    		patient = listPatient.get(0);
	    	}
	    }catch(RuntimeException re){
	    	throw re;
	    }finally{
	    	if(listPatient != null){
	    		listPatient.clear();
	    		listPatient = null;
	    	}
	    }
	    
	    return patient;
	  }
	  
	  public void deletePatient(String id) {
		  
		  Session session = sessionFactory.openSession();
		  
		  try{
			  Query query = session.createQuery("UPDATE Patient set status='0' where patientId=:id");
			  query.setParameter("id", id);
			  query.executeUpdate();
		  }catch(RuntimeException re){
			  throw re;
		  }finally{
			  
		  }
	  }
}
