package gabywald.rpg.view.panels;

import gabywald.global.view.PanelsFactory;
import gabywald.rpg.view.SpecificityPanel;

/**
 * Specific Panels Factory for RPG Swing GUI. 
 * <br><i>DPsingleton</i><br><i>DP(Abstract)Factory</i>
 * @author Gabriel Chandesris (2011)
 */
public class RPGPanelsFactory extends PanelsFactory {
	private static RPGPanelsFactory instance;

	private RPGPanelsFactory() { ; }

	public static RPGPanelsFactory getInstance() {
		if (RPGPanelsFactory.instance == null) 
			{ RPGPanelsFactory.instance = new RPGPanelsFactory(); }
		return RPGPanelsFactory.instance;
	}
	
	public SpecificityPanel getPanelWithName(String name) {
		SpecificityPanel toReturn = null;
		if (name.equals("Welcome")) 
			{ toReturn = WelcomePanel.getInstance(); }
		else if (name.equals("SimulacreS"))
			{ toReturn = RPGPersonnaeSimulacreSPanel.getInstance(); }
		else if (name.equals("Basics"))
			{ toReturn = RPGPersonnaeBasicsPanel.getInstance(); }
		else if (name.equals("GURPS"))
			{ toReturn = RPGPersonnaeGURPSPanel.getInstance(); }
		else if (name.equals("Skills"))
			{ toReturn = SkillsPanel.getInstance(); }
		else if (name.equals("Weapons"))
			{ toReturn = WeaponsPanel.getInstance(); }
		else if (name.equals("Equipment"))
			{ toReturn = EquipmentsPanel.getInstance(); }
		else if (name.equals("Special / Powers"))
			{ toReturn = SpecialPanel.getInstance(); }
		else if (name.equals("Biography"))
			{ toReturn = BiographyPanel.getInstance(); }
		else if (name.equals("General Informations"))
			{ toReturn = GeneralInfoPanel.getInstance(); }
		else if (name.equals("Scenario"))
			{ toReturn = ScenarioGenerator.getInstance(); }
		else if (name.equals("RetroFutur"))
			{ toReturn = RetroFuturPanel.getInstance(); }
		else if (name.equals("Engines Failures"))
			{ toReturn = BarbarismScientificPanel.getInstance(); }
		else if (name.equals("CyberAge"))
			{ toReturn = RPGPersonnaeCyberAgePanel.getInstance(); }
		return toReturn;
	}
}
