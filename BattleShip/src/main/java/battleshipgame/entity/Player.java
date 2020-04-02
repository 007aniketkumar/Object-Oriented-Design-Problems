/**
 * 
 */
package battleshipgame.entity;

import java.util.List;

import battleshipgame.utils.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 *  
 * This will store the hitting coordinates and firing function
 * Each player has a {@link BattleArea}.
 * 
 * The 
 * 
 * @author aniket
 *
 * 
 */


@AllArgsConstructor
@Getter
public class Player {

	

	
	private int playerID;
	private  List<Coordinates> hitMissiles;
	private BattleArea battleArea;
	
	//each player has total missiles it can fire
	
	public Response fireMissile(Coordinates c, BattleArea enemyBattleArea){
		boolean result=false;
		String responseStr ="Is a Miss";
		if(enemyBattleArea.getOccupied().containsKey(c)) {
			responseStr="is a Hit";
			int remainingLife = enemyBattleArea.getOccupied().get(c)-1;
			if(remainingLife==0) {
				result = true;
				enemyBattleArea.getOccupied().remove(c);
			} else {				
				enemyBattleArea.getOccupied().put(c, remainingLife);
				result =true;
			}
		}
		Response response = new Response(responseStr,result);
	return response;}
	
	
	
	public boolean losingStatus() {
		return(this.battleArea.getOccupied().size()==0) ;
	}
	
	
}
