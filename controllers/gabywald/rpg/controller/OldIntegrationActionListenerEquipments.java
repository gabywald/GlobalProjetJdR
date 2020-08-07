package gabywald.rpg.controller;

import java.awt.event.ActionEvent;

import gabywald.global.controller.BooleanActionListener;
import gabywald.rpg.data.samples.RPGDataFile;
import gabywald.rpg.view.dialog.EquipmentsAskingDialog;
import gabywald.rpg.view.panels.EquipmentsPanel;

/**
 * 
 * @author Gabriel Chandesris (2011)
 * @deprecated ...
 */
public class OldIntegrationActionListenerEquipments extends BooleanActionListener {
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
	
	public OldIntegrationActionListenerEquipments(boolean b) { super(b); }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (this.isAware) {
			int number				= EquipmentsPanel.getInstance().getSelection();
			String choice			= OldIntegrationActionListenerEquipments.MAIN_DOMAINS[number];
			String nameOfDialog		= "Choice of a Shipment ("+choice+"). ";
			String messagDialog		= "Choose a Shipment ("+choice+") !";
			String[] completeEquipments	= null;
			String[] toShowerEquipments	= null;
			String[] valuesToEquipments	= null;
			if ( (number < OldIntegrationActionListenerEquipments.MAIN_DOMAINS.length) 
					&& (number >= 0) ) 
				{ completeEquipments	= OldIntegrationActionListenerEquipments
											.TALENTS_FILES_SETS[number].getTable(); }
			else { completeEquipments = null; }
			
			if (completeEquipments != null) {
				int sizeOfEquipments	= completeEquipments.length;
				toShowerEquipments		= new String[sizeOfEquipments];
				valuesToEquipments		= new String[sizeOfEquipments];
				
				for (int i = 0 ; i < sizeOfEquipments ; i++) {
					String[] splitter	= completeEquipments[i].split("\t");
					if (number == 4) {
						toShowerEquipments[i]	= splitter[0]+" ("+splitter[6]+")";
						valuesToEquipments[i]	= splitter[1]+" MU : ("+splitter[3]+")";
					} else {
						toShowerEquipments[i]	= splitter[0];
						valuesToEquipments[i]	= splitter[1];
					}
				}
			}
			
			if ( (toShowerEquipments != null) && (toShowerEquipments.length > 0) ) {
				EquipmentsAskingDialog dlg = EquipmentsAskingDialog.getConfigureAndAddInstance
										(nameOfDialog, messagDialog, toShowerEquipments, valuesToEquipments);
				dlg.setVisible(true);
				if (dlg.getAnswer() == 0) {
					String EquipmentName	= dlg.getMainChoice();
					String subEquipmentName	= dlg.getSubbChoice();
					String EquipmentValue	= dlg.getValue();
					String lineOfEquipmentToAdd = EquipmentName
								+((subEquipmentName != null)?"\t(("+subEquipmentName+")) ":"")
								+"\t["+EquipmentValue+"]\n";
					EquipmentsPanel.getInstance().addToContent(lineOfEquipmentToAdd);
				}
			}
		} else {
			String[] content = EquipmentsPanel.getInstance().getContent().split("\n");
			if ( (content.length > 0) && (!content[0].equals("")) ) {
				String[] nextContent = new String[content.length];
				for (int i = 0 ; i < nextContent.length ; i++) 
					{ nextContent[i] = content[i].split("\t")[0]; }
				
				EquipmentsAskingDialog dlg = EquipmentsAskingDialog.getRemovalInstance
										("Removing a Shipment. ", "Choose a Shipment to remove !", nextContent);
				dlg.setVisible(true);
				if (dlg.getAnswer() == 0) {
					int lineNumber = dlg.getMainChoiceAsInteger();
					EquipmentsPanel.getInstance().removeLineOfContent(lineNumber);
				}
			} /** else { ; } */
		}

	}

}
