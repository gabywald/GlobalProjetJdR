package gabywald.rpg.view.dialog;

import gabywald.global.view.dialog.GenericAskingDialog;
import gabywald.rpg.view.BuildPersonnaeFrame;

/**
 * Double implementation of dialog for Weapons. 
 * <br><i>Doubleton ("double singleton")</i>
 * @author Gabriel Chandesris (2011)
 * @deprecated ...
 */
public class WeaponsAskingDialog extends GenericAskingDialog {
	private static final String FIRST_SET_LABEL		= "Weapon Name : ";
	private static final String VALUE_LABEL			= "Weapon Value";
	/** Current instances of WeaponAskingDialog. */
	private static WeaponsAskingDialog configureAndAdd, removal;

	private WeaponsAskingDialog(String name, String message, 
							    String[] weapons, 
							    String[] valuesToWeapons) 
		{ super(name, message, weapons, valuesToWeapons, 
				WeaponsAskingDialog.FIRST_SET_LABEL, 
				WeaponsAskingDialog.VALUE_LABEL, 
				BuildPersonnaeFrame.getInstance()); }
	
	private WeaponsAskingDialog(String name, String message, 
							   String[] weapons) 
		{ super(name, message, weapons, WeaponsAskingDialog.FIRST_SET_LABEL, 
				BuildPersonnaeFrame.getInstance()); }
	
	
	public static WeaponsAskingDialog getConfigureAndAddInstance(String name, String message, 
															     String[] weapons, 
															     String[] valuesToWeapons) {
		WeaponsAskingDialog.configureAndAdd = new WeaponsAskingDialog
			(name, message, weapons, valuesToWeapons);
		return WeaponsAskingDialog.configureAndAdd;
	}
	
	public static WeaponsAskingDialog getConfigureAndAddInstance() 
		{ return WeaponsAskingDialog.configureAndAdd; }
	
	public static WeaponsAskingDialog getRemovalInstance(String name, String message, 
													     String[] Weapons) {
		WeaponsAskingDialog.removal = new WeaponsAskingDialog
			(name, message, Weapons);
		return WeaponsAskingDialog.removal;
	}
	
	public static WeaponsAskingDialog getRemovalInstance() 
		{ return WeaponsAskingDialog.removal; }
	
}
