package config;
/**
 * tThis class contains elementary data and graphical parameters.
 * @author Ghezil.A
 * @author Jaafar.A
 * @author Bouras.N
 *
 */

public class GameConfiguration {
	/**
	 * Dashboard dimension
	 */
	public static final int WINDOW_WIDTH = 900;
	public static final int WINDOW_HEIGHT = 600;
	
	/**
	 * OPERATIONZONE dimension
	 */
	public static final int OPERATIONZONE_WIDTH = 200;
	public static final int OPERATIONZONE_HEIGHT = 600;
	
	/**
	 *  DEPPARTEMENT dimension
	 */
	public static final int DEPPARTEMENT_SHOP_WIDTH = 410;
	public static final int DEPPARTEMENT_SHOP_HEIGHT = 600;
	
	/**
	 * INFORMATIONZONE dimension
	 */
	public static final int INFORMATIONZONE_WIDTH = 900;
	public static final int INFORMATIONZONE_HEIGHT = 100;
	
	
	public static final String SEPARETOR = "#";
	
	public static final int BLOCK_SIZE = 15;
	
	public static final int LINE_COUNT = WINDOW_HEIGHT / BLOCK_SIZE;
	public static final int COLUMN_COUNT = WINDOW_WIDTH / BLOCK_SIZE;
	
	
	public static final int GAME_SPEED = 1000;
	
	/**
	 * Initial Credit value 
	 */
	public static final int INIT_CREDIT = 6000;
	
	/**
	 * HEIGHT Of each department
	 */
	public static final int DEP_LINE_RECEPTION  = 14;
	public static final int DEP_LINE_SURGERY = 10;
	public static final int DEP_LINE_CARDIOLOGY= 9;
	public static final int DEP_LINE_EMERGENCY = 10;
	public static final int DEP_LINE_GENERALMEDECINE = 10;
	public static final int DEP_LINE_NEUROLOGY = 11;
	public static final int DEP_LINE_PEDIATRICS = 11;
	public static final int DEP_LINE_RADIOLOGY = 10;

	/**
	 * WIDTH Of each department
	 */
	public static final int DEP_CLOM_RECEPTION = 14;
	public static final int DEP_CLOM_SURGERY = 10;
	public static final int DEP_CLOM_CARDIOLOGY= 9;
	public static final int DEP_CLOM_EMERGENCY = 11;
	public static final int DEP_CLOM_GENERALMEDECINE = 11;
	public static final int DEP_CLOM_NEUROLOGY = 10;
	public static final int DEP_CLOM_PEDIATRICS = 10;
	public static final int DEP_CLOM_RADIOLOGY = 12;
	
	
	/**
	 * price of each department
	 */
	public static final int DEP_PRICE_SURGERY = 2010;
	public static final int DEP_PRICE_CARDIOLOGY= 150;
	public static final int DEP_PRICE_EMERGENCY = 1530;
	public static final int DEP_PRICE_GENERALMEDECINE = 540;
	public static final int DEP_PRICE_NEUROLOGY = 150;
	public static final int DEP_PRICE_PEDIATRICS = 240;
	public static final int DEP_PRICE_RADIOLOGY = 420;
	
	/**
	 * Updating price of each department
	 */
	public static final int UPDATE_PRICE_SURGERY = 990;
	public static final int UPDATE_PRICE_CARDIOLOGY= 90;
	public static final int UPDATE_PRICE_EMERGENCY = 700;
	public static final int UPDATE_PRICE_GENERALMEDECINE = 270;
	public static final int UPDATE_PRICE_NEUROLOGY = 90;
	public static final int UPDATE_PRICE_PEDIATRICS = 120;
	public static final int UPDATE_PRICE_RADIOLOGY = 210;
	
	
	/**
	 * Price of an consultation on each department
	 */
	public static final int CONSULTATION_PRICE_SURGERY = 135;
	public static final int CONSULTATION_PRICE_CARDIOLOGY= 2;
	public static final int CONSULTATION_PRICE_EMERGENCY = 6;
	public static final int CONSULTATION_PRICE_GENERALMEDECINE = 1;
	public static final int CONSULTATION_PRICE_NEUROLOGY = 2;
	public static final int CONSULTATION_PRICE_PEDIATRICS = 1;
	public static final int CONSULTATION_PRICE_RADIOLOGY = 3;
	

	/**
	 * Number of patients on each department
	 */
	public static final int NUMBER_PATIENTS_SURGERY = 5;
	public static final int NUMBER_PATIENTS_CARDIOLOGY = 25;
	public static final int NUMBER_PATIENTS_EMERGENCY = 85;
	public static final int NUMBER_PATIENTS_GENERALMEDECINE = 200;
	public static final int NUMBER_PATIENTS_NEUROLOGY = 20;
	public static final int NUMBER_PATIENTS_PEDIATRICS = 60;
	public static final int NUMBER_PATIENTS_RADIOLOGY = 45;
}
