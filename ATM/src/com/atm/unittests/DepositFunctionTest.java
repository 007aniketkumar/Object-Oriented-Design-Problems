package com.atm.unittests;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.Before;
import org.junit.Test;

import com.atm.process.DepositFunction;
import com.atm.utils.Utils;

public class DepositFunctionTest {


	DepositFunction sut;
	
	@Before
	public void initialize() {
		sut = new DepositFunction();
		Utils.validDenominations.clear();

	}
	
	
	
	
	@Test
	public void handleDepositFunctionTest() {
	Utils.validDenominations.clear();
	String input="10 20 .";
	Utils.BalanceAmount=0;
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    sut.handleFunction();
    assertEquals(Integer.valueOf(10), Utils.validDenominations.get(0));
    assertEquals(30,Utils.BalanceAmount);
	Utils.validDenominations.clear();


	}
	
	
	@Test
	public void handleDepositFunctionTestInvalidInputs() {
		Utils.validDenominations.clear();
		Utils.BalanceAmount=0;
		String input="60";
	    InputStream in = new ByteArrayInputStream(input.getBytes());  
	    System.setIn(in);
	    sut.handleFunction();
	    assertEquals(0, Utils.validDenominations.size());
	    assertEquals(0,Utils.BalanceAmount);



		}
}
