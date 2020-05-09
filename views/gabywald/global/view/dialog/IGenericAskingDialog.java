package gabywald.global.view.dialog;

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
