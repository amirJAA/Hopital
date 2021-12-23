package hospital.timer;

import hospital.timer.CyclicCounter;
/**
 * This Class is a data class how construct an Initialize a Timer
 * a Timer is a sort of 2 counter 
 * one of the minutes and one of hours
 * @author Ghezil.A
 *
 */
public class Timer {
	/**
	 * 
	 */
	private CyclicCounter mm = new CyclicCounter(30, 59, 00);
	private CyclicCounter hh = new CyclicCounter(8, 23, 00);
	
	
	
	public Timer() {
		// TODO Auto-generated constructor stub
	}

	public void inc() {
		mm.inc();
		if (mm.getValue() == 0) {
			hh.inc();
		}
	}
	
	
	
	/**
	 * 
	 */
	public void dic() {
		mm.dic();
		if (mm.getValue()==0) {
			hh.dic();
		}
		
	}

	
	public CyclicCounter getMm() {
		return mm;
	}

	public CyclicCounter getHh() {
		return hh;
	}
	public void setMm(int value){
		mm.setValue(value);	
	}
	public void setHh(int value){
		hh.setValue(value);	
	}
	
	
	@Override
	public String toString(){
		return hh.toString() + " : "+ mm.toString() ; 
	}
	/**
	 * 
	 * @param value
	 * @return
	 */
	public static String transorm(int value){
		String tmp = "";
		if (value<10){
			tmp = "0"+value ;
		}else{
			tmp = ""+value ;
		}
		return tmp ;
	}
	/**
	 * 
	 */
	
	public void init(){
		hh.setValue(0);
		mm.setValue(0);
	}
}
