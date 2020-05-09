package gabywald.framework.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gabywald.framework.view.MyInternalFrame;
import gabywald.framework.view.MyPanel;

/**
 * 
 * @author Gabriel Chandesris (2008-2012)
 */
public class MyInternalFrameActionListener implements ActionListener {
	private MyInternalFrame	miif;
	private int currentStep		= 0, 
				destinaStep		= 0;
	
	public MyInternalFrameActionListener(MyInternalFrame mif) 
		{ this.miif = mif; }
	
	public void actionPerformed (ActionEvent e){
		/** Previous */
		if (e.getActionCommand().equals(MyPanel.WIZ_BUTTONS_NAMES[0])) {
			if (this.currentStep > 0) { 
				this.destinaStep = this.currentStep - 1;
				/** System.out.println("\tprev\t"+this.currentStep+" => "+this.destinaStep); */
				this.miif.goToCard(this.destinaStep);
				this.currentStep = this.destinaStep;
			}
		}
		/** Next */
		else if (e.getActionCommand().equals(MyPanel.WIZ_BUTTONS_NAMES[1])) {
			if (this.currentStep < this.miif.getNumberOfCards() - 1 ) { 
				this.destinaStep = this.currentStep + 1;
				/** System.out.println("\tnext\t"+this.currentStep+" => "+this.destinaStep); */
				this.miif.goToCard(this.destinaStep);
				this.currentStep = this.destinaStep;
			}
		}
		/** Finish */
		else if (e.getActionCommand().equals(MyPanel.WIZ_BUTTONS_NAMES[2])) {
			/** XXX ... */
			this.miif.dispose();
		}
		/** Cancel */
		else if (e.getActionCommand().equals(MyPanel.WIZ_BUTTONS_NAMES[3])) {
			/** XXX ... */
			this.miif.dispose();
		}
	}

}
