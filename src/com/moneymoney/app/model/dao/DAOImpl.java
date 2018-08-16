package com.moneymoney.app.model.dao;

import java.util.ArrayList;

import com.moneymoney.app.model.pojo.MMCurrentAccount;
import com.moneymoney.app.model.pojo.MMCustomer;
import com.moneymoney.app.model.pojo.MMSavingAccount;
import com.moneymoney.framework.account.dao.DAO;
import com.moneymoney.framework.account.pojo.BankAccount;
import com.moneymoney.framework.account.pojo.Customer;

/**
 * @author Satyen Singh
 * @author Drishti Rao
 *
 *         This is class for maintaining the list of all unique account objects.
 *
 *         This was created from the warm heart. The Developers are From
 *         capgemini.
 */
public class DAOImpl implements DAO {
	private static ArrayList<BankAccount> bankAccountSet;
	private static ArrayList<Customer> customerList;
	static {
		bankAccountSet = new ArrayList<>();
		customerList = new ArrayList<>();
	}
	
	public DAOImpl() {
		Customer PR = new MMCustomer("PR", 50205, "25/08/1996", "ram@gmail.com");
		BankAccount pr = new MMSavingAccount(PR, 110000, true);
		addBankAccount(pr);
		
		Customer DR = new MMCustomer("DR", 150205, "29/08/1996", "dr@gmail.com");
		BankAccount dr = new MMSavingAccount(DR, 210000, true);
		addBankAccount(dr);
		
		Customer PK = new MMCustomer("PK", 250205, "18/08/1996", "pk@gmail.com");
		BankAccount pk = new MMSavingAccount(PK, 310000, false);
		addBankAccount(pk);
		
		Customer KW = new MMCustomer("KW", 350205, "27/08/1996", "kw@gmail.com");
		BankAccount kw = new MMCurrentAccount(KW, 98000, 3500);
		addBankAccount(kw);
		
		
		
		
	}

	@Override
	public void addBankAccount(BankAccount bankAccount) {
		bankAccountSet.add(bankAccount);
	}

	@Override
	public ArrayList<BankAccount> viewAllAccounts() {
		return bankAccountSet;
	}

	@Override
	public void addCustomer(Customer customer) {
		
		System.out.println(customer + "is the new customer");
		customerList.add(customer);
	}

	@Override
	public ArrayList<Customer> viewAllCustomers() {
		
		return customerList;
	}

	@Override
	public BankAccount searchAccountById(int num) {
		BankAccount account = null;
		for (BankAccount a : bankAccountSet) {
			if (a.getAccountNumber() == num) {
				account = a;
			}
		}
		return account;
	}
}