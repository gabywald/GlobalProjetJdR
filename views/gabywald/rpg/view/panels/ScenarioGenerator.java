package gabywald.rpg.view.panels;

import gabywald.rpg.controller.ScenarioGeneratorActionListener;
import gabywald.rpg.model.IdeesSousLesDes;

/**
 * 
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2011)
 */
public class ScenarioGenerator extends RPGDataPanel {
	private static ScenarioGenerator instance = null;
	
	private ScenarioGenerator() {
		super(IdeesSousLesDes.ENVIRONMENTS, true);
		this.add(this.getApplyFirstButton(new ScenarioGeneratorActionListener(true)));
		this.add(this.getApplySecondButton(new ScenarioGeneratorActionListener(false)));
	}

	public static ScenarioGenerator getInstance() {
		if (ScenarioGenerator.instance == null) 
			{ ScenarioGenerator.instance = new ScenarioGenerator(); }
		return ScenarioGenerator.instance;
	}
	
}
