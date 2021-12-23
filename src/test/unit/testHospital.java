package test.unit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;

import hospital.Building;
import hospital.Equipment;
import hospital.Hospital;
import hospital.Operation;
import hospital.Staffing;
import hospital.elements.Department;
import hospital.elements.Neurology;
import hospital.elements.Reception;
import hospital.elements.Surgery;
import hospital.map.Map;
import hospital.timer.Timer;

import org.junit.Before;
import org.junit.Test;



/**
 * Unit test of Bulding a Hospital from a csv file
 * Each department and each Operation is verified
 * @author Ghezil.A
 *
 */
public class testHospital {
	private Hospital hospital;
	private Map map;
	private Timer time;
	
	@Before
	public void prepareTree() throws NumberFormatException, IOException {
		map = Building.buildMap();
		time = new Timer();
		Operation operation = new Operation(hospital,map,time);
		hospital = operation.textReadInformation("src/test/unit/DataInformation2.csv");
		operation.textReadDepartement("src/test/unit/DataDepartement2.csv");
	}

	@Test
	public void testUpdatePlayground(){
		hospital.UpdatePlayground();
		assertEquals(500, hospital.getCredit().getValue());
		assertEquals(27,hospital.getWidth());
		assertEquals(37, hospital.getHeight());
		
		
	}
	/**
	 * test building departement from a .csv file 
	 */
	@Test
	public void testBuildingDepartement(){
		List<Department> departements = hospital.getDepartements();
		int numberOfDepartements = departements.size();
		assertEquals(8, numberOfDepartements);
		
		assertTrue(departements.get(0) instanceof Reception);
		assertTrue(departements.get(1) instanceof Neurology);
		assertTrue(departements.get(7) instanceof Surgery);
	}
	/**
	 * For this test we need to confirm the operation manually 
	 * LevelNeurology : the level of Neurology department after adding equipments
	 */
	@Test
	public void AddingEquipment(){
		Equipment equipment = new Equipment();
		JDialog dialog = new JDialog();
		dialog.setVisible(false);
		equipment.addEquipment(hospital,"neurology","Level 3",dialog);
		equipment.addEquipment(hospital,"Surgery","Level 2",dialog);
		equipment.getValidPosColm((ArrayList<Department>)hospital.getDepartements(), hospital, hospital.getNeurology(), 17);
		List<String> ValidColm = (ArrayList<String>) equipment.getChoicesArrayColm();
		int NumberofvalidColm = ValidColm.size();
		assertEquals(25, NumberofvalidColm);
		int LevelNeurology = hospital.getNeurology().getLevel();
		int LevelSurgery =  hospital.getSurgery().getLevel();
		assertEquals(3,LevelNeurology);
		assertEquals(1,LevelSurgery);
		
	}
	@Test
	public void AddingStaff(){
		Staffing staffing = new Staffing();
		JDialog dialog = new JDialog();
		dialog.setVisible(false);
		staffing.addStaff(hospital, "neurology", "Doctor", "Grade 2", dialog);
		staffing.addStaff(hospital, "Radiology", "Doctor", "Grade 3", dialog);
		int GradeDrNeurology = hospital.getNeurology().getDrGrade();
		int GradeDrRadiology =  hospital.getRadiology().getDrGrade();
		assertEquals(2,GradeDrNeurology);
		assertEquals(3,GradeDrRadiology);
	}

}
