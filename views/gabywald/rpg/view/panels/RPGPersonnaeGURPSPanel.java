package gabywald.rpg.view.panels;

import java.awt.Rectangle;
import java.io.IOException;

import javax.swing.JComboBox;
import gabywald.global.data.StringUtils;
import gabywald.rpg.data.samples.RPGDataFile;
import gabywald.rpg.model.PersonnaeOfGURPS;
import gabywald.rpg.view.BuildPersonnaeFrame;
import gabywald.utilities.logger.Logger;
import gabywald.utilities.logger.Logger.LoggerLevel;

/**
 * 
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2011, 2022)
 */
@SuppressWarnings("serial")
public class RPGPersonnaeGURPSPanel extends RPGPersonnaeAnyPanel {
	private static RPGPersonnaeGURPSPanel instance;
	
	private static String[][] TEXTS_FOR_LABELS	= PersonnaeOfGURPS.GENERAL_NAMES;
	private static String[] TEXTS_UPPER_LABELS	= 
		BuildPersonnaeFrame.confRPG.getValueOf("personnaeGURPSView").split(";");

	private RPGPersonnaeGURPSPanel() {
		super(RPGPersonnaeGURPSPanel.TEXTS_FOR_LABELS, 
			  RPGPersonnaeGURPSPanel.TEXTS_UPPER_LABELS, 
			  false, 1);
		this.setName("GURPS");
		this.generateRandomData();
		
		/** Technical Level */
		Rectangle bounds	= this.fields[this.fields.length-1].getBounds();
		bounds.setSize(bounds.width*3/2, bounds.height);
		RPGDataFile nt02	= RPGDataFile.getNTv01();
		try {
			nt02.load();
		} catch (IOException e) {
			Logger.printlnLog(LoggerLevel.LL_ERROR, "RPGPersonnaeGURPSPanel file cannot be loaded !");
		}
		String[] setOfLines	= new String[nt02.nbLines()];
		for (int i = 0 ; i < setOfLines.length ; i++) {
			String line		= nt02.getChamp(i);
			String[] tab	= line.split("\t");
			setOfLines[i]	= tab[0]; // +" -- "+tab[1];
		}
		JComboBox<String> selector	= new JComboBox<String>(setOfLines);
		selector.setBounds(bounds);
		selector.setSelectedIndex(7);
		this.remove(this.fields[this.fields.length-1]);
		this.add(selector);
		
		/** Disable convertion to 'SimulacreS'. */
		this.convertAndRecord[1].setEnabled(false);
	}

	public static RPGPersonnaeGURPSPanel getInstance() {
		if (RPGPersonnaeGURPSPanel.instance == null) 
			{ RPGPersonnaeGURPSPanel.instance = new RPGPersonnaeGURPSPanel(); }
		return RPGPersonnaeGURPSPanel.instance;
	}
	
	@Override
	public void generateRandomData() {
		int FOR = StringUtils.randomValue(12) + 8;
		int DEX = StringUtils.randomValue(12) + 8;
		int INT = StringUtils.randomValue(12) + 8;
		int SAN = StringUtils.randomValue(12) + 8;
		this.setFieldValueAt(0, FOR);
		this.setFieldValueAt(1, DEX);
		this.setFieldValueAt(2, INT);
		this.setFieldValueAt(3, SAN);
		this.setFieldValueAt(4, SAN); // Fatigue
		this.setFieldValueAt(5, FOR); // PV
		this.setFieldValueAt(6, INT); // Volonté
		this.setFieldValueAt(7, (double)( SAN + DEX ) / 4 );	// Vitesse Base
		this.setFieldValueAt(8, ( SAN + DEX ) / 4);				// Déplacement Base
		
		// TODO others attributes ???
	}

}
