package com.example.hibernate;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.example.model.Customer;
import com.example.service.CustomerService;

@Repository
@Qualifier("hibernateRepository")
public class HibernateCustomerService implements CustomerService{

	@Inject
	SessionFactory sessionFactory;
	
	@Override
	public Customer updateCustomer(long id, String fn, String ln) {
		Query query = sessionFactory.openSession().createQuery("update Customer set firstName=:fName, lastName=:lName where id=:id").setParameter("fName", fn).setParameter("lName", ln).setParameter("id", id);
		query.executeUpdate();
		return null;
	}

	@Override
	public List<Customer> updateCustomers(List<Customer> customersToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(long id) {
		return  (Customer) sessionFactory.openSession().createQuery("from Customer where id=?").setLong(0, id).list().get(0);
	}

	@Override
	public Collection<Customer> getAllCustomers() {
		return (Collection<Customer>)sessionFactory.openSession().createQuery("from Customer").list();
	}

	@Override
	public Customer createCustomer(String fn, String ln) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Customer c = new Customer();
		c.setFirstName(fn);
		c.setLastName(ln);
		session.save(c);
		tx.commit();
		session.close();
		return c;
	}

	@Override
	public void deleteCustomer(long id) {
		Query query = sessionFactory.openSession().createQuery("delete Customer where id = :id").setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public Customer createCustomer(Customer newCustomer) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(newCustomer);
		tx.commit();
		session.close();
		return newCustomer;
	}

	@Override
	public Customer updateCustomer(long id, Customer updateCustomer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> bulkCreate(List<Customer> customers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findCustomerByQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomers(List<Customer> customerToDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> getPaginatedCustomer(Integer currentPage,
			Integer totalPerPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalRecords() {
		String hql = "Select count(*) from Customer";
		Query query = sessionFactory.openSession().createQuery(hql);
		return ((Long)query.uniqueResult()).intValue();
	}

	@Override
	public List<String> getPaginationSequence() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCustomersFromMap(Map<String, String> mapOfCustomers) {
		// TODO Auto-generated method stub
		
	}


}
