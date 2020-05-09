package gabywald.framework.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JProgressBar;

import gabywald.framework.controller.MyInternalFrameActionListener;

/**
 * 
 * @author St&eacute;fan Engelen (2006)
 * @author Gabriel Chandesris (2008-2012)
 */
public /** abstract */ class MyPanel extends JPanelWithBackgroundImage {
	/** Serial number (48).  */
	private static final long serialVersionUID		= 48L;
	/** Names of buttons for Wizard Panels. */
	public static final String[] WIZ_BUTTONS_NAMES	= 
		{ "Previous", "Next", "Finish", "Cancel" };
	/** Dimension / Size of buttons for Wizard Panels. */
	private static final Dimension wizDim			= new Dimension(100, 20);
	/** Current layout.  */
	protected MyLayout layout	= new MyLayout();
	
	private JButton[] forWizards;
	
	/** Default Constructor. */
	public MyPanel() { this.init(false); }
	
	/**
	 * Constructor. 
	 * @param compass (boolean)
	 */
	public MyPanel(boolean compass) { this.init(compass); }
	
	
	/**
	 * Constructors helper. 
	 * @param processParent (MyProcessus)
	 */
	private void init(boolean compass) {
		this.forWizards		= new JButton[MyPanel.WIZ_BUTTONS_NAMES.length];
		for (int i = 0 ; i < MyPanel.WIZ_BUTTONS_NAMES.length ; i++) { 
			this.forWizards[i]	= new JButton(MyPanel.WIZ_BUTTONS_NAMES[i]);
			this.forWizards[i].setName(MyPanel.WIZ_BUTTONS_NAMES[i]);
			this.forWizards[i].setActionCommand(MyPanel.WIZ_BUTTONS_NAMES[i]);
			this.forWizards[i].setEnabled(true); /** XXX false !! */
			this.forWizards[i].setVisible(true); /** XXX false !! */
			this.add(this.forWizards[i]);
		}
	}
	
	public void paintComponent(Graphics g) {
		for (int i = 0 ; i < this.forWizards.length ; i++) { 
			this.forWizards[i].setSize(MyPanel.wizDim);
			int posX = this.getWidth()  - (this.forWizards.length)*(110) + (i*110) - 18;
			int posY = this.getHeight() - 30;
			/** System.out.println("\t("+posX+", "+posY+") : '"+this.forWizards[i].getName()+"'"); */
			this.forWizards[i].setBounds(posX, posY, 
					MyPanel.wizDim.width, MyPanel.wizDim.height);
		}
		/** System.out.println(); */
		
		/** For sub-elements vizualisation... */
		for (int i = 0 ; i < this.getComponentCount() ; i++) {
			Component comp = this.getComponent(i);
			comp.setBackground(JPanelWithBackgroundImage.BACKGROUND_COLOR);
			comp.setForeground(JPanelWithBackgroundImage.FOREGROUND_COLOR);
			if (comp.getName().equals("title")) {
				comp.setFont(new Font("Times", Font.BOLD, 25));
			} else { comp.setFont(JPanelWithBackgroundImage.FONT4INTERFACE); }
		}
		super.paintChildren(g);
		super.paintComponent(g);
	}
	
	public void setPrevEnabled(boolean b) { this.forWizards[0].setEnabled(b); }
	public void setNextEnabled(boolean b) { this.forWizards[1].setEnabled(b); }
	public void setFiniEnabled(boolean b) { this.forWizards[2].setEnabled(b); }
	public void setCancEnabled(boolean b) { this.forWizards[3].setEnabled(b); }
	
	public void setPrevVisible(boolean b) { this.forWizards[0].setVisible(b); }
	public void setNextVisible(boolean b) { this.forWizards[1].setVisible(b); }
	public void setFiniVisible(boolean b) { this.forWizards[2].setVisible(b); }
	public void setCancVisible(boolean b) { this.forWizards[3].setVisible(b); }
	
	public void setListenerForWizard(MyInternalFrameActionListener mifal) {
		for (int i = 0 ; i < MyPanel.WIZ_BUTTONS_NAMES.length ; i++) 
			{ this.forWizards[i].addActionListener(mifal); }
	}
	
	/** To initialize interface's items. */
	private void initialize() 
		{ MyPanel.subInitialization(this.getComponents(), 
										this.currentFont, 
										this.currentBGColor, 
										this.currentFGColor); }
	
	private static void subInitialization(Component[] tabComponent, 
										  Font font2apply, 
										  Color bgColor2apply, 
										  Color fgColor2apply) {
		for (int i = 0 ; i < tabComponent.length;i++) {
			tabComponent[i].setFont(font2apply);
			tabComponent[i].setBackground(bgColor2apply);
			tabComponent[i].setForeground(fgColor2apply);
			MyPanel.subInitialization(((Container)(tabComponent[i])).getComponents(), 
										  font2apply, bgColor2apply, fgColor2apply);
		}
	}
	
	/**
	 * To add and vizualise progression bar on this interface. 
	 * @param progressBar JProgressBar
	 */
	public void addProgressBar(JProgressBar progressBar){
		this.layout.positionXY(this, progressBar, 30, 90, 40, 3);
		this.initialize();
	}

	/**
	 * To remove the progression bar. 
	 * @param progressBar JProgressBar
	 */
	public void remProgressBar(JProgressBar progressBar)
		{ this.remove(progressBar); }
	
	/**
	 * To remove what interface's items contain. 
	 * @see MyPanel#initialiser()
	 */
	 public void erase() { ; }

	/**
	 * <i>Some inheritants interfaces have a method called setInterface 
	 * (with differents arguments and exceptions throws). <u>It is used 
	 * for execution of Processus. </u></i><br>
	 * This abstract method to centralised thoses nmethods' data. 
	 * @see AloneProcessus#avance
	 */
	// public abstract void setInterface();
	
}
