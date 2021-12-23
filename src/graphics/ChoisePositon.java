package graphics;

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
 * This is a Dialog box for choosing a line of a new department
 * @author Bouras.N
 *
 */
public class ChoisePositon extends JDialog {
	private Hospital hospital ;
	private final static Dimension SizeDepartemntShop = new Dimension(640,200);
	private Font font = new Font(Font.MONOSPACED, Font.BOLD,17);
	private Equipment equipment = new Equipment();
	private JComboBox<String> valideLine;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ChoisePositon(JFrame topFrame,String string,Boolean b,Hospital hospital) {
		super(topFrame,string,b);
		this.hospital = hospital;
	}

	/**
	 * Creation of the dialog box which contains an JComboBox with all of the free lines
	 * Where we can add our department 
	 * @param department the department
	 */
	public void choisepos(Department department){
		ChoisePositon instance=this;
		instance.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER,30	,30));
		instance.setPreferredSize(SizeDepartemntShop);
		ArrayList<Department>departements = (ArrayList<Department>) hospital.getDepartements();
		
		JLabel label = new JLabel("Select the line position of your department ");
		label.setFont(font);
		instance.add(label);
		
		
		List<String> choicesArrayLine =new ArrayList<String>();
		equipment.getValidPosLine(departements, hospital,department);
		choicesArrayLine = equipment.getChoicesArrayLine();
		String[] choices =  choicesArrayLine.toArray(new String[0]);						
		valideLine = new JComboBox<String>(choices);
		valideLine.setFont(font);
		valideLine.setName("Line");
		instance.add(valideLine);
		
		
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setFont(font);
		instance.add(btnFinish);
		btnFinish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				instance.setVisible(false);
				
			}
		});		
		
		pack();
		
		if(choicesArrayLine.isEmpty()){
			JOptionPane.showMessageDialog(instance,"You don't have space","Warning", JOptionPane.WARNING_MESSAGE);
			instance.setVisible(false);
		}else{
			instance.setVisible(true);
		}
	}
	/**
	 * @return the valideLine
	 */
	public JComboBox<String> getValideLine() {
		return valideLine;
	}


}
