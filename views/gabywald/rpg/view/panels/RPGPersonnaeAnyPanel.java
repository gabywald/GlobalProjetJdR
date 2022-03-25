package gabywald.rpg.view.panels;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import gabywald.rpg.controller.ButtonIconsActionListener;
import gabywald.rpg.controller.ConvertRecordActionListener;
import gabywald.rpg.view.BuildPersonnaeFrame;
import gabywald.rpg.view.RPGAvailableImages;
import gabywald.rpg.view.SpecificityPanel;

/**
 * Intermediate abstract class for determining attributes of Personnae. 
 * @author Gabriel Chandesris (2011, 2015, 2022)
 * @see GeneralInfoPanel
 * @see RPGPersonnaeBasicsPanel
 * @see RPGPersonnaeGURPSPanel
 * @see RPGPersonnaeSimulacreSPanel
 * @see RPGPersonnaeCyberAgePanel
 */
@SuppressWarnings("serial")
public abstract class RPGPersonnaeAnyPanel extends SpecificityPanel {
	/** Attributes names... */
	protected JLabel[] labels;
	/** Attributes content... */
	protected JTextField[] fields;
	/** Specific to SimulacreS (maybe others) to get icons... */
	private JButton[] buttonsIcons;
	/** Conversion and record buttons... */
	protected JButton[] convertAndRecord;
	
	protected RPGPersonnaeAnyPanel(	String[][] txt4lbls, 
									String[] txt4lblsUP, 
							 		boolean hasSimulacreSButtons, 
							 		int forWhich) {
		this.setDisposable(txt4lbls, txt4lblsUP, hasSimulacreSButtons);
		this.setConvertAndRecords(forWhich);
	}

	@Override
	public String getData() { return this.getFields(); }
	
	@Override
	public void setData(String content) { 
		String[] splitter = content.split(":::::");
		if (splitter.length != 2) { return; }
		try { 
			// TODO ?? 
			// int source = Integer.parseInt(splitter[0]);
			// this.setFields(source, splitter[1]);
		} catch (NumberFormatException nfe) { return; }
	}
	
//	public void setFields(int source, String data) {
//		if (this.fields.length == 0) { return; }
//		// TODO this.internalTreatmentForFields(source, data);
// }
	
	/** protected abstract void internalTreatmentForFields(int source, String data); */
	
	public int getFieldValueAt(int i) {
		if ( (i >= 0) && (i < this.fields.length) ) 
			{ return Integer.parseInt(this.fields[i].getText()); } 
		else { return 0; }
	}
	
	public void setFieldValueAt(int i, int val) {
		if ( (i >= 0) && (i < this.fields.length) ) 
			{ this.fields[i].setText(val+""); } 
		/** XXX ?? BUG : first of the PersonnaeAnyPanel do not actualize in the UI (but values internal are good...) ?? */
		// System.out.println("\t'"+this.getName()+"'\t'"+i+"'\t'"+this.fields[i].getName()+"'\t'"+val+"'\t'"+this.fields[i].getText()+"'");
	}
	
	public void setFieldValueAt(int i, double val) {
		if ( (i >= 0) && (i < this.fields.length) ) 
			{ this.fields[i].setText(val+""); } 
		// System.out.println("\t'"+this.getName()+"'\t'"+i+"'\t'"+this.fields[i].getName()+"'\t'"+val+"'\t'"+this.fields[i].getText()+"'");
	}
	
	public String getFieldAt(int i) {
		if ( (i >= 0) && (i < this.fields.length) ) 
			{ return this.fields[i].getText(); } 
		else { return new String(""); }
	}
	
	public String getFields() { 
		String toReturn = new String("");
		for (int i = 0 ; i < this.fields.length ; i++) 
			{ toReturn += this.fields[i].getText()+"\n"; }
		return toReturn; 
	}
	
	
	/** To put 'random' data into the characteristics... */
	public abstract void generateRandomData();
	
	protected void setDisposable(String[][] txt4lbls, 
								 String[] txt4lblsUP,
								 boolean hasSimulacreSButtons) {
		int sizeDoLbls = txt4lbls.length;
		int sizeUpLbls = txt4lblsUP.length;
		int size = (sizeDoLbls <= sizeUpLbls) ? sizeDoLbls : sizeUpLbls;

		int x4labelInit = Integer.parseInt(BuildPersonnaeFrame.confRPG
				.getValueOf("personnaeGenericx4Labels")); // 5;
		int x4fieldInit = Integer.parseInt(BuildPersonnaeFrame.confRPG
				.getValueOf("personnaeGenericx4Fields")); // 160;
		int x4buttoInit = Integer.parseInt(BuildPersonnaeFrame.confRPG
				.getValueOf("personnaeGenericx4Buttons")); // 315;
		int yInit = Integer.parseInt(BuildPersonnaeFrame.confRPG
				.getValueOf("personnaeGenericYPos")); // 5;

		int x4label = x4labelInit;
		int x4field = x4fieldInit;
		int x4butto = x4buttoInit;
		int y = yInit;
		int width = Integer.parseInt(BuildPersonnaeFrame.confRPG
				.getValueOf("personnaeGenericWidth")); // 150;
		int height = Integer.parseInt(BuildPersonnaeFrame.confRPG
				.getValueOf("personnaeGenericHeight")); // 20;
		int diff = 30;

		/** To be sure of the number of labels and fields. */
		int cumulateSizeLbls = txt4lblsUP.length;
		int cumulateSizeFlds = 0;
		for (int i = 0 ; i < txt4lbls.length ; i++) {
			int sizeToAdd = txt4lbls[i].length;
			cumulateSizeLbls += sizeToAdd;
			cumulateSizeFlds += sizeToAdd;
		} // END "for (int i = 0 ; i < txt4lbls.length ; i++)"

		this.labels			= new JLabel[cumulateSizeLbls];
		this.fields			= new JTextField[cumulateSizeFlds];
		this.buttonsIcons	= 
			new JButton[(hasSimulacreSButtons) ? cumulateSizeFlds - 4 : 0];

		/**
		 * System.out.println("\tfor lbls : '"+cumulateSizeLbls
		 * +"'\tfor flds : '"+cumulateSizeFlds+"'"
		 * +"'\tfor buts : '"+(cumulateSizeFlds-4)+"'");
		 */

		int index4lbls = 0, index4flds = 0;
		for (int i = 0 ; i < size ; i++) {
			this.labels[index4lbls] = new JLabel(txt4lblsUP[i]);
			this.labels[index4lbls].setBorder(BorderFactory
					.createLineBorder(Color.BLACK, 2));
			this.labels[index4lbls].setBounds(x4label, y, width, height);
			y += 25;
			this.add(this.labels[index4lbls]);
			index4lbls++;
			/** Sub-Parts details... */
			for (int j = 0 ; j < txt4lbls[i].length ; j++) {
				String nameAbbrev = txt4lbls[i][j];
				String name = nameAbbrev;
				if (nameAbbrev.split(":").length > 1) 
					{ name = nameAbbrev.split(":")[0] + " ("
							+ nameAbbrev.split(":")[1] + ")"; }

				this.labels[index4lbls] = new JLabel(name);
				this.labels[index4lbls].setName(name);
				this.labels[index4lbls].setBorder(BorderFactory
						.createRaisedBevelBorder());
				this.labels[index4lbls]
						.setBounds(x4label + diff, y, width, height);
				this.fields[index4flds] = new JTextField();
				this.fields[index4flds].setName(name);
				this.fields[index4flds].setBounds(x4field + diff, y, width,
						height);
				if ( (hasSimulacreSButtons) && (index4flds < this.buttonsIcons.length) ) {
					/** Pass through 'neant' -> '+1' over index of 14 */
					this.buttonsIcons[index4flds] = new JButton(
							RPGAvailableImages.getAnIcon(index4flds
									+ ((index4flds >= 14) ? 1 : 0)));
					this.buttonsIcons[index4flds]
							.setBounds(x4butto + diff, y, 12, 12);
					this.buttonsIcons[index4flds]
							.addActionListener(new ButtonIconsActionListener(index4flds, 2));
					this.add(this.buttonsIcons[index4flds]);
				} // END "if ( (hasSimulacreSButtons) && (index4flds < this.buttonsIcons.length) )"
				y += 25;
				this.add(this.labels[index4lbls]);
				this.add(this.fields[index4flds]);
				index4lbls++;
				index4flds++;
			} // END "for (int j = 0 ; j < txt4lbls[i].length ; j++)"

			int limit = (hasSimulacreSButtons) ? 2 : 1;
			if (i == limit) {
				int xNext = Integer.parseInt(BuildPersonnaeFrame.confRPG
						.getValueOf("personnaeGenericxNextColumn")); // 400
				x4label = xNext + x4labelInit;
				x4field = xNext + x4fieldInit;
				x4butto = xNext + x4buttoInit;
				y = yInit;
			} // END "if (i == limit)"
		} // END "for (int i = 0 ; i < size ; i++)"
	}

	/**
	 * Generate and position of convert / record Buttons...
	 * @param forWhich (int) 0 for Basics ; 1 for GURPS ; 2 for SimulacreS.
	 * @see gabywald.rpg.view.panels.RPGPersonnaeBasicsPanel#RPGPersonnaeBasicsPanel()
	 * @see gabywald.rpg.view.panels.RPGPersonnaeGURPSPanel#PersonnaeGURPSPanel()
	 * @see gabywald.rpg.view.panels.RPGPersonnaeSimulacreSPanel#RPGPersonnaeSimulacreSPanel()
	 */
	protected void setConvertAndRecords(int forWhich) {
		String[] possibilities	= { "Basics", "GURPS", "SimulacreS" };
		String templateConvert	= new String("Convert to ");
		this.convertAndRecord	= new JButton[possibilities.length];

		int xStart = Integer.parseInt(BuildPersonnaeFrame.confRPG
				.getValueOf("convertAndRecordPosX"));
		int yStart = Integer.parseInt(BuildPersonnaeFrame.confRPG
				.getValueOf("convertAndRecordPosY"));
		int xPlus = Integer.parseInt(BuildPersonnaeFrame.confRPG
				.getValueOf("convertAndRecordXPlus"));
		int width = Integer.parseInt(BuildPersonnaeFrame.confRPG
				.getValueOf("convertAndRecordWidth"));
		int height = Integer.parseInt(BuildPersonnaeFrame.confRPG
				.getValueOf("convertAndRecordHeight"));
		
		int index = 0;
		if (forWhich != -1) { 
			for (int i = 0; i < possibilities.length; i++) {
				if (i != forWhich) {
					this.convertAndRecord[index] = 
						new JButton(templateConvert + possibilities[i]);
					this.convertAndRecord[index]
						.setBounds(xStart, yStart, width, height);
					this.add(this.convertAndRecord[index]);
					this.convertAndRecord[index].addActionListener
						(new ConvertRecordActionListener(i, forWhich));
					xStart += xPlus;
					index++;
				} // END "if (i != forWhich)"
			} // END "for (int i = 0; i < possibilities.length; i++)"
		} // END "if (forWhich != -1)"
		this.convertAndRecord[index] = new JButton("Record");
		this.convertAndRecord[index].setBounds(xStart, yStart, width, height);
		this.add(this.convertAndRecord[index]);
	}
	
	public String toString() {
		String toReturn  = new String("");
		
		toReturn += "Panel '"+this.getName()+"'\n";
		toReturn += "\tLabels : \n";
		for (int i = 0 ; i < this.labels.length ; i++) {
			String bounds = "("+this.labels[i].getBounds().x+", "
							   +this.labels[i].getBounds().y+", "
							   +this.labels[i].getBounds().width+", "
							   +this.labels[i].getBounds().height+") ";
			toReturn += "\t\t"+bounds+"\t'"+this.labels[i].getText()+"'\n";
		}
		
		toReturn += "\tFields : \n";
		for (int i = 0 ; i < this.fields.length ; i++) {
			String bounds = "("+this.fields[i].getBounds().x+", "
							   +this.fields[i].getBounds().y+", "
							   +this.fields[i].getBounds().width+", "
							   +this.fields[i].getBounds().height+") ";
			toReturn += "\t\t"+bounds+"\t'"+this.fields[i].getName()+"' == '"+this.fields[i].getText()+"'\n";
		}
		
		return toReturn;
	}

}

