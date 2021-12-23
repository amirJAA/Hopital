package graphics;

import hospital.Audio;
import hospital.Hospital;
import hospital.elements.Credit;
import hospital.timer.Timer;
import hospital.timer.CyclicCounter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.GameConfiguration;



/**
 * a Jpanel where we can see an digital clock and our credit 
 * we also have a button (Map) for printing the map when we want to
 * @author Ghezil.A
 *
 */
public class InformationZone extends JPanel implements Runnable{
	private Hospital hospital;
	private Audio audio = new Audio();
	//private Timer time = new Timer();
	private Element element = new Element();
	private JPanel Pleft= new JPanel();
	private final static Dimension SizeInformationZone = new Dimension(GameConfiguration.INFORMATIONZONE_WIDTH, GameConfiguration.INFORMATIONZONE_HEIGHT);
	
	private JLabel hourLabel = new JLabel(" Hour: 00 ");
	private JLabel minuteLabel = new JLabel("Minute: 00");
	private JLabel creditLabel = new JLabel(" 00$ ");
	private Font font = new Font(Font.MONOSPACED, Font.ITALIC,25);
	public static int mapEvent = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static final Graphics Graphics = null;
	public InformationZone(Hospital hospital){
		this.hospital=hospital;
	}
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Timer timer = hospital.getTime();
		element.paint(timer, g);
		
		Credit credit = hospital.getCredit();
		element.paint(credit, g);
		
		
	}
	
	
	public void Information(){
		updateValues();
		InformationZone instance = this;
		instance.setLayout(new BorderLayout());
		instance.setBackground(Color.GRAY);
		instance.setBorder(BorderFactory.createLoweredBevelBorder());
		instance.setPreferredSize(SizeInformationZone);
		
		
		hourLabel.setFont(font );
		minuteLabel.setFont(font );
		hourLabel.setForeground(Color.white);
		minuteLabel.setForeground(Color.white);
		
		creditLabel.setFont(font );
		creditLabel.setForeground(Color.white);
		
		instance.add(hourLabel,BorderLayout.WEST);
		instance.add(minuteLabel,BorderLayout.CENTER);
		
		Pleft.setLayout(new BorderLayout());
		Pleft.setBackground(Color.GRAY);
		Pleft.add(creditLabel,BorderLayout.CENTER);
		
		
		
		
		Button btnmap = new Button("MAP");
		Dimension d = new Dimension(30,60);
		btnmap.setSize(d);
		btnmap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				audio.getaCClic().play();
				if(mapEvent==1){
					mapEvent = 0 ; 
				}else{
					mapEvent = 1;
				}
			}
		});
		Pleft.add(btnmap,BorderLayout.EAST);
		Pleft.add(new JLabel(" "),BorderLayout.NORTH);
		Pleft.add(new JLabel(" "),BorderLayout.SOUTH);
		instance.add(Pleft,BorderLayout.EAST);
		
		instance.setVisible(true);
		
	}
	
	private void updateValues() {
		
		CyclicCounter hour = hospital.getTime().getHh();
		hourLabel.setText( " Hour:" +hour.toString()+ " ");
		CyclicCounter minute = hospital.getTime().getMm();
		minuteLabel.setText(" Minute:"+minute.toString() + " ");
		Credit credit = hospital.getCredit();
		creditLabel.setText(credit.getValue()+"$ ");
	}
	public int getmapEvent(){
		return mapEvent;
	}
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			updateValues();
		}
	}
	

}