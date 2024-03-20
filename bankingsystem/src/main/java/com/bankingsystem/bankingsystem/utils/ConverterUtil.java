package com.bankingsystem.bankingsystem.utils;

import com.bankingsystem.bankingsystem.entities.BankDetails;
import com.bankingsystem.bankingsystem.entities.BankbalanceDTO;

public class ConverterUtil {
	
	public static BankbalanceDTO ConvertToBankBalanceDto(BankDetails bankDetails) {
		BankbalanceDTO bbDTO = new BankbalanceDTO();
		bbDTO.setBankBalance(bankDetails.getBankBalance());
		bbDTO.setName(bankDetails.getName());
		return bbDTO;
		
	}

}
