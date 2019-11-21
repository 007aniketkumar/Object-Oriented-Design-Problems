/**
 * 
 */
package com.atm.process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.atm.Interfaces.ATMFunctions;
import com.atm.domain.MiniStatementDomain;
import com.atm.domain.MiniStatementDomain.TransactionType;
import com.atm.utils.Utils;

/**
 * @author aniket
 *
 */
public class WithdrawFunction implements ATMFunctions{

	List<Integer> tempList = Utils.validDenominations;

	 public List<Integer> denominatedAmount = new ArrayList<>();

	@Override
	public void handleFunction() {
		// TODO Auto-generated method stub
		System.out.println("Enter amount to withdraw: ");
		//Sort the existing list in decreasing order
		int desiredAmountToWithdraw=0;//only saving for the entire transaction.
		Collections.sort(tempList,Collections.reverseOrder());
		
		//create a tempMap
		
		
		
		try {Scanner sc = new Scanner(System.in); 
			
			Integer withdrawalAmount  = sc.nextInt();
			desiredAmountToWithdraw = withdrawalAmount;
			//check if the withdrawalAmount is more than balance
			//if yes return insufficient balance
			if(Utils.BalanceAmount<withdrawalAmount) {
				System.out.println("Insufficient Balance");
				return;
			}
			//Follow the greedy approach of dispensing the money
			int index=0;
			
			while(withdrawalAmount!=0&& index<tempList.size()) {
				
			    if(withdrawalAmount >= tempList.get(index)) {
			    	withdrawalAmount = withdrawalAmount - tempList.get(index);
			    	Utils.BalanceAmount =  	Utils.BalanceAmount - tempList.get(index);
			    	
			    	denominatedAmount.add(tempList.remove(index));
			    
			    } else {
			    index++;
			    }

			}
			
			
			if(withdrawalAmount==0) {
			
			//update Ministatement
			MiniStatementDomain ministatement = new MiniStatementDomain(Utils.simpleDateFormat.format(new Date()),
					desiredAmountToWithdraw,
					Utils.BalanceAmount,
					TransactionType.Debit);
			
		Utils.ministatements.add(ministatement);
		
		System.out.println("The denominations are : ");
		denominatedAmount.stream().forEach(val->System.out.print(" "+val));
		Utils.validDenominations = tempList;//update the actual denominations list.
			} 
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}
	

}
