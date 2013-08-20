package com.example.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.service.CustomerService;
import com.example.model.Customer;


public class Main {
    public static void main(String args[]) throws Throwable {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("default");
        applicationContext.scan(JpaConfiguration.class.getPackage().getName());
        applicationContext.refresh();

        Log log = LogFactory.getLog(Main.class);

        CustomerService customerService = applicationContext.getBean(CustomerService.class);

       /* Customer customer = customerService.createCustomer("Jpa", "Lover");

        Customer retrievedCustomer = customerService.getCustomerById(customer.getId());

        log.info(String.format("customer.id (%s) == retreivedCustomer.id (%s)?  %s",
                customer.getId(), retrievedCustomer.getId(), customer.getId().equals(retrievedCustomer.getId())));

        Customer updatedCustomer = customerService.updateCustomer(customer.getId(), "JPA", "Lover");
        log.info(String.format("updated customer's firstName: %s", updatedCustomer.getFirstName()));
        
        Collection<Customer> listOfCustomers = customerService.getAllCustomers();
        for (Customer c : listOfCustomers){
        	System.out.println(c);
        }
        
        List<Customer> createDummyCustomers = new ArrayList<Customer>();
        for (int k = 0; k < 10; k++){
        	Customer dummy = new Customer();
        	dummy.setFirstName("FName"+k);
        	dummy.setLastName("LName"+k);
        	createDummyCustomers.add(dummy);
        }
        
        List<Customer> insertedCustomer = customerService.bulkCreate(createDummyCustomers);
        for (Customer c : insertedCustomer){
        	System.out.println(c);
        }
        
        
        List<Customer> customQueryCustomer = customerService.findCustomerByQuery("Select * from customer");
        for (Customer c : customQueryCustomer){
        	System.out.println(c);
        }*/
        
        List<Customer> customerPagination = customerService.getPaginatedCustomer(0, 10);
        for (Customer c : customerPagination){
        	System.out.println(c);
        }
       
        //System.out.println((int)Math.round((customerService.getTotalRecords()/10)+0.5));
        System.out.println(customerService.getPaginationSequence());
        
        
    }
}
