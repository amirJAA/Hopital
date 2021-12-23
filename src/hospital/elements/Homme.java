package hospital.elements;

import hospital.map.Block;



/**
 * this is a data class 
 * Initialize the patiens
 * @author Jaafar.A
 *
 */
public class Homme {
	private Block position;
public Homme(Block position) {
		
		this.setPosition(position);
		
	}
public Block getPosition() {
	return position;
}
public void setPosition(Block position) {
	this.position = position;
}
	
	

}
