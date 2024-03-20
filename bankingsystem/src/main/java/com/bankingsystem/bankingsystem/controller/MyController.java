package com.bankingsystem.bankingsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankingsystem.bankingsystem.entities.BankbalanceDTO;
import com.bankingsystem.bankingsystem.entities.TranferDTO;
import com.bankingsystem.bankingsystem.entities.Logindetails;
import com.bankingsystem.bankingsystem.services.BankServices;
import com.bankingsystem.bankingsystem.utils.ConverterUtil;

@RestController
public class MyController {
	
	@Autowired
	private BankServices bankservice;
	
	@GetMapping("/Bankbalance")
	private BankbalanceDTO ShowBankBalance(@RequestBody Logindetails logindetail)
	{
		try {
			
			return  ConverterUtil.ConvertToBankBalanceDto(this.bankservice.GetBankBalance(logindetail));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}
	
	@PutMapping("/Withdrawl/{amount}")
	private String DebitMoneyFromBank(  @PathVariable Integer amount  ,  @RequestBody Logindetails logindetail)
	{
		try {
			return this.bankservice.withdrawMoney(amount,logindetail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "Failed";
		}
	}
	
	@PutMapping("/Deposit/{amount}")
	private String CreditMoney(@PathVariable Integer amount  ,@RequestBody Logindetails logindetail)
	{
		try {
			return this.bankservice.depositMoney(amount,logindetail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "Failed!" ;		}
	}
	
	@PutMapping("/TransferMoney/{amount}")
	private String transferMoney(@PathVariable Integer amount,@RequestBody TranferDTO transferdto)
			{try {
				return this.bankservice.transferMoney(amount,transferdto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return "exception";
			}}
	
	
	
	
	
}
