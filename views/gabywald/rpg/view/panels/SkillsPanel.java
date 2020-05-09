package gabywald.rpg.view.panels;

import gabywald.rpg.controller.IntegrationActionListenerSkills;

/**
 * 
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2011)
 */
public class SkillsPanel extends RPGDataPanel {
	private static SkillsPanel instance;
	
	private SkillsPanel() {
		super(IntegrationActionListenerSkills.MAIN_DOMAINS, false);
		this.add(this.getApplyFirstButton(new IntegrationActionListenerSkills(true, this)));
		this.add(this.getApplySecondButton(new IntegrationActionListenerSkills(false, this)));
	}

	public static SkillsPanel getInstance() {
		if (SkillsPanel.instance == null) 
			{ SkillsPanel.instance = new SkillsPanel(); }
		return SkillsPanel.instance;
	}
	
}
