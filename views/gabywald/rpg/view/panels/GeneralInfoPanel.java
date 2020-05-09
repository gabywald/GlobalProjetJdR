package gabywald.rpg.view.panels;

import gabywald.rpg.model.Personnae;

/**
 * 
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2011)
 */
public class GeneralInfoPanel extends RPGPersonnaeAnyPanel /** SpecificityPanel */ {
	private static GeneralInfoPanel instance;
	private static String[] TEXTS_FOR_LABELS = Personnae.GENERAL_ATTR_NAMES;

	private GeneralInfoPanel() {
		super(new String[][] { GeneralInfoPanel.TEXTS_FOR_LABELS }, 
			  new String[] { "General Informations" }, 
			  false, -1);
	}

	public static GeneralInfoPanel getInstance() {
		if (GeneralInfoPanel.instance == null) 
			{ GeneralInfoPanel.instance = new GeneralInfoPanel(); }
		return GeneralInfoPanel.instance;
	}

	@Override
	public void generateRandomData() { ; }
	
}
