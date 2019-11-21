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
public class MiniStatement implements ATMFunctions{



@Override
public void handleFunction() {
	// TODO Auto-generated method stub
//Printing the header section
	
	System.out.println("\n"+ "Date Time"+ "\t\tTransaction" +"\tAmount" +"\tClosingBalance");
	
	Utils.ministatements.forEach(ministatement->System.out.println(ministatement.toString()));
} }
