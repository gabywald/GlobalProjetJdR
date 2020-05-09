package gabywald.global.view.dialog;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import gabywald.global.dialog.controller.GenericAskingDialogListener;
import gabywald.global.dialog.controller.GenericSelectActionListener;
import gabywald.global.view.GenericJFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * An Abstract Class to define dialogs with choices and subChoices, values... 
 * @author Gabriel Chandesris (2011)
 */
public class GenericAskingDialog extends JDialog {
	/** Current instances of WeaponAskingDialog. */
	private static GenericAskingDialog configureAndAddv01, configureAndAddv02, removal;
	/** Options : Save, Discard and Cancel. */
	public static final String[] options	= { "Save", "Discard", "Cancel" };
	/** Sets of skills and sub-skills currently used. */
	private String[] choices, subChoices;
	/** Space of Choices. */
	private JComboBox choice, subChoice;
	/** A given Value for a given choice (Skill for example). */
	private JTextField value;
	/** The buttons in the box. */
	private JButton buttons[];
	/** To know which option has been selected. */
	private int answer;
	
	/**
	 * Constructor of Dialog with Choices, Value and subChoices (linked to adapted ActionsListeners). 
	 * @param name (String)
	 * @param message (String)
	 * @param choices (String[])
	 * @param valuesToChoose (String[])
	 * @param subChoices (String[][])
	 * @param firstListLabel (String)
	 * @param secondListLabel (String)
	 * @param frame (GenericJFrame)
	 * @see GenericAskingDialog#initializeBegin(GenericJFrame, String, String)
	 * @see GenericAskingDialog#addAComponent(int, int, int, GridBagConstraints, JComponent)
	 * @see GenericAskingDialog#initializeButtonsAndFinal(GridBagConstraints)
	 */
	protected GenericAskingDialog(String name, String message, 
								  String[] choices, 
								  String[] valuesToChoose, 
								  String[][] subChoices, 
								  String firstListLabel, String secondListLabel, 
								  String valueLabel, 
								  GenericJFrame frame) {
		super(frame, name, true);
		this.choices	= choices;
		this.subChoices	= null;

		GridBagConstraints c = this.initializeBegin(frame, message, firstListLabel);
		/** ****** ****** ****** ****** ****** */
		this.choice.addActionListener(new GenericSelectActionListener(this, valuesToChoose, subChoices));
		this.value	= new JTextField("*****");
		// this.value.setEditable(false);
		this.subChoice	 = new JComboBox();
		this.subChoice.setEditable(true);
		this.subChoice.setEnabled(false);
		/** ****** ****** ****** ****** ****** */
		this.addAComponent(0, 4, 1, c, new JLabel(valueLabel));
		this.addAComponent(1, 4, 2, c, this.value);
		this.addAComponent(0, 5, 3, c, GenericAskingDialog.getEmptyJLabel());
		this.addAComponent(0, 6, 1, c, new JLabel(secondListLabel));
		this.addAComponent(1, 6, 2, c, this.subChoice);
		this.addAComponent(0, 7, 3, c, GenericAskingDialog.getEmptyJLabel());
		/** ****** ****** ****** ****** ****** */
		this.initializeButtonsAndFinal(c);
	}
	
	/**
	 * Constructor of Dialog with Choices and Value (linked to adapted ActionsListeners). 
	 * @param name (String)
	 * @param message (String)
	 * @param choices (String[])
	 * @param valuesToChoose (String[])
	 * @param firstListLabel (String)
	 * @param valueLabel (String)
	 * @param frame (GenericJFrame)
	 */
	protected GenericAskingDialog(String name, String message, 
								  String[] choices, 
								  String[] valuesToChoose, 
								  String firstListLabel, 
								  String valueLabel, 
								  GenericJFrame frame) {
		super(frame, name, true);
		this.choices	= choices;
		this.subChoices	= null;

		GridBagConstraints c = this.initializeBegin(frame, message, firstListLabel);
		/** ****** ****** ****** ****** ****** */
		this.choice.addActionListener(new GenericSelectActionListener(this, valuesToChoose));
		this.value	= new JTextField("*****");
		/** ****** ****** ****** ****** ****** */
		this.addAComponent(0, 4, 1, c, new JLabel(valueLabel));
		this.addAComponent(1, 4, 2, c, this.value);
		this.addAComponent(0, 5, 3, c, GenericAskingDialog.getEmptyJLabel());
		/** ****** ****** ****** ****** ****** */
		this.initializeButtonsAndFinal(c);
	}
	
	/**
	 * Constructor of Dialog with Choices (linked to adapted ActionsListeners). 
	 * @param name (String)
	 * @param message (String)
	 * @param choices (String[])
	 * @param firstListLabel (String)
	 * @param frame (GenericJFrame)
	 * @see GenericAskingDialog#initializeBegin(GenericJFrame, String, String)
	 * @see GenericAskingDialog#initializeButtonsAndFinal(GridBagConstraints)
	 */
	protected GenericAskingDialog(String name, String message, 
								  String[] choices, 
								  String firstListLabel, 
								  GenericJFrame frame) {
		super(frame, name, true);
		this.choices	= choices;
		this.subChoices	= null;
		
		GridBagConstraints c = this.initializeBegin(frame, message, firstListLabel);
		/** ****** ****** ****** ****** ****** */
		this.initializeButtonsAndFinal(c);
	}
	
	/** 
	 * Provides a new JLabel filled with five (5) spaces.  
	 * @return (JLabel)
	 */
	private static JLabel getEmptyJLabel() 
		{ return new JLabel("     "); }
	
	/**
	 * Constructors Helper to add a component into the grid. 
	 * @param x (int)
	 * @param y (int)
	 * @param width (int)
	 * @param c (GridBagConstraints)
	 * @param component
	 */
	private void addAComponent(int x, int y, int width, 
							   GridBagConstraints c, 
							   JComponent component) {
		c.gridx = x;c.gridy = y;c.gridwidth = width;
		this.add(component, c);
	}
	
	/**
	 * Constructors Helper which provides first part. 
	 * @param frame (GenericJFrame)
	 * @param message (String)
	 * @param firstListLabel (String)
	 * @return (GridBagConstraints)
	 * @see GenericAskingDialog#addAComponent(int, int, int, GridBagConstraints, JComponent)
	 */
	private GridBagConstraints initializeBegin(GenericJFrame frame, 
											   String message, 
											   String firstListLabel) {
		this.setLocationRelativeTo(frame);
		this.setPreferredSize(new Dimension(400, 250));
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		/** ****** ****** ****** ****** ****** */
		this.choice = new JComboBox(this.choices);
		/** ****** ****** ****** ****** ****** */
		this.addAComponent(0, 0, 3, c, new JLabel(message));
		this.addAComponent(0, 1, 3, c, GenericAskingDialog.getEmptyJLabel());
		this.addAComponent(0, 2, 1, c, new JLabel(firstListLabel));
		this.addAComponent(1, 2, 2, c, this.choice);
		this.addAComponent(0, 3, 3, c, GenericAskingDialog.getEmptyJLabel());
		/** ****** ****** ****** ****** ****** */
		return c;
	}
	
	/**
	 * Constructors Helper which initialize buttons and some default values. 
	 * @param c (GridBagConstraints)
	 */
	private void initializeButtonsAndFinal(GridBagConstraints c) {
		this.buttons = new JButton[GenericAskingDialog.options.length];
		int y = c.gridy+1, width = 1;
		for (int i = 0 ; i < GenericAskingDialog.options.length ; i++) {
			this.buttons[i] = new JButton(GenericAskingDialog.options[i]);
			this.buttons[i].addActionListener(new GenericAskingDialogListener(this));
			this.addAComponent(i, y, width, c, this.buttons[i]);
		}
		/** ****** ****** ****** ****** ****** */
		this.pack();
		// this.setVisible(true);
		/** ****** ****** ****** ****** ****** */
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) 
				{ /** System.out.println("Thwarted user attempt to close window."); */ }
		});
		/** ****** ****** ****** ****** ****** */
		this.answer = -1;
		this.choice.setSelectedIndex(0);
	}
	
	public JButton getRecordButton()	{ return this.buttons[0]; }
	public JButton getNoRecoButton()	{ return this.buttons[1]; }
	public JButton getCancelButton()	{ return this.buttons[2]; }
	
	public int getAnswer()				{ return this.answer; }
	public void setAnswer(int answer)	{ this.answer = answer; }
	
	public void setVisible(boolean arg) {
		if (arg) { ; }
		super.setVisible(arg);
	}
	
	public void setSubChoices(String[] subChoices) {
		this.subChoices = subChoices;
		this.subChoice.removeAllItems();
		if ( (this.subChoices != null) && (this.subChoices.length > 0) ) {
			for (int i = 0 ; i < this.subChoices.length ; i++) 
				{ this.subChoice.addItem(this.subChoices[i]); }
			this.subChoice.setEnabled(true);
		} else { 
			this.subChoices = null;
			this.subChoice.setEnabled(false);
		}
	}
	
	public int getMainChoiceAsInteger() 
		{ return this.choice.getSelectedIndex(); }
	
	public int getSubbChoiceAsInteger() {
		if (this.subChoices == null) { return -1; }
		return this.subChoice.getSelectedIndex();
	}
	
	public String getMainChoice() 
		{ return this.choices[this.choice.getSelectedIndex()]; }
	
	public String getSubbChoice() {
		if (this.subChoices == null) { return null; }
		return this.subChoices[this.subChoice.getSelectedIndex()];
	}
	
	public void setValue(String val)	{ this.value.setText(val); }
	public String getValue()			{ return this.value.getText(); }
	
	public static GenericAskingDialog getConfigureAndAddInstance(String name, String message, 
															     	String[] choices, 
															     	String[] valuesToChoose, 
															     	String[][] subChoices, 
															     	String firstListLabel, 
															     	String secondListLabel, 
															     	String valueLabel, 
															     	GenericJFrame frame) { 
		GenericAskingDialog.configureAndAddv01 = new GenericAskingDialog
											(name, message, choices, valuesToChoose, subChoices, 
												firstListLabel, secondListLabel, valueLabel, frame);
		return GenericAskingDialog.configureAndAddv01;
	}
	
	public static GenericAskingDialog getConfigureAndAddInstance01() 
		{ return GenericAskingDialog.configureAndAddv01; }
	
	public static GenericAskingDialog getConfigureAndAddInstance(String name, String message, 
															     	String[] choices, 
															     	String[] valuesToChoose, 
															     	String firstLabel, 
															     	String valueLabel, 
															     	GenericJFrame frame) { 
		GenericAskingDialog.configureAndAddv02 = new GenericAskingDialog
											(name, message, choices, valuesToChoose, 
												firstLabel, valueLabel, frame);
		return GenericAskingDialog.configureAndAddv02;
	}

	public static GenericAskingDialog getConfigureAndAddInstance02() 
		{ return GenericAskingDialog.configureAndAddv02; }
	
	public static GenericAskingDialog getRemovalInstance(String name, String message, 
														    String[] choices, 
															String firstListLabel, 
															GenericJFrame frame) {
		GenericAskingDialog.removal = new GenericAskingDialog(name, message, choices, 
																firstListLabel, frame);
		return GenericAskingDialog.removal;
	}

	public static GenericAskingDialog getRemovalInstance() 
		{ return GenericAskingDialog.removal; }
}
