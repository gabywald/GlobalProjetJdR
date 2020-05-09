package gabywald.rpg.controller;

import gabywald.global.controller.BooleanActionListener;
import gabywald.global.data.samples.RPGDataFile;
import gabywald.rpg.view.dialog.SkillsAskingDialog;
import gabywald.rpg.view.panels.SkillsPanel;

import java.awt.event.ActionEvent;

/**
 * 
 * @author Gabriel Chandesris (2011)
 * @deprecated ...
 */
public class OldIntegrationActionListenerSkills extends BooleanActionListener {
	public static String[] MAIN_DOMAINS = {
		"SimulacreS Generic", 
		"CyberAge (SimulacreS)", 
		"GURPS Generic", 
	};
	private static final RPGDataFile[] TALENTS_FILES_SETS		= {
		RPGDataFile.getSimulacreSTalents(), 	/** SimulacreS Generic */
		RPGDataFile.getCyberAgeTalents(), 		/** SimulacreS Cyber Age */
		RPGDataFile.getGURPSTalents(), 			/** GURPS Generic */
	};
	
	public OldIntegrationActionListenerSkills(boolean b) { super(b); }

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (this.isAware) {
			int number				= SkillsPanel.getInstance().getSelection();
			String choice			= OldIntegrationActionListenerSkills.MAIN_DOMAINS[number];
			String nameOfDialog		= "Choice of a Skill ("+choice+"). ";
			String messagDialog		= "Choose a Skill ("+choice+") !";
			String[] completeSkills	= null;
			String[] toShowerSkills	= null;
			String[] valuesToSkills	= null;
			String[][] subChoices	= null;
			if ( (number < OldIntegrationActionListenerSkills.MAIN_DOMAINS.length) 
					&& (number >= 0) ) 
				{ completeSkills	= OldIntegrationActionListenerSkills
									.TALENTS_FILES_SETS[number].getTable(); }
			else { completeSkills = null; }
			
			if (completeSkills != null) {
				int sizeOfSkills	= completeSkills.length;
				toShowerSkills		= new String[sizeOfSkills];
				valuesToSkills		= new String[sizeOfSkills];
				subChoices			= new String[sizeOfSkills][];
				
				for (int i = 0 ; i < sizeOfSkills ; i++) {
					String[] splitter = completeSkills[i].split("\t");
					toShowerSkills[i] = splitter[0];
					valuesToSkills[i] = splitter[1];
					if ( (splitter.length >= 3) && (splitter[2] != null) ) 
						{ subChoices[i]	= splitter[2].substring(1, 
									splitter[2].length()-1).split(";"); }
				}
			}
			
			if ( (toShowerSkills != null) && (toShowerSkills.length > 0) ) {
				SkillsAskingDialog dlg = SkillsAskingDialog.getConfigureAndAddInstance
										(nameOfDialog, messagDialog, toShowerSkills, valuesToSkills, subChoices);
				dlg.setVisible(true);
				if (dlg.getAnswer() == 0) {
					String skillName	= dlg.getMainChoice();
					String subSkillName	= dlg.getSubbChoice();
					String skillValue	= dlg.getValue();
					String lineOfSkillToAdd = skillName
								+((subSkillName != null)?"\t(("+subSkillName+")) ":"")
								+"\t["+skillValue+"]\n";
					SkillsPanel.getInstance().addToContent(lineOfSkillToAdd);
				}
			}
		} else {
			String[] content = SkillsPanel.getInstance().getContent().split("\n");
			if ( (content.length > 0) && (!content[0].equals("")) ) {
				String[] nextContent = new String[content.length];
				for (int i = 0 ; i < nextContent.length ; i++) 
					{ nextContent[i] = content[i].split("\t")[0]; }
				
				SkillsAskingDialog dlg = SkillsAskingDialog.getRemovalInstance
										("Removing a Skill. ", "Choose a Skill to remove !", nextContent);
				dlg.setVisible(true);
				if (dlg.getAnswer() == 0) {
					int lineNumber = dlg.getMainChoiceAsInteger();
					SkillsPanel.getInstance().removeLineOfContent(lineNumber);
				}
			} /** else { ; } */
		}
	}

}
