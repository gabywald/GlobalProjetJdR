package gabywald.global.view.dialog;

/**
 * 
 * @author Gabriel Chandesris (2011, 2026)
 */
public interface IGenericAskingDialog {
	public GenericAskingDialog getConfigureAndAddInstance(String name, String message, 
													      String[] choices, 
													      String[] valuesToChoose, 
													      String[][] subChoices);
	public GenericAskingDialog getConfigureAndAddInstance(String name, String message, 
													      String[] choices, 
													      String[] valuesToChoose);
	public GenericAskingDialog getRemovalInstance(String name, String message, 
			 									  String[] choices);
}
