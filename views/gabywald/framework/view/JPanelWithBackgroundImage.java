package gabywald.framework.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import gabywald.global.data.TextualInfoFile;

/**
 * Re-definition of JPanel including implementation of interface {@linkplain HasBackgroundImage}. 
 * <br><i>Graphical class</i>
 * @author Gabriel Chandesris (2012)
 */
public abstract class JPanelWithBackgroundImage extends JPanel 
												implements HasBackgroundImage {
	/** Serial number (99).  */
	private static final long serialVersionUID = 99L;
	/** Visualization text Font. */
	protected static final Font FONT4INTERFACE		= new Font (
			TextualInfoFile.getFrameworkContext().getValueOf("panelPaneFontType"), 
			Font.PLAIN, 
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("panelPaneFontSize") ) );
	/** Background color. */
	protected static final Color BACKGROUND_COLOR	= new Color(
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("panelBGColorRed")), 
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("panelBGColorGreen")), 
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("panelBGColorBlue"))
			);
	/** Foreground color. */
	protected static final Color FOREGROUND_COLOR	= new Color(
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("panelFGColorRed")), 
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("panelFGColorGreen")), 
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("panelFGColorBlue"))
			);
	/** Background interface image. */
	protected static final MyImage IMG4INTERFACE		= 
		new MyImage(TextualInfoFile.getFrameworkContext().getValueOf("panelImage"));
	
	protected MyImage currentImage;
	protected Font currentFont;
	protected Color currentBGColor;
	protected Color currentFGColor;
	private int marginTopTop = 0, marginBottom = 0, marginLeftLF = 0, marginRightR = 0;
	
	public JPanelWithBackgroundImage() {
		this.currentImage	= JPanelWithBackgroundImage.IMG4INTERFACE;
		this.currentFont	= JPanelWithBackgroundImage.FONT4INTERFACE;
		this.currentBGColor	= JPanelWithBackgroundImage.BACKGROUND_COLOR;
		this.currentFGColor	= JPanelWithBackgroundImage.FOREGROUND_COLOR;
	}
	
	public JPanelWithBackgroundImage(MyImage image, Font font, 
									 Color bgColor, Color fgColor) {
		this.currentImage	= image;
		this.currentFont	= font;
		this.currentBGColor	= bgColor;
		this.currentFGColor	= fgColor;
	}


	public void paintComponent(Graphics g) {
		int posX	= 0 + this.marginLeftLF;
		int posY	= 0 + this.marginTopTop;
		int width	= this.getWidth() - this.marginRightR - this.marginLeftLF;
		int height	= this.getHeight() - this.marginBottom - this.marginTopTop;
		g.drawImage(this.currentImage.getImage(), 
					posX, posY, width, height, 
					null);
		// super.paintComponent(g);
	}

	public void setMargins(int marginTopTop, int marginBottom, 
						   int marginLeftLF, int marginRightR) {
		this.marginTopTop	= marginTopTop;
		this.marginBottom	= marginBottom;
		this.marginLeftLF	= marginLeftLF;
		this.marginRightR	= marginRightR;
	}

	public void setBackgroundColor(int red, int green, int blue)
		{ this.currentBGColor = new Color(red, green, blue); }
	
	public void setForegroundColor(int red, int green, int blue)
		{ this.currentBGColor = new Color(red, green, blue); }
	
	public void setBackgroundColor(Color color)
		{ this.currentBGColor = color; }
	
	public void setForegroundColor(Color color)
		{ this.currentBGColor = color; }

	public MyImage getImage()				{ return this.currentImage; }

	public void setImage(MyImage image)		{ this.currentImage	= image; }
}
