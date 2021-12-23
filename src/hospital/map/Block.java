package hospital.map;

import config.GameConfiguration;

/**
 * this is a data class 
 * our Playground is is divided by Block and :
 * A Block is a square 
 * @author Bouras.n
 *
 */
public class Block {
	private int line;
	private int column;

	public Block(int line, int column) {
		this.line = line;
		this.column = column;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public String toString() {
		return "" + line + GameConfiguration.SEPARETOR+ column;
	}

}
