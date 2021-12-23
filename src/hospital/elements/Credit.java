package hospital.elements;

/**
 * A data class witch has 2 basic method 
 * to increment and decrement the value
 * @author Bouras.N
 *
 */

public class Credit {
	/**
	 * the value of our Credit
	 */
	private int value ;
	
	public Credit (int value){
		this.value = value;
	}


	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void incCredit(int price){
		value = value + price ; 
	}
	public void dicCredit(int price){
		value = value - price ; 
	}
	@Override
	public String toString(){
		return ""+value;
	}

	
}
