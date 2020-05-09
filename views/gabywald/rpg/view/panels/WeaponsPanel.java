package gabywald.rpg.view.panels;

import gabywald.rpg.controller.IntegrationActionListenerWeapons;

/**
 * 
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2011)
 */
public class WeaponsPanel extends RPGDataPanel {
	private static WeaponsPanel instance;

	private WeaponsPanel() {
		super(IntegrationActionListenerWeapons.MAIN_DOMAINS, false);
		this.add(this.getApplyFirstButton(new IntegrationActionListenerWeapons(true, this)));
		this.add(this.getApplySecondButton(new IntegrationActionListenerWeapons(false, this)));
	}

	public static WeaponsPanel getInstance() {
		if (WeaponsPanel.instance == null) 
			{ WeaponsPanel.instance = new WeaponsPanel(); }
		return WeaponsPanel.instance;
	}
	
}
