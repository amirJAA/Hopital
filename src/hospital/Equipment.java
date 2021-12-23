package hospital;

import java.util.ArrayList;
import java.util.List;


import hospital.elements.Credit;
import hospital.elements.Department;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import config.GameConfiguration;

public class Equipment {
	/**
	 * 
	 */
	private Audio audio = new Audio();
	/**
	 * 
	 */
	private List<String> choicesArrayLine =new ArrayList<String>();
	private List<String> choicesArrayColm=new ArrayList<String>();
	
	
	
	
	
	/**
	 * this method add the line valid position an a array to build our a new department on an free space
	 * we calculate it by keeping lines between ((40-height)/2) and (40+height)/2)-dep.getSizeLine()
	 * witch are the free spaces
	 * @param departements don't serve we can dalet it but we keep it in case of update 
	 * @param hospital 
	 * @param dep the department that we would 
	 */
	public void getValidPosLine(ArrayList<Department> departements,Hospital hospital,Department dep){
		int height = hospital.getHeight();
		ArrayList<Integer> posLine =  new ArrayList<Integer>();
		
		for (int i = ((40-height)/2); i < ((40+height)/2)-dep.getSizeLine(); i++) {
			posLine.add(i);
		}
		
		for (Integer i : posLine) {
			choicesArrayLine.add(""+i);
		}
		
		
		
	}
	/**
	 * this method add the column valid position an a array to build our a new department on an free space
	 * we calculate it by keeping lines between((60-width)/2) and ((60+width)/2)-dep.getSizeColm()
	 * removing all the column that  invalid with a simple algorithm 
	 * witch are the free spaces
	 * @param departements array of the dep in hospital to removing invalid spaces
	 * @param hospital
	 * @param dep
	 * @param line is the chosen value of the line 
	 */
	public void getValidPosColm(ArrayList<Department> departements,Hospital hospital,Department dep,int line){
		int width = hospital.getWidth();
		ArrayList<Integer> posColm =  new ArrayList<Integer>();
		
		
		for (int i = ((60-width)/2); i < ((60+width)/2)-dep.getSizeColm(); i++) {	
			posColm.add(i);
			choicesArrayColm.add(""+i);
			
		}
		for (Department department : departements) {
			
			int linedep = department.getPosition().getLine();
			int columndep = department.getPosition().getColumn();
			int columndepif=columndep-dep.getSizeColm();
			int columndepsup=columndep+dep.getSizeColm();
			int linedepif =  linedep-dep.getSizeLine();
			int linedepsup = linedep+dep.getSizeLine();
			for (int j = linedepif; j <= linedepsup; j++) {
				if(line==j){
					for (int j2 =columndepif; j2 <columndepsup; j2++) {
						if(posColm.contains(j2)){
							try{
								choicesArrayColm.remove(""+j2);
							}catch(Exception e){
								e.printStackTrace();
							}
						}
					}
					
				}
				
			}
			
			
			
			
			
		}
		
		
	
		
		
		
		
	}
	
	
	
	
	/**
	 * @param hospital
	 * @param x is the made of the department that we would update 
	 * @param y is the level of the update
	 * @param instance
	 */
	public void addEquipment(Hospital hospital ,String x , String y,JDialog instance){
		
		Credit credit = new Credit(hospital.getCredit().getValue());
		//-----------------------------------------------------------------------------------------------
		//-------------------------------------------NEUROLOGY----------------------------------------------------
		//-----------------------------------------------------------------------------------------------
		try{
			if(x==hospital.getNeurology().getName()){
				int level = hospital.getNeurology().getLevel();
				switch(y){
				case "Level 1":
					JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
					break;
				case "Level 2":
					if (level==1 ) {
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
								hospital.getNeurology().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_NEUROLOGY+5);
								hospital.getNeurology().setLevel(2);
								audio.getaCLevelUp().play();
							}
						}
					}else {
						JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
					}
					break;
				case "Level 3":
					if (level==1 ) {
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
								hospital.getNeurology().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_NEUROLOGY+10);
								hospital.getNeurology().setLevel(3);
								audio.getaCLevelUp().play();
							}
						}
					}
					else if (level==2 ) {
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
								hospital.getNeurology().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_NEUROLOGY+5);
								hospital.getNeurology().setLevel(3);
								audio.getaCLevelUp().play();
							}
						}
					} 
						else{
						JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
						
					}
					break;
				}
			}
		}catch(Exception e){
			
		}
		
//-----------------------------------------------------------------------------------------------
//-------------------------------CARDIOLOGY----------------------------------------------------------------
//-----------------------------------------------------------------------------------------------
		try{
			if(x==hospital.getCardiology().getName()){
				int level = hospital.getCardiology().getLevel();
				switch(y){
				case "Level 1":
					JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
					break;
				case "Level 2":
					if (level==1 ) {
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
								hospital.getCardiology().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_CARDIOLOGY+5);
								hospital.getCardiology().setLevel(2);
								audio.getaCLevelUp().play();
							}
						}
					}else {
						JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
					}
					break;
				case "Level 3":
					if (level==1 ) {
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
								hospital.getCardiology().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_CARDIOLOGY+10);
								hospital.getCardiology().setLevel(3);
								audio.getaCLevelUp().play();
							}
						}
					}
					else if (level==2 ) {
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
								hospital.getCardiology().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_CARDIOLOGY+5);
								hospital.getCardiology().setLevel(3);
								audio.getaCLevelUp().play();
							}
						}
					} 
						else{
						JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
						
					}
					break;
				}
			}
		}catch(Exception e){
			
		}

//------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------
//------------------------EMERGENCY---------------------------------------------------------
//------------------------------------------------------------------------------------------
				
		try{
			if(x==hospital.getEmergency().getName()){
				int level = hospital.getEmergency().getLevel();
				switch(y){
				case "Level 1":
					JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
					break;
				case "Level 2":
					if (level==1 ) {
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
								hospital.getEmergency().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_EMERGENCY+5);
								hospital.getEmergency().setLevel(2);
								audio.getaCLevelUp().play();
							}
						}
					}else {
						JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
					}
					break;
				case "Level 3":
					if (level==1 ) {
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
								hospital.getEmergency().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_EMERGENCY+10);
								hospital.getEmergency().setLevel(3);
								audio.getaCLevelUp().play();
							}
						}
					}
					else if (level==2 ) {
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
								hospital.getEmergency().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_EMERGENCY+5);
								hospital.getEmergency().setLevel(3);
								audio.getaCLevelUp().play();
							}
						}
					} 
						else{
						JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
						
					}
					break;
				}
			}
		}catch(Exception e){
			
		}


						//------------------------------------------------------------------------------------------
						//------------------------------------------------------------------------------------------
						//------------------------------------------------------------------------------------------
						//-----------------GENERALMEDECINE-------------------------------------------------------------------------
						//------------------------------------------------------------------------------------------
						//------------------------------------------------------------------------------------------
						//------------------------------------------------------------------------------------------
		try{
			if(x==hospital.getGeneralMedcine().getName()){
				int level = hospital.getGeneralMedcine().getLevel();
				switch(y){
				case "Level 1":
					JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
					break;
				case "Level 2":
					if (level==1 ) {
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
								hospital.getGeneralMedcine().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_GENERALMEDECINE+5);
								hospital.getGeneralMedcine().setLevel(2);
								audio.getaCLevelUp().play();
							}
						}
					}else {
						JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
					}
					break;
				case "Level 3":
					if (level==1 ) {
						if ((credit.getValue())-(GameConfiguration.UPDATE_PRICE_GENERALMEDECINE*2)<0) {
							JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_GENERALMEDECINE+"$","Money...!",JOptionPane.WARNING_MESSAGE);
						}else {
							int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
									+GameConfiguration.UPDATE_PRICE_GENERALMEDECINE+"$\n"
									+ "augmentation of patients per day : "
									+5+"\n"
									+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
							if (rep==JOptionPane.YES_OPTION){
								credit.dicCredit(GameConfiguration.UPDATE_PRICE_GENERALMEDECINE*2);
								hospital.setCredit(credit);
								hospital.getGeneralMedcine().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_GENERALMEDECINE+10);
								hospital.getGeneralMedcine().setLevel(3);
								audio.getaCLevelUp().play();
							}
						}
					}
					else if (level==2 ) {
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
								hospital.getGeneralMedcine().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_GENERALMEDECINE+5);
								hospital.getGeneralMedcine().setLevel(3);
								audio.getaCLevelUp().play();
							}
						}
					} 
						else{
						JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
						
					}
					break;
				}
			}
		}catch(Exception e){
			
		}
				//------------------------------------------------------------------------------------------
				//------------------------------------------------------------------------------------------
				//------------------------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				//----------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
							//--------------PEDIATRICS----------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
		try{
			if(x==hospital.getPediatrics().getName()){
				int level = hospital.getPediatrics().getLevel();
				switch(y){
				case "Level 1":
					JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
					break;
				case "Level 2":
					if (level==1 ) {
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
								hospital.getPediatrics().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_PEDIATRICS+5);
								hospital.getPediatrics().setLevel(2);
								audio.getaCLevelUp().play();
							}
						}
					}else {
						JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
					}
					break;
				case "Level 3":
					if (level==1 ) {
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
								hospital.getPediatrics().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_PEDIATRICS+10);
								hospital.getPediatrics().setLevel(3);
								audio.getaCLevelUp().play();
							}
						}
					}
					else if (level==2 ) {
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
								hospital.getPediatrics().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_PEDIATRICS+5);
								hospital.getPediatrics().setLevel(3);
								audio.getaCLevelUp().play();
							}
						}
					} 
						else{
						JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
						
					}
					break;
				}
			}
		}catch(Exception e){
			
		}

							//------------------------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
							//-------------------RADIOLOGY-----------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
		try{
			if(x==hospital.getRadiology().getName()){
				int level = hospital.getRadiology().getLevel();
				switch(y){
					case "Level 1":
						JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
						break;
					case "Level 2":
						if (level==1 ) {
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
									hospital.getRadiology().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_RADIOLOGY+5);
									hospital.getRadiology().setLevel(2);
									audio.getaCLevelUp().play();
								}
							}
						}else {
							JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
						}
						break;
					case "Level 3":
						if (level==1 ) {
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
									hospital.getRadiology().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_RADIOLOGY+10);
									hospital.getRadiology().setLevel(3);
									audio.getaCLevelUp().play();
								}
							}
						}
						else if (level==2 ) {
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
									hospital.getRadiology().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_RADIOLOGY+5);
									hospital.getRadiology().setLevel(3);
									audio.getaCLevelUp().play();
								}
							}
						} 
							else{
							JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
							
						}
						break;
					}
				}
		}catch(Exception e){
					
		}


							//------------------------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
							//--------------------SURGERY----------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
		try{
							if(x==hospital.getSurgery().getName()){
								int level = hospital.getSurgery().getLevel();
								switch(y){
								case "Level 1":
									JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
									break;
								case "Level 2":
									if (level==1 ) {
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
												hospital.getSurgery().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_SURGERY+5);
												hospital.getSurgery().setLevel(2);
												audio.getaCLevelUp().play();
											}
										}
									}else {
										JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
									}
									break;
								case "Level 3":
									if (level==1 ) {
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
												hospital.getSurgery().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_SURGERY+10);
												hospital.getSurgery().setLevel(3);
												audio.getaCLevelUp().play();
											}
										}
									}
									else if (level==2 ) {
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
												hospital.getSurgery().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_SURGERY+5);
												hospital.getSurgery().setLevel(3);
												audio.getaCLevelUp().play();
											}
										}
									} 
										else{
										JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
										
									}
									break;
								}
							}
		}catch(Exception e){
			
		}


							//------------------------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
							//------------------------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				//----------------------------------------------------------------------------
				
		
	}
	/**
	 * @return the choicesArrayLine
	 */
	public List<String> getChoicesArrayLine() {
		return choicesArrayLine;
	}

	/**
	 * @return the choicesArrayColm
	 */
	public List<String> getChoicesArrayColm() {
		return choicesArrayColm;
	}

	/**
	 * @param departements
	 * @param hospital
	 * @return
	 */
	public List<String> chois(ArrayList<Department> departements,Hospital hospital ){
		List<String> choicesArray =new ArrayList<String>();
		for (int i = 0; i < departements.size(); i++) {
			if(!(departements.get(i).getName()=="reception"))
				choicesArray.add(departements.get(i).getName());	
		}
		return choicesArray;
	}
	
}
