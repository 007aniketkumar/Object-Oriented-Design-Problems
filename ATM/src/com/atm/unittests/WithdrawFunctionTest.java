package com.atm.unittests;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.atm.process.WithdrawFunction;
import com.atm.utils.Utils;

public class WithdrawFunctionTest {

	WithdrawFunction sut;

	List<Integer> denominatedAmount = new ArrayList<>();

	
	
	@Before
	public void initialize() {
		sut = new WithdrawFunction();
	}
	
	/*
	 * 
	 * Test code for withdrawing smallest denomination of 10 only
	 * 
	 * 
	 */
	
	@Test
	public void handleWithdrawFunctionTest() {
		
		Utils.validDenominations.addAll(Arrays.asList(50,20,50,10));
		String input="10";
		Utils.BalanceAmount = 130;

	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    sut.handleFunction();
	   // assertEquals(Integer.valueOf(10), denominatedAmount.get(0));
	    assertEquals(1,sut.denominatedAmount.size());
	    assertEquals(120, Utils.BalanceAmount);

		Utils.validDenominations.clear();	
	}
	
	
	
	/*
	 * 
	 * Check if the correct denominations are released
	 * 
	 */
	
	@Test
	public void handleWDTestWithMultipLEDenominations() {
		Utils.validDenominations.addAll(Arrays.asList(50,20,50,10));
		Utils.BalanceAmount = 130;
		String input="110";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    sut.handleFunction();
	   // assertEquals(Integer.valueOf(10), denominatedAmount.get(0));
	    assertEquals(3,sut.denominatedAmount.size());//which implies 50,50,20,10
	    List<Integer> result = new ArrayList<>();
	    result.add(50);
	    result.add(50);
	    result.add(20);
	    assertEquals(Integer.valueOf(50),sut.denominatedAmount.get(0));//which implies 50,50,20,10
	    assertEquals(Integer.valueOf(50),sut.denominatedAmount.get(1));//which implies 50,50,20,10
	    assertEquals(Integer.valueOf(10),sut.denominatedAmount.get(2));//which implies 50,50,20,10
	    assertEquals(20, Utils.BalanceAmount);
	    assertEquals(Integer.valueOf(20),Utils.validDenominations.get(0));
	    Utils.validDenominations.clear();	
	}
	
	
	
	
	/*
	 * 
	 * 
	 * 
	 * Higher withdrawal than balance
	 * 
	 */
			
	@Test
	public void handleWDTestWithHigherWithdrawal() {
		Utils.validDenominations.addAll(Arrays.asList(50,20,50,10));
		Utils.BalanceAmount = 130;

		
		String input="150";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    sut.handleFunction();
	   // assertEquals(Integer.valueOf(10), denominatedAmount.get(0));
	    assertEquals(0,sut.denominatedAmount.size());//which implies insufficient balance
	   
 		Utils.validDenominations.clear();	
	}
	
	
	
}
