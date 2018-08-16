package com.moneymoney.app.model.service;

import java.util.ArrayList;

import com.moneymoney.app.model.dao.DAOImpl;
import com.moneymoney.app.model.pojo.MMCurrentAccount;
import com.moneymoney.app.model.pojo.MMCustomer;
import com.moneymoney.app.model.pojo.MMSavingAccount;
import com.moneymoney.framework.account.pojo.BankAccount;
import com.moneymoney.framework.account.pojo.Customer;
import com.moneymoney.framework.account.pojo.PaymentGateway;
import com.moneymoney.framework.service.Service;

public class ServiceImpl implements Service {
	DAOImpl dao = new DAOImpl();

//	public ServiceImpl() {
//	}

	@Override
	public void addBankAccount(BankAccount bankAccount) {
		System.out.println(bankAccount);
		dao.addBankAccount(bankAccount);
	}

	@Override
	public ArrayList<BankAccount> viewAllAccounts() {
		return dao.viewAllAccounts();
	}

	@Override
	public boolean FundTransfer(BankAccount sender, BankAccount reciever, double amount) {
		return PaymentGateway.transfer(sender, reciever, amount);
	}

	@Override
	public void addCustomer(Customer customer) {
		dao.addCustomer(customer);
	}

	@Override
	public ArrayList<Customer> viewAllCustomers() {

		return dao.viewAllCustomers();
	}

	@Override
	public BankAccount searchAccountById(int num) {

		return dao.searchAccountById(num);
	}

	public String withdraw(int accNo, double amount) {
		BankAccount account = searchAccountById(accNo);
		return account.withdraw(amount);
	}

	public String deposit(int accNo, double amount) {
		BankAccount account = searchAccountById(accNo);
		return account.deposit(amount);

	}
}
