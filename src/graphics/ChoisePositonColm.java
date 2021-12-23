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

/**
 * This is a Dialog box for choosing a line of a new department
 * @author Bouras.N
 *
 */
public class ChoisePositonColm extends JDialog {
	private Hospital hospital ;
	private AddNewDepartemnt addNewDepartemnt;
	private final static Dimension SizeDepartemntShop = new Dimension(640,200);
	private Audio audio = new Audio();
	private Font font = new Font(Font.MONOSPACED, Font.BOLD,17);
	private Equipment equipment = new Equipment();
	private JComboBox<String>  valideColm; 
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ChoisePositonColm(JFrame topFrame,String string,Boolean b,Hospital hospital,AddNewDepartemnt addNewDepartemnt) {
		super(topFrame,string,b);
		this.hospital = hospital;
		this.addNewDepartemnt=addNewDepartemnt;
	}
	/**
	 * Creation of the dialog box which contains an JComboBox with all of the free column
	 * on the chosen line
	 * Where we can add our department 
	 * it throw NoMoreSpaceException if there is no space to add our department in
	 * @param department the department
	 */
	public void choisepos(Department department)throws NoMoreSpaceException{
		ChoisePositonColm instance=this;
		instance.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER,30	,30));
		instance.setPreferredSize(SizeDepartemntShop);
		ArrayList<Department>departements = (ArrayList<Department>) hospital.getDepartements();
		
		JLabel label = new JLabel("Select the column position of your department");
		label.setFont(font);
		instance.add(label);
		
		List<String> choicesArrayColm =new ArrayList<String>();
		String x = addNewDepartemnt.getXi();
		int line= Integer.parseInt(x);
		equipment.getValidPosColm(departements, hospital,department,line);
		choicesArrayColm = equipment.getChoicesArrayColm();
		String[] choicesColm = choicesArrayColm.toArray(new String[0]);						
		valideColm= new JComboBox<String>(choicesColm);
		valideColm.setFont(font);
		valideColm.setName("Column");
		instance.add(valideColm);

		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setFont(font);
		instance.add(btnFinish);
		btnFinish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				audio.getaCLevelUp().play();
				instance.setVisible(false);
				
			}
		});		
		
		pack();
		
		if(choicesArrayColm.isEmpty()) {
			throw new NoMoreSpaceException(department);
		}else{
			instance.setVisible(true);
		}
	}
	
	/**
	 * @return the valideColm
	 */
	public JComboBox<String> getValideColm() {
		return valideColm;
	}
	

}
