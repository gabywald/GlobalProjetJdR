package gabywald.rpg.view.panels;

import gabywald.rpg.controller.BiographyGeneratorActionListener;

/**
 * 
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2011)
 */
public class BiographyPanel extends RPGDataPanel {
	private static BiographyPanel instance;

	private BiographyPanel() {
		super(BiographyGeneratorActionListener.MAIN_DOMAINS, true);
		this.add(this.getApplyFirstButton(new BiographyGeneratorActionListener(true)));
		this.add(this.getApplySecondButton(new BiographyGeneratorActionListener(false)));
	}

	public static BiographyPanel getInstance() {
		if (BiographyPanel.instance == null) 
			{ BiographyPanel.instance = new BiographyPanel(); }
		return BiographyPanel.instance;
	}

	@Override
	public String getData() { return this.getContent(); }
}
