package gabywald.rpg.controller;

import gabywald.global.controller.BooleanActionListener;
import gabywald.rpg.data.samples.RPGDataFile;
import gabywald.rpg.view.dialog.WeaponsAskingDialog;
import gabywald.rpg.view.panels.WeaponsPanel;

import java.awt.event.ActionEvent;

/**
 * 
 * @author Gabriel Chandesris (2011)
 * @deprecated ...
 */
public class OldIntegrationActionListenerWeapons extends BooleanActionListener {
	public static String[] MAIN_DOMAINS = {
		"GURPS Melee Weapons", 
		"GURPS Dist. Muscle Weapons", 
		"GURPS Dist. Energ. Weapons", 
	};
	private static final RPGDataFile[] TALENTS_FILES_SETS		= {
		RPGDataFile.getGURPSArmesMelee(), 
		RPGDataFile.getGURPSArmesDistMusc(), 
		RPGDataFile.getGURPSArmesDistEner(), 
	};

	public OldIntegrationActionListenerWeapons(boolean b)	{ super(b); }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (this.isAware) {
			int number				= WeaponsPanel.getInstance().getSelection();
			String choice			= OldIntegrationActionListenerWeapons.MAIN_DOMAINS[number];
			String nameOfDialog		= "Choice of a Weapon ("+choice+"). ";
			String messagDialog		= "Choose a Weapon ("+choice+") !";
			String[] completeWeapons	= null;
			String[] toShowerWeapons	= null;
			String[] valuesToWeapons	= null;
			if ( (number < OldIntegrationActionListenerWeapons.MAIN_DOMAINS.length) 
					&& (number >= 0) ) 
				{ completeWeapons	= OldIntegrationActionListenerWeapons
										.TALENTS_FILES_SETS[number].getTable(); }
			else { completeWeapons = null; }
			
			if (completeWeapons != null) {
				int sizeOfWeapons	= completeWeapons.length;
				toShowerWeapons		= new String[sizeOfWeapons];
				valuesToWeapons		= new String[sizeOfWeapons];
				
				for (int i = 0 ; i < sizeOfWeapons ; i++) {
					String[] splitter	= completeWeapons[i].split("\t");
					toShowerWeapons[i]	= splitter[0];
					valuesToWeapons[i]	= splitter[1];
				}
			}
			
			if ( (toShowerWeapons != null) && (toShowerWeapons.length > 0) ) {
				WeaponsAskingDialog dlg = WeaponsAskingDialog.getConfigureAndAddInstance
										(nameOfDialog, messagDialog, toShowerWeapons, valuesToWeapons);
				dlg.setVisible(true);
				if (dlg.getAnswer() == 0) {
					String WeaponName	= dlg.getMainChoice();
					String subWeaponName	= dlg.getSubbChoice();
					String WeaponValue	= dlg.getValue();
					String lineOfWeaponToAdd = WeaponName
								+((subWeaponName != null)?"\t(("+subWeaponName+")) ":"")
								+"\t["+WeaponValue+"]\n";
					WeaponsPanel.getInstance().addToContent(lineOfWeaponToAdd);
				}
			}
		} else {
			String[] content = WeaponsPanel.getInstance().getContent().split("\n");
			if ( (content.length > 0) && (!content[0].equals("")) ) {
				String[] nextContent = new String[content.length];
				for (int i = 0 ; i < nextContent.length ; i++) 
					{ nextContent[i] = content[i].split("\t")[0]; }
				
				WeaponsAskingDialog dlg = WeaponsAskingDialog.getRemovalInstance
										("Removing a Weapon. ", "Choose a Weapon to remove !", nextContent);
				dlg.setVisible(true);
				if (dlg.getAnswer() == 0) {
					int lineNumber = dlg.getMainChoiceAsInteger();
					WeaponsPanel.getInstance().removeLineOfContent(lineNumber);
				}
			} /** else { ; } */
		}
	}
}
