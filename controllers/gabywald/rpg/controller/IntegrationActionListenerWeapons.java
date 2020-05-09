package gabywald.rpg.controller;

import gabywald.global.data.samples.RPGDataFile;
import gabywald.rpg.view.panels.WeaponsPanel;

/**
 * 
 * @author Gabriel Chandesris (2011)
 */
public class IntegrationActionListenerWeapons extends IntegrationActionListener {
	
	public static String[] MAIN_DOMAINS = {
		"GURPS Melee Weapons", 
		"GURPS Dist. Muscle Weapons", 
		"GURPS Dist. Energ. Weapons", 
	};
	private static final RPGDataFile[] TALENTS_FILES_SETS		= {
		RPGDataFile.getGURPSArmesMelee(), 
		RPGDataFile.getGURPSArmesDistMusc(), 
		RPGDataFile.getGURPSArmesDistEner(), 
	};

	public IntegrationActionListenerWeapons(boolean b, WeaponsPanel sp) {
		super(b, false, sp);
		this.setElement("Weapon");
		this.setMainDomains(IntegrationActionListenerWeapons.MAIN_DOMAINS);
		this.setTalentsFileSets(IntegrationActionListenerWeapons.TALENTS_FILES_SETS);
	}

}
