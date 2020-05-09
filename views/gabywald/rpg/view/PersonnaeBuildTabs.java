package gabywald.rpg.view;

import gabywald.global.view.DataBasesTabbedPanel;
import gabywald.rpg.view.panels.RPGPanelsFactory;

/**
 * 
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2011)
 */
public class PersonnaeBuildTabs extends DataBasesTabbedPanel {
	private static final String[] DATABASES_NAMES = 
		BuildPersonnaeFrame.confRPG.getValueOf("tabsPanelsTitles").split(";");
	/** { 
		"Welcome",		"General Informations", "Biography",	
		"SimulacreS",	"Basic",		"GURPS",		
		"Skills",		"Weapons", 		"Equipment",	"Special / Powers", 	
		"Scenario"
	}; */
	
	private static PersonnaeBuildTabs instance;

	private PersonnaeBuildTabs() 
		{ super(PersonnaeBuildTabs.DATABASES_NAMES, RPGPanelsFactory.getInstance()); }

	public static PersonnaeBuildTabs getInstance() {
		if (PersonnaeBuildTabs.instance == null) 
			{ PersonnaeBuildTabs.instance = new PersonnaeBuildTabs(); }
		return PersonnaeBuildTabs.instance;
	}
}