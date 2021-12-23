package graphics;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import  java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import graphics.chart.ChartManager;
import hospital.Audio;
import hospital.Building;
import hospital.Hospital;
import hospital.Operation;
import hospital.map.Map;
import hospital.timer.Timer;






import javax.swing.ImageIcon;
import javax.swing.JFrame;
//import javax.swing.JTextField;





import javax.swing.JOptionPane;



























import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;

import config.GameConfiguration;

/**
 * The manual test of graphical tree.
 * @author Ghezil.A
 * @author Jaafar.A
 * @author Bouras.B
 * @version 1.0
 *
 */
public class MainFrame extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map map;
	private Timer time;
	private static Image icon = Toolkit.getDefaultToolkit().getImage("./src/config/images/icon.png");  
	private ImageIcon icon2 = new ImageIcon("./src/config/images/cover.png"); 
	private Hospital hospital;
	private final static Dimension SizeDashboard = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);
	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH+200, GameConfiguration.WINDOW_HEIGHT+100);
	private Dashboard dashboard;
	private static InformationZone informationZone ;
	private OperationZone operationZone;
	private Audio audio = new Audio();
	//private static URL url = getClass().getResource("./src/config/main-title.mp3");
	private MainFrame main= this;
	

	public MainFrame(String title){
		super(title);
		init();
		
	}
	
	
	private void init(){
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		map = Building.buildMap();
		time = new Timer();
		
		
		
		audio.getaCHosto().play();
		// les textes figurant // sur les boutons 
		String lesTextes[]={ "Create a new session", "Restore the previous session"}; 
		int retour = JOptionPane.showOptionDialog(this, "Welcom in Your Hospital Game\n"
				+ "Do you want to : Restore the previous session OR Create a new one ?", "Session",  JOptionPane.DEFAULT_OPTION,  JOptionPane.CLOSED_OPTION, 
				 icon2,
				lesTextes,lesTextes[0]);
		
				if( retour!=JOptionPane.CLOSED_OPTION){
					if( retour == 0){
						audio.getaCClic().play();
						hospital = Building.buildInitMobile(map,time);
					}else if(retour==1){
						audio.getaCClic().play();
						try{
							Operation operation = new Operation(hospital,map,time);
							hospital = operation.textReadInformation("DataInformation.csv");
							operation.textReadDepartement("DataDepartement.csv");
						}catch(Exception e1){
							//e1.printStackTrace();
							hospital = Building.buildInitMobile(map,time);
						}
					}
				}else{
					System.exit(0);
				} ;
		
		dashboard = new Dashboard(map, hospital);
		informationZone = new InformationZone(hospital);
		operationZone = new OperationZone(hospital,this);

	
		informationZone.Information();
		contentPane.add(informationZone,BorderLayout.NORTH);
		Thread timer = new Thread(informationZone);
		timer.start();
		dashboard.setPreferredSize(SizeDashboard);
		contentPane.add(dashboard, BorderLayout.CENTER);

		
		
		operationZone.operation();
		contentPane.add(operationZone,BorderLayout.EAST);
		
		
		
		main.setIconImage(icon);  
		main.setVisible(true);

		Thread gameThread = new Thread(main);
		gameThread.start();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}
	public MainFrame getMain(){
		return main;
	}
	@Override
	public void run() {	
		while (true) {
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED );
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			time.inc();
			informationZone.repaint();	
			dashboard.repaint();
			//hospital.generateHommes();
			hospital.nextRound();
		}
	}
	
}
