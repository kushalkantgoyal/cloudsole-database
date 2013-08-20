package com.example.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.service.CustomerService;
import com.example.model.Customer;

@Repository
@Qualifier("jpaRepository")
@Transactional(readOnly = true)
public class JpaCustomerService implements CustomerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public Customer getCustomerById(long id) {
        return this.entityManager.find(Customer.class, id);
    }

    public Customer createCustomer(String fn, String ln) {
        Customer newCustomer = new Customer();
        newCustomer.setFirstName(fn);
        newCustomer.setLastName(ln);
        this.entityManager.persist(newCustomer);
        return newCustomer;
    }
    
    @Transactional
    public Customer updateCustomer(long id, String fn, String ln) {
        Customer customer = this.getCustomerById(id);
        customer.setFirstName(fn);
        customer.setLastName(ln);
        this.entityManager.merge(customer);
        return getCustomerById(id);
    }

	public Collection<Customer> getAllCustomers() {
		 CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
	        CriteriaQuery<Customer> criteriaBuilderQuery = criteriaBuilder.createQuery(Customer.class);
	        CriteriaQuery<Customer> customerCriteriaQuery = criteriaBuilderQuery.select(
	                criteriaBuilderQuery.from(Customer.class));
	        return this.entityManager.createQuery(customerCriteriaQuery).getResultList();
	}

	@Transactional
	public void deleteCustomer(long id) {
		Customer customerToDelete = this.entityManager.find(Customer.class, id);
		this.entityManager.remove(customerToDelete);
	}

	public Customer createCustomer(Customer newCustomer) {
		 this.entityManager.persist(newCustomer);
	     return newCustomer;
	}

	@Transactional
	public Customer updateCustomer(long id, Customer updateCustomer) {
		Customer customer = this.getCustomerById(id);
		customer.setFirstName(updateCustomer.getFirstName());
	    customer.setLastName(updateCustomer.getLastName());
		this.entityManager.merge(customer);
        return getCustomerById(id);
	}

	@Override
	public List<Customer> bulkCreate(List<Customer> customers) {
		for (Customer customer : customers){
			this.entityManager.persist(customer);
		}
		return customers;
	}

	@Override
	public List<Customer> findCustomerByQuery(String query) {
		return this.entityManager.createNativeQuery(query, Customer.class).getResultList();
	}

	@Transactional
	public void deleteCustomers(List<Customer> customersToDelete) {
		for (Customer customer : customersToDelete){
			entityManager.remove(customer);
		}
	}

	@Override
	public List<Customer> getPaginatedCustomer(Integer currentPage,
			Integer totalPerPage) {
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaBuilderQuery = criteriaBuilder.createQuery(Customer.class);
        CriteriaQuery<Customer> customerCriteriaQuery = criteriaBuilderQuery.select(
                criteriaBuilderQuery.from(Customer.class));
        return this.entityManager.createQuery(customerCriteriaQuery).getResultList().subList(currentPage, totalPerPage);
	}

	@Transactional
	public List<Customer> updateCustomers(List<Customer> customersToUpdate) {
		List<Customer> listOfUpdatedCustomers = new ArrayList<Customer>();
		for (Customer customerToUpdate : customersToUpdate){
		 this.entityManager.merge(customerToUpdate);
		 listOfUpdatedCustomers.add(getCustomerById(customerToUpdate.getId()));
		}
		return listOfUpdatedCustomers;
	}

	@Override
	public int getTotalRecords() {
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaBuilderQuery = criteriaBuilder.createQuery(Customer.class);
        CriteriaQuery<Customer> customerCriteriaQuery = criteriaBuilderQuery.select(
                criteriaBuilderQuery.from(Customer.class));
        return this.entityManager.createQuery(customerCriteriaQuery).getResultList().size();
	}

	@Override
	public List<String> getPaginationSequence() {
		List<String> listOfPages = new ArrayList<String>();
		for (int k = 1; k < (int)Math.round((this.getTotalRecords()/10)+0.5)+1; k++){
			listOfPages.add(String.valueOf(k));
		}
		return listOfPages;
	}

	@Override
	public void createCustomersFromMap(Map<String, String> mapOfCustomers) {
		for (Map.Entry<String, String> customer : mapOfCustomers.entrySet()){
			Customer newCustomer = new Customer();
			newCustomer.setFirstName(customer.getKey());
			newCustomer.setLastName(customer.getValue());
			createCustomer(newCustomer);
		}
	}
	
	
}
