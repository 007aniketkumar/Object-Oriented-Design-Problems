/**
 * 
 */
package battleshipgame.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author aniket
 *
 */

@AllArgsConstructor
@Getter
public class BattleShipGameException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	
	public BattleShipGameException(){
		super();
	}
	
	
}
