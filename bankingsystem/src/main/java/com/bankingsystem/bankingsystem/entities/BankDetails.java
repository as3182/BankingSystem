package com.bankingsystem.bankingsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="bankdatabase")
@Entity
public class BankDetails {
	
	@Id
	private String username;
	private String password;
	private String name;
	private Integer bankbalance;
	
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBankBalance() {
		return bankbalance;
	}
	public void setBankBalance(Integer bankbalance) {
		this.bankbalance = bankbalance;
	}
	@Override
	public String toString() {
		return "BankDetails [userName=" + username + ", password=" + password + ", name=" + name + ", bankbalance="
				+ bankbalance + "]";
	}
	public BankDetails(String userName, String password, String name, Integer bankbalance) {
		super();
		this.username = userName;
		this.password = password;
		this.name = name;
		this.bankbalance = bankbalance;
	}
	public BankDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
