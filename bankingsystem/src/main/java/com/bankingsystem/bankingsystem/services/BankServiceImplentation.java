package com.bankingsystem.bankingsystem.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingsystem.bankingsystem.dao.Databasedao;
import com.bankingsystem.bankingsystem.entities.BankDetails;
import com.bankingsystem.bankingsystem.entities.Logindetails;
import com.bankingsystem.bankingsystem.entities.TranferDTO;
import com.bankingsystem.bankingsystem.utils.BankLogin;


@Service
public class BankServiceImplentation implements BankServices {

	@Autowired
	private Databasedao databasedao;
	
	@Override
	public BankDetails GetBankBalance(Logindetails logindetail) throws Exception {
		
	
		
		String localUsername=logindetail.getUsername();
		String localPassword=logindetail.getPassword();
		
		
		BankLogin banklogin=new BankLogin(databasedao);
		
		Boolean result =  banklogin.MyLogin(localUsername,localPassword);
	    if(result==false) 
	    {
	    	throw new Exception("Exception Message");
	    	
	    }
	    
	    else {
	    	Optional<BankDetails> bankDetails =databasedao.findById(localUsername);
			return bankDetails.get();
		}
		
		
	}

	
	@Override
	public String withdrawMoney(Integer amount, Logindetails logindetail) throws Exception {

		String localUsername=logindetail.getUsername();
		String localPassword=logindetail.getPassword();
		
		
		
		BankLogin banklogin=new BankLogin(databasedao);
		
		Boolean result =  banklogin.MyLogin(localUsername,localPassword);
	    if(result==false) 
	    {
	    	throw new Exception("Exception Message");
	    	
	    }
	    
	    else {
	    	Optional<BankDetails> databaseinfo= databasedao.findById(localUsername);
	    	Integer databaseBankBalance  =  databaseinfo.get().getBankBalance();
	    	if(databaseBankBalance>=amount) {
	    	Integer ResultantBankBalance = databaseBankBalance-amount;
	    	databaseinfo.get().setBankBalance(ResultantBankBalance);
	    	databasedao.save(databaseinfo.get());
	    	return "success";}
	    	else 
	    	{
	    		return "bank balance is insufficient";
	    	}
	    	
		}
		
	}


	@Override
	public String depositMoney(Integer amount, Logindetails loginetail) throws Exception {
		
		String localUsername=loginetail.getUsername();
		String localPassword=loginetail.getPassword();
		
		
		
		BankLogin banklogin=new BankLogin(databasedao);
		
		Boolean result =  banklogin.MyLogin(localUsername,localPassword);
	    if(result==false) 
	    {
	    	throw new Exception("Exception Message");
	    	
	    }
	    
	    else {
	    	Optional<BankDetails> databaseinfo= databasedao.findById(localUsername);
	    	Integer databaseBankBalance  =  databaseinfo.get().getBankBalance();
	    
	    	Integer ResultantBankBalance = databaseBankBalance+amount;
	    	databaseinfo.get().setBankBalance(ResultantBankBalance);
	    	databasedao.save(databaseinfo.get());
	    	return "success";
	    	
	    	
		}
		
	}


	@Override
	public String transferMoney(Integer amount, TranferDTO transferdto) throws Exception {
		
		ArrayList<Logindetails> loginDetailsList = transferdto.getList_of_Logindetails();

	     
	    	
	        Logindetails logindetail1 = loginDetailsList.get(0);
	        Logindetails logindetail2 = loginDetailsList.get(1);
	        String s=withdrawMoney(amount, logindetail1);
	        if(s.equals("success"))
	        {
	        	Optional<BankDetails> dbinfo=databasedao.findById(logindetail2.getUsername());
	        	dbinfo.get().setBankBalance(dbinfo.get().getBankBalance()+amount);
	        	databasedao.save(dbinfo.get());
	        	return "success";
	        
	    }
	        else {
				return "insufficient money for transfer";
			}
		

		

	}


	
	}
   