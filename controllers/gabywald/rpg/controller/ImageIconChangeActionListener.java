package gabywald.rpg.controller;

import gabywald.rpg.view.RetroFuturAvailableImages;
import gabywald.rpg.view.panels.RetroFuturPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * 
 * @author Gabriel Chandesris (2011)
 */
public class ImageIconChangeActionListener implements ActionListener {
	private JButton imageViewer;
	private int start, endin;
	private int[] possibles;
	private int currentIndex;
	
	public ImageIconChangeActionListener(JButton viewer, 
							 			 int sta, int end) 
		{ this.init(viewer, sta, end, new int[0]); }
	
	public ImageIconChangeActionListener(JButton viewer, 
			 							 int[] poss) 
		{ this.init(viewer, -1, -1, poss); }
	
	private void init(JButton viewer, 
					  int sta, int end, int[] poss) {
		this.imageViewer	= viewer;
		this.start			= sta;
		this.endin			= end;
		this.possibles		= poss;
		if ( (this.start != -1) && (this.endin != -1) ) 
			{ this.currentIndex	= this.start; } 
		else if (this.possibles.length > 0) 
			{ this.currentIndex = this.possibles[0]; }
	}
	
	private void selectMovingImage(boolean next) {
		if (next) {
			// System.out.print(this.currentIndex+" NEXT ");
			if ( (this.start != -1) && (this.endin != -1) ) {
				if (this.currentIndex < this.endin) 
					{ this.currentIndex++; }
				else { this.currentIndex = this.start;  }
			} else if (this.possibles.length > 0) {
				boolean select = false;
				int possLength = this.possibles.length;
				for (int i = 0 ; i < possLength ; i++) {
					if (select) {
						this.currentIndex = this.possibles[i];
						select = false;
					} else if (this.currentIndex == this.possibles[i]) { 
						select = true;
						if (i == (possLength-1) ) 
							{ this.currentIndex = this.possibles[0]; }
					}
				}
			}
		} else {
			// System.out.print(this.currentIndex+" PREV ");
			if ( (this.start != -1) && (this.endin != -1) ) {
				if (this.currentIndex > this.start) 
					{ this.currentIndex--; }
				else { this.currentIndex = this.endin;  }
			} else if (this.possibles.length > 0) {
				boolean select = false;
				int possLength = this.possibles.length;
				for (int i = possLength-1 ; i >= 0 ; i++) {
					if (select) {
						this.currentIndex = this.possibles[i];
						select = false;
					} else if (this.currentIndex == this.possibles[i]) { 
						select = true;
						if (i == 0) { this.currentIndex = 
										this.possibles[possLength-1]; }
					}
				}
			}
		}
		// System.out.println(this.currentIndex);
		this.imageViewer.setIcon(RetroFuturAvailableImages
									.getImageIcon(this.currentIndex));
	}
	

	@Override
	public void actionPerformed(ActionEvent ae) { 
		JButton src		= (JButton)ae.getSource();
		// System.out.println("\t'"+src.getName()+"'\t'"+src.getText()+"'"+src);
		boolean next	= src.getName().equals(RetroFuturPanel.BUTTON_NAMES[1]);
		this.selectMovingImage(next); 
	}

}
