package gabywald.rpg.controller;

import gabywald.rpg.data.samples.RPGDataFile;
import gabywald.rpg.view.panels.EquipmentsPanel;

/**
 * 
 * @author Gabriel Chandesris (2011)
 */
public class IntegrationActionListenerEquipments extends IntegrationActionListener {

	public static String[] MAIN_DOMAINS = {
		"Protections (SimulacreS)", 
		"Magiques (SimulacreS)", 
		"Hardware (CyberAge)", 
		"Software (CyberAge)",
		"Software (CyberPunk 2020)", 
	};
	private static final RPGDataFile[] TALENTS_FILES_SETS		= {
		RPGDataFile.getSimulacreSProtections(), 
		RPGDataFile.getSimulacreSMagiques(), 
		RPGDataFile.getCyberAgeHardware(), 
		RPGDataFile.getCyberAgeSoftware(), 
		RPGDataFile.getGURPSCyberSoftware(), 
	};
	
	public IntegrationActionListenerEquipments(boolean b, EquipmentsPanel sp) {
		super(b, false, sp);
		this.setElement("Shipment");
		this.setMainDomains(IntegrationActionListenerEquipments.MAIN_DOMAINS);
		this.setTalentsFileSets(IntegrationActionListenerEquipments.TALENTS_FILES_SETS);
		this.setSpecificSelection(4);
	}
	
}
