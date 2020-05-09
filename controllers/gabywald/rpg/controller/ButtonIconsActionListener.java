package gabywald.rpg.controller;

import gabywald.global.data.Utils;
import gabywald.rpg.view.panels.RPGPersonnaeAnyPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Gabriel Chandesris (2011)
 */
public class ButtonIconsActionListener implements ActionListener {
	private int ij;
	private int rpgpap;
	
	public ButtonIconsActionListener(int ij, int rpgpap) 
		{ this.ij = ij;this.rpgpap = rpgpap; }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		RPGPersonnaeAnyPanel panel = ConvertRecordActionListener.SOURCE_PANELS[this.rpgpap];
		panel.setFieldValueAt(this.ij, Utils.randomValue(42));
		// System.out.println(panel);
	}

}
