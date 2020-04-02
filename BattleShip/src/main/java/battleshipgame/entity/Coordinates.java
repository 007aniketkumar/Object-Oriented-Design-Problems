/**
 * 
 */
package battleshipgame.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author aniket
 * @param <T>
 *
 */

@Getter
@Setter
@AllArgsConstructor
public class Coordinates implements Comparable<Coordinates>{

	
	@Override
	public String toString() {
		return "" + inputCoordinates + "";
	}


	private int xCoordinate;
	private int yCoordinate;
	private String inputCoordinates;//used for printing the inputs
	
	
	@Override
	public int compareTo(Coordinates o) {
		if(this.xCoordinate==o.xCoordinate && this.yCoordinate==o.yCoordinate)
	        return 0;
	    else if(this.xCoordinate<o.xCoordinate && this.yCoordinate<o.yCoordinate)
	        return -1;
	    else
	        return 1;
	}


	public Coordinates(int xCoordinate, int yCoordinate) {
		super();
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xCoordinate;
		result = prime * result + yCoordinate;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (xCoordinate != other.xCoordinate)
			return false;
		if (yCoordinate != other.yCoordinate)
			return false;
		return true;
	}
	
	
	
	
}
