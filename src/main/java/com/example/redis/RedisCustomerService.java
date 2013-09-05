package com.example.redis;

import com.example.service.CustomerService;
import com.example.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.*;

@Component
public class RedisCustomerService implements CustomerService {


	 private String uniqueIdKey = "customerId";
	 
	 
	    @Autowired
	    private RedisTemplate<String, Object> redisTemplate;

	    private BigInteger uniqueId() {
	        long uniqueId = this.redisTemplate.opsForValue().increment(uniqueIdKey, 1);
	        return BigInteger.valueOf(uniqueId);
	    }

	    private String lastNameKey(BigInteger id) {
	        return "customer:ln:" + id;
	    }

	    private String firstNameKey(BigInteger id) {
	        return "customer:fn:" + id;
	    }

	    
	    public Customer getCustomerById(BigInteger id) {
	        String ln = (String) this.redisTemplate.opsForValue().get(lastNameKey(id));
	        String fn = (String) this.redisTemplate.opsForValue().get(firstNameKey(id));
	        return new Customer(fn, ln);
	    }

	    private void setCustomerValues(BigInteger lid, String fn, String ln) {
	        this.redisTemplate.opsForValue().set(lastNameKey(lid), ln);
	        this.redisTemplate.opsForValue().set(firstNameKey(lid), fn);
	    }


	    public Collection<Customer> loadAllCustomers() {
	        String keyPattern = "customer:fn:*";
	        Set<String> keys = redisTemplate.keys(keyPattern);
	        Set<Customer> customerSet = new HashSet<Customer>();
	        for (String firstNameKey : keys) {
	            long id = Long.parseLong(firstNameKey.split(":")[2]);
	            customerSet.add(this.getCustomerById(BigInteger.valueOf(id)));
	        }
	        return customerSet;
	    }


	    public Customer updateCustomer(BigInteger id, String fn, String ln) {
	        setCustomerValues(id, fn, ln);
	        return getCustomerById(id);
	    }


	@Override
	public Customer updateCustomer(long id, String fn, String ln) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> updateCustomers(List<Customer> customersToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer createCustomer(Customer newCustomer) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
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

	@Override
	public Customer createCustomer(String fn, String ln) {
		  BigInteger lid = uniqueId();
	        setCustomerValues(lid, fn, ln);
	        return getCustomerById(lid);
	}
}