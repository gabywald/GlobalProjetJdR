package gabywald.rpg.view.panels;

import gabywald.rpg.controller.IntegrationActionListenerSpecial;

/**
 * 
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2011)
 */
public class SpecialPanel extends RPGDataPanel {
	private static SpecialPanel instance;

	private SpecialPanel() {
		super(IntegrationActionListenerSpecial.MAIN_DOMAINS, false);
		this.add(this.getApplyFirstButton(new IntegrationActionListenerSpecial(true, this)));
		this.add(this.getApplySecondButton(new IntegrationActionListenerSpecial(false, this)));
	}

	public static SpecialPanel getInstance() {
		if (SpecialPanel.instance == null) 
			{ SpecialPanel.instance = new SpecialPanel(); }
		return SpecialPanel.instance;
	}
	
}
