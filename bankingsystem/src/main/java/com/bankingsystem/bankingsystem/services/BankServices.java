package com.bankingsystem.bankingsystem.services;

import com.bankingsystem.bankingsystem.entities.BankDetails;
import com.bankingsystem.bankingsystem.entities.Logindetails;
import com.bankingsystem.bankingsystem.entities.TranferDTO;

public interface BankServices {

	public BankDetails GetBankBalance(Logindetails ld) throws Exception;

	public String withdrawMoney(Integer amount, Logindetails ld) throws Exception;

	public String depositMoney(Integer amount, Logindetails ld) throws Exception;

	public String transferMoney(Integer amount, TranferDTO td) throws Exception;

	
	
	
	
}
