/**
 * 
 */
package com.atm.domain;

/**
 * @author aniket
 *
 */
public enum AllowedDenomination {

	TEN(10),
	TWENTY(20),
	FIFTY(50);
	
	int value;
	
	AllowedDenomination(int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
