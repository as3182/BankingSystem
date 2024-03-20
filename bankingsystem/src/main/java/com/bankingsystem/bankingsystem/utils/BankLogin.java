package com.bankingsystem.bankingsystem.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bankingsystem.bankingsystem.dao.Databasedao;
import com.bankingsystem.bankingsystem.entities.BankDetails;

@Component
public class BankLogin {
	
private final Databasedao dao;	

public BankLogin(Databasedao dao) {
    this.dao = dao;
}





	public Boolean MyLogin (String username, String password) 
	{
		BankDetails db = dao.findById(username).get();
		String databasepassword = db.getPassword();
		if(databasepassword.equals(password))
		{return true;}
		else {
			return false;
		}
		
		
		
	}

	
}
