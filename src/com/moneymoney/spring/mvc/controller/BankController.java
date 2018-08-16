package com.moneymoney.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moneymoney.app.model.service.ServiceImpl;
import com.moneymoney.framework.account.pojo.BankAccount;

@Controller
public class BankController {
	ServiceImpl service = new ServiceImpl();

	@RequestMapping("/withdrawPerform")
	public String withdrawPerform(@RequestParam("accountNum") int accountNum, @RequestParam("amount") double amount,
			Model model) {
		String result = service.withdraw(accountNum, amount);
		model.addAttribute("result", result);
		model.addAttribute("bankAccount1", service.searchAccountById(accountNum));
		model.addAttribute("customerName", service.searchAccountById(accountNum).getCustomer().getCustomerName());
		model.addAttribute("classType1", service.searchAccountById(accountNum).getClass().getSimpleName());

		return "display";
	}

	@RequestMapping("/depositPerform")
	public String depositPerform(@RequestParam("accountNum") int accountNum, @RequestParam("amount") double amount,
			Model model) {
		String result = service.deposit(accountNum, amount);
		model.addAttribute("result", result);
		model.addAttribute("bankAccount1", service.searchAccountById(accountNum));
		model.addAttribute("customerName", service.searchAccountById(accountNum).getCustomer().getCustomerName());
		model.addAttribute("classType1", service.searchAccountById(accountNum).getClass().getSimpleName());
		return "display";
	}

	@RequestMapping("/fundTransferPerform")
	public String fundTransferPerform(@RequestParam("senderAccountNum") int senderAccountNum,
			@RequestParam("recieverAccountNum") int recieverAccountNum, @RequestParam("amount") double amount,
			Model model) {
		String result;
		if (service.FundTransfer(service.searchAccountById(senderAccountNum),
				service.searchAccountById(recieverAccountNum), amount)) {
			result = "Payment Successful";
		} else
			result = "Payment Unsuccessful";

		model.addAttribute("result", result);
		model.addAttribute("bankAccount1", service.searchAccountById(senderAccountNum));
		model.addAttribute("customerName", service.searchAccountById(senderAccountNum).getCustomer().getCustomerName());
		model.addAttribute("classType1", service.searchAccountById(senderAccountNum).getClass().getSimpleName());
		model.addAttribute("bankAccount2", service.searchAccountById(recieverAccountNum));
		model.addAttribute("customerName",
				service.searchAccountById(recieverAccountNum).getCustomer().getCustomerName());
		model.addAttribute("classType2", service.searchAccountById(senderAccountNum).getClass().getSimpleName());

		return "display";
	}

//	@RequestMapping("/createNewAccount")
//	public String createNewAccount() {
//		return "createNewAccount";
//	}
//
//	@RequestMapping("/addnewaccount")
//	public String addnewaccount(@RequestParam("accName") String accName, @RequestParam) {
//		return "display";
//	}

}
