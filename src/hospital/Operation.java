package hospital;

import graphics.MainFrame;
import hospital.elements.Cardiology;
import hospital.elements.Department;
import hospital.elements.Emergency;
import hospital.elements.GeneralMedcine;
import hospital.elements.Neurology;
import hospital.elements.Pediatrics;
import hospital.elements.Radiology;
import hospital.elements.Surgery;
import hospital.map.Block;
import hospital.map.Map;
import hospital.timer.Timer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import config.GameConfiguration;




/**
 *The Operation class. Its prepares all {@link Logout}
 * 
 * on this class we have some basic operations .
 *	
 * @author Ghezil.A
 *
 */
public class Operation {
	private String SEPARATOR = GameConfiguration.SEPARETOR;//#
	private Hospital hospital;
	private Map map;
	private Timer time;
	
	/**
	 * 
	 * @param hospital
	 * @param map
	 * @param time
	 */
	public Operation(Hospital hospital,Map map,Timer time){
		this.hospital =hospital;
		this.map = map;
		this.time = time;
	}
	 
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	/**
	 * @param fileName
	 */
	public void textSaveDepartement(String fileName) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			for (Department department  : hospital.getDepartements()) {
				writer.write(department.getName() + SEPARATOR + department.getLevel()+ SEPARATOR + department.getPosition()+SEPARATOR+department.getDrGrade()+SEPARATOR+department.getNtGrade());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	/**
	 * To save the hospital information such as the Height - Time - Credit ...
	 * @param fileName
	 */
	public void textSavenInformation(String fileName) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(""+hospital.getHeight()+SEPARATOR+hospital.getWidth()+SEPARATOR+hospital.getTime().getHh().toString()+SEPARATOR+hospital.getTime().getMm().toString()+SEPARATOR+hospital.getCredit().toString());
			writer.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	/**
	 * Method for Reading from a .csv file used on {@link MainFrame} to construct all department Already saved  
	 * @param fileName
	 */
	public void textReadDepartement(String fileName) {
		String line, fields[];
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			while ((line = reader.readLine()) != null) {
				
				fields = line.split(SEPARATOR);
				int l = Integer.parseInt(fields[2]);  
				int Colm= Integer.parseInt(fields[3]);  
				int level = Integer.parseInt(fields[1]);
				int drGrade= Integer.parseInt(fields[4]);
				int ntGrade = Integer.parseInt(fields[5]);
				switch (fields[0]) {
				case "neurology":
					Neurology neurology = new Neurology(new Block(l,Colm)) ;
					neurology.setPrise(GameConfiguration.DEP_PRICE_NEUROLOGY);
					neurology.setLevel(level);
					neurology.setNb_Patient(GameConfiguration.NUMBER_PATIENTS_NEUROLOGY);
					neurology.setDrGrade(drGrade);
					neurology.setNtGrade(ntGrade);
					neurology.setName("neurology");
					hospital.set(neurology);
					hospital.addDep(neurology);
					break;
				case "Cardiology":
					Cardiology cardiology = new Cardiology(new Block(l,Colm)) ;
					cardiology.setPrise(GameConfiguration.DEP_PRICE_CARDIOLOGY);
					cardiology.setLevel(level);
					cardiology.setNb_Patient(GameConfiguration.NUMBER_PATIENTS_CARDIOLOGY);
					cardiology.setDrGrade(drGrade);
					cardiology.setNtGrade(ntGrade);
					cardiology.setName("Cardiology");
					hospital.set(cardiology);
					hospital.addDep(cardiology);
					break;
				case "Emergency":
					Emergency emergency = new Emergency(new Block(l,Colm)) ;
					emergency.setPrise(GameConfiguration.DEP_PRICE_EMERGENCY);
					emergency.setLevel(level);
					emergency.setNb_Patient(GameConfiguration.NUMBER_PATIENTS_EMERGENCY);
					emergency.setDrGrade(drGrade);
					emergency.setNtGrade(ntGrade);
					emergency.setName("Emergency");
					hospital.set(emergency);
					hospital.addDep(emergency);
					break;
				case "GeneralMedcine":
					GeneralMedcine generalMedcine = new GeneralMedcine(new Block(l,Colm)) ;
					generalMedcine.setPrise(GameConfiguration.DEP_PRICE_GENERALMEDECINE);
					generalMedcine.setLevel(level);
					generalMedcine.setNb_Patient(GameConfiguration.NUMBER_PATIENTS_GENERALMEDECINE);
					generalMedcine.setDrGrade(drGrade);
					generalMedcine.setNtGrade(ntGrade);
					generalMedcine.setName("GeneralMedcine");
					hospital.set(generalMedcine);
					hospital.addDep(generalMedcine);
					break;
				case "Pediatrics":
					Pediatrics pediatrics = new Pediatrics(new Block(l,Colm)) ;
					pediatrics.setPrise(GameConfiguration.DEP_PRICE_PEDIATRICS);
					pediatrics.setLevel(level);
					pediatrics.setNb_Patient(GameConfiguration.NUMBER_PATIENTS_PEDIATRICS);
					pediatrics.setDrGrade(drGrade);
					pediatrics.setNtGrade(ntGrade);
					pediatrics.setName("Pediatrics");
					hospital.set(pediatrics);
					hospital.addDep(pediatrics);
					break;
				case "Radiology":
					Radiology radiology = new Radiology(new Block(l,Colm)) ;
					radiology.setPrise(GameConfiguration.DEP_PRICE_RADIOLOGY);
					radiology.setLevel(level);
					radiology.setNb_Patient(GameConfiguration.NUMBER_PATIENTS_RADIOLOGY);
					radiology.setDrGrade(drGrade);
					radiology.setNtGrade(ntGrade);
					radiology.setName("Radiology");
					hospital.set(radiology);
					hospital.addDep(radiology);
					break;
				case "Surgery":
					Surgery surgery = new Surgery(new Block(l,Colm)) ;
					surgery.setPrise(GameConfiguration.DEP_PRICE_SURGERY);
					surgery.setLevel(level);
					surgery.setNb_Patient(GameConfiguration.NUMBER_PATIENTS_SURGERY);
					surgery.setDrGrade(drGrade);
					surgery.setNtGrade(ntGrade);
					surgery.setName("Surgery");
					hospital.set(surgery);
					hospital.addDep(surgery);
					break;

				default:
					break;
				}
				//Department departement = new Department(fields[0], fields[1], fields[2]);
				//hospital.addDep(departement);
			}
			reader.close();
		//} catch (ContactAlreadyExistsException e) {
			//System.err.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	
	/**
	 * this method is for reading the hospital information Already saved on a .csv file 
	 * @param fileName
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public Hospital textReadInformation(String fileName) throws NumberFormatException, IOException {
		String line, fields[];
		
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			while ((line = reader.readLine()) != null) {
				
				fields = line.split(SEPARATOR);
				int height = Integer.parseInt(fields[0]);  
				int width= Integer.parseInt(fields[1]);  
				int hh = Integer.parseInt(fields[2]);
				int mm = Integer.parseInt(fields[3]);
				int credit = Integer.parseInt(fields[4]);
				time.setHh(hh);
				time.setMm(mm);
				
				hospital = Building.buildInitMobile(map,height,width,time,credit);
				
			}
			reader.close();
		//} catch (ContactAlreadyExistsException e) {
			//System.err.println(e.getMessage());
		
		return hospital;
	}

	
	
	
	
}
