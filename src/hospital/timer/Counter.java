package hospital.timer;

/**
 * data Class of a Counter (the same as that of the first semester P.O.O )
 * with some methods such as inc() and dic()  to increment and decrement the time
 * @author jaafar.A
 * @author Bouras.N 
 *
 */
public class Counter {
	/**
	 * 
	 */
	public int value ;
	
	/*
	 * 
	 */
	public Counter(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * 
	 */
	public void inc(){
		value++;
	}
	/**
	 * 
	 */
	public void dic(){
		value--;
	}
	

	@Override
	public String toString() {
		return "Counter [value=" + value + "]";
	}
	
}
