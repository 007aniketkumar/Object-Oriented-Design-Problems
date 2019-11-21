/**
 * 
 */
package com.atm.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import com.atm.Interfaces.ATMFunctions;
import com.atm.domain.AllowedDenomination;
import com.atm.domain.MiniStatementDomain;
import com.atm.domain.MiniStatementDomain.TransactionType;
import com.atm.utils.Utils;

/**
 * @author aniket
 *
 */
public class DepositFunction implements ATMFunctions {

	@Override
	public void handleFunction() {

		System.out.println("Enter ccy to deposit terminated by. e.g. 10 20 50 .");
		try {
			BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

			String input = scanner.readLine();
			int totalDepositedAmount = 0;
			if (input != null) {
				String[] inputs = input.split(" ");// accept the input with space

				int i = 0;
				while (i < inputs.length && !inputs[i].equals(".")) {
					Validity result = validInput(inputs[i]);

					if (result.isAnInteger && result.isAValidDenomination) {
                        int tempValue = Integer.valueOf(inputs[i]);
                        
						Utils.validDenominations.add(tempValue);
						System.out.println("Accepted input :" + inputs[i]);
						Utils.BalanceAmount = Utils.BalanceAmount + tempValue;
						totalDepositedAmount = totalDepositedAmount + tempValue;
					} else if (result.isAnInteger) {

						System.out.println("Invalid input :" + Integer.valueOf(inputs[i]));

					}
					i++;

				}

				if (totalDepositedAmount != 0) {
					// update Ministatement
					MiniStatementDomain ministatement = new MiniStatementDomain(
							Utils.simpleDateFormat.format(new Date()), totalDepositedAmount, Utils.BalanceAmount,
							TransactionType.Credit);

					Utils.ministatements.add(ministatement);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	
	
	
	
	
	/**
	 * 
	 * The input should be an integer 
	 * and should be a denomination of either 10,20,50
	 * {@code AllowedDenomination}
	 * 
	 * 
	 */
	private Validity validInput(String input) {
		boolean isAValidDenomination = false;
		boolean isAnInteger = true;
		try {
			isAValidDenomination = (Integer.valueOf(input) == AllowedDenomination.TEN.getValue()
					|| Integer.valueOf(input) == AllowedDenomination.TWENTY.getValue()
					|| Integer.valueOf(input) == AllowedDenomination.FIFTY.getValue());
		} catch (NumberFormatException ne) {
			isAnInteger = false;
		}

		return new Validity(isAValidDenomination, isAnInteger);
	}

}





class Validity {
	boolean isAValidDenomination = false;

	public boolean isisAValidDenomination() {
		return isAValidDenomination;
	}

	public void setResult(boolean isAValidDenomination) {
		this.isAValidDenomination = isAValidDenomination;
	}

	public boolean isAnInteger() {
		return isAnInteger;
	}

	public void setAnInteger(boolean isAnInteger) {
		this.isAnInteger = isAnInteger;
	}

	boolean isAnInteger = true;

	Validity(boolean isAValidDenomination, boolean isAnInteger) {
		this.isAValidDenomination = isAValidDenomination;
		this.isAnInteger = isAnInteger;

	}
}
