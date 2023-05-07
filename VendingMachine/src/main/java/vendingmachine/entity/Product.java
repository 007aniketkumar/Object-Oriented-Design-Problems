/**
 * 
 */
package vendingmachine.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author aniket
 *
 */

@Getter
@AllArgsConstructor
public class Product {

	private String productName;
	private int price;
}
