package gabywald.rpg.view.panels;

import java.awt.Rectangle;
import javax.swing.JComboBox;
import gabywald.global.data.Utils;
import gabywald.global.data.samples.RPGDataFile;
import gabywald.rpg.model.PersonnaeOfGURPS;
import gabywald.rpg.view.BuildPersonnaeFrame;

/**
 * 
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2011)
 */
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
		String[] setOfLines	= new String[nt02.getNbLines()];
		for (int i = 0 ; i < setOfLines.length ; i++) {
			String line		= nt02.getLine(i);
			String[] tab	= line.split("\t");
			setOfLines[i]	= tab[0]; // +" -- "+tab[1];
		}
		JComboBox selector	= new JComboBox(setOfLines);
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
		int FOR = Utils.randomValue(12) + 8;
		int DEX = Utils.randomValue(12) + 8;
		int INT = Utils.randomValue(12) + 8;
		int SAN = Utils.randomValue(12) + 8;
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
