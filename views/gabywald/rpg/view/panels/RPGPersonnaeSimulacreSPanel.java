package gabywald.rpg.view.panels;

import gabywald.global.data.StringUtils;
import gabywald.rpg.model.PersonnaeOfSimulacreS;
import gabywald.rpg.view.BuildPersonnaeFrame;

/**
 * 
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2011, 2022)
 */
@SuppressWarnings("serial")
public class RPGPersonnaeSimulacreSPanel extends RPGPersonnaeAnyPanel {
	private static RPGPersonnaeSimulacreSPanel instance;
	
	private static String[][] TEXTS_FOR_LABELS	= PersonnaeOfSimulacreS.GENERAL_NAMES;
	private static String[] TEXTS_UPPER_LABELS	= 
		BuildPersonnaeFrame.confRPG.getValueOf("personnaeSimulacreSView").split(";");

	private RPGPersonnaeSimulacreSPanel() {
		super(RPGPersonnaeSimulacreSPanel.TEXTS_FOR_LABELS, 
			  RPGPersonnaeSimulacreSPanel.TEXTS_UPPER_LABELS, 
			  true, 2);
		this.setName("SimulacreS");
		this.generateRandomData();
		/** Disable convertion to 'GURPS'. */
		this.convertAndRecord[1].setEnabled(false);
	}

	public static RPGPersonnaeSimulacreSPanel getInstance() {
		if (RPGPersonnaeSimulacreSPanel.instance == null) 
			{ RPGPersonnaeSimulacreSPanel.instance = new RPGPersonnaeSimulacreSPanel(); }
		return RPGPersonnaeSimulacreSPanel.instance;
	}
	
	@Override
	public void generateRandomData() {
		/** SimulacreS (alternate) : Composantes [3-6 points each ; total of 18] */
		int total = 18;int sum = 0;int[] compTable = new int[4];
		while (sum != total) {
			sum = 0;
			for (int i = 0 ; i < compTable.length ; i++) {
				int value		= StringUtils.randomValue(4) + 3;
				compTable[i]	= value;
				sum				+= value;
			}
		}
		/** SimulacreS (alternate) : Moyens [0-4 points each ; total of 10] */
		total = 10;sum = 0;int[] moyeTable = new int[4];
		while (sum != total) {
			sum = 0;
			for (int i = 0 ; i < moyeTable.length ; i++) {
				int value		= StringUtils.randomValue(5);
				moyeTable[i]	= value;
				sum				+= value;
			}
		}
		/** SimulacreS (alternate) : Domaines [0-2 points each ; total of 7 for domaines and energies] */
		/** SimulacreS (alternate) : Energies [0-2 points each ; total of 7 for domaines and energies] ; !! max for 'Pouvoir' is 1 !! */
		boolean pouvoir = (StringUtils.randomValue(100)%3 == 0);
		total = 10;sum = 0;int[] doenTable = new int[10];
		int[] specTable = new int[4];
		if (pouvoir) { 
			total--;
			doenTable[9] = 1;
			int which = StringUtils.randomValue(specTable.length);
			for (int i = 0 ; i < specTable.length ; i++) {
				if (i == which) { specTable[i] = 5; }
				else { specTable[i] = 0; }
			}
		}
		while (sum != total) {
			sum = 0;
			for (int i = 0 ; i < doenTable.length-1 ; i++) {
				int value		= StringUtils.randomValue(3);
				doenTable[i]	= value;
				sum				+= value;
			}
		}
		
		/** Putting values in GUI... */
		for (int i = 0 ; i < this.fields.length ; i++) {
			int compLen = compTable.length;
			int moyeLen = moyeTable.length;
			int doenLen = doenTable.length;
			int specLen = specTable.length;
			
			int firstStep = 000000000 + compLen;
			int seconStep = firstStep + moyeLen;
			int thirdStep = seconStep + doenLen;
			int forthStep = thirdStep + specLen;
			
			if (i < firstStep) 
				{ this.setFieldValueAt(i, compTable[i]); }
			else if (i < seconStep) 
				{ this.setFieldValueAt(i, moyeTable[i-firstStep /**compLen*/]); } 
			else if (i < thirdStep) 
				{ this.setFieldValueAt(i, doenTable[i-seconStep/**compLen-moyeLen*/]); }
			else if (i < forthStep) 
				{ this.setFieldValueAt(i, specTable[i-thirdStep/**compLen-moyeLen-doenLen*/]); }
			else { this.setFieldValueAt(i, 4); }
		} /** END 'for (int i = 0 ; i < this.fields.length ; i++)' */
	
	}
	
}
