/**
 * 
 */
package com.atm.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.atm.domain.MiniStatementDomain;

/**
 * @author aniket
 *
 *  This is not multithreaded , because the input is coming from console.
 *  
 *  In case of an actual application, this class will be replaced by an actual DAO layer, 
 *  supported by transaction management.
 *  
 *  
 * Each of the static variables defined here , will need to be protected in case of multithreaded environment.
 * 
 *
 *
 */
public  class Utils {

	public static List<Integer> validDenominations = new ArrayList<>();
	
	
    public  static final DateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public static int BalanceAmount =0;
	
	public static List<MiniStatementDomain> ministatements = new ArrayList<>();
	
	
	
	
	
	
}


  