package graphics;

import java.io.FileNotFoundException;
import hospital.Hospital;
import hospital.map.Map;
import hospital.timer.Timer;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hospital.*;

/**
 * dialog box for saving our session
 * @author Jaafar.A
 * @author Bouras.N
 *
 */
public class Logout extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Hospital hospital; 
	private Map map;
	private Timer time  ;
	
	public Logout(JFrame topFrame, String string,Boolean b,Hospital hospital) {
		super(topFrame,string,b);
		this.hospital=hospital;
	}
	public void logout() throws FileNotFoundException {
		Logout instance=this;
		Operation operation = new Operation(hospital,map,time);
		int rep = JOptionPane.showConfirmDialog(instance, "Do you want to exit the game ?\n Your session well be saved \n", "Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (rep==JOptionPane.YES_OPTION){
			operation.textSaveDepartement("DataDepartement.csv");
			operation.textSavenInformation("DataInformation.csv");
			System.exit(0) ;
		}
		
	}
	

}
