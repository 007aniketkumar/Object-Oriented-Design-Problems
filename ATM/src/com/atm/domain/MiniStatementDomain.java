/**
 * 
 */
package com.atm.domain;

/**
 * @author aniket
 *
 */
public class MiniStatementDomain {


	
	public enum TransactionType {
		Credit,
		Debit
	};
	
	
	private TransactionType  transaction;
	
public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public int getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(int closingBalance) {
		this.closingBalance = closingBalance;
	}

private String dateTime;

private int Amount;

private int closingBalance;



public MiniStatementDomain(String dateTime, int Amount, int closingBalance, TransactionType transaction ){

	this.dateTime = dateTime;
	this.Amount = Amount;
	this.closingBalance = closingBalance;
    this.transaction = transaction;
}


public String toString() {
	return dateTime+"\t"+transaction+"\t\t"+Amount+"\t"+closingBalance;
	
}
}
