package hospital.timer;

/** A CyclicCounter is a BoundedCounter that he turn on it self 
 *  to increment and decrement the value
 * @author Jaafar.A
 * 
 *
 */
public class CyclicCounter extends BoundedCounter{
	/**
	 * 
	 * @param value
	 * @param max
	 * @param min
	 */
	public CyclicCounter(int value,int max , int min){
		super(value,max,min);
	}
	/**
	 * 
	 */
	@Override
	public void inc(){
		if(getValue()<getMax()){
			super.inc();
		}else{
			setValue(getMin());
		}
	}
	/**
	 * 
	 */
	@Override
	public void dic(){
		if (getValue()>getMin()){
			super.dic();
		}else{
			setValue(getMax());
		}
	}
	/**
	 * 
	 */
	@Override
	public String toString() {
		return Timer.transorm(getValue());
	}
	
}
