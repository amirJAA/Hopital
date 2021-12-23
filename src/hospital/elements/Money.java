package hospital.elements;

import hospital.map.Block;

/**
 * this is a data class
 * @author ghezil.A
 *
 */
public class Money {
	private Block position;
	public Money(Block position) {
		this.setPosition(position);
	}
	public Block getPosition() {
		return position;
	}
	public void setPosition(Block position) {
		this.position = position;
	}
	
}
