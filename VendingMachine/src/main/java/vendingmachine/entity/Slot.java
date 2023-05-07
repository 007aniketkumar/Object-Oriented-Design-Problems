package vendingmachine.entity;

import java.util.Queue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * 
 * Each slot has 
 * 
 * @author aniket
 *
 */

@Getter
@Setter
@AllArgsConstructor
public class Slot {

	private Queue<Product> product;
	private int SlotId;
	
	
}
