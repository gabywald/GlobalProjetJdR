package gabywald.global.dialog.controller;

import gabywald.global.view.dialog.GenericAskingDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenericSelectActionListener implements ActionListener {
	private GenericAskingDialog gad;
	private String[] values;
	private String[][] subChoices;
	
	public GenericSelectActionListener(GenericAskingDialog gad, 
									   String[] valuesToChoose, 
									   String[][] subChoices) { 
		this.gad		= gad;
		this.values		= valuesToChoose;
		this.subChoices	= subChoices;
	}
	
	public GenericSelectActionListener(GenericAskingDialog gad, 
									   String[] valuesToChoose) { 
		this.gad		= gad;
		this.values		= valuesToChoose;
		this.subChoices	= null;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		int choice = this.gad.getMainChoiceAsInteger();
		this.gad.setValue(this.values[choice]);
		if (this.subChoices != null) 
			{ this.gad.setSubChoices(this.subChoices[choice]); }
	}

}
