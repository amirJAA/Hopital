package graphics;

import hospital.Hospital;
import hospital.elements.Cardiology;
import hospital.elements.Credit;
import hospital.elements.Emergency;
import hospital.elements.GeneralMedcine;
import hospital.elements.Homme;
import hospital.elements.Money;
import hospital.elements.Neurology;
import hospital.elements.Pediatrics;
import hospital.elements.Radiology;
import hospital.elements.Reception;
import hospital.elements.Surgery;
import hospital.map.Block;
import hospital.map.Map;
import hospital.timer.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import config.GameConfiguration;

/**
 * Class for paint the all Element of our hospital
 * Map - Departments - Money - Credit - Patients(Homme)
 *
 */
public class Element {
	private Font font = new Font("TimesRoman",Font.BOLD,30);
	private BufferedImage img ;
	//private Hospital hospital;
	
	//-----------------------------------------------------------------------------------------------------
	//---------------------------------------map-------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------	
	public void paint(Map map, Graphics graphics ,Hospital hospital) {
		int height = hospital.getHeight();
		int width = hospital.getWidth();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int x = ((60 - width)/2)*blockSize;
		int y = ((40 - height)/2)*blockSize;
		Block[][] blocks = map.getBlocks();
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex];

				if ((lineIndex + columnIndex) % 2 == 0) {
					graphics.setColor(new Color(200, 200,200));
					graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);
					graphics.setColor(Color.RED);
					graphics.setFont(font);
					graphics.drawRect(x, y,width*blockSize, height*blockSize);
				}
			}
		}
	}
	//-----------------------------------------------------------------------------------------------------
	//---------------------------------------reception--------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------


	public void paint(Reception reception,Graphics graphics) {
		Block position = reception.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int y = position.getLine();
		int x = position.getColumn();
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/config/images/logo_hopital.png") );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*GameConfiguration.DEP_CLOM_RECEPTION,blockSize*GameConfiguration.DEP_LINE_RECEPTION, null);
	}
	//-----------------------------------------------------------------------------------------------------
	//---------------------------------------money--------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------

	
	public void paint(Money money,Graphics graphics) {
		Block position = money.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int y = position.getLine();
		int x = position.getColumn();
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/config/images/AnimatedCoins.gif") );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*8,blockSize*8, null);
	}
	//-----------------------------------------------------------------------------------------------------
	//------------------------------------credit-----------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------

	
	public void paint(Credit credit,Graphics graphics){
		int y = 40;
		int x = 650;
		graphics.setColor(Color.WHITE);
		graphics.fillRoundRect(x, y, 300, 30, 10, 10);
		graphics.setColor(Color.green);
		//int width = *(50/600);
		graphics.fillRoundRect(x, y, credit.getValue()/10, 30, 10, 10);
	}
	private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}
	public void paint(Timer timer,Graphics graphics){
		int y = 35;
		int x = 3;
		graphics.setColor(Color.RED);
		graphics.fillRoundRect(x, y, 300, 35, 10, 10);
		
	}

	
	//-----------------------------------------------------------------------------------------------------
		//-----------------------------------homme------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------------------

	
	public void paint(Homme homme, Graphics graphics,Timer timer) {
		
		Block position = homme.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		
		int y = position.getLine();
		int x = position.getColumn();
		int rand =getRandomNumber(0,2);
		
		
		
		try {
			if(rand==0){
				img = ImageIO.read(getClass().getResourceAsStream("/config/images/homme.png") );	
			}else if(rand==1){
				img = ImageIO.read(getClass().getResourceAsStream("/config/images/homme1.png") );
			}else{
				img = ImageIO.read(getClass().getResourceAsStream("/config/images/homme2.png") );
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*2,blockSize*2, null);
	}
	//-----------------------------------------------------------------------------------------------------
		//-------------------------------neurology----------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------------------

	
	public void paint(Neurology neurology, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block position = neurology.getPosition();
		int y =position.getLine();
		int x = position.getColumn();
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/config/images/neurology.png") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*GameConfiguration.DEP_CLOM_NEUROLOGY,blockSize*GameConfiguration.DEP_LINE_NEUROLOGY, null);
	}
	
	//-----------------------------------------------------------------------------------------------------
	//---------------------------------------Pediatrics--------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------
	public void paint(Pediatrics Pediatrics, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block position = Pediatrics.getPosition();
		int y =position.getLine();
		int x = position.getColumn();
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/config/images/Pediatrics.png") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*GameConfiguration.DEP_CLOM_PEDIATRICS,blockSize*GameConfiguration.DEP_LINE_PEDIATRICS, null);
	}

	//-----------------------------------------------------------------------------------------------------
	//---------------------------------------Cardiology--------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------
	public void paint(Cardiology Cardiology, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block position = Cardiology.getPosition();
		int y =position.getLine();
		int x = position.getColumn();
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/config/images/Cardiology.png") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*GameConfiguration.DEP_CLOM_CARDIOLOGY,blockSize*GameConfiguration.DEP_LINE_CARDIOLOGY, null);
	}

	//-----------------------------------------------------------------------------------------------------
	//--------------------------------------Emergency---------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------
	public void paint(Emergency Emergency, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block position = Emergency.getPosition();
		int y =position.getLine();
		int x = position.getColumn();
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/config/images/Emergency.png") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*GameConfiguration.DEP_CLOM_EMERGENCY,blockSize*GameConfiguration.DEP_LINE_EMERGENCY, null);
	}

	//-----------------------------------------------------------------------------------------------------
	//--------------------------------------GeneralMedcine---------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------
	public void paint(GeneralMedcine GeneralMedcine, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block position = GeneralMedcine.getPosition();
		int y =position.getLine();
		int x = position.getColumn();
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/config/images/GeneralMedicine.png") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*GameConfiguration.DEP_CLOM_GENERALMEDECINE,blockSize*GameConfiguration.DEP_LINE_GENERALMEDECINE, null);
	}

	//-----------------------------------------------------------------------------------------------------
	//---------------------------------------Radiology--------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------
	public void paint(Radiology Radiology, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block position = Radiology.getPosition();
		int y =position.getLine();
		int x = position.getColumn();
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/config/images/Radiology.png") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*GameConfiguration.DEP_CLOM_RADIOLOGY,blockSize*GameConfiguration.DEP_LINE_RADIOLOGY, null);
	}
	//-----------------------------------------------------------------------------------------------------
	//------------------------------------Surgery-----------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------
	public void paint(Surgery Surgery, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block position = Surgery.getPosition();
		int y =position.getLine();
		int x = position.getColumn();
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/config/images/Surgery.png") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*GameConfiguration.DEP_CLOM_SURGERY,blockSize*GameConfiguration.DEP_LINE_SURGERY, null);
	}
	
	

	
}
