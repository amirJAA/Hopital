package graphics;

import hospital.Audio;
import hospital.Equipment;
import hospital.Hospital;

import hospital.elements.Department;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



/**
 * This Class is an Dialog box with many JComboBox for adding equipment to the hospital 
 * by updating the Level of an specific department
 * Date : 26/02/2021
 * @author Jaafar.A
 *
 */
public class AddEquipments extends JDialog{
	private final static Dimension SizeDepartemntShop = new Dimension(430,300);
	private Font font = new Font(Font.MONOSPACED, Font.BOLD,17);
	private Hospital hospital;
	private Audio audio = new Audio();
	
	/**
	 * I have add this object because we need same method implemented on it
	 */
	private Equipment equipment = new Equipment(); 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public AddEquipments(JFrame topFrame, String string,Boolean b,Hospital hospital) {
		super(topFrame,string,b);
		this.hospital = hospital;
	}

	/**
	 * build the dialog box witch in we can select a department from a list
	 * select a level of the update 
	 * and call equipment.addEquipment(..) to update the selected department
	 */
	public void addequipments(){
		ArrayList<Department>departements = (ArrayList<Department>) hospital.getDepartements();
		AddEquipments instance=this;
		instance.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER,30	,30));
		instance.setPreferredSize(SizeDepartemntShop);
		
		JLabel label = new JLabel("Select a Department:");
		label.setFont(font);
		instance.add(label);
		

		List<String> choicesArray =new ArrayList<String>();
		choicesArray = equipment.chois(departements, hospital);

		String[] choices =  choicesArray.toArray(new String[0]);
		
		JComboBox<String> menuDepartement = new JComboBox<String>( choices);
		
		
		menuDepartement.setFont(font);
		instance.add(menuDepartement);
		
		
		
		JLabel labelUpdate = new JLabel("Update the department:");
		labelUpdate.setFont(font);
		instance.add(labelUpdate);
		String[] choices1 = { "Level 1", "Level 2", "Level 3" };
		JComboBox<String>menuLevel = new JComboBox<String>(choices1);
		menuDepartement.setFont(font);
		menuLevel.setFont(font);
		instance.add(menuLevel);
		

		JButton btnFinish = new JButton("Finish");
		btnFinish.setFont(font);
		btnFinish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				audio.getaCClic().play();
				String x = String.valueOf(menuDepartement.getSelectedItem());
				String y = String.valueOf(menuLevel.getSelectedItem());
				equipment.addEquipment(hospital, x, y, instance);
			}
		});
		instance.add(btnFinish);
		

		JButton btnCancel= new JButton("Cancel");
		btnCancel.setFont(font);
		instance.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				audio.getaCClic().play();
				instance.setVisible(false);
			}
		});
		pack();
		/**
		 * if we dont have departments yet a Warning JOptionPane will open
		 */
		if(choicesArray.isEmpty()){
			JOptionPane.showMessageDialog(instance,"you shoud have a depertement to add Equipments in","Warning", JOptionPane.WARNING_MESSAGE);
			instance.setVisible(false);
		}else{
			instance.setVisible(true);
		}
	}
}
