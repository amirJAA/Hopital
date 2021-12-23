package hospital;

import hospital.elements.Credit;
import hospital.elements.Department;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import config.GameConfiguration;

/**
 * this class is for staffing
 *  we have a specific behavior for each department
 *  it also has same process method 
 * @author Ghezil.A
 * @author Jaafar.A
 *
 */
public class Staffing {
	private Audio audio = new Audio();
	
	
	/**
	 * this method return an array of all the department of the hospital to choose an of them 
	 * @param departements
	 * @param hospital
	 * @return choicesArray
	 */
	public List<String> chois(ArrayList<Department> departements,Hospital hospital ){
		List<String> choicesArray =new ArrayList<String>();
		for (int i = 0; i < departements.size(); i++) {
			if(!(departements.get(i).getName()=="reception"))
				choicesArray.add(departements.get(i).getName());	
		}
		return choicesArray;
	}
	
	
	/**
	 * this method return nothing but it upgrade the staff of the chosen Parameter and decrement the credit   
	 * @param hospital this is the hospital
	 * @param x this is the chosen department
	 * @param y this is the chosen Type of staff
	 * @param z this is the chosen Staff
	 * @param instance
	 */
	public void addStaff(Hospital hospital ,String x , String y,String z,JDialog instance){
		
		Credit credit = new Credit(hospital.getCredit().getValue());
		/*-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		------------------------------------------------Neurology----------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		*/
		try{
				if(x==hospital.getNeurology().getName()){
					int nTGrade = hospital.getNeurology().getNtGrade();
					int dRGrade = hospital.getNeurology().getDrGrade();
					
					if(y=="Doctor"){
						switch(z){
						case "Grade 1":
							JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
							break;
						case "Grade 2":
							if (dRGrade==1 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_NEUROLOGY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this Staffing  : "+GameConfiguration.UPDATE_PRICE_NEUROLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected Staff is : "
											+GameConfiguration.UPDATE_PRICE_NEUROLOGY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_NEUROLOGY);
										hospital.setCredit(credit);
										int nb_p = hospital.getNeurology().getNb_Patient();
										hospital.getNeurology().setNb_Patient(nb_p+5);
										hospital.getNeurology().setDrGrade(2);
										audio.getaCLevelUp().play();
									}
								}
							}else {
								JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case "Grade 3":
							if (dRGrade==1 ) {
								if ((credit.getValue())-(GameConfiguration.UPDATE_PRICE_NEUROLOGY*2)<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_NEUROLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_NEUROLOGY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_NEUROLOGY*2);
										hospital.setCredit(credit);
										int nb_p = hospital.getNeurology().getNb_Patient();
										hospital.getNeurology().setNb_Patient(nb_p+10);
										hospital.getNeurology().setDrGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							}
							else if (dRGrade==2 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_NEUROLOGY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_NEUROLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_NEUROLOGY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_NEUROLOGY);
										hospital.setCredit(credit);
										int nb_p = hospital.getNeurology().getNb_Patient();
										hospital.getNeurology().setNb_Patient(nb_p+5);
										hospital.getNeurology().setDrGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							} 
								else{
								JOptionPane.showMessageDialog(instance,"you can not buy this Staff","Warning", JOptionPane.WARNING_MESSAGE);
								
							}
							break;
						}
						
					}else{
						switch(z){
						case "Grade 1":
							JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
							break;
						case "Grade 2":
							if (nTGrade==1 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_NEUROLOGY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this Staffing  : "+GameConfiguration.UPDATE_PRICE_NEUROLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected Staff is : "
											+GameConfiguration.UPDATE_PRICE_NEUROLOGY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_NEUROLOGY);
										hospital.setCredit(credit);
										int nb_p = hospital.getNeurology().getNb_Patient();
										hospital.getNeurology().setNb_Patient(nb_p+5);
										hospital.getNeurology().setNtGrade(2);
										audio.getaCLevelUp().play();
									}
								}
							}else {
								JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case "Grade 3":
							if (nTGrade==1 ) {
								if ((credit.getValue())-(GameConfiguration.UPDATE_PRICE_NEUROLOGY*2)<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_NEUROLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_NEUROLOGY+"$\n"
											+ "augmentation of patients per day : "
											+10+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_NEUROLOGY*2);
										hospital.setCredit(credit);
										int nb_p = hospital.getNeurology().getNb_Patient();
										hospital.getNeurology().setNb_Patient(nb_p+10);
										hospital.getNeurology().setNtGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							}
							else if (nTGrade==2 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_NEUROLOGY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_NEUROLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_NEUROLOGY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_NEUROLOGY);
										hospital.setCredit(credit);
										int nb_p = hospital.getNeurology().getNb_Patient();
										hospital.getNeurology().setNb_Patient(nb_p+5);
										hospital.getNeurology().setNtGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							} 
								else{
								JOptionPane.showMessageDialog(instance,"you can not buy this Staff","Warning", JOptionPane.WARNING_MESSAGE);
								
							}
							break;
						}
						
					}
				}
				}catch(Exception e ){
					
				}
				/*-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		----------------------------------------------Cardiology---------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		*/
		
		try{
				if(x==hospital.getCardiology().getName()){
					int nTGrade = hospital.getCardiology().getNtGrade();
					int dRGrade = hospital.getCardiology().getDrGrade();
					
					if(y=="Doctor"){
						switch(z){
						case "Grade 1":
							JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
							break;
						case "Grade 2":
							if (dRGrade==1 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_CARDIOLOGY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this Staffing  : "+GameConfiguration.UPDATE_PRICE_CARDIOLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected Staff is : "
											+GameConfiguration.UPDATE_PRICE_CARDIOLOGY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_CARDIOLOGY);
										hospital.setCredit(credit);
										int nb_p = hospital.getCardiology().getNb_Patient();
										hospital.getCardiology().setNb_Patient(nb_p+5);
										hospital.getCardiology().setDrGrade(2);
										audio.getaCLevelUp().play();
									}
								}
							}else {
								JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case "Grade 3":
							if (dRGrade==1 ) {
								if ((credit.getValue())-(GameConfiguration.UPDATE_PRICE_CARDIOLOGY*2)<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_CARDIOLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_CARDIOLOGY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_CARDIOLOGY*2);
										hospital.setCredit(credit);
										int nb_p = hospital.getCardiology().getNb_Patient();
										hospital.getCardiology().setNb_Patient(nb_p+10);
										hospital.getCardiology().setDrGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							}
							else if (dRGrade==2 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_CARDIOLOGY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_CARDIOLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_CARDIOLOGY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_CARDIOLOGY);
										hospital.setCredit(credit);
										int nb_p = hospital.getCardiology().getNb_Patient();
										hospital.getCardiology().setNb_Patient(nb_p+5);
										hospital.getCardiology().setDrGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							} 
								else{
								JOptionPane.showMessageDialog(instance,"you can not buy this Staff","Warning", JOptionPane.WARNING_MESSAGE);
								
							}
							break;
						}
						
					}else{
						switch(z){
						case "Grade 1":
							JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
							break;
						case "Grade 2":
							if (nTGrade==1 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_CARDIOLOGY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this Staffing  : "+GameConfiguration.UPDATE_PRICE_CARDIOLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected Staff is : "
											+GameConfiguration.UPDATE_PRICE_CARDIOLOGY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_CARDIOLOGY);
										hospital.setCredit(credit);
										int nb_p = hospital.getCardiology().getNb_Patient();
										hospital.getCardiology().setNb_Patient(nb_p+5);
										hospital.getCardiology().setNtGrade(2);
										audio.getaCLevelUp().play();
									}
								}
							}else {
								JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case "Grade 3":
							if (nTGrade==1 ) {
								if ((credit.getValue())-(GameConfiguration.UPDATE_PRICE_CARDIOLOGY*2)<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_CARDIOLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_CARDIOLOGY+"$\n"
											+ "augmentation of patients per day : "
											+10+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_CARDIOLOGY*2);
										hospital.setCredit(credit);
										int nb_p = hospital.getCardiology().getNb_Patient();
										hospital.getCardiology().setNb_Patient(nb_p+10);
										hospital.getCardiology().setNtGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							}
							else if (nTGrade==2 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_CARDIOLOGY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_CARDIOLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_CARDIOLOGY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_CARDIOLOGY);
										hospital.setCredit(credit);
										int nb_p = hospital.getCardiology().getNb_Patient();
										hospital.getCardiology().setNb_Patient(nb_p+5);
										hospital.getCardiology().setNtGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							} 
								else{
								JOptionPane.showMessageDialog(instance,"you can not buy this Staff","Warning", JOptionPane.WARNING_MESSAGE);
								
							}
							break;
						}
						
					}
				}
				}catch(Exception e ){
					
				}
				/*-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-----------------------------------------------Emergency--------------------------------------------------------------------
		-----------------------------------------------Emergency--------------------------------------------------------------------
		-----------------------------------------------Emergency--------------------------------------------------------------------
		-----------------------------------------------Emergency--------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		*/
		try{
				if(x==hospital.getEmergency().getName()){
					int nTGrade = hospital.getEmergency().getNtGrade();
					int dRGrade = hospital.getEmergency().getDrGrade();
					
					if(y=="Doctor"){
						switch(z){
						case "Grade 1":
							JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
							break;
						case "Grade 2":
							if (dRGrade==1 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_EMERGENCY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this Staffing  : "+GameConfiguration.UPDATE_PRICE_EMERGENCY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected Staff is : "
											+GameConfiguration.UPDATE_PRICE_EMERGENCY+"$\n"
											+ "augmentation of patients nubmer per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_EMERGENCY);
										hospital.setCredit(credit);
										int nb_p = hospital.getEmergency().getNb_Patient();
										hospital.getEmergency().setNb_Patient(nb_p+5);
										hospital.getEmergency().setDrGrade(2);
										audio.getaCLevelUp().play();
									}
								}
							}else {
								JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case "Grade 3":
							if (dRGrade==1 ) {
								if ((credit.getValue())-(GameConfiguration.UPDATE_PRICE_EMERGENCY*2)<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_EMERGENCY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_EMERGENCY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_EMERGENCY*2);
										hospital.setCredit(credit);
										int nb_p = hospital.getEmergency().getNb_Patient();
										hospital.getEmergency().setNb_Patient(nb_p+10);
										hospital.getEmergency().setDrGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							}
							else if (dRGrade==2 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_EMERGENCY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_EMERGENCY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_EMERGENCY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_EMERGENCY);
										hospital.setCredit(credit);
										int nb_p = hospital.getEmergency().getNb_Patient();
										hospital.getEmergency().setNb_Patient(nb_p+5);
										hospital.getEmergency().setDrGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							} 
								else{
								JOptionPane.showMessageDialog(instance,"you can not buy this Staff","Warning", JOptionPane.WARNING_MESSAGE);
								
							}
							break;
						}
						
					}else{
						switch(z){
						case "Grade 1":
							JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
							break;
						case "Grade 2":
							if (nTGrade==1 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_EMERGENCY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this Staffing  : "+GameConfiguration.UPDATE_PRICE_EMERGENCY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected Staff is : "
											+GameConfiguration.UPDATE_PRICE_EMERGENCY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_EMERGENCY);
										hospital.setCredit(credit);
										int nb_p = hospital.getEmergency().getNb_Patient();
										hospital.getEmergency().setNb_Patient(nb_p+5);
										hospital.getEmergency().setNtGrade(2);
										audio.getaCLevelUp().play();
									}
								}
							}else {
								JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case "Grade 3":
							if (nTGrade==1 ) {
								if ((credit.getValue())-(GameConfiguration.UPDATE_PRICE_EMERGENCY*2)<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_EMERGENCY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_EMERGENCY+"$\n"
											+ "augmentation of patients per day : "
											+10+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_EMERGENCY*2);
										hospital.setCredit(credit);
										int nb_p = hospital.getEmergency().getNb_Patient();
										hospital.getEmergency().setNb_Patient(nb_p+10);
										hospital.getEmergency().setNtGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							}
							else if (nTGrade==2 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_EMERGENCY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_EMERGENCY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_EMERGENCY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_EMERGENCY);
										hospital.setCredit(credit);
										int nb_p = hospital.getEmergency().getNb_Patient();
										hospital.getEmergency().setNb_Patient(nb_p+5);
										hospital.getEmergency().setNtGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							} 
								else{
								JOptionPane.showMessageDialog(instance,"you can not buy this Staff","Warning", JOptionPane.WARNING_MESSAGE);
								
							}
							break;
						}
						
					}
				}
				}catch(Exception e ){
					
				}
		/*-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-----------------------------------------GeneralMedcine--------------------------------------------------------------------------
		-----------------------------------------GeneralMedcine--------------------------------------------------------------------------
		-----------------------------------------GeneralMedcine--------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		*/
		try{
				if(x==hospital.getGeneralMedcine().getName()){
					int nTGrade = hospital.getGeneralMedcine().getNtGrade();
					int dRGrade = hospital.getGeneralMedcine().getDrGrade();
					
					if(y=="Doctor"){
						switch(z){
						case "Grade 1":
							JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
							break;
						case "Grade 2":
							if (dRGrade==1 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_GENERALMEDECINE<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this Staffing  : "+GameConfiguration.UPDATE_PRICE_GENERALMEDECINE+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected Staff is : "
											+GameConfiguration.UPDATE_PRICE_GENERALMEDECINE+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_GENERALMEDECINE);
										hospital.setCredit(credit);
										int nb_p = hospital.getGeneralMedcine().getNb_Patient();
										hospital.getGeneralMedcine().setNb_Patient(nb_p+5);
										hospital.getGeneralMedcine().setDrGrade(2);
										audio.getaCLevelUp().play();
									}
								}
							}else {
								JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case "Grade 3":
							if (dRGrade==1 ) {
								if ((credit.getValue())-(GameConfiguration.UPDATE_PRICE_GENERALMEDECINE*2)<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_GENERALMEDECINE+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_GENERALMEDECINE +"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_GENERALMEDECINE*2);
										hospital.setCredit(credit);
										int nb_p = hospital.getGeneralMedcine().getNb_Patient();
										hospital.getGeneralMedcine().setNb_Patient(nb_p+10);
										hospital.getGeneralMedcine().setDrGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							}
							else if (dRGrade==2 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_GENERALMEDECINE<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_GENERALMEDECINE+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_GENERALMEDECINE+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_GENERALMEDECINE);
										hospital.setCredit(credit);
										int nb_p = hospital.getGeneralMedcine().getNb_Patient();
										hospital.getGeneralMedcine().setNb_Patient(nb_p+5);
										hospital.getGeneralMedcine().setDrGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							} 
								else{
								JOptionPane.showMessageDialog(instance,"you can not buy this Staff","Warning", JOptionPane.WARNING_MESSAGE);
								
							}
							break;
						}
						
					}else{
						switch(z){
						case "Grade 1":
							JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
							break;
						case "Grade 2":
							if (nTGrade==1 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_GENERALMEDECINE<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this Staffing  : "+GameConfiguration.UPDATE_PRICE_GENERALMEDECINE+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected Staff is : "
											+GameConfiguration.UPDATE_PRICE_GENERALMEDECINE+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_GENERALMEDECINE);
										hospital.setCredit(credit);
										int nb_p = hospital.getGeneralMedcine().getNb_Patient();
										hospital.getGeneralMedcine().setNb_Patient(nb_p+5);
										hospital.getGeneralMedcine().setNtGrade(2);
										audio.getaCLevelUp().play();
									}
								}
							}else {
								JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case "Grade 3":
							if (nTGrade==1 ) {
								if ((credit.getValue())-(GameConfiguration.UPDATE_PRICE_GENERALMEDECINE*2)<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_GENERALMEDECINE+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_GENERALMEDECINE+"$\n"
											+ "augmentation of patients per day : "
											+10+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_GENERALMEDECINE*2);
										hospital.setCredit(credit);
										int nb_p = hospital.getGeneralMedcine().getNb_Patient();
										hospital.getGeneralMedcine().setNb_Patient(nb_p+10);
										hospital.getGeneralMedcine().setNtGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							}
							else if (nTGrade==2 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_GENERALMEDECINE<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_GENERALMEDECINE+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_GENERALMEDECINE+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_GENERALMEDECINE);
										hospital.setCredit(credit);
										int nb_p = hospital.getGeneralMedcine().getNb_Patient();
										hospital.getGeneralMedcine().setNb_Patient(nb_p+5);
										hospital.getGeneralMedcine().setNtGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							} 
								else{
								JOptionPane.showMessageDialog(instance,"you can not buy this Staff","Warning", JOptionPane.WARNING_MESSAGE);
								
							}
							break;
						}
						
					}
				}
				}catch(Exception e ){
					
				}
				/*-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		----------------------------------------Pediatrics---------------------------------------------------------------------------
		----------------------------------------Pediatrics---------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		*/
		try{
				if(x==hospital.getPediatrics().getName()){
					int nTGrade = hospital.getPediatrics().getNtGrade();
					int dRGrade = hospital.getPediatrics().getDrGrade();
					
					if(y=="Doctor"){
						switch(z){
						case "Grade 1":
							JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
							break;
						case "Grade 2":
							if (dRGrade==1 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_PEDIATRICS<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this Staffing  : "+GameConfiguration.UPDATE_PRICE_PEDIATRICS+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected Staff is : "
											+GameConfiguration.UPDATE_PRICE_PEDIATRICS+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_PEDIATRICS);
										hospital.setCredit(credit);
										int nb_p = hospital.getPediatrics().getNb_Patient();
										hospital.getPediatrics().setNb_Patient(nb_p+5);
										hospital.getPediatrics().setDrGrade(2);
										audio.getaCLevelUp().play();
									}
								}
							}else {
								JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case "Grade 3":
							if (dRGrade==1 ) {
								if ((credit.getValue())-(GameConfiguration.UPDATE_PRICE_PEDIATRICS*2)<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_PEDIATRICS+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_PEDIATRICS+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_PEDIATRICS*2);
										hospital.setCredit(credit);
										int nb_p = hospital.getPediatrics().getNb_Patient();
										hospital.getPediatrics().setNb_Patient(nb_p+10);
										hospital.getPediatrics().setDrGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							}
							else if (dRGrade==2 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_PEDIATRICS<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_PEDIATRICS+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_PEDIATRICS+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_PEDIATRICS);
										hospital.setCredit(credit);
										int nb_p = hospital.getPediatrics().getNb_Patient();
										hospital.getPediatrics().setNb_Patient(nb_p+5);
										hospital.getPediatrics().setDrGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							} 
								else{
								JOptionPane.showMessageDialog(instance,"you can not buy this Staff","Warning", JOptionPane.WARNING_MESSAGE);
								
							}
							break;
						}
						
					}else{
						switch(z){
						case "Grade 1":
							JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
							break;
						case "Grade 2":
							if (nTGrade==1 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_PEDIATRICS<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this Staffing  : "+GameConfiguration.UPDATE_PRICE_PEDIATRICS+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected Staff is : "
											+GameConfiguration.UPDATE_PRICE_PEDIATRICS+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_PEDIATRICS);
										hospital.setCredit(credit);
										int nb_p = hospital.getPediatrics().getNb_Patient();
										hospital.getPediatrics().setNb_Patient(nb_p+5);
										hospital.getPediatrics().setNtGrade(2);
										audio.getaCLevelUp().play();
									}
								}
							}else {
								JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case "Grade 3":
							if (nTGrade==1 ) {
								if ((credit.getValue())-(GameConfiguration.UPDATE_PRICE_PEDIATRICS*2)<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_PEDIATRICS+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_PEDIATRICS+"$\n"
											+ "augmentation of patients per day : "
											+10+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_PEDIATRICS*2);
										hospital.setCredit(credit);
										int nb_p = hospital.getPediatrics().getNb_Patient();
										hospital.getPediatrics().setNb_Patient(nb_p+10);
										hospital.getPediatrics().setNtGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							}
							else if (nTGrade==2 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_PEDIATRICS<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_PEDIATRICS+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_PEDIATRICS+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_PEDIATRICS);
										hospital.setCredit(credit);
										int nb_p = hospital.getPediatrics().getNb_Patient();
										hospital.getPediatrics().setNb_Patient(nb_p+5);
										hospital.getPediatrics().setNtGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							} 
								else{
								JOptionPane.showMessageDialog(instance,"you can not buy this Staff","Warning", JOptionPane.WARNING_MESSAGE);
								
							}
							break;
						}
						
					}
				}
				}catch(Exception e ){
					
				}
				/*-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-----------------------------------------Radiology--------------------------------------------------------------------------
		-----------------------------------------Radiology--------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		*/
		try{
				if(x==hospital.getRadiology().getName()){
					int nTGrade = hospital.getRadiology().getNtGrade();
					int dRGrade = hospital.getRadiology().getDrGrade();
					
					if(y=="Doctor"){
						switch(z){
						case "Grade 1":
							JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
							break;
						case "Grade 2":
							if (dRGrade==1 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_RADIOLOGY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this Staffing  : "+GameConfiguration.UPDATE_PRICE_RADIOLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected Staff is : "
											+GameConfiguration.UPDATE_PRICE_RADIOLOGY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_RADIOLOGY);
										hospital.setCredit(credit);
										int nb_p = hospital.getRadiology().getNb_Patient();
										hospital.getRadiology().setNb_Patient(nb_p+5);
										hospital.getRadiology().setDrGrade(2);
										audio.getaCLevelUp().play();
									}
								}
							}else {
								JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case "Grade 3":
							if (dRGrade==1 ) {
								if ((credit.getValue())-(GameConfiguration.UPDATE_PRICE_RADIOLOGY*2)<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_RADIOLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_RADIOLOGY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_RADIOLOGY*2);
										hospital.setCredit(credit);
										int nb_p = hospital.getRadiology().getNb_Patient();
										hospital.getRadiology().setNb_Patient(nb_p+10);
										hospital.getRadiology().setDrGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							}
							else if (dRGrade==2 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_RADIOLOGY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_RADIOLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_RADIOLOGY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_RADIOLOGY);
										hospital.setCredit(credit);
										int nb_p = hospital.getRadiology().getNb_Patient();
										hospital.getRadiology().setNb_Patient(nb_p+5);
										hospital.getRadiology().setDrGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							} 
								else{
								JOptionPane.showMessageDialog(instance,"you can not buy this Staff","Warning", JOptionPane.WARNING_MESSAGE);
								
							}
							break;
						}
						
					}else{
						switch(z){
						case "Grade 1":
							JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
							break;
						case "Grade 2":
							if (nTGrade==1 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_RADIOLOGY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this Staffing  : "+GameConfiguration.UPDATE_PRICE_RADIOLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected Staff is : "
											+GameConfiguration.UPDATE_PRICE_RADIOLOGY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_RADIOLOGY);
										hospital.setCredit(credit);
										int nb_p = hospital.getRadiology().getNb_Patient();
										hospital.getRadiology().setNb_Patient(nb_p+5);
										hospital.getRadiology().setNtGrade(2);
										audio.getaCLevelUp().play();
									}
								}
							}else {
								JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case "Grade 3":
							if (nTGrade==1 ) {
								if ((credit.getValue())-(GameConfiguration.UPDATE_PRICE_RADIOLOGY*2)<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_RADIOLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_RADIOLOGY+"$\n"
											+ "augmentation of patients per day : "
											+10+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_RADIOLOGY*2);
										hospital.setCredit(credit);
										int nb_p = hospital.getRadiology().getNb_Patient();
										hospital.getRadiology().setNb_Patient(nb_p+10);
										hospital.getRadiology().setNtGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							}
							else if (nTGrade==2 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_RADIOLOGY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_RADIOLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_RADIOLOGY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_RADIOLOGY);
										hospital.setCredit(credit);
										int nb_p = hospital.getRadiology().getNb_Patient();
										hospital.getRadiology().setNb_Patient(nb_p+5);
										hospital.getRadiology().setNtGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							} 
								else{
								JOptionPane.showMessageDialog(instance,"you can not buy this Staff","Warning", JOptionPane.WARNING_MESSAGE);
								
							}
							break;
						}
						
					}
				}
				}catch(Exception e ){
					
				}
				/*-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		---------------------------------------Surgery----------------------------------------------------------------------------
		---------------------------------------Surgery----------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		-------------------------------------------------------------------------------------------------------------------
		*/
		try{
				if(x==hospital.getSurgery().getName()){
					int nTGrade = hospital.getSurgery().getNtGrade();
					int dRGrade = hospital.getSurgery().getDrGrade();
					
					if(y=="Doctor"){
						switch(z){
						case "Grade 1":
							JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
							break;
						case "Grade 2":
							if (dRGrade==1 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_SURGERY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this Staffing  : "+GameConfiguration.UPDATE_PRICE_SURGERY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected Staff is : "
											+GameConfiguration.UPDATE_PRICE_SURGERY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_SURGERY);
										hospital.setCredit(credit);
										int nb_p = hospital.getSurgery().getNb_Patient();
										hospital.getSurgery().setNb_Patient(nb_p+5);
										hospital.getSurgery().setDrGrade(2);
										audio.getaCLevelUp().play();
									}
								}
							}else {
								JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case "Grade 3":
							if (dRGrade==1 ) {
								if ((credit.getValue())-(GameConfiguration.UPDATE_PRICE_SURGERY*2)<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_SURGERY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_SURGERY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_SURGERY*2);
										hospital.setCredit(credit);
										int nb_p = hospital.getSurgery().getNb_Patient();
										hospital.getSurgery().setNb_Patient(nb_p+10);
										hospital.getSurgery().setDrGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							}
							else if (dRGrade==2 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_SURGERY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_SURGERY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_SURGERY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_SURGERY);
										hospital.setCredit(credit);
										int nb_p = hospital.getSurgery().getNb_Patient();
										hospital.getSurgery().setNb_Patient(nb_p+5);
										hospital.getSurgery().setDrGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							} 
								else{
								JOptionPane.showMessageDialog(instance,"you can not buy this Staff","Warning", JOptionPane.WARNING_MESSAGE);
								
							}
							break;
						}
						
					}else{
						switch(z){
						case "Grade 1":
							JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
							break;
						case "Grade 2":
							if (nTGrade==1 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_SURGERY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this Staffing  : "+GameConfiguration.UPDATE_PRICE_SURGERY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected Staff is : "
											+GameConfiguration.UPDATE_PRICE_SURGERY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_SURGERY);
										hospital.setCredit(credit);
										int nb_p = hospital.getSurgery().getNb_Patient();
										hospital.getSurgery().setNb_Patient(nb_p+5);
										hospital.getSurgery().setNtGrade(2);
										audio.getaCLevelUp().play();
									}
								}
							}else {
								JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case "Grade 3":
							if (nTGrade==1 ) {
								if ((credit.getValue())-(GameConfiguration.UPDATE_PRICE_SURGERY*2)<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_SURGERY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_SURGERY+"$\n"
											+ "augmentation of patients per day : "
											+10+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_SURGERY*2);
										hospital.setCredit(credit);
										int nb_p = hospital.getSurgery().getNb_Patient();
										hospital.getSurgery().setNb_Patient(nb_p+10);
										hospital.getSurgery().setNtGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							}
							else if (nTGrade==2 ) {
								if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_SURGERY<0) {
									JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_SURGERY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
								}else {
									int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
											+GameConfiguration.UPDATE_PRICE_SURGERY+"$\n"
											+ "augmentation of patients per day : "
											+5+"\n"
											+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
									if (rep==JOptionPane.YES_OPTION){
										credit.dicCredit(GameConfiguration.UPDATE_PRICE_SURGERY);
										hospital.setCredit(credit);
										int nb_p = hospital.getSurgery().getNb_Patient();
										hospital.getSurgery().setNb_Patient(nb_p+5);
										hospital.getSurgery().setNtGrade(3);
										audio.getaCLevelUp().play();
									}
								}
							} 
								else{
								JOptionPane.showMessageDialog(instance,"you can not buy this Staff","Warning", JOptionPane.WARNING_MESSAGE);
								
							}
							break;
						}
						
					}
				}
				}catch(Exception e ){
					
				}
		
		//----------------------------------------------------------------------------/
		//----------------------------------------------------------------------------
		//----------------------------------------------------------------------------
		
	}
}
