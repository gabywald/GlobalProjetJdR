package gabywald.rpg.controller;

import java.awt.event.ActionEvent;

import gabywald.global.controller.BooleanActionListener;
import gabywald.global.view.dialog.GenericAskingDialog;
import gabywald.rpg.data.samples.RPGDataFile;
import gabywald.rpg.view.BuildPersonnaeFrame;
import gabywald.rpg.view.panels.RPGDataPanel;

/**
 * 
 * @author Gabriel Chandesris (2011)
 */
public abstract class IntegrationActionListener extends BooleanActionListener {
	private RPGDataPanel spInstance;
	private String[] mainDomains;
	private RPGDataFile[] talentsFileSets;
	private String elementOfMsgTitle;
	private boolean isMore;
	private int specific;
	private GenericAskingDialog dlgOfAdding	= null, dlgOfRemove	= null;
	
	public IntegrationActionListener(boolean b, boolean m, 
									 RPGDataPanel sp) { 
		super(b);
		this.isMore		= m;
		this.spInstance	= sp;
		this.initSpecificities();
	}
	
	private void initSpecificities()  {
		this.mainDomains		= new String[0];
		this.talentsFileSets	= new RPGDataFile[0];
		this.elementOfMsgTitle	= "Element";
		this.specific			= -1;
	}
	
	protected void setMainDomains(String[] mains) 
		{ this.mainDomains = mains; }
	
	protected void setTalentsFileSets(RPGDataFile[] files)
		{ this.talentsFileSets = files; }
	
	protected void setElement(String elt) 
		{ this.elementOfMsgTitle = elt; }
	
	protected void setSpecificSelection(int spe) 
		{ this.specific = spe; }
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if (this.spInstance == null) { return; }
		
		if (this.isAware) {
			int number				= this.spInstance.getSelection();
			String choice			= this.mainDomains[number];
			String nameOfDialog		= "Choice of a "+this.elementOfMsgTitle+" ("+choice+"). ";
			String messagDialog		= "Choose a "+this.elementOfMsgTitle+" ("+choice+") !";
			
			String[] completeElements	= null;
			String[] toShowerElements	= null;
			String[] valuesToElements	= null;
			String[][] subChoices		= null;
			if ( (number < this.mainDomains.length) 
					&& (number >= 0) ) 
				{ completeElements	= this.talentsFileSets[number].getTable(); }
			else { completeElements = null; }
			
			if (completeElements != null) {
				int sizeOfElements	= completeElements.length;
				toShowerElements	= new String[sizeOfElements];
				valuesToElements	= new String[sizeOfElements];
				if (this.isMore) 
					{ subChoices	= new String[sizeOfElements][]; }
				
				for (int i = 0 ; i < sizeOfElements ; i++) {
					String[] splitter	= completeElements[i].split("\t");
					if ( (this.specific == -1) || (this.specific != number) ) {
						toShowerElements[i]	= splitter[0];
						valuesToElements[i]	= splitter[1];
						if (this.isMore) {
							if ( (splitter.length >= 3) && (splitter[2] != null) ) 
								{ subChoices[i]	= splitter[2].substring(1, 
													splitter[2].length()-1).split(";"); }
						}
					} else if (this.specific == number) { 
						toShowerElements[i]	= splitter[0]+" ("+splitter[6]+")";
						valuesToElements[i]	= splitter[1]+" MU : ("+splitter[3]+")";
					}
				}
			}
			
			if ( (toShowerElements != null) && (toShowerElements.length > 0) ) {
				String firstSetLabel	= this.elementOfMsgTitle+" Name : ";
				String secondSetLabel	= "Sub-Choice : ";
				String valueLabel		= this.elementOfMsgTitle+" Value";
				if (this.isMore) { 
					this.dlgOfAdding = GenericAskingDialog.getConfigureAndAddInstance
						(nameOfDialog, messagDialog, toShowerElements, valuesToElements, subChoices, 
								firstSetLabel, secondSetLabel, valueLabel, BuildPersonnaeFrame.getInstance());
				} else { 
					this.dlgOfAdding = GenericAskingDialog.getConfigureAndAddInstance
						(nameOfDialog, messagDialog, toShowerElements, valuesToElements, 
								firstSetLabel, valueLabel, BuildPersonnaeFrame.getInstance());
				}
				this.dlgOfAdding.setVisible(true);
				if (this.dlgOfAdding.getAnswer() == 0) {	
					String ElementName			= this.dlgOfAdding.getMainChoice();
					String subElementName		= this.dlgOfAdding.getSubbChoice();
					String ElementValue			= this.dlgOfAdding.getValue();
					String lineOfElementToAdd	= ElementName
								+((subElementName != null)?"\t(("+subElementName+")) ":"")
								+"\t["+ElementValue+"]\n";
					this.spInstance.addToContent(lineOfElementToAdd);
				}
			}
		} else {
			String[] content = this.spInstance.getContent().split("\n");
			if ( (content.length > 0) && (!content[0].equals("")) ) {
				String[] nextContent = new String[content.length];
				for (int i = 0 ; i < nextContent.length ; i++) 
					{ nextContent[i] = content[i].split("\t")[0]; }
				
				String valueLabel	= this.elementOfMsgTitle+" Value";
				this.dlgOfRemove 	= GenericAskingDialog.getRemovalInstance
										("Removing a "+this.elementOfMsgTitle+". ", 
										 "Choose a "+this.elementOfMsgTitle+" to remove !", 
										 nextContent, valueLabel, BuildPersonnaeFrame.getInstance());
				this.dlgOfRemove.setVisible(true);
				if (this.dlgOfRemove.getAnswer() == 0) {
					int lineNumber = this.dlgOfRemove.getMainChoiceAsInteger();
					this.spInstance.removeLineOfContent(lineNumber);
				}
			} /** else { ; } */
		}

	}

}
