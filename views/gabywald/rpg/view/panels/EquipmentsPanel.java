package gabywald.rpg.view.panels;

import gabywald.rpg.controller.IntegrationActionListenerEquipments;

/**
 * 
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2011)
 */
public class EquipmentsPanel extends RPGDataPanel {
	private static EquipmentsPanel instance;

	private EquipmentsPanel() {
		super(IntegrationActionListenerEquipments.MAIN_DOMAINS, false);
		this.add(this.getApplyFirstButton(new IntegrationActionListenerEquipments(true, this)));
		this.add(this.getApplySecondButton(new IntegrationActionListenerEquipments(false, this)));
	}

	public static EquipmentsPanel getInstance() {
		if (EquipmentsPanel.instance == null) 
			{ EquipmentsPanel.instance = new EquipmentsPanel(); }
		return EquipmentsPanel.instance;
	}
	
	@Override
	public String getData() { return this.getContent(); }
}
