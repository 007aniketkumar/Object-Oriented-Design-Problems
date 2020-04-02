package battleshipgame.exception;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public class BattleShipGameErrorCodes {

	static BattleShipGameErrorCodes instance=new BattleShipGameErrorCodes();

	public static BattleShipGameErrorCodes getInstance() {
		return instance;
	}
	
	private BattleShipGameErrorCodes() {
		
	}
	
	
	public  static Map<String,String> errorCodeToMessageMapping = new HashMap<>();

	public static void ErrorCodeMapping() {
		errorCodeToMessageMapping.put("1", "BattleField Dimensions are Invalid ! Exiting");
		errorCodeToMessageMapping.put("2", "Ship Dimensions are Invalid! Exiting");
		errorCodeToMessageMapping.put("3", "Number of Ships is Invalid! Exiting");
		errorCodeToMessageMapping.put("4", "Position Already occupied");
		errorCodeToMessageMapping.put("5", "Outside the battle Area");
		errorCodeToMessageMapping.put("6", "Invalid missiles");
		errorCodeToMessageMapping.put("7", "Invalid input file path");
		errorCodeToMessageMapping.put("8", "Invalid Ship type ! Terminating the Game ");







	}
	
}
