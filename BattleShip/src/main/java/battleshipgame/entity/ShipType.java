/**
 * 
 */
package battleshipgame.entity;

import lombok.Getter;

/**
 * 
 * 
 * Ship types, along with the fixed Width,
 * Height and lifePoints 
 * 
 * @author aniket
 *
 * 
 * 
 */

@Getter
public enum ShipType {
	Q(1, 1, 2), P(2, 1, 1);

	private int width;
	private int height;
	private int lifePoints;

	ShipType(int width, int height, int lifePoints) {
		this.width = width;
		this.height = height;
		this.lifePoints = lifePoints;

	}
	
	

}
