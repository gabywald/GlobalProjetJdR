package gabywald.rpg.view.dialog;

import gabywald.global.view.dialog.GenericAskingDialog;
import gabywald.rpg.view.BuildPersonnaeFrame;

/**
 * Double implementation of dialog for Skills. 
 * <br><i>Doubleton ("double singleton")</i>
 * @author Gabriel Chandesris (2011)
 * @deprecated ...
 */
public class SkillsAskingDialog extends GenericAskingDialog {
	private static final String FIRST_SET_LABEL		= "Skill Name : ";
	private static final String SECOND_SET_LABEL	= "Sub-Choice : ";
	private static final String VALUE_LABEL			= "Skill Value";
	/** Current instances of SkillAskingDialog. */
	private static SkillsAskingDialog configureAndAdd, removal;

	private SkillsAskingDialog(String name, String message, 
							   String[] skills, 
							   String[] valuesToSkills, 
							   String[][] subSkills) 
		{ super(name, message, skills, valuesToSkills, subSkills, 
				SkillsAskingDialog.FIRST_SET_LABEL, 
				SkillsAskingDialog.SECOND_SET_LABEL, 
				SkillsAskingDialog.VALUE_LABEL, 
				BuildPersonnaeFrame.getInstance()); }
	
	private SkillsAskingDialog(String name, String message, 
							   String[] skills) 
		{ super(name, message, skills, SkillsAskingDialog.FIRST_SET_LABEL, 
				BuildPersonnaeFrame.getInstance()); }
	
	
	public static SkillsAskingDialog getConfigureAndAddInstance(String name, String message, 
															    String[] skills, 
															    String[] valuesToSkills, 
															    String[][] subSkills) {
		SkillsAskingDialog.configureAndAdd = new SkillsAskingDialog
			(name, message, skills, valuesToSkills, subSkills);
		return SkillsAskingDialog.configureAndAdd;
	}
	
	public static SkillsAskingDialog getConfigureAndAddInstance() 
		{ return SkillsAskingDialog.configureAndAdd; }
	
	public static SkillsAskingDialog getRemovalInstance(String name, String message, 
													    String[] skills) {
		SkillsAskingDialog.removal = new SkillsAskingDialog
			(name, message, skills);
		return SkillsAskingDialog.removal;
	}
	
	public static SkillsAskingDialog getRemovalInstance() 
		{ return SkillsAskingDialog.removal; }
	
}
