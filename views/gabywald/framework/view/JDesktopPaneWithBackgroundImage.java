package gabywald.framework.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JDesktopPane;
import gabywald.global.data.TextualInfoFile;

/**
 * Re-definition of JDesktopPane including implementation of interface {@linkplain HasBackgroundImage}. 
 * <br><i>Graphical class</i>
 * @author Gabriel Chandesris (2012)
 */
public abstract class JDesktopPaneWithBackgroundImage extends JDesktopPane 
											 implements HasBackgroundImage {
	/** Serial number (98).  */
	private static final long serialVersionUID = 98L;
	
	/** Visualization text Font. */
	protected static final Font FONT4INTERFACE		= new Font (
			TextualInfoFile.getFrameworkContext().getValueOf("desktopPaneFontType"), 
			Font.PLAIN, 
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("desktopPaneFontSize") ) );
	/** Background color. */
	protected static final Color BACKGROUND_COLOR	= new Color(
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("desktopBGColorRed")), 
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("desktopBGColorGreen")), 
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("desktopBGColorBlue"))
			);
	/** Foreground color. */
	protected static final Color FOREGROUND_COLOR	= new Color(
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("desktopFGColorRed")), 
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("desktopFGColorGreen")), 
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("desktopFGColorBlue"))
			);
	/** Background interface image. */
	protected static final MyImage IMG4INTERFACE		= 
		new MyImage(TextualInfoFile.getFrameworkContext().getValueOf("desktopImage"));
	
	protected MyImage currentImage;
	protected Font currentFont;
	protected Color currentBGColor;
	protected Color currentFGColor;
	/** Distance of image from the bvorder. */
	private int marginTopTop = 0, marginBottom = 0, marginLeftLF = 0, marginRightR = 0;

	
	public JDesktopPaneWithBackgroundImage() {
		this.currentImage	= JDesktopPaneWithBackgroundImage.IMG4INTERFACE;
		this.currentFont	= JDesktopPaneWithBackgroundImage.FONT4INTERFACE;
		this.currentBGColor	= JDesktopPaneWithBackgroundImage.BACKGROUND_COLOR;
		this.currentFGColor	= JDesktopPaneWithBackgroundImage.FOREGROUND_COLOR;
	}
	
	public JDesktopPaneWithBackgroundImage(MyImage image, Font font, 
										   Color bgColor, Color fgColor) {
		this.currentImage	= image;
		this.currentFont	= font;
		this.currentBGColor	= bgColor;
		this.currentFGColor	= fgColor;
	}


	public void paintComponent(Graphics g) {
		int posX	= 0 + this.marginLeftLF;
		int posY	= 0 + this.marginTopTop;
		int width	= this.getWidth()  - this.marginRightR - this.marginLeftLF;
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
