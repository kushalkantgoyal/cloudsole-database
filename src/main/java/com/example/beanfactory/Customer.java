package com.example.beanfactory;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Customer implements ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean {
	
	private Account account1;
	private Account account2;
	private Account account3;
	private List<Account> accounts;
	private ApplicationContext context = null;
	
	public Customer(String type) {
		super();
		this.type = type;
	}
	
	public Customer(String type, String name){
		this.type = type;
		this.name = name;
	}

	private String name;
	private String type;
	
	public void customer(){
		/*for (Account account : accounts){
			System.out.println(getType() +  ": " + getName() + " has been created with with Account " + account.getBalance() + " and balance " + account.getLoan());
		}*/
		System.out.println(getType() +  ": " + getName() + " has been created with " + getAccount1().getBalance() + " " + getAccount2().getLoan() + " " + getAccount3().getBalance());
	}


	public String getType() {
		return type;
	}


	public String getName() {
		return name;
	}

	public Account getAccount1() {
		return account1;
	}

	public void setAccount1(Account account1) {
		this.account1 = account1;
	}

	public Account getAccount2() {
		return account2;
	}

	public void setAccount2(Account account2) {
		this.account2 = account2;
	}

	public Account getAccount3() {
		return account3;
	}

	public void setAccount3(Account account3) {
		this.account3 = account3;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
		
	}

	@Override
	public void setBeanName(String beanName) {
		System.out.println(beanName);
		
	}
	
	public void initMethod(){
		System.out.println("Intializing beans init method called for Customer");
	}
	
	public void destroyMethod(){
		System.out.println("Bean destoyed");
	}

	//InitializingBean
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Intializing beans by InitializingBean");
	}

	//DisposableBean
	@Override
	public void destroy() throws Exception {
		System.out.println("Bean destoyed by DisposableBean");
		
	}

	/*public void setType(String type) {
		this.type = type;
	}*/

}
