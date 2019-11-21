/**
 * 
 */
package com.atm.domain;

import com.atm.Interfaces.ATMFunctions;
import com.atm.process.DepositFunction;
import com.atm.process.DisplayBalanceFunction;
import com.atm.process.InvalidSelectionfunction;
import com.atm.process.MiniStatement;
import com.atm.process.WithdrawFunction;

/**
 * @author aniket
 *
 */
public enum ATMOptions {
	
	

	Deposit("1.Deposit"){
		@Override
		public ATMFunctions getInstance() {
			 return new DepositFunction();
		}
	},
	Withdraw("2.Withdraw") {
		@Override
		public ATMFunctions getInstance() {
			 return new WithdrawFunction();
	}},
	DisplayBalance("3.Display Balance")
 {
		@Override
		public ATMFunctions getInstance() {
			return new DisplayBalanceFunction();
		} },
		MiniStatement("4.Mini Statement") {
			@Override
			public	ATMFunctions getInstance() {
				return new MiniStatement();
		}},
	Exit("5.Exit"){

		@Override
		public ATMFunctions getInstance() {
			System.exit(0);
			return null;
		}
			
		},
	
	Invalid(""){
			@Override
			public ATMFunctions getInstance() {
				return  new InvalidSelectionfunction();
			}	
		};
	
	
	abstract public ATMFunctions getInstance();
	
	
	private String AtmFunctionsMessage;
	
	ATMOptions(final String AtmFunctionsMessage) {
		this.AtmFunctionsMessage = AtmFunctionsMessage;
	}	
	public String options() {
		return AtmFunctionsMessage;
	}
	
	public static ATMOptions getOptionsFromIntegerSelection(int selection) {
		
		switch(selection) {
		case 1: return ATMOptions.Deposit;
		case 2: return ATMOptions.Withdraw;
		case 3: return ATMOptions.DisplayBalance;
		case 4: return ATMOptions.MiniStatement;
		case 5: return ATMOptions.Exit;
		
		default: return ATMOptions.Invalid;
		}
		
	}
	}

