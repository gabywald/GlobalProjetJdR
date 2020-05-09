package gabywald.rpg.model;

import gabywald.global.data.samples.RPGDataFile;

/**
 * Inheritant class to generate biographies for Cyber Age. 
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2011)
 */
public class BTCyberAge extends Biography {
	private static BTCyberAge instance;

	private BTCyberAge() 
		{ super(RPGDataFile.getCyberAgeBiography()); }

	public static BTCyberAge getInstance() {
		if (BTCyberAge.instance == null) 
			{ BTCyberAge.instance = new BTCyberAge(); }
		return BTCyberAge.instance;
	}

}
