package gabywald.rpg.view.panels;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import gabywald.rpg.controller.ImageIconChangeActionListener;
import gabywald.rpg.view.RetroFuturAvailableImages;
import gabywald.rpg.view.SpecificityPanel;

/**
 * 
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2011)
 */
public class RetroFuturPanel extends SpecificityPanel {
	private static RetroFuturPanel instance;
	private static final Font BUTTON_FONT		= 
			new Font("Monospaced", Font.PLAIN, 11);
	public static final String[] BUTTON_NAMES	= { "<=", "=>" };
	private static final int[][] IMG_PARAMETERS	= {
		{   5, 100, 260, 400,   0,  11 }, 
		{   5,   5, 400,  87,  13, 206 }, 
		{ 300, 100, 800, 600, 209, 244 }, 
		{ 550,   5,  80,  80, 246, 257 }, 
		// {   0,   0, 100, 100,   0,  11 }, 
	};
	
	private static final int[][] PNS_PARAMETERS	= {
		{ 270, 200,  20,  20 }, 
		{ 410,   5,  20,  20 }, 
		{ 280, 410,  20,  20 }, 
		{ 640,   5,  20,  20 }, 
		// {   0,   0, 100, 100,   0,  11 }, 
	};
	
	private JButton[] imgButtons;
	private JButton[] pnsButtons;

	private RetroFuturPanel() {
		/** 800*600 */
		
		/** Affiches	296x400	; [0-11] */
		/** Bannieres	400x87	; [13-206] */
		/** Decors		800x600	; [209-244] */
		/** Logos		'62x62'	; [246-257] */
		// /** General { 12, 207, 208, 245, 258, 259} */
		int lengthIMG	= RetroFuturPanel.IMG_PARAMETERS.length;
		this.imgButtons	= new JButton[lengthIMG];
		// int lengthPNS	= RetroFuturPanel.PNS_PARAMETERS.length;
		this.pnsButtons	= new JButton[lengthIMG*2]; /** !! */
		for (int i = 0 ; i < lengthIMG ; i++) {
			this.imgButtons[i]	= new JButton();
			this.imgButtons[i].setFont(RetroFuturPanel.BUTTON_FONT);
			int[] iParameters	= RetroFuturPanel.IMG_PARAMETERS[i];
			int iPosX			= iParameters[0];
			int iPosY			= iParameters[1];
			int iWidth			= iParameters[2];
			int iHeight			= iParameters[3];
			this.imgButtons[i].setBounds(iPosX, iPosY, iWidth, iHeight);
			
			int lenOfParas		= iParameters.length;
			ImageIcon tmpImg	= null;
			int start			= -1;
			int endin			= -1;
			int[] possibles		= new int[0];
			if (lenOfParas == 6) {
				start	= iParameters[4];
				endin	= iParameters[5];
				tmpImg 	= RetroFuturAvailableImages.getImageIcon(start);
					// RetroFuturAvailableImages.getRandom(start, endin);
			} else {
				possibles	= new int[lenOfParas];
				int decal	= 4;
				for (int j = decal ; j < lenOfParas ; j++) 
					{ possibles[j-decal] = iParameters[j]; }
				tmpImg	 	= RetroFuturAvailableImages.getImageIcon(possibles[0]);
					// RetroFuturAvailableImages.getRandom(possibles);
			}
			this.imgButtons[i].setIcon(tmpImg);
			
			this.add(this.imgButtons[i]);
			
			ImageIconChangeActionListener iical = null;
			if (lenOfParas == 6)	{ iical = new ImageIconChangeActionListener(
												this.imgButtons[i], start, endin); }
			else 					{ iical = new ImageIconChangeActionListener(
												this.imgButtons[i], possibles); }
			
			for (int j = 2*i ; j <= 2*i+1 ; j++) {
				int[] pParameters	= RetroFuturPanel.PNS_PARAMETERS[i]; /** !! */
				int pPosX			= pParameters[0];
				int pPosY			= pParameters[1];
				int pWidth			= pParameters[2];
				int pHeight			= pParameters[3];
				String pnsName		= RetroFuturPanel.BUTTON_NAMES[(j%2 == 0)?0:1];
				this.pnsButtons[j]	= new JButton(pnsName);
				this.pnsButtons[j].setFont(RetroFuturPanel.BUTTON_FONT);
				this.pnsButtons[j].setBorder(null);
				this.pnsButtons[j].setName(pnsName);
				// System.out.println("\t"+i+"\t"+j+"\t"+pnsName+"\t"+this.pnsButtons[j].getName());
				if (j%2 == 0)		{ pPosY += pHeight; } // could be 'if (j == 2*i+1)'
				this.pnsButtons[j].setBounds(pPosX, pPosY, pWidth, pHeight);
				this.pnsButtons[j].addActionListener(iical);
				this.add(this.pnsButtons[j]);
			}
		}
	}

	public static RetroFuturPanel getInstance() {
		if (RetroFuturPanel.instance == null) 
			{ RetroFuturPanel.instance = new RetroFuturPanel(); }
		return RetroFuturPanel.instance;
	}

	@Override
	public String getData()				{ return null; }
	@Override
	public void setData(String content)	{ ; }
}
