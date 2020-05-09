package gabywald.rpg.view.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import gabywald.rpg.view.SpecificityPanel;

/**
 * Intermediate abstract class for determining some 'complex' data of Personnae. 
 * @author Gabriel Chandesris (2011)
 * @see BiographyPanel
 * @see ScenarioGenerator
 * @see EquipmentsPanel
 * @see SkillsPanel
 * @see SpecialPanel
 * @see WeaponsPanel
 */
public abstract class RPGDataPanel extends SpecificityPanel {
	protected static final String[] FIRST_BUTTON_NAME	= { "Select & Add below",	"Generate !!" };
	protected static final String[] SECOND_BUTTON_NAME	= { "Remove one. ",			"Add one line" };
	/** Indicates if a generator panel or not. */
	private boolean isGenerator;
	/** A TextArea for content. */
	private JTextArea contentGenerated;
	/** A selector. */
	private JComboBox selector;
	/** Some apply-ing button. */
	private JButton applyFirst, applySecond;
	/** A TextField for a number. */
	private JTextField number;
	/** Default value for previous TextField. */
	private int defaultValue;
	
	protected RPGDataPanel(String[] dataForComboBox, boolean generator) {
		this.isGenerator = generator;
		this.initalize();
		this.add(this.getContentScroll());
		this.add(this.getComboBox(dataForComboBox));
		if (this.isGenerator) { this.add(this.getNumberField(10)); }
		this.enableContentAccess(this.isGenerator);
	}
	
	private void initalize() {
		this.contentGenerated	= null;
		this.selector			= null;
		this.applyFirst			= null;
		this.applySecond		= null;
		this.number				= null;
		this.defaultValue		= -1;
	}

	@Override
	public String getData()	{ return this.getContent(); }
	
	@Override
	public void setData(String content) 
		{ this.setContent(content); }
	
	protected JScrollPane getContentScroll() {
		this.contentGenerated	= new JTextArea();
		this.contentGenerated.setFont(new Font("Monospaced", Font.PLAIN, 12));
		this.contentGenerated.setDisabledTextColor(Color.DARK_GRAY);
		JScrollPane scroll		= new JScrollPane(this.contentGenerated);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(this.criterias[0], this.criterias[1], this.criterias[2], this.criterias[3]);
		this.add(scroll);
		return scroll;
	}
	
	protected JComboBox getComboBox(String[] items) {
		this.selector			= new JComboBox(items);
		this.selector.setBounds(this.criterias[0], this.criterias[4], this.criterias[7], this.criterias[5]);
		return this.selector;
	}
	
	protected JTextField getNumberField(int val) {
		this.defaultValue 		= val;
		this.number				= new JTextField(val+"");
		this.number.setBounds(this.criterias[10], this.criterias[4], this.criterias[8], this.criterias[5]);
		return this.number;
	}
	
//	protected JButton getApplyFirstButton(String name, ActionListener ial) {
//		this.applyFirst		= new JButton(name);
//		this.applyFirst.setBounds(this.criterias[9], this.criterias[4], this.criterias[10], this.criterias[5]);
//		this.applyFirst.addActionListener(ial);
//		return this.applyFirst;
//	}
//	
//	protected JButton getApplySecondButton(String name, ActionListener ial) {
//		this.applySecond		= new JButton(name);
//		this.applySecond.setBounds(this.criterias[10]+this.criterias[9]+this.criterias[4], 
//								   this.criterias[4], this.criterias[6], this.criterias[5]);
//		this.applySecond.addActionListener(ial);
//		return this.applySecond;
//	}
	
	protected JButton getApplyFirstButton(ActionListener ial) {
		String name = RPGDataPanel.FIRST_BUTTON_NAME[this.isGenerator?1:0];
		this.applyFirst		= new JButton(name);
		this.applyFirst.setBounds(this.criterias[9], this.criterias[4], this.criterias[10], this.criterias[5]);
		this.applyFirst.addActionListener(ial);
		return this.applyFirst;
	}
	
	protected JButton getApplySecondButton(ActionListener ial) {
		String name = RPGDataPanel.SECOND_BUTTON_NAME[this.isGenerator?1:0];
		this.applySecond		= new JButton(name);
		this.applySecond.setBounds(this.criterias[10]+this.criterias[9]+this.criterias[4], 
								   this.criterias[4], this.criterias[6], this.criterias[5]);
		this.applySecond.addActionListener(ial);
		return this.applySecond;
	}
	
	public void enableContentAccess(boolean b) 
		{ if (this.contentGenerated != null) 
			{ this.contentGenerated.setEnabled(b); } }
	
	public void setContent(String cont)		
		{ if (this.contentGenerated != null) 
			{ this.contentGenerated.setText(cont); } }
	
	public void addToContent(String cont)	
		{ if (this.contentGenerated != null) 
			{ this.contentGenerated.setText(this.contentGenerated.getText()+cont); } }
	
	public void removeLineOfContent(int lineNumber) {
		String[] content = this.contentGenerated.getText().split("\n");
		if ( (lineNumber >= 0) && (lineNumber < content.length) ) {
			this.contentGenerated.setText("");
			int i = 0;
			for ( ; i < lineNumber ; i++) 
				{ this.addToContent(content[i]+"\n"); }
			i++;
			for ( ; i < content.length ; i++) 
				{ this.addToContent(content[i]+"\n"); }
		}
	}
	
	public String getContent()		{
		if (this.contentGenerated != null) 
			{ return this.contentGenerated.getText(); } 
		else { return new String(""); }
	}

	public int getSelection()	{ 
		if (this.selector != null) 
			{ return this.selector.getSelectedIndex(); }
		else { return -1; }
	}
	
	public int getNumber() {
		if (this.number != null) {
			try { return Integer.parseInt(this.number.getText()); }
			catch (NumberFormatException nfe) { return this.defaultValue; }
		} else { return -1; }
	}

}
