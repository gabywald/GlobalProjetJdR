package gabywald.rpg.view.panels;

import gabywald.rpg.controller.BarbarismScientificGeneratorActionListener;

/**
 * 
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2012)
 */
public class BarbarismScientificPanel extends RPGDataPanel {
	private static BarbarismScientificPanel instance;

	private BarbarismScientificPanel() {
		super(BarbarismScientificGeneratorActionListener.MAIN_DOMAINS, true);
		this.add(this.getApplyFirstButton(new BarbarismScientificGeneratorActionListener(true)));
		this.add(this.getApplySecondButton(new BarbarismScientificGeneratorActionListener(false)));
	}

	public static BarbarismScientificPanel getInstance() {
		if (BarbarismScientificPanel.instance == null) 
			{ BarbarismScientificPanel.instance = new BarbarismScientificPanel(); }
		return BarbarismScientificPanel.instance;
	}

	@Override
	public String getData() { return this.getContent(); }
}
