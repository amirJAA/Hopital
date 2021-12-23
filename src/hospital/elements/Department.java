package hospital.elements;

import hospital.map.Block;

/**
 * 
 * this is the mother class from which all the others derive
 * Data class
 * @author Ghezil.A
 * @author Jaafar.A
 *
 */


public class Department {
	
	/**
	 * position of the department
	 */
	private Block position;
	/**
	 * Name of the department
	 */
	private String Name;
	/**
	 * level of the department
	 */
	private int level;
	

	/**
	 * the Doctors Grade of the department
	 */
	private int drGrade;
	/**
	 * the Nursing Teams Grade of the department
	 */
	private int ntGrade;
	/**
	 * the prise of the department
	 */
	private int prise;
	/**
	 * the number of patient that generate the department
	 */
	private int nb_Patient ;
	
	/**
	 * the Dimension of the department
	 */
	private int sizeLine;
	private int sizeColm;

	/**
	 * @return the sizeLine
	 */
	public int getSizeLine() {
		return sizeLine;
	}

	/**
	 * @param sizeLine the sizeLine to set
	 */
	public void setSizeLine(int sizeLine) {
		this.sizeLine = sizeLine;
	}

	/**
	 * @return the sizeColm
	 */
	public int getSizeColm() {
		return sizeColm;
	}

	/**
	 * @param sizeColm the sizeColm to set
	 */
	public void setSizeColm(int sizeColm) {
		this.sizeColm = sizeColm;
	}


	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the prise
	 */
	public int getPrise() {
		return prise;
	}

	/**
	 * @param prise the prise to set
	 */
	public void setPrise(int prise) {
		this.prise = prise;
	}

	/**
	 * @return the nb_Patient
	 */
	public int getNb_Patient() {
		return nb_Patient;
	}

	/**
	 * @param nb_Patient the nb_Patient to set
	 */
	public void setNb_Patient(int nb_Patient) {
		this.nb_Patient = nb_Patient;
	}

	/**
	 * @return the size
	 */
	
	
	

	public Department(Block position) {
		this.position = position;
	}


	public Department(String position, String Name, String level) {
		
	}

	public Block getPosition() {
		return position;
	}

	public void setPosition(Block position) {
		this.position = position;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the drGrade
	 */
	public int getDrGrade() {
		return drGrade;
	}

	/**
	 * @param drGrade the drGrade to set
	 */
	public void setDrGrade(int drGrade) {
		this.drGrade = drGrade;
	}

	/**
	 * @return the ntGrade
	 */
	public int getNtGrade() {
		return ntGrade;
	}

	/**
	 * @param ntGrade the ntGrade to set
	 */
	public void setNtGrade(int ntGrade) {
		this.ntGrade = ntGrade;
	}
}
