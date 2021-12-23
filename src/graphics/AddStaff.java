package graphics;

import hospital.Audio;
import hospital.Hospital;
import hospital.Staffing;
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
 * a Dialog box how help as to add staff witch has the same Structure as {@link AddNewDepartemnt}
 * @author Bouras.N
 *
 */
public class AddStaff extends JDialog{
	private Hospital hospital ;
	private final static Dimension SizeDepartemntShop = new Dimension(305,500);
	private Font font = new Font(Font.MONOSPACED, Font.BOLD,17);
	private Audio audio = new Audio();
	private Staffing staffing = new Staffing();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public AddStaff(JFrame topFrame,String string,Boolean b,Hospital hospital) {
		super(topFrame,string,b);
		this.hospital = hospital;
	}

	public void addstaff(){
		AddStaff instance=this;
		instance.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER,30	,30));
		instance.setPreferredSize(SizeDepartemntShop);
		ArrayList<Department>departements = (ArrayList<Department>) hospital.getDepartements();
		
		JLabel label = new JLabel("Select a Department:");
		label.setFont(font);
		instance.add(label);
		

		List<String> choicesArray =new ArrayList<String>();
		choicesArray = staffing.chois(departements, hospital);

		String[] choices =  choicesArray.toArray(new String[0]);		
		JComboBox<String> menuDepartement = new JComboBox<String>( choices);
		
		menuDepartement.setFont(font);
		instance.add(menuDepartement);
		
		
		
		JLabel labelStaffType = new JLabel("Select a type of Staff:");
		labelStaffType.setFont(font);
		instance.add(labelStaffType);
		
		String[] choices1 = { "Doctor", "Nursing Team" };
		JComboBox<String>menuTypeStaff = new JComboBox<String>(choices1);
		
		menuDepartement.setFont(font);
		menuTypeStaff.setFont(font);
		instance.add(menuTypeStaff);
		
		
		
		
		JLabel labelStaff = new JLabel("Available staff to recruit :");
		labelStaff.setFont(font);
		instance.add(labelStaff);
		String[] choices2 = { "Grade 1", "Grade 2", "Grade 3" };
		
		JComboBox<String>menuStaff = new JComboBox<String>(choices2);
		menuStaff.setFont(font);
		instance.add(menuStaff);
		
		
		JLabel l = new JLabel("    ");
		
		instance.add(l);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setFont(font);
		instance.add(btnFinish);
		btnFinish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				audio.getaCClic().play();
				String x = String.valueOf(menuDepartement.getSelectedItem());
				String y = String.valueOf(menuTypeStaff.getSelectedItem());
				String z = String.valueOf(menuStaff.getSelectedItem());
				
				staffing.addStaff(hospital, x, y,z, instance);
			}
		});
		
		

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
		
		if(choicesArray.isEmpty()){
			JOptionPane.showMessageDialog(instance,"you shoud have a depertement to add staff in","Warning", JOptionPane.WARNING_MESSAGE);
			instance.setVisible(false);
		}else{
			instance.setVisible(true);
		}
	}

}
