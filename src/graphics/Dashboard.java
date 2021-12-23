package graphics;

import java.awt.Dimension;
import java.awt.Graphics;







import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import graphics.chart.ChartManager;
import hospital.Audio;
import hospital.Building;
import hospital.Hospital;
import hospital.Operation;
import hospital.elements.Cardiology;
import hospital.elements.Department;
import hospital.elements.Emergency;
import hospital.elements.GeneralMedcine;
import hospital.elements.Homme;
import hospital.elements.Money;
import hospital.elements.Neurology;
import hospital.elements.Pediatrics;
import hospital.elements.Radiology;
import hospital.elements.Reception;
import hospital.elements.Surgery;
import hospital.map.Map;
import hospital.timer.Timer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;

import config.GameConfiguration;



/**
 * This class is the JPanel where we draw all our department 
 * this is the playground our our game
 * @author Ghezil.A
 *
 */
public class Dashboard extends JPanel {

	private static final long serialVersionUID = 1L;
	private Map map;
	private Hospital hospital;
	private ImageIcon icon = new ImageIcon("./src/config/images/graphique.jpg"); 
	/**
	 * this is a object of the money class witch have the same structure as CREDIT 
	 * just for drawing Coins of Money when we win some
	 */
	private Money money;
	
	/**
	 * to generate an audio clip when we win some money
	 */
	private Audio audio = new Audio();
	
	private Element element = new Element();
	
	public Dashboard(Map map,Hospital hospital){
		this.map=map;
		this.hospital=hospital;
		Dashboard dashboard = this;
		Button btnInfo = new Button("INFO");
		Dimension d1 = new Dimension(10,20);
		btnInfo.setSize(d1);
		btnInfo.setLocation(100, 100);
		btnInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String lesTextes[]={ "Department and there level", "Information Doctors Grade"}; 
				int retour = JOptionPane.showOptionDialog(dashboard, "Welcom in Your Graphical Information\n"
						+ "Information About", "Session",  JOptionPane.DEFAULT_OPTION,  JOptionPane.CLOSED_OPTION, 
						 icon,
						lesTextes,lesTextes[0]);
				if( retour!=JOptionPane.CLOSED_OPTION){
							if( retour == 0){
								audio.getaCClic().play();
								ChartManager chartManager = new ChartManager(hospital); 
								JFreeChart chart = chartManager.getTypeLevelDep();
								ChartFrame frame = new ChartFrame("INFORMATION LEVEL DEPARTMENT ", chart);
								frame.pack();
								frame.setVisible(true);
							}else if(retour==1){
								audio.getaCClic().play();
								ChartManager chartManager = new ChartManager(hospital); 
								JFreeChart chart = chartManager.getTypeCountBar(hospital);
								ChartFrame frame = new ChartFrame("INFORMATION GRADE OF DOCTORS ", chart);
								frame.pack();
								frame.setVisible(true);
							}
					}
			}
		});
		this.add(btnInfo);
	}
		
	
	/* (non-Javadoc)
	 * here we paint our department in the playground 
	 * if the department(index) is equals to on of the departments then draw it
	 * and if time is equal to what ever we have chose that is moments for take the recipe
	 * we take it and draw a image for a coin of money
	 * 
	 * we draw patients(Homme) to if we have more than 1 department
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Neurology neurology = hospital.getNeurology();
		GeneralMedcine generalMedcine= hospital.getGeneralMedcine();
		Pediatrics pediatrics = hospital.getPediatrics();

		Cardiology cardiology = hospital.getCardiology();
		Emergency emergency= hospital.getEmergency();
		Radiology radiology = hospital.getRadiology();
		Surgery surgery = hospital.getSurgery();

		Reception reception = hospital.getReception();
		Timer timer = hospital.getTime();
		ArrayList<Department>departements = (ArrayList<Department>) hospital.getDepartements();
		List<Homme>hommes = hospital.getHommes();		
		if(InformationZone.mapEvent == 1){
			element.paint(map, g,hospital);
		}
		
		if ( departements.size()>1) {
			try{
				for (Homme homme : hommes) {
					element.paint(homme, g,timer);
				}
			}catch(ConcurrentModificationException e){
				
			}
		}
		
		
			

		
		
		for (int i = 0; i < departements.size(); i++) {
			//--------------------------------------------------------------------------------
			//------------------------------------pediatrics--------------------------------------------
			
			if(departements.get(i).equals(pediatrics)){
				element.paint(pediatrics, g);
				if(hospital.getTime().getMm().getValue()==00){
					money = new Money(departements.get(i).getPosition());
					element.paint(money, g);
					audio.getaCArgent().play();	
					hospital.setCredit(hospital.getCredit().getValue()+GameConfiguration.CONSULTATION_PRICE_PEDIATRICS*hospital.getPediatrics().getNb_Patient());
				}
			}
			//--------------------------------------------------------------------------------
			//------------------------------------neurology--------------------------------------------
			if(departements.get(i).equals(neurology)){
				element.paint(neurology, g);
				if(hospital.getTime().getMm().getValue()==10){
					money = new Money(departements.get(i).getPosition());
					element.paint(money, g);
					audio.getaCArgent().play();
					hospital.setCredit(hospital.getCredit().getValue()+GameConfiguration.CONSULTATION_PRICE_NEUROLOGY*hospital.getNeurology().getNb_Patient());
				}
				
			}
			//--------------------------------------------------------------------------------
			//---------------------------------------generalMedcine-----------------------------------------
			if(departements.get(i).equals(generalMedcine)){
				element.paint(generalMedcine, g);
				if( hospital.getTime().getMm().getValue()==20){
					money = new Money(departements.get(i).getPosition());
					element.paint(money, g);
					audio.getaCArgent().play();	
					hospital.setCredit(hospital.getCredit().getValue()+GameConfiguration.CONSULTATION_PRICE_GENERALMEDECINE*hospital.getGeneralMedcine().getNb_Patient());
			}
			}
			//--------------------------------------------------------------------------------
			//-----------------------------------------cardiology---------------------------------------
			if(departements.get(i).equals(cardiology)){
				element.paint(cardiology, g);
				if(hospital.getTime().getMm().getValue()==30){
					money = new Money(departements.get(i).getPosition());
					element.paint(money, g);
					audio.getaCArgent().play();	
					hospital.setCredit(hospital.getCredit().getValue()+GameConfiguration.CONSULTATION_PRICE_CARDIOLOGY*hospital.getCardiology().getNb_Patient());
			}
			}
			//--------------------------------------------------------------------------------
			//------------------------------------------emergency--------------------------------------
			if(departements.get(i).equals(emergency)){
				
				element.paint(emergency, g);
				if( hospital.getTime().getMm().getValue()==35){
					money = new Money(departements.get(i).getPosition());
					element.paint(money, g);
					audio.getaCArgent().play();	
					
					hospital.setCredit(hospital.getCredit().getValue()+GameConfiguration.CONSULTATION_PRICE_EMERGENCY*hospital.getEmergency().getNb_Patient());
			}
			}
			//--------------------------------------------------------------------------------
			//---------------------------------------radiology----------------------------------------
			if(departements.get(i).equals(radiology)){
				element.paint(radiology, g);
				if( hospital.getTime().getMm().getValue()==40){
					money = new Money(departements.get(i).getPosition());
					element.paint(money, g);
					audio.getaCArgent().play();	
					hospital.setCredit(hospital.getCredit().getValue()+GameConfiguration.CONSULTATION_PRICE_RADIOLOGY*hospital.getRadiology().getNb_Patient());
				}
			}
			//--------------------------------------------------------------------------------
			//--------------------------------------surgery------------------------------------------
			if(departements.get(i).equals(surgery)){
				element.paint(surgery, g);
				if( hospital.getTime().getMm().getValue()==50){
					money = new Money(departements.get(i).getPosition());
					element.paint(money, g);
					audio.getaCArgent().play();	
					hospital.setCredit(hospital.getCredit().getValue()+GameConfiguration.CONSULTATION_PRICE_SURGERY*hospital.getSurgery().getNb_Patient());
				}
			}
			//--------------------------------------------------------------------------------
			//--------------------------------------------------------------------------------
			
		}
		Dashboard instance = this;
		instance.setBorder(BorderFactory.createLoweredBevelBorder());		
		element.paint(reception,g);
		

		
	}
	
	
	
}