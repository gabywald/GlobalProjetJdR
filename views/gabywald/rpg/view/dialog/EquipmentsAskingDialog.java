package gabywald.rpg.view.dialog;

import gabywald.global.view.dialog.GenericAskingDialog;
import gabywald.rpg.view.BuildPersonnaeFrame;

/**
 * Double implementation of dialog for Equipments. 
 * <br><i>Doubleton ("double singleton")</i>
 * @author Gabriel Chandesris (2011)
 * @deprecated ...
 */
public class EquipmentsAskingDialog extends GenericAskingDialog {
	private static final String FIRST_SET_LABEL		= "Shipment Name : ";
	private static final String VALUE_LABEL			= "Shipment Value";
	/** Current instances of WeaponAskingDialog. */
	private static EquipmentsAskingDialog configureAndAdd, removal;

	private EquipmentsAskingDialog(String name, String message, 
								   String[] equipments, 
								   String[] valuesToEquipments) 
		{ super(name, message, equipments, valuesToEquipments, 
				EquipmentsAskingDialog.FIRST_SET_LABEL, 
				EquipmentsAskingDialog.VALUE_LABEL, 
				BuildPersonnaeFrame.getInstance()); }
	
	private EquipmentsAskingDialog(String name, String message, 
							   String[] weapons) 
		{ super(name, message, weapons, EquipmentsAskingDialog.FIRST_SET_LABEL, 
				BuildPersonnaeFrame.getInstance()); }
	
	
	public static EquipmentsAskingDialog getConfigureAndAddInstance(String name, String message, 
															    String[] equipments, 
															    String[] valuesToEquipments) {
		EquipmentsAskingDialog.configureAndAdd = new EquipmentsAskingDialog
			(name, message, equipments, valuesToEquipments);
		return EquipmentsAskingDialog.configureAndAdd;
	}
	
	public static EquipmentsAskingDialog getConfigureAndAddInstance() 
		{ return EquipmentsAskingDialog.configureAndAdd; }
	
	public static EquipmentsAskingDialog getRemovalInstance(String name, String message, 
													    	String[] equipments) {
		EquipmentsAskingDialog.removal = new EquipmentsAskingDialog
			(name, message, equipments);
		return EquipmentsAskingDialog.removal;
	}
	
	public static EquipmentsAskingDialog getRemovalInstance() 
		{ return EquipmentsAskingDialog.removal; }
	
}
