/**
 * 
 */
package com.atm.process;

import com.atm.Interfaces.ATMFunctions;
import com.atm.utils.Utils;

/**
 * @author aniket
 *
 */
public class DisplayBalanceFunction implements ATMFunctions{

	@Override
	public void handleFunction() {

		System.out.println("The current standing balance is:" + Utils.BalanceAmount);
	}

}
