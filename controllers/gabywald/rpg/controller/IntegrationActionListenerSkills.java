package gabywald.rpg.controller;

import gabywald.global.data.samples.RPGDataFile;
import gabywald.rpg.view.panels.SkillsPanel;

/**
 * 
 * @author Gabriel Chandesris (2011)
 */
public class IntegrationActionListenerSkills extends IntegrationActionListener {
	
	public static String[] MAIN_DOMAINS = {
		"SimulacreS Generic", 
		"CyberAge (SimulacreS)", 
		"GURPS Generic", 
	};
	private static final RPGDataFile[] TALENTS_FILES_SETS		= {
		RPGDataFile.getSimulacreSTalents(), 	/** SimulacreS Generic */
		RPGDataFile.getCyberAgeTalents(), 		/** SimulacreS Cyber Age */
		RPGDataFile.getGURPSTalents(), 			/** GURPS Generic */
	};
	
	public IntegrationActionListenerSkills(boolean b, SkillsPanel sp) {
		super(b, true, sp);
		this.setElement("Skills");
		this.setMainDomains(IntegrationActionListenerSkills.MAIN_DOMAINS);
		this.setTalentsFileSets(IntegrationActionListenerSkills.TALENTS_FILES_SETS);
	}
}
