package gabywald.rpg.controller;

import java.awt.event.ActionEvent;

import gabywald.global.controller.BooleanActionListener;
import gabywald.rpg.model.BTCyberAge;
import gabywald.rpg.model.Biography;
import gabywald.rpg.view.panels.BiographyPanel;

/**
 * 
 * @author Gabriel Chandesris (2011)
 */
public class BiographyGeneratorActionListener extends BooleanActionListener {
	public static String[] MAIN_DOMAINS = {
		"CyberAge (SimulacreS)", 
	};
//	private static final RPGDataFile[] TALENTS_FILES_SETS		= {
//		RPGDataFile.getCyberAgeBiography(), 		/** SimulacreS Cyber Age */
//	};
	
	public BiographyGeneratorActionListener(boolean b) { super(b); }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Biography bio = null;
		if (this.isAware) {
			int select	= BiographyPanel.getInstance().getSelection();
			if (select == 0) { bio = BTCyberAge.getInstance(); }
			
			if (bio == null) { return; }
			/** Here is number of lines. */
			int number	= BiographyPanel.getInstance().getNumber();
			String cont	= new String("");
			for (int i = 0 ; i < number ; i++) 
				{ cont += bio.getARandomElement()+"\n"; }
			BiographyPanel.getInstance().setContent(cont);
		} else {
			int select	= BiographyPanel.getInstance().getSelection();
			if (select == 0) { bio = BTCyberAge.getInstance(); }
			
			if (bio == null) { return; }
			String cont	= bio.getARandomElement()+"\n";
			BiographyPanel.getInstance().addToContent(cont);
		}

	}

}
