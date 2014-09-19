package com.EHR.DAOImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.EHR.DAO.TemplateDAO;
import com.EHR.bean.CaseDocsBean;
import com.EHR.bean.PDCTTemplateMOU;
import com.EHR.bean.TemplateField;
import com.EHR.bean.TemplateMasterBean;

@Repository
public class TemplateDAOImpl extends HibernateDaoSupport implements TemplateDAO{
	
	
	@Autowired
	TemplateDAOImpl(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

	public TemplateMasterBean getTemplate(int categoryId) {

		//Session session = getHibernateTemplate().getSessionFactory().openSession();
		Session session = getSession();
		
		try{
			Query query = session.createQuery("from TemplateMasterBean where templateCategoryId=:id");
			query.setParameter("id", categoryId);
			
			//return null;
			return (TemplateMasterBean)query.list().get(0);
		}catch(RuntimeException re){
			throw re;
		}finally{
			//if(session != null) session.close();
		}
		
	}

	public List<PDCTTemplateMOU> createUnitMap1() {
		
		//Session session = getHibernateTemplate().getSessionFactory().openSession();
		Session session = getSession();
		    try
		    {
		      String queryString = "from PDCTTemplateMOU";
		      
		      Query query  = session.createQuery(queryString);
		      return query.list();
		    }
		    catch (RuntimeException re)
		    {
		      throw re;
		    }finally{
		    	//if(session != null) session.close();
		    }
	}

	public Long saveCaseDocs(String caseDocumentId, String appointmentId, String templateId, String templateCategoryId) {
		
		Transaction tx = null;
		//Session session = getHibernateTemplate().getSessionFactory().openSession();
		Session session = getSession();
		CaseDocsBean caseDocsBean = null;
		Long caseDocId = 1l;
		
		try{
			caseDocsBean = new CaseDocsBean();
			caseDocsBean.setAppointmentId(Long.valueOf(appointmentId));
			//caseDocsBean.setCaseDocumentId(Long.valueOf(caseDocumentId));
			caseDocsBean.setTemplateCategoryId(Integer.valueOf(templateCategoryId));
			caseDocsBean.setTemplateId(Integer.valueOf(templateId));
			
			tx = session.beginTransaction();
			session.saveOrUpdate(caseDocsBean);
			//session.flush();
			tx.commit();
			caseDocId = caseDocsBean.getCaseDocumentId();
			
			return caseDocId;
		}catch(RuntimeException re){
			if(tx!= null) tx.rollback();
			throw re;
		}finally{
			tx= null;
			//session.close();
		}

	}

	public boolean disablePatientTemplate(String caseDocumentId, String appointmentId) {
		
		boolean flag = false;
		//Session session = getHibernateTemplate().getSessionFactory().openSession();
		Session session = getSession();
		
		try{
			
			Query query1 = session.createQuery("delete from CaseDocsBean where appointmentId=:appointmentId and caseDocumentId=:caseDocumentId");
			query1.setParameter("appointmentId", Long.valueOf(appointmentId));
			query1.setParameter("caseDocumentId", Long.valueOf(caseDocumentId));
			
			Query query2 = session.createQuery("delete from TemplateField where appointmentId=:appointmentId and caseDocumentId=:caseDocumentId");
			query2.setParameter("appointmentId", appointmentId);
			query2.setParameter("caseDocumentId", Long.valueOf(caseDocumentId));
			
			query1.executeUpdate();
			query2.executeUpdate();
			
			flag = true;
			
		}catch(RuntimeException re){
			throw re;
		}
		return flag;
	}
	
	public void insertTemplateFieldValue(List<TemplateField> fieldList){
	    Transaction tx = null;
	    try{
	      tx = getSession().beginTransaction();
	      for (TemplateField field : fieldList) {
	        getHibernateTemplate().merge(field);
	      }
	      tx.commit();
	    }catch (Exception e){
	      tx.rollback();
	      e.printStackTrace();
	    }
	    finally
	    {
	      tx = null;
	    }
	}

	public String checkTemplateMode(int category, String appointmentId) {

		//Session session = getHibernateTemplate().getSessionFactory().openSession();
		Session session = getSession();
		List<CaseDocsBean> caseBeanList = new ArrayList<CaseDocsBean>();
		
		try{
			Query query = session.createQuery("from CaseDocsBean where  templateCategoryId=:catId and appointmentId=:apptId");
			query.setParameter("catId", category);
			query.setParameter("apptId", Long.valueOf(appointmentId));
			
			caseBeanList = query.list();
			
			if(caseBeanList !=  null && caseBeanList.size()>0){
				return caseBeanList.get(0).getCaseDocumentId().toString();
			}else{
				return "add";
			}
			
		}catch(RuntimeException re){
			
		}
		
		return null;
	}

	public List<Map<String, String>> getPatientTemplateValues(Long templateId, String appointmentId, String caseDocumentId, String templateCode) {

		List<Map<String, String>> listOfValues = null;
		Session session = getSession();
		
		System.out.println(templateId+"  "+appointmentId+"  "+caseDocumentId+" "+templateCode);
		
		try{
			Query query = session.createSQLQuery(" SELECT PTFT.appointmentId, PTFT.caseDocumentId, PTFT.templateId, PTFT.templateCode, PTFT.fieldName,PTDT.elementName, PTDT.unitId, PTFT.fieldValue FROM TemplateDetailTable PTDT INNER JOIN TemplateField PTFT ON PTDT.templateId = PTFT.templateId  AND (PTDT.elementCode = PTFT.fieldName) WHERE PTFT.TemplateId = :templateId AND PTFT.appointmentId = :appointmentId AND PTFT.caseDocumentId = :caseDocumentId AND templateCode = :templateCode Order By TemplateFieldId");
		      query.setParameter("templateId", templateId);
		      query.setParameter("appointmentId", appointmentId);
		      query.setParameter("caseDocumentId", caseDocumentId);
		      query.setParameter("templateCode", templateCode);
		      query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		      listOfValues = query.list();
		}catch(Exception re){
			re.printStackTrace();
		}
		return listOfValues;
	}

}
