package graphics;

import graphics.chart.ChartManager;
import hospital.Audio;
import hospital.Hospital;
import hospital.elements.Neurology;
import hospital.elements.Credit;
import hospital.elements.Department;
import hospital.elements.Cardiology;
import hospital.elements.Emergency;
import hospital.elements.GeneralMedcine;
import hospital.elements.Pediatrics;
import hospital.elements.Radiology;
import hospital.elements.Surgery;
import hospital.map.Block;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import config.GameConfiguration;

import javax.swing.JButton;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;


/**
 * This Class is an Dialog box with many Button for adding an new department to the hospital 
 * @author Ghezil.A
 * @author Jaafar.A
 *
 */
public class AddNewDepartemnt extends JDialog{
	
	private Audio audio = new Audio();
	/**
	 * Dialog boxes 
	 */
	private ChoisePositon choisePositonLine ;
	private ChoisePositonColm choisePositonColm ;
	/**
	 * x is the value chosen for the line of the new department 
	 * we shou'd keep it because it's the key of our algorithm that he search free column 
	 */
	private String x;
	
	private final static Dimension SizeDepartemntShop = new Dimension(GameConfiguration.DEPPARTEMENT_SHOP_WIDTH, GameConfiguration.DEPPARTEMENT_SHOP_HEIGHT);
	private final static Dimension SizeFooteur = new Dimension(400, 100);
	private Font font = new Font(Font.MONOSPACED, Font.BOLD,17);

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public AddNewDepartemnt(JFrame topFrame, String string,Boolean b,Hospital hospital) {
		super(topFrame,string,b);
	}

	/**
	 * INITIALIZE The Dialog box 7 button who each one can create a new specific department in the hospital
	 * @param topFrame
	 * @param string
	 * @param b
	 * @param hospital
	 */
	public void addDepartemnt(JFrame topFrame, String string,Boolean b,Hospital hospital){
		AddNewDepartemnt instance=this;
		instance.getContentPane().setLayout(new GridLayout(5,2));
		instance.setPreferredSize(SizeDepartemntShop);

		ArrayList<Department>departements = (ArrayList<Department>) hospital.getDepartements();
		
		

/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/	
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------NEUROLOGY------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/	
		
		
Button btnNeurology= new Button("Neurology");
		btnNeurology.setFont(font);
		instance.add(btnNeurology);
		btnNeurology.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				audio.getaCClic().play();
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_NEUROLOGY<0) {
					JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nNEUROLOGY Price : "+GameConfiguration.DEP_PRICE_NEUROLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
					int tmp =0;
					for (int i = 0; i < departements.size(); i++) {
						if(departements.get(i).equals(hospital.getNeurology())){
							JOptionPane.showMessageDialog(instance,"you already have a neurology departements","Warning", JOptionPane.WARNING_MESSAGE);
							tmp=1;
						}
					}
					if(tmp==0){					
						int rep = JOptionPane.showConfirmDialog(instance, "department price : "
								+GameConfiguration.DEP_PRICE_NEUROLOGY+"$\n"
								+ "his sizes : "+GameConfiguration.DEP_CLOM_NEUROLOGY+"x"+GameConfiguration.DEP_LINE_NEUROLOGY+" \n"
								+ "patients per day : "
								+GameConfiguration.NUMBER_PATIENTS_NEUROLOGY+"\n"
								+ "consultation price : "
								+GameConfiguration.CONSULTATION_PRICE_NEUROLOGY +"$\n"
								+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
						
						if (rep==JOptionPane.YES_OPTION){
							
							
							//String positionLine = JOptionPane.showInputDialog(instance, "Vouyez indiquer la position de votre departement ici\n Line \n exemple : 5 (valeur par defaut)", "position", JOptionPane.PLAIN_MESSAGE);
							//String positionColm = JOptionPane.showInputDialog(instance, "Vouyez indiquer la position de votre departement ici\n Colonne \n exemple : 5 (valeur par defaut)", "position", JOptionPane.PLAIN_MESSAGE);
							
							Neurology neurology = new Neurology(new Block(0,0)) ;
							
							
							
							neurology.setSizeLine(GameConfiguration.DEP_LINE_NEUROLOGY);
							neurology.setSizeColm(GameConfiguration.DEP_CLOM_NEUROLOGY);
							choisePositonLine= new ChoisePositon(topFrame,string,b,hospital);
							choisePositonLine.choisepos(neurology);
							x = String.valueOf(choisePositonLine.getValideLine().getSelectedItem());	
							choisePositonColm= new ChoisePositonColm(topFrame,string,b,hospital,instance);
							try {
								choisePositonColm.choisepos(neurology);
								
								
							} catch (NoMoreSpaceException e1) {
								JOptionPane.showMessageDialog(choisePositonColm,"You don't have space","Warning", JOptionPane.WARNING_MESSAGE);
								choisePositonColm.setVisible(false);
							}
							String y = String.valueOf(choisePositonColm.getValideColm().getSelectedItem());
							
							int line= Integer.parseInt(x);		
							try {
								if(y!="null"){
									credit.dicCredit(GameConfiguration.DEP_PRICE_NEUROLOGY);
									hospital.setCredit(credit);
									int Colm = Integer.parseInt(y);
									
									neurology.setPosition(new Block(line,Colm)) ;
									neurology.setPrise(GameConfiguration.DEP_PRICE_NEUROLOGY);
									neurology.setLevel(1);
									neurology.setDrGrade(1);
									neurology.setNtGrade(1);
									neurology.setNb_Patient(GameConfiguration.NUMBER_PATIENTS_NEUROLOGY);
									neurology.setName("neurology");
									hospital.set(neurology);
									hospital.addDep(neurology);
								}
							}catch(Exception e1){
								e1.printStackTrace();
							}	
						}
					}
				}
			}
		});
		
		
		
		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-------------------------------------------CARDIOLOGY----------------------------------------------------*/	
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
	Button btnCardiology= new Button("Cardiology");
		btnCardiology.setFont(font);
		instance.add(btnCardiology);
		btnCardiology.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				audio.getaCClic().play();
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_CARDIOLOGY<0) {
					JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nCardiology Price : "+GameConfiguration.DEP_PRICE_CARDIOLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
					int tmp =0;
					for (int i = 0; i < departements.size(); i++) {
						if(departements.get(i).equals(hospital.getCardiology())){
							JOptionPane.showMessageDialog(instance,"you already have a Cardiology departements","Warning", JOptionPane.WARNING_MESSAGE);
							tmp=1;
						}
					}
					if(tmp==0){					
						int rep = JOptionPane.showConfirmDialog(instance, "department price : "
								+GameConfiguration.DEP_PRICE_CARDIOLOGY+"$\n"
								+ "his sizes : "+GameConfiguration.DEP_CLOM_CARDIOLOGY+"x"+GameConfiguration.DEP_LINE_CARDIOLOGY+" \n"
								+ "patients per day : "
								+GameConfiguration.NUMBER_PATIENTS_CARDIOLOGY+"\n"
								+ "consultation price : "
								+GameConfiguration.CONSULTATION_PRICE_CARDIOLOGY +"$\n"
								+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
						
						if (rep==JOptionPane.YES_OPTION){
							
							Cardiology Cardiology = new Cardiology(new Block(0,0)) ;
							
							
							
							Cardiology.setSizeLine(GameConfiguration.DEP_LINE_CARDIOLOGY);
							Cardiology.setSizeColm(GameConfiguration.DEP_CLOM_CARDIOLOGY);
							choisePositonLine= new ChoisePositon(topFrame,string,b,hospital);
							choisePositonLine.choisepos(Cardiology);
							x = String.valueOf(choisePositonLine.getValideLine().getSelectedItem());	
							choisePositonColm= new ChoisePositonColm(topFrame,string,b,hospital,instance);
							try {
								choisePositonColm.choisepos(Cardiology);

							} catch (NoMoreSpaceException e1) {
								JOptionPane.showMessageDialog(choisePositonColm,"You don't have space","Warning", JOptionPane.WARNING_MESSAGE);
								choisePositonColm.setVisible(false);
							}
							String y = String.valueOf(choisePositonColm.getValideColm().getSelectedItem());
							int line= Integer.parseInt(x);							
							try{
								if(y!="null"){
								int Colm = Integer.parseInt(y);	
								credit.dicCredit(GameConfiguration.DEP_PRICE_CARDIOLOGY);
								hospital.setCredit(credit);
								
								Cardiology.setPosition(new Block(line,Colm)) ;
								Cardiology.setPrise(GameConfiguration.DEP_PRICE_CARDIOLOGY);
								Cardiology.setLevel(1);
								Cardiology.setDrGrade(1);
								Cardiology.setNtGrade(1);
								Cardiology.setNb_Patient(GameConfiguration.NUMBER_PATIENTS_CARDIOLOGY);
								Cardiology.setName("Cardiology");
								hospital.set(Cardiology);
								hospital.addDep(Cardiology);
								}
							} catch (Exception e2) {
								e2.printStackTrace();
							}

							
						}
					}
				}
			}
		});
		

		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*----------------------------------------EMERGENCY-------------------------------------------------------*/	
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
		Button btnEmergency= new Button("Emergency");
		btnEmergency.setFont(font);
		instance.add(btnEmergency);
		btnEmergency.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				audio.getaCClic().play();
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_EMERGENCY<0) {
					JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nEmergency Price : "+GameConfiguration.DEP_PRICE_EMERGENCY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
					int tmp =0;
					for (int i = 0; i < departements.size(); i++) {
						if(departements.get(i).equals(hospital.getEmergency())){
							JOptionPane.showMessageDialog(instance,"you already have a Emergency departements","Warning", JOptionPane.WARNING_MESSAGE);
							tmp=1;
						}
					}
					if(tmp==0){					
						int rep = JOptionPane.showConfirmDialog(instance, "department price : "
								+GameConfiguration.DEP_PRICE_EMERGENCY+"$\n"
								+ "his sizes : "+GameConfiguration.DEP_CLOM_EMERGENCY+"x"+GameConfiguration.DEP_LINE_EMERGENCY+" \n"
								+ "patients per day : "
								+GameConfiguration.NUMBER_PATIENTS_EMERGENCY+"\n"
								+ "consultation price : "
								+GameConfiguration.CONSULTATION_PRICE_EMERGENCY +"$\n"
								+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
						
						if (rep==JOptionPane.YES_OPTION){
							
							
							//String positionLine = JOptionPane.showInputDialog(instance, "Vouyez indiquer la position de votre departement ici\n Line \n exemple : 5 (valeur par defaut)", "position", JOptionPane.PLAIN_MESSAGE);
							//String positionColm = JOptionPane.showInputDialog(instance, "Vouyez indiquer la position de votre departement ici\n Colonne \n exemple : 5 (valeur par defaut)", "position", JOptionPane.PLAIN_MESSAGE);
							
							Emergency Emergency = new Emergency(new Block(0,0)) ;
							
							
							
							Emergency.setSizeLine(GameConfiguration.DEP_LINE_EMERGENCY);
							Emergency.setSizeColm(GameConfiguration.DEP_CLOM_EMERGENCY);
							choisePositonLine= new ChoisePositon(topFrame,string,b,hospital);
							choisePositonLine.choisepos(Emergency);
							x = String.valueOf(choisePositonLine.getValideLine().getSelectedItem());	
							
							choisePositonColm= new ChoisePositonColm(topFrame,string,b,hospital,instance );
							try {
								choisePositonColm.choisepos(Emergency);
								
							} catch (NoMoreSpaceException e1) {
								JOptionPane.showMessageDialog(choisePositonColm,"You don't have space","Warning", JOptionPane.WARNING_MESSAGE);
								choisePositonColm.setVisible(false);
							}
							String y = String.valueOf(choisePositonColm.getValideColm().getSelectedItem());
							
							
							int line= Integer.parseInt(x);		
							try{
								if(y!="null"){
									credit.dicCredit(GameConfiguration.DEP_PRICE_EMERGENCY);
									hospital.setCredit(credit);
								int Colm = Integer.parseInt(y);							
								Emergency.setPosition(new Block(line,Colm)) ;
								Emergency.setPrise(GameConfiguration.DEP_PRICE_EMERGENCY);
								Emergency.setLevel(1);
								Emergency.setDrGrade(1);
								Emergency.setNtGrade(1);
								Emergency.setNb_Patient(GameConfiguration.NUMBER_PATIENTS_EMERGENCY);
								Emergency.setName("Emergency");
								hospital.set(Emergency);
								hospital.addDep(Emergency);
								}
							} catch (Exception e2) {
								e2.printStackTrace();
							}
						}
					}
				}
			}
		});
		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------GENERALMEDECINE------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/	
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
		Button btnGeneralMedcine= new Button("General Medicine");
		btnGeneralMedcine.setFont(font);
		instance.add(btnGeneralMedcine);
		btnGeneralMedcine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				audio.getaCClic().play();
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_GENERALMEDECINE<0) {
					JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nGeneral Medicine Price : "+GameConfiguration.DEP_PRICE_GENERALMEDECINE+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
					int tmp =0;
					for (int i = 0; i < departements.size(); i++) {
						if(departements.get(i).equals(hospital.getGeneralMedcine())){
							JOptionPane.showMessageDialog(instance,"you already have a General Medicine departements","Warning", JOptionPane.WARNING_MESSAGE);
							tmp=1;
						}
					}
					if(tmp==0){					
						int rep = JOptionPane.showConfirmDialog(instance, "department price : "
								+GameConfiguration.DEP_PRICE_GENERALMEDECINE+"$\n"
								+ "his sizes : "+GameConfiguration.DEP_CLOM_GENERALMEDECINE+"x"+GameConfiguration.DEP_LINE_GENERALMEDECINE+" \n"
								+ "patients per day : "
								+GameConfiguration.NUMBER_PATIENTS_GENERALMEDECINE+"\n"
								+ "consultation price : "
								+GameConfiguration.CONSULTATION_PRICE_GENERALMEDECINE +"$\n"
								+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
						
						if (rep==JOptionPane.YES_OPTION){
							
							
							//String positionLine = JOptionPane.showInputDialog(instance, "Vous pouvez indiquer la position de votre departement ici\n Ligne \n exemple : 5 (valeur par defaut)", "position", JOptionPane.PLAIN_MESSAGE);
							//String positionColm = JOptionPane.showInputDialog(instance, "Vous pouvez indiquer la position de votre departement ici\n Colonne \n exemple : 5 (valeur par defaut)", "position", JOptionPane.PLAIN_MESSAGE);
							
							GeneralMedcine GeneralMedcine = new GeneralMedcine(new Block(0,0)) ;
							
							
							
							GeneralMedcine.setSizeLine(GameConfiguration.DEP_LINE_GENERALMEDECINE);
							GeneralMedcine.setSizeColm(GameConfiguration.DEP_CLOM_GENERALMEDECINE);
							choisePositonLine= new ChoisePositon(topFrame,string,b,hospital);
							choisePositonLine.choisepos(GeneralMedcine);
							
							x = String.valueOf(choisePositonLine.getValideLine().getSelectedItem());	
							
							choisePositonColm= new ChoisePositonColm(topFrame,string,b,hospital,instance);
							try {
								choisePositonColm.choisepos(GeneralMedcine);
								
							} catch (NoMoreSpaceException e1) {
								JOptionPane.showMessageDialog(choisePositonColm,"You don't have space","Warning", JOptionPane.WARNING_MESSAGE);
								choisePositonColm.setVisible(false);
							}
							String y = String.valueOf(choisePositonColm.getValideColm().getSelectedItem());
							
							int line= Integer.parseInt(x);	
							try{
								if(y!="null"){
									credit.dicCredit(GameConfiguration.DEP_PRICE_GENERALMEDECINE);
									hospital.setCredit(credit);
							int Colm = Integer.parseInt(y);							
							GeneralMedcine.setPosition(new Block(line,Colm)) ;
							GeneralMedcine.setPrise(GameConfiguration.DEP_PRICE_GENERALMEDECINE);
							GeneralMedcine.setLevel(1);
							GeneralMedcine.setDrGrade(1);
							GeneralMedcine.setNtGrade(1);
							GeneralMedcine.setNb_Patient(GameConfiguration.NUMBER_PATIENTS_GENERALMEDECINE);
							GeneralMedcine.setName("GeneralMedcine");
							hospital.set(GeneralMedcine);
							hospital.addDep(GeneralMedcine);
								}
							} catch (Exception e2) {
								e2.printStackTrace();
							}
						}
					}
				}
			}
		});

		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*------------------------------------------PEDIATRICS-----------------------------------------------------*/	
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
		Button btnPediatrics= new Button("Pediatrics");
		btnPediatrics.setFont(font);
		instance.add(btnPediatrics);
		btnPediatrics.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				audio.getaCClic().play();
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_PEDIATRICS<0) {
					JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPediatrics Price : "+GameConfiguration.DEP_PRICE_PEDIATRICS+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
					int tmp =0;
					for (int i = 0; i < departements.size(); i++) {
						if(departements.get(i).equals(hospital.getPediatrics())){
							JOptionPane.showMessageDialog(instance,"you alredy have a Pediatrics departements","Warning", JOptionPane.WARNING_MESSAGE);
							tmp=1;
						}
					}
					if(tmp==0){					
						int rep = JOptionPane.showConfirmDialog(instance, "department price : "
								+GameConfiguration.DEP_PRICE_PEDIATRICS+"$\n"
								+ "his sizes : "+GameConfiguration.DEP_CLOM_PEDIATRICS+"x"+GameConfiguration.DEP_LINE_PEDIATRICS+" \n"
								+ "patients per day : "
								+GameConfiguration.NUMBER_PATIENTS_PEDIATRICS+"\n"
								+ "consultation price : "
								+GameConfiguration.CONSULTATION_PRICE_PEDIATRICS +"$\n"
								+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
						
						if (rep==JOptionPane.YES_OPTION){
							
							
							//String positionLine = JOptionPane.showInputDialog(instance, "Vous pouvez indiquer la position de votre departement ici\n Line \n exemple : 5 (valeur par defaut)", "position", JOptionPane.PLAIN_MESSAGE);
							//String positionColm = JOptionPane.showInputDialog(instance, "Vous pouvez indiquer la position de votre departement ici\n Colonne \n exemple : 5 (valeur par defaut)", "position", JOptionPane.PLAIN_MESSAGE);
							
							Pediatrics Pediatrics = new Pediatrics(new Block(0,0)) ;
							
							
							
							Pediatrics.setSizeLine(GameConfiguration.DEP_LINE_PEDIATRICS);
							Pediatrics.setSizeColm(GameConfiguration.DEP_CLOM_PEDIATRICS);
							choisePositonLine= new ChoisePositon(topFrame,string,b,hospital);
							choisePositonLine.choisepos(Pediatrics);
							
							

							x = String.valueOf(choisePositonLine.getValideLine().getSelectedItem());	
							
							choisePositonColm= new ChoisePositonColm(topFrame,string,b,hospital,instance);
							try {
								choisePositonColm.choisepos(Pediatrics);
								
							} catch (NoMoreSpaceException e1) {
								JOptionPane.showMessageDialog(choisePositonColm,"You don't have space","Warning", JOptionPane.WARNING_MESSAGE);
								choisePositonColm.setVisible(false);
							}
							String y = String.valueOf(choisePositonColm.getValideColm().getSelectedItem());
							int line= Integer.parseInt(x);	
							try{
								if(y!="null"){
							int Colm = Integer.parseInt(y);		
							credit.dicCredit(GameConfiguration.DEP_PRICE_PEDIATRICS);
							hospital.setCredit(credit);
							Pediatrics.setPosition(new Block(line,Colm)) ;
							Pediatrics.setPrise(GameConfiguration.DEP_PRICE_PEDIATRICS);
							Pediatrics.setLevel(1);
							Pediatrics.setDrGrade(1);
							Pediatrics.setNtGrade(1);
							Pediatrics.setNb_Patient(GameConfiguration.NUMBER_PATIENTS_PEDIATRICS);
							Pediatrics.setName("Pediatrics");
							hospital.set(Pediatrics);
							hospital.addDep(Pediatrics);
								}
							} catch (Exception e2) {
								e2.printStackTrace();
							}
							
						}
					}
				}
			}
		});
		

/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*---------------------------------------------RADIOLOGY--------------------------------------------------*/	
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/	
		Button btnRadiology= new Button("Radiology");
		btnRadiology.setFont(font);
		instance.add(btnRadiology);
		btnRadiology.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				audio.getaCClic().play();
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_RADIOLOGY<0) {
					JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nRadiology Price : "+GameConfiguration.DEP_PRICE_RADIOLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
					int tmp =0;
					for (int i = 0; i < departements.size(); i++) {
						if(departements.get(i).equals(hospital.getRadiology())){
							JOptionPane.showMessageDialog(instance,"you alredy have a Radiology departements","Warning", JOptionPane.WARNING_MESSAGE);
							tmp=1;
						}
					}
					if(tmp==0){					
						int rep = JOptionPane.showConfirmDialog(instance,"department price : "
								+GameConfiguration.DEP_PRICE_RADIOLOGY+"$\n"
								+ "his sizes : "+GameConfiguration.DEP_CLOM_RADIOLOGY+"x"+GameConfiguration.DEP_LINE_RADIOLOGY+" \n"
								+ "patients per day : "
								+GameConfiguration.NUMBER_PATIENTS_RADIOLOGY+"\n"
								+ "consultation price : "
								+GameConfiguration.CONSULTATION_PRICE_RADIOLOGY +"$\n"
								+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
						
						if (rep==JOptionPane.YES_OPTION){
							
							Radiology Radiology = new Radiology(new Block(0,0)) ;
							Radiology.setSizeLine(GameConfiguration.DEP_LINE_RADIOLOGY);
							Radiology.setSizeColm(GameConfiguration.DEP_CLOM_RADIOLOGY);
							choisePositonLine= new ChoisePositon(topFrame,string,b,hospital);
							choisePositonLine.choisepos(Radiology);							
							x = String.valueOf(choisePositonLine.getValideLine().getSelectedItem());
							
							choisePositonColm= new ChoisePositonColm(topFrame,string,b,hospital,instance);
							try {
								choisePositonColm.choisepos(Radiology);
								
							} catch (NoMoreSpaceException e1) {
								JOptionPane.showMessageDialog(choisePositonColm,"You don't have space","Warning", JOptionPane.WARNING_MESSAGE);
								choisePositonColm.setVisible(false);
							}
							String y = String.valueOf(choisePositonColm.getValideColm().getSelectedItem());
							if(y!="null"){
								credit.dicCredit(GameConfiguration.DEP_PRICE_RADIOLOGY);
								hospital.setCredit(credit);
								int line= Integer.parseInt(x);	
								try{
								int Colm = Integer.parseInt(y);							
								Radiology.setPosition(new Block(line,Colm)) ;
								Radiology.setPrise(GameConfiguration.DEP_PRICE_RADIOLOGY);
								Radiology.setLevel(1);
								Radiology.setDrGrade(1);
								Radiology.setNtGrade(1);
								Radiology.setNb_Patient(GameConfiguration.NUMBER_PATIENTS_RADIOLOGY);
								Radiology.setName("Radiology");
								hospital.set(Radiology);
								hospital.addDep(Radiology);
								
								} catch (Exception e2) {
									e2.printStackTrace();
								}
							}
							
						}
					}
				}
			}
		});
		
		


		
		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------SURGERY------------------------------------------------------*/	
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/	
		Button btnSurgery= new Button("Surgery");
		btnSurgery.setFont(font);
		instance.add(btnSurgery);
		btnSurgery.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				audio.getaCClic().play();
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_SURGERY<0) {
					JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nSurgery Price : "+GameConfiguration.DEP_PRICE_SURGERY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
					int tmp =0;
					for (int i = 0; i < departements.size(); i++) {
						if(departements.get(i).equals(hospital.getSurgery())){
							JOptionPane.showMessageDialog(instance,"you alredy have a Surgery departements","Warning", JOptionPane.WARNING_MESSAGE);
							tmp=1;
						}
					}
					if(tmp==0){					
						int rep = JOptionPane.showConfirmDialog(instance,"department price : "
								+GameConfiguration.DEP_PRICE_SURGERY+"$\n"
								+ "his sizes : "+GameConfiguration.DEP_CLOM_SURGERY+"x"+GameConfiguration.DEP_LINE_SURGERY+" \n"
								+ "patients per day : "
								+GameConfiguration.NUMBER_PATIENTS_SURGERY+"\n"
								+ "consultation price : "
								+GameConfiguration.CONSULTATION_PRICE_SURGERY +"$\n"
								+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
						
						if (rep==JOptionPane.YES_OPTION){							
							Surgery Surgery = new Surgery(new Block(0,0)) ;						
							Surgery.setSizeLine(GameConfiguration.DEP_LINE_SURGERY);
							Surgery.setSizeColm(GameConfiguration.DEP_CLOM_SURGERY);
							choisePositonLine= new ChoisePositon(topFrame,string,b,hospital);
							choisePositonLine.choisepos(Surgery);
							x = String.valueOf(choisePositonLine .getValideLine().getSelectedItem());	
							choisePositonColm= new ChoisePositonColm(topFrame,string,b,hospital,instance);
							
							try {
								choisePositonColm.choisepos(Surgery);
								
								
							} catch (NoMoreSpaceException e1) {
								JOptionPane.showMessageDialog(choisePositonColm,"You don't have space","Warning", JOptionPane.WARNING_MESSAGE);
								choisePositonColm.setVisible(false);	
							}
							String y = String.valueOf(choisePositonColm.getValideColm().getSelectedItem());
							
							int line= Integer.parseInt(x);
							try{
								if(y!="null"){
									credit.dicCredit(GameConfiguration.DEP_PRICE_SURGERY);
									hospital.setCredit(credit);
									
								int Colm = Integer.parseInt(y);							
								Surgery.setPosition(new Block(line,Colm)) ;
								Surgery.setPrise(GameConfiguration.DEP_PRICE_SURGERY);
								Surgery.setLevel(1);
								Surgery.setDrGrade(1);
								Surgery.setNtGrade(1);
								Surgery.setNb_Patient(GameConfiguration.NUMBER_PATIENTS_SURGERY);
								Surgery.setName("Surgery");
								hospital.set(Surgery);
								hospital.addDep(Surgery);
								}
							} catch (Exception e2) {
								e2.printStackTrace();
							}
							

							
						}
					}
				}
			}
		});
		
		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/	
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/	
		
		instance.add(new JLabel(""));
		instance.add(new JLabel(""));
		
		JPanel footer = new JPanel();
		footer.setPreferredSize(SizeFooteur);
		footer.setLayout(null);
		
		
		
		JButton btnFinish = new JButton("Finish");

		btnFinish.setBounds(0, 60, 85, 40);
		btnFinish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				audio.getaCClic().play();
				instance.setVisible(false);
				
			}
		});
		footer.add(btnFinish,BorderLayout.EAST);
		

		JButton btnCancel= new JButton("Cancel");
		btnCancel.setBounds(95, 60,85,40);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				audio.getaCClic().play();
				instance.setVisible(false);
				
			}
		});
		footer.add(btnCancel,BorderLayout.WEST);
		
		instance.add(footer);
		pack();
		instance.setVisible(true);
	}
	public String getXi(){
		return x;
	}
}
