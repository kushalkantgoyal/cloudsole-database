package com.example.config;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.service.CustomerService;
import com.example.model.Customer;

@Service
@Transactional
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

    public Customer updateCustomer(long id, String fn, String ln) {
        Customer customer = this.getCustomerById(id);
        customer.setFirstName(fn);
        customer.setLastName(ln);
        this.entityManager.merge(customer);
        return getCustomerById(id);
    }
    
    public List<Customer> getAllCustomers(String query) {
		 return this.entityManager.createQuery(query, Customer.class).getResultList();
	}

}
