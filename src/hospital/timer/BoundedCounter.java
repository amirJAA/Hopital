package hospital.timer;

/**
 * data Class of a BoundedCounter (the same as that of the first semester P.O.O )
 * @author Jaafar.A
 *
 */
public class BoundedCounter extends Counter {
	
	private int max ;
	private int min ;
	
	public BoundedCounter(int value , int max ,int min) {
		super(value);
		this.max = max;
		this.min = min ;
	}
	
	@Override
	public void inc(){
		if(getValue() < max){
			super.inc();
		}
	}
	
	@Override
	public void dic(){
		if(getValue() < max ){
			super.dic();
		}
	}

	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}
}
