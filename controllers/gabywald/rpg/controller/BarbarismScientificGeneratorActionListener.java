package gabywald.rpg.controller;

import java.awt.event.ActionEvent;

import gabywald.global.controller.BooleanActionListener;
import gabywald.rpg.model.BarbarismScientific;
import gabywald.rpg.view.panels.BarbarismScientificPanel;

/**
 * 
 * @author Gabriel Chandesris (2012)
 */
public class BarbarismScientificGeneratorActionListener extends BooleanActionListener {
	public static String[] MAIN_DOMAINS = {
		"Generic Scientific Barbarism", 
	};
//	private static final RPGDataFile[] TALENTS_FILES_SETS		= {
//		RPGDataFile.getCyberAgeBiography(), 		/** SimulacreS Cyber Age */
//	};
	
	public BarbarismScientificGeneratorActionListener(boolean b) { super(b); }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		BarbarismScientific bio = null;
		if (this.isAware) {
			int select	= BarbarismScientificPanel.getInstance().getSelection();
			if (select == 0) { bio = BarbarismScientific.getInstance(); }
			
			if (bio == null) { return; }
			/** Here is number of lines. */
			int number	= BarbarismScientificPanel.getInstance().getNumber();
			String cont	= new String("");
			for (int i = 0 ; i < number ; i++) 
				{ cont += bio.getARandomElement()+"\n"; }
			BarbarismScientificPanel.getInstance().setContent(cont);
		} else {
			int select	= BarbarismScientificPanel.getInstance().getSelection();
			if (select == 0) { bio = BarbarismScientific.getInstance(); }
			
			if (bio == null) { return; }
			String cont	= bio.getARandomElement()+"\n";
			BarbarismScientificPanel.getInstance().addToContent(cont);
		}

	}

}
