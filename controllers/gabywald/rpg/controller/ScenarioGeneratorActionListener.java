package gabywald.rpg.controller;

import gabywald.global.controller.BooleanActionListener;
import gabywald.rpg.model.IdeesSousLesDes;
import gabywald.rpg.view.panels.ScenarioGenerator;

import java.awt.event.ActionEvent;

/**
 * 
 * @author Gabriel Chandesris (2011)
 */
public class ScenarioGeneratorActionListener extends BooleanActionListener {
	
	public ScenarioGeneratorActionListener(boolean b)	{ super(b); }

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (this.isAware) {
			int select	= ScenarioGenerator.getInstance().getSelection();
			/** Here is number of lines. */
			int number	= ScenarioGenerator.getInstance().getNumber();
			String cont	= new String("");
			for (int i = 0 ; i < number ; i++) 
				{ cont += IdeesSousLesDes.getInstance().getAnElementInto(select)+"\n"; }
			ScenarioGenerator.getInstance().setContent(cont);
		} else {
			int select	= ScenarioGenerator.getInstance().getSelection();
			String cont	= IdeesSousLesDes.getInstance().getAnElementInto(select)+"\n";
			ScenarioGenerator.getInstance().addToContent(cont);
		}
	}

}
