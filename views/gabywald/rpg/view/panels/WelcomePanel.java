package gabywald.rpg.view.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import gabywald.rpg.view.BuildPersonnaeFrame;
import gabywald.rpg.view.RPGAvailableImages;
import gabywald.rpg.view.SpecificityPanel;

/**
 * 
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2011)
 */
public class WelcomePanel extends SpecificityPanel {
	private static WelcomePanel instance;
	private static final int mainImageWidth = 
		RPGAvailableImages.getSimulacreSAlternative().getIconWidth();
	private static final int mainImageHeight = 
		RPGAvailableImages.getSimulacreSAlternative().getIconHeight();
	
	private JTextArea textZone;
	
	private WelcomePanel() {
		this.setLayout(null);
		
		int x = WelcomePanel.mainImageWidth+60;
		int y = WelcomePanel.mainImageHeight-325;
		int titleWidth		= Integer.parseInt(BuildPersonnaeFrame.confRPG.getValueOf("titleWidth"));
		int titleHeight		= Integer.parseInt(BuildPersonnaeFrame.confRPG.getValueOf("titleHeight"));
		int welcomeWidth	= Integer.parseInt(BuildPersonnaeFrame.confRPG.getValueOf("welcomeScrollWidth"));
		int welcomeHeight	= Integer.parseInt(BuildPersonnaeFrame.confRPG.getValueOf("welcomeScrollHeight"));
		
		JLabel biggTitle = new JLabel(BuildPersonnaeFrame.confRPG.getValueOf("welcomeBiggTitle"));
		biggTitle.setForeground(Color.DARK_GRAY);
		biggTitle.setFont(new Font("Monospaced", Font.BOLD, 24));
		biggTitle.setBounds(x, y, titleWidth, titleHeight);
		this.add(biggTitle);
		
		JLabel subbTitle	= new JLabel(BuildPersonnaeFrame.confRPG.getValueOf("welcomeSubbTitle"));
		subbTitle.setFont(new Font("Monospaced", Font.BOLD, 16));
		subbTitle.setBounds(x-30, y+30, titleWidth, titleHeight);
		this.add(subbTitle);

		this.textZone = new JTextArea();
		this.textZone.setEditable(false);
		JScrollPane scrollZone = new JScrollPane(this.textZone);
		scrollZone.setBounds(WelcomePanel.mainImageWidth+30, 
							 WelcomePanel.mainImageHeight-250, 
							 welcomeWidth, welcomeHeight);
		
		this.add(scrollZone);
	}

	public static WelcomePanel getInstance() {
		if (WelcomePanel.instance == null) 
			{ WelcomePanel.instance = new WelcomePanel(); }
		return WelcomePanel.instance;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(RPGAvailableImages.getSimulacreSCyberAge().getImage(), 
				WelcomePanel.mainImageWidth-50, 0, null);
		
		g.drawImage(RPGAvailableImages.getSimulacreSAlternative().getImage(), 0, 0, null);
		
		int height = RPGAvailableImages.getSimulacreSCyberAge().getIconHeight()+1;
		for (int i = 0 ; i < 23 ; i++) {
			g.drawImage(RPGAvailableImages.getAnIcon(i).getImage(), 
					WelcomePanel.mainImageWidth, height, null);
			height += 12;
		}
		// this.repaint();
	}
	
	@Override
	public String getData()	
		{ return this.textZone.getText(); }

	@Override
	public void setData(String content) 
		{ this.textZone.setText(content); }
}
