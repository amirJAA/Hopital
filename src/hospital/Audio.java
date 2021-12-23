package hospital;

import java.io.File;

import javafx.scene.media.AudioClip;

/**
 * This class is for initialize Audio clips for our game 
 * @author Bouras.N
 *	@version 1.0
 */
public class Audio {
	/**
	 * Audio clic button
	 */
	private AudioClip aCClic = new AudioClip( new File("./src/config/audio/clic.wav").toURI().toString());
	/**
	 * The Main Audio Clip
	 */ 
	private AudioClip aCHosto = new AudioClip( new File("./src/config/audio/main-sond.wav").toURI().toString());
	
	/**
	 * outher audio 
	 */
	private AudioClip aCLevelUp = new AudioClip( new File("./src/config/audio/Video-Game-Power-Level-Up.wav").toURI().toString());
	private AudioClip aCArgent =new AudioClip( new File("./src/config/audio/bruitage-encaissement-dargent.wav").toURI().toString());
	
	public Audio(){
		aCHosto.setVolume(0.1);
	}
	
	/**
	 * @return the aCLevelUp
	 */
	public AudioClip getaCLevelUp() {
		return aCLevelUp;
	}

	/**
	 * @param aCLevelUp the aCLevelUp to set
	 */
	public void setaCLevelUp(AudioClip aCLevelUp) {
		this.aCLevelUp = aCLevelUp;
	}

	/**
	 * @return the aCArgent
	 */
	public AudioClip getaCArgent() {
		return aCArgent;
	}

	/**
	 * @param aCArgent the aCArgent to set
	 */
	public void setaCArgent(AudioClip aCArgent) {
		this.aCArgent = aCArgent;
	}

	/**
	 * @return the aCClic
	 */
	public AudioClip getaCClic() {
		return aCClic;
	}

	/**
	 * @param aCClic the aCClic to set
	 */
	public void setaCClic(AudioClip aCClic) {
		this.aCClic = aCClic;
	}

	/**
	 * @return the aCHosto
	 */
	public AudioClip getaCHosto() {
		return aCHosto;
	}

	/**
	 * @param aCHosto the aCHosto to set
	 */
	public void setaCHosto(AudioClip aCHosto) {
		this.aCHosto = aCHosto;
	}

	

}
