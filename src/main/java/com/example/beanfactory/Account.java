package com.example.beanfactory;

public class Account {
	
	public Account(){
		super();
	}
	public Account(int balance, int loan) {
		super();
		this.balance = balance;
		this.loan = loan;
	}
	private int balance;
	private int loan;
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getLoan() {
		return loan;
	}
	public void setLoan(int loan) {
		this.loan = loan;
	}

}
