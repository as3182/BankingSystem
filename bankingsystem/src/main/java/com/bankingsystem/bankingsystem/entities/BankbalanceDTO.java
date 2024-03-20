package com.bankingsystem.bankingsystem.entities;

public class BankbalanceDTO {
	
	private String name;
	private long bankBalance;
	
	public BankbalanceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getBankBalance() {
		return bankBalance;
	}

	public void setBankBalance(long bankBalance) {
		this.bankBalance = bankBalance;
	}

	public BankbalanceDTO(String name, long bankBalance) {
		super();
		this.name = name;
		this.bankBalance = bankBalance;
	}
	
	
	
}
