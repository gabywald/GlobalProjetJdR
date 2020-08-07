package gabywald.rpg.controller;

import gabywald.rpg.data.samples.RPGDataFile;
import gabywald.rpg.view.panels.SpecialPanel;

/**
 * 
 * @author Gabriel Chandesris (2011)
 */
public class IntegrationActionListenerSpecial extends IntegrationActionListener {
	
	public static String[] MAIN_DOMAINS = {
		"Pouvoirs psy (SimulacreS)", 
		"Pouvoir de la Force", 
	};
	private static final RPGDataFile[] TALENTS_FILES_SETS		= {
		RPGDataFile.getSimulacreSpouvoirsPsy(), 
		RPGDataFile.getGenericPouvoirsForce(), 
	};

	public IntegrationActionListenerSpecial(boolean b, SpecialPanel sp) {
		super(b, true, sp);
		this.setElement("Special");
		this.setMainDomains(IntegrationActionListenerSpecial.MAIN_DOMAINS);
		this.setTalentsFileSets(IntegrationActionListenerSpecial.TALENTS_FILES_SETS);
	}
	
}
