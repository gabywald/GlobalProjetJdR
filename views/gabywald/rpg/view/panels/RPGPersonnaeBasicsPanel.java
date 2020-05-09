package gabywald.rpg.view.panels;

import gabywald.global.data.Utils;
import gabywald.rpg.model.PersonnaeOfBasics;
import gabywald.rpg.view.BuildPersonnaeFrame;

/**
 * 
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2011)
 */
public class RPGPersonnaeBasicsPanel extends RPGPersonnaeAnyPanel {
	private static RPGPersonnaeBasicsPanel instance;
	
	private static String[][] TEXTS_FOR_LABELS	= PersonnaeOfBasics.GENERAL_NAMES;
	private static String[] TEXTS_UPPER_LABELS	= 
		BuildPersonnaeFrame.confRPG.getValueOf("personnaeBasicsView").split(";");

	private RPGPersonnaeBasicsPanel() {
		super(RPGPersonnaeBasicsPanel.TEXTS_FOR_LABELS, 
			  RPGPersonnaeBasicsPanel.TEXTS_UPPER_LABELS, 
			  false, 0);
		this.setName("Basics");
		this.generateRandomData();
	}

	public static RPGPersonnaeBasicsPanel getInstance() {
		if (RPGPersonnaeBasicsPanel.instance == null) 
			{ RPGPersonnaeBasicsPanel.instance = new RPGPersonnaeBasicsPanel(); }
		return RPGPersonnaeBasicsPanel.instance;
	}
	
	@Override
	public void generateRandomData() {
		for (int i = 0 ; i < this.fields.length ; i++) 
			{ this.setFieldValueAt(i, Utils.randomValue(11) + 8); }
	}
	
}
