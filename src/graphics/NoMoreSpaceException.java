package graphics;

import hospital.elements.Department;

public class NoMoreSpaceException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoMoreSpaceException(Department dep){
		super("No More Space Available to add "+dep.getName());
	}
}
