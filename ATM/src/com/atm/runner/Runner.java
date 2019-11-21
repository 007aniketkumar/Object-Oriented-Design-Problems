/**
 * 
 */
package com.atm.runner;

import java.util.Arrays;
import java.util.Scanner;
import com.atm.domain.ATMOptions;

/**
 * 
 * This is a basic ATM runner class which will accept valid user inputs and display results accordingly.
 * 
 * 
 * @author aniket
 *
 */
public class Runner {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {

      try { Scanner scanner = new Scanner(System.in);
        

        while(true) {//as long as the user keeps on providing a non exit input
        		//iterate over the enum and print the options
        	System.out.println("\n");
        	Arrays.asList(ATMOptions.values()).forEach(action->System.out.println(action.options()));
        	System.out.println("\n Select an option :");

        		//call the appropriate handle method of the ATMFunction class based on the input selected by the user
            String input = scanner.next();
        	ATMOptions func =(ATMOptions.getOptionsFromIntegerSelection(Integer.valueOf(input)));
               func.getInstance().handleFunction();;
        	}


	}
      catch(NumberFormatException ne) {
    	  
    	  System.out.println("Invalid Keystroke, a non integer option selected!" + " Please try again");
      }
       catch(Exception e) {
		e.printStackTrace();
	}
	
}}
