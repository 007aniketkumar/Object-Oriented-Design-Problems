/**
 * 
 */
package battleshipgame.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author aniket
 *
 */
@AllArgsConstructor
@Getter
public class BattleShip {

	// create a new instance of battle ship every time
	ShipType shiptype;
	
	//location of ship placed on the battle field
	Coordinates location;

	
}
