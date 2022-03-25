package gabywald.rpg.view.panels;

import gabywald.global.data.StringUtils;
import gabywald.rpg.model.PersonnaeOfCyberAge;
import gabywald.rpg.view.BuildPersonnaeFrame;

/**
 * 
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2015, 2022)
 */
@SuppressWarnings("serial")
public class RPGPersonnaeCyberAgePanel extends RPGPersonnaeAnyPanel {
	private static RPGPersonnaeCyberAgePanel instance;
	
	private static String[][] TEXTS_FOR_LABELS	= PersonnaeOfCyberAge.GENERAL_NAMES;
	private static String[] TEXTS_UPPER_LABELS	= 
		BuildPersonnaeFrame.confRPG.getValueOf("personnaeCyberAgeView").split(";");

	private RPGPersonnaeCyberAgePanel() {
		super(RPGPersonnaeCyberAgePanel.TEXTS_FOR_LABELS, 
			  RPGPersonnaeCyberAgePanel.TEXTS_UPPER_LABELS, 
			  false, -1);
		this.setName("Basics -- CyberAge");
		this.generateRandomData();
	}

	public static RPGPersonnaeCyberAgePanel getInstance() {
		if (RPGPersonnaeCyberAgePanel.instance == null) 
			{ RPGPersonnaeCyberAgePanel.instance = new RPGPersonnaeCyberAgePanel(); }
		return RPGPersonnaeCyberAgePanel.instance;
	}
	
	@Override
	public void generateRandomData() {
		for (int i = 0 ; (i < this.fields.length) && (i < 8) ; i++) 
			{ this.setFieldValueAt(i, StringUtils.randomValue(11) + 8); }
	}

}
