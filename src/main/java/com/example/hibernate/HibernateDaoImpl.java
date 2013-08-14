package com.example.hibernate;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value="HibernateDaoImpl")
public class HibernateDaoImpl {
	
	@Autowired
	private SessionFactory session;

	public int getCustomerCount() {
		String hql = "Select count(*) from Customer";
		Query query = getSession().openSession().createQuery(hql);
		return ((Long)query.uniqueResult()).intValue();
	}
		
	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}
	

}