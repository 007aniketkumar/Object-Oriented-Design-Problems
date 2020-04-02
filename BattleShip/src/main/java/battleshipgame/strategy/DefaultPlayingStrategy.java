/**
 * 
 */
package battleshipgame.strategy;

import battleshipgame.entity.Coordinates;
import battleshipgame.entity.Player;
import battleshipgame.utils.BattleShipGameUtils;

/**
 * @author aniket
 *
 */
public class DefaultPlayingStrategy implements PlayingStrategy{

	
	
	/**
	 * 
	 * Supports 'N' Player game strategy where opponents fire against each other.
	 * 
	 * @param player
	 * @param enemyPlayer
	 */
	public int playingStrategy(Player player, Player enemyPlayer) {
		int i = 0;
		int playingCode=-1;
		Coordinates c = player.getHitMissiles().remove(i);
		System.out.print("Player-"+player.getPlayerID()+" fires a missile with target:" + c.getInputCoordinates());
		while (player.fireMissile(c, enemyPlayer.getBattleArea()).getResponse()) {
			System.out.print(" Is a hit \n");
			if (enemyPlayer.losingStatus()) {
				System.out.println("Player-"+enemyPlayer.getPlayerID()+" lost");
				playingCode=0;
				return playingCode;
				}
			if(BattleShipGameUtils.getInstance().checkArsenal(player)) {
			c =player.getHitMissiles().remove(i);
			System.out.print("Player-"+player.getPlayerID()+" fires a missile with target:" + c.getInputCoordinates());	
			} else{
				playingCode =1; //arsernal over
				return playingCode;
			}
		}
		System.out.print(" Is a Miss \n");
		if (enemyPlayer.losingStatus()) {
			System.out.println("Player"+enemyPlayer.getPlayerID()+ " lost");
			playingCode=0;
			return playingCode;

			}
	return playingCode;}
}
