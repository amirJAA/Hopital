package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import hospital.Audio;
import hospital.Hospital;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import config.GameConfiguration;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

/**
 * this is a Panel in the right of the frame witch have  few button how serve to :
 * -Adding new Department - Adding Equipment to a specific Department - Baying more play ground
 * -Add staff to a specific Department- Logout and save the session
 * @author Bouras.N
 * @author Jaafar.A
 *
 */
public class OperationZone extends JPanel {
	private Hospital hospital;
	private final static Dimension SizeOperationZone = new Dimension(GameConfiguration.OPERATIONZONE_WIDTH, GameConfiguration.OPERATIONZONE_HEIGHT);
	private Font font1 = new Font(Font.MONOSPACED, Font.BOLD,16);
	private Font font = new Font(Font.MONOSPACED, Font.BOLD,20);
	private Font font3 = new Font(Font.MONOSPACED, Font.BOLD,19);
	private MainFrame main;
	
	private Font font2 = new Font(Font.MONOSPACED, Font.BOLD,25);
	private	AddNewDepartemnt addNewDepartemnt;

	private Logout logout;
	private	AddStaff addStaff;
	private AddEquipments addEquipments;
	//private AudioClip aC = new AudioClip( new File("./src/config/clic.mp3").toURI().toString());
	private Audio audio = new Audio();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public OperationZone(Hospital hospital,MainFrame main){
		this.hospital=hospital;
		this.main = main;
	}
	
	public void operation(){
	
		OperationZone instance = this;
		
		instance.setPreferredSize(SizeOperationZone);
		instance.setBackground(Color.gray);
		instance.setLayout(new GridLayout(5,1) );
		instance.setBorder(BorderFactory.createLoweredBevelBorder());
		
		Button btnaddDepartments = new Button("Add Departments");
		btnaddDepartments.setFont(font1);
		instance.add(btnaddDepartments);
		
		btnaddDepartments.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				audio.getaCClic().play();
				addNewDepartemnt = new AddNewDepartemnt(main,"Add a new Department for your hospital",true, hospital);
				addNewDepartemnt.addDepartemnt(main,"Add a new Department for your hospital",true, hospital);
			}
		});
		
		Button btnaddStaff = new Button("Add Staff");
		btnaddStaff.setFont(font);
		instance.add(btnaddStaff);
		btnaddStaff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				audio.getaCClic().play();
				addStaff = new AddStaff(main,"Staffing Shop",true,hospital);
				addStaff.addstaff();
			}
		});
		
		
		
		Button btnaddEquipments= new Button("Add Equipments");
		btnaddEquipments.setFont(font3);
		instance.add(btnaddEquipments);
		btnaddEquipments.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				audio.getaCClic().play();				
				addEquipments = new AddEquipments(main,"Equipment Shop",true,hospital);
				addEquipments.addequipments();
			}
		});
		
		Button btnPlayground= new Button("Playground");
		btnPlayground.setFont(font);
		instance.add(btnPlayground);
		btnPlayground.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				audio.getaCClic().play();
				if (hospital.getCredit().getValue()-100>=0)
				{
					int rep = JOptionPane.showConfirmDialog(main, "Do you wount to enlarge your Hospital ?"
					+ "\n\n The operation cost 100$", "Playground", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					
					if(rep==JOptionPane.YES_OPTION){
						audio.getaCClic().play();
						int Up = hospital.UpdatePlayground();
						if(Up == 0){
							JOptionPane.showMessageDialog(main, "You Can not enlarge your hospital more", "Message Space",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}else{
					JOptionPane.showMessageDialog(main, "You Can not enlarge your hospital\n You dont have enough money", "Message Space",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		
		
		Button btnlogout = new Button("Logout");
		btnlogout.setFont(font2);
		instance.add(btnlogout);
		btnlogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				logout = new Logout(main,"Logout",true,hospital);
				audio.getaCClic().play();
				try {
					logout.logout();
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
	
	
}
