package hospital;


import hospital.elements.Reception;
import hospital.map.Block;
import hospital.map.Map;
import hospital.timer.Timer;
import hospital.Hospital;
import config.GameConfiguration;



/**
 * Date : 04/02/2021
 *@version 1.0
 */
public class Building {
	public static Map buildMap() {
		return new Map(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}
	/**
	 * This Method construct our hospital and initialize The reception on it 
	 * it's use if we already had a session
	 * @param map
	 * @param height of the map playground 
	 * @param width of the map playground 
	 * @param timer of the last session 
	 * @param credit of the last session 
	 * @return hospital
	 */
	public static Hospital buildInitMobile(Map map,int height,int width,Timer timer, int credit)  {
		Hospital hospital = new Hospital( map, height, width,  timer, credit) ;
		
		intializeReception(map,hospital);
		
		return hospital;
	}
	/**
	 * This Method construct our hospital and initialize The reception on it 
	 * @param map
	 * @param timer 
	 * @return hospital 
	 */
	public static Hospital buildInitMobile(Map map,Timer timer) {
		Hospital hospital = new Hospital(map,timer);
		
		intializeReception(map,hospital);
		
		return hospital;
	}
	/**
	 * This Method construct and initialize the reception department in the middle of the map
	 * @param map
	 * @param hospital
	 */
	private static void intializeReception(Map map, Hospital hospital) {
		Block block = map.getBlock((GameConfiguration.LINE_COUNT-14)/2,(GameConfiguration.COLUMN_COUNT-12)/2);
		Reception reception	= new Reception(block);
		reception.setSizeColm(GameConfiguration.DEP_CLOM_RECEPTION);
		reception.setSizeLine(GameConfiguration.DEP_LINE_RECEPTION);
		reception.setName("reception");
		hospital.set(reception);
		hospital.addDep(reception);
	}
	
}
