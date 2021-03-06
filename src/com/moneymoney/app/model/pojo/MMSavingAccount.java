package com.moneymoney.app.model.pojo;

import com.moneymoney.framework.account.pojo.Customer;
import com.moneymoney.framework.account.pojo.SavingAccount;

public class MMSavingAccount extends SavingAccount {

	public MMSavingAccount(Customer accountHolder) {
		super(accountHolder);
	}

	public MMSavingAccount(Customer accountHolder, double accountBalance, boolean salary) {
		super(accountHolder, accountBalance, salary);
	}
	@Override
	public String withdraw(double amount) {
		String denominations;
		if(amount <= (this.getAccountBalance() - super.getMINIMUM_BALANCE())) {
			this.setAccountBalance(this.getAccountBalance() - amount);
				int thousand = (int)amount/1000;
				amount = amount%1000;
				int fiveHundred = (int)amount/500;
				amount = amount%500;
				int hundred = (int)amount/100;
				amount = amount%100;
				int fifty = (int)amount/50;
				amount = amount%50;
				denominations = "No of thousand notes "+ thousand +"\nNo of five hundred notes "+fiveHundred+"\nNo of Hundred notes"+ hundred +
						"\n No of fifty notes "+ fifty + ".";
		}
		else
		{
			denominations = "Does not meet Minimum Balance Requirement";
		}
		return denominations;
	}
	public String deposit(double amount) {
		return super.deposit(amount);
	}
}