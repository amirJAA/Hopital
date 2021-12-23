package hospital;
import java.util.ArrayList;


import hospital.map.Block;

import java.util.List;


import config.GameConfiguration;
import hospital.map.Map;
import hospital.elements.Cardiology;
import hospital.elements.Credit;
import hospital.elements.Department;
import hospital.elements.Emergency;
import hospital.elements.GeneralMedcine;
import hospital.elements.Homme;

import hospital.elements.Neurology;
import hospital.elements.Pediatrics;
import hospital.elements.Radiology;
import hospital.elements.Reception;
import hospital.elements.Surgery;
import hospital.timer.Timer;
/**
 * Date 10/02/2021
 * @author Bouras.N
 * @author A.Ghezil
 * @version 1.0
 * */
public class Hospital {
	

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	private Map map;
	private int width = 35;
	private int height = 25;
	
	private List<Department> departements = new ArrayList<Department>();
	private Credit credit = new Credit (GameConfiguration.INIT_CREDIT);
	private Timer time;
	private List<Homme> hommes= new ArrayList<Homme>();
	//private List<Money> moneys= new ArrayList<Money>();
	private Cardiology cardiology;
	private Reception reception = new Reception(new Block(0,0));
	private GeneralMedcine generalMedcine;
	private Pediatrics pediatrics;
	private Surgery surgery;
	private Department department;
	private Neurology neurology;
	private Radiology radiology;
	private Emergency emergency;
	
	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}
	/**
	 * @param reception the reception to set
	 */
	public void setReception(Reception reception) {
		this.reception = reception;
	}
	/**
	 * @param surgery the surgery to set
	 */
	public void setSurgery(Surgery surgery) {
		this.surgery = surgery;
	}
	public List<Department> getDepartements() {
		return departements;
	}
	public Hospital(Map map,Timer time/*Credit credit*/){
		this.map = map;
		this.time = time;
		/*this.credit = credit;*/
	}
	public Hospital(Map map, Timer time, Credit credit) {
		this.map = map;
		this.time = time;
		this.credit = credit;
	}
	public Hospital(Map map,int height,int width,Timer time, int credit) {
		this.map = map;
		this.height = height;
		this.width = width;
		this.time = time;
		//Timer t = new Timer(hh, mm);
		
		//this.time = t;
		this.credit.setValue(credit);
	}
	public int UpdatePlayground(){
		int c = credit.getValue() - 100; 
		if(width<=56){
			width+=2;
		}
		if(height<=35){
			height+=2;
		}
		if(height>35 && width>56 ){
			return 0;
		}else{
			credit.setValue(c);
			return 1;
		}
		
		
	}
	
	public Cardiology getCardiology(){
		return cardiology;
	}
	public Reception getReception(){
		return reception;
	}
	public void add(Homme homme) {
		hommes.add(homme);
	}
	public void addDep(Cardiology dep){
		departements.add(dep);
	}
	public void addDep(GeneralMedcine dep){
		departements.add(dep);
	}
	public void addDep(Pediatrics dep){
		departements.add(dep);
	}
	public void addDep(Surgery dep){
		departements.add(dep);
	}
	public void addDep(Neurology dep){
		departements.add(dep);
	}
	public void addDep(Radiology dep) {
		departements.add(dep);
	}
	public void addDep(Emergency dep) {
		departements.add(dep);
	}
		/**
	 * @return the generalMedcine
	 */
	public GeneralMedcine getGeneralMedcine() {
		return generalMedcine;
	}
	/**
	 * @return the pediatrics
	 */
	public Pediatrics getPediatrics() {
		return pediatrics;
	}
	/**
	 * @return the surgery
	 */
	public Surgery getSurgery() {
		return surgery;
	}
	/**
	 * @return the neurology
	 */
	public Neurology getNeurology() {
		return neurology;
	}
	
	/**
	 * @param departements
	 */
	public void setDepartements(List<Department> departements) {
		this.departements = departements;
	}
	public void set(Emergency emergency) {
		this.setEmergency(emergency);
	}
	public void set(Radiology radiology) {
		this.setRadiology(radiology);
	}
	public void set(GeneralMedcine generalMedcine) {
		this.generalMedcine = generalMedcine;
	}
	public void set(Pediatrics pediatrics) {
		this.pediatrics = pediatrics;
	}
	public void set(Surgery surgery) {
		this.surgery = surgery;
	}
	public void set(Neurology neurology) {
		this.neurology = neurology;
	}
	public void set(Reception reception) {
		this.reception = reception;
	}
	public void set(Cardiology cardiology) {
		this.cardiology = cardiology;
	}
	
	public Credit getCredit() {
		return credit;
	}
	
	public void setCredit(Credit credit) {
		this.credit = credit;
	}
	public void setCredit(int value) {
		Credit credit = new Credit(value);
		this.credit = credit;
	}
	
	public Timer getTime() {
		return time;
	}

	public void setTime(Timer time) {
		this.time = time;
	}

	/**
	 * 
	 */
	public void generateHommes() {
		Block position =  new Block(39,28);
		Homme homme = new Homme(position);
		add(homme);

	}
	
	/**
	 * 
	 */
	public void nextRound() {
		int t =getTime().getMm().getValue();
		
		
		if (t%2 == 0 ){
			generateHommes();
		
	}
		
		moveHommes();
	}

	/**
	 * a method to move the patient (inspired by that of M.Lui)
	 * if the patient touch the Reception department it will disappear
	 */
	private void moveHommes() {
		List<Homme> outHomme = new ArrayList<Homme>();

		for (Homme homme : hommes) {
			Block position = homme.getPosition();
			Block elePosition = getReception().getPosition();

			 if (!map.istouch(position,elePosition)) {
				Block newPosition = map.getBlock(position.getLine() - 2, position.getColumn());
				homme.setPosition(newPosition);
			} else {
				outHomme.add(homme);
			}

		}

		for (Homme homme : outHomme) {
			hommes.remove(homme);
		}
	}
	public List<Homme> getHommes() {
		return hommes;
	}
	
	@Override
	public String toString() {
		return "hospitaldepartements=" + departements + ", credit=" + credit

				+ ", time=" + time + "]";
	}
	public void addDep(Department department) {
		departements.add(department);
	}
	
	public Radiology getRadiology() {
		return radiology;
	}
	public void setRadiology(Radiology radiology) {
		this.radiology = radiology;
	}
	public void setEmergency(Emergency emergency) {
		this.emergency = emergency;
	}
	public Emergency getEmergency(){
		return emergency;
	}
	
	
	
	
}
