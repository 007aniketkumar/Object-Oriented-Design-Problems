/**
 * 
 */
package com.atm.process;

import com.atm.Interfaces.ATMFunctions;

/**
 * @author aniket
 *
 */
public class InvalidSelectionfunction implements ATMFunctions{



@Override
public void handleFunction() {

	System.out.println("Please try a valid selection again");
}
}