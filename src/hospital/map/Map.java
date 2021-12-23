package hospital.map;
/**
 * our map is inspired by that of M.Lui
 * a 2-dimensional array of blocks
 * @author Jaafar.Amir
 * @author Bouras.N
 *
 */
public class Map { 
	/**
	 * 
	 */
	private Block[][] blocks;
	private int lineCount;
	private int columnCount;
	/**
	 * 
	 * @param lineCount
	 * @param columnCount
	 */
	public Map(int lineCount, int columnCount) {
		this.lineCount = lineCount;
		this.columnCount = columnCount;

		blocks = new Block[lineCount][columnCount];

		for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				blocks[lineIndex][columnIndex] = new Block(lineIndex, columnIndex);
			}
		}
	}
	
	public Block[][] getBlocks() {
		return blocks;
	}

	public int getLineCount() {
		return lineCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public Block getBlock(int line, int column) {
		return blocks[line][column];
	}
	
	/**
	 * 
	 * @param block
	 * @param element
	 * @return true if it touch the element
	 */
	public boolean istouch(Block block,Block element) {
		int line = block.getLine();
		return (line == element.getLine())  ;
	}
	

}
