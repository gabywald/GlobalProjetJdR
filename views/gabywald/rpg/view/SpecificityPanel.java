package gabywald.rpg.view;

import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * A general abstract 'mother' class to build Personnae datas, attributes...
 * @author Gabriel Chandesris (2011)
 * @see gabywald.rpg.view.panels.RPGPersonnaeAnyPanel
 * @see gabywald.rpg.view.panels.RPGDataPanel
 * @see gabywald.rpg.view.panels.WelcomePanel
 */
public abstract class SpecificityPanel extends JPanel {
	private static final String[] CRITERIAS_NAMES = {
		"scenarioGeneratorScrollPosX", 			/** 00 */
		"scenarioGeneratorScrollPosY", 			/** 01 */
		"scenarioGeneratorScrollWidth", 		/** 02 */
		"scenarioGeneratorScrollHeight", 		/** 03 */
		"scenarioGeneratorGenericPosY", 		/** 04 */
		"scenarioGeneratorGenericHeight", 		/** 05 */
		"scenarioGeneratorButtonWidth", 		/** 06 */
		"scenarioGeneratorSelectorWidth", 		/** 07 */
		"scenarioGeneratorNumberLinesWidth", 	/** 08 */
		"scenarioGeneratorButtonPosX", 			/** 09 */
		"scenarioGeneratorNumberLinesPosX", 	/** 10 */
	};
	/** Some criterias for positionning. */
	protected int[] criterias;
	
	/**
	 * Default Constructor (Layout is <i>null</i>). 
	 */
	protected SpecificityPanel() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(
				BuildPersonnaeFrame.WIDTH-BuildPersonnaeFrame.WIDTH_EAST, 
				BuildPersonnaeFrame.HEIGHT));
		
		this.criterias = new int[SpecificityPanel.CRITERIAS_NAMES.length];
		for (int i = 0 ; i < SpecificityPanel.CRITERIAS_NAMES.length ; i++) 
			{ this.criterias[i] = Integer.parseInt(BuildPersonnaeFrame.confRPG
								.getValueOf(SpecificityPanel.CRITERIAS_NAMES[i])); }
	}
	
	/**
	 * To get pieces of informations stored in this Panel. 
	 * @return (String)
	 */
	public abstract String getData();
	
	/**
	 * To put pieces of informations into this Panel. 
	 * @param content
	 */
	public abstract void setData(String content);
}
