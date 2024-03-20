package com.bankingsystem.bankingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingsystem.bankingsystem.entities.BankDetails;

public interface Databasedao extends JpaRepository<BankDetails, String>{

}
