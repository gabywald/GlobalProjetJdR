package gabywald.framework.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JInternalFrame;
import gabywald.global.data.TextualInfoFile;

/**
 * Re-definition of JInternalFrame including implementation of interface {@linkplain HasBackgroundImage}. 
 * <br><i>Graphical class</i>
 * @author Gabriel Chandesris (2012)
 */
public abstract class JInternalFrameWithBackgroundImage extends JInternalFrame
											   			implements HasBackgroundImage {
	/** Serial number (97).  */
	private static final long serialVersionUID = 97L;

	/** Visualization text Font. */
	protected static final Font FONT4INTERFACE		= new Font (
			TextualInfoFile.getFrameworkContext().getValueOf("internalFramePaneFontType"), 
			Font.PLAIN, 
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("internalFramePaneFontSize") ) );
	/** Background color. */
	protected static final Color BACKGROUND_COLOR	= new Color(
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("internalFrameBGColorRed")), 
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("internalFrameBGColorGreen")), 
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("internalFrameBGColorBlue"))
			);
	/** Foreground color. */
	protected static final Color FOREGROUND_COLOR	= new Color(
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("internalFrameFGColorRed")), 
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("internalFrameFGColorGreen")), 
			Integer.parseInt(TextualInfoFile.getFrameworkContext().getValueOf("internalFrameFGColorBlue"))
			);
	/** Background interface image. */
	protected static final MyImage IMG4INTERFACE		= 
		new MyImage(TextualInfoFile.getFrameworkContext().getValueOf("internalFrameImage"));

	
	protected MyImage currentImage;
	protected Font currentFont;
	protected Color currentBGColor;
	protected Color currentFGColor;
	private int marginTopTop = 0, marginBottom = 0, marginLeftLF = 0, marginRightR = 0;
	
	public JInternalFrameWithBackgroundImage() 
		{ this.initDefault(); }
	
	public JInternalFrameWithBackgroundImage(MyImage image, Font font, 
									 		 Color bgColor, Color fgColor) {
		this.currentImage	= image;
		this.currentFont	= font;
		this.currentBGColor	= bgColor;
		this.currentFGColor	= fgColor;
	}
	
	protected JInternalFrameWithBackgroundImage(String name, 
												boolean resizable, boolean closable, 
												boolean maximizable, boolean iconifiable) {
		super(name, true, true, true, true);
		this.initDefault();
	}
	private void initDefault() {
		this.currentImage	= JInternalFrameWithBackgroundImage.IMG4INTERFACE;
		this.currentFont	= JInternalFrameWithBackgroundImage.FONT4INTERFACE;
		this.currentBGColor	= JInternalFrameWithBackgroundImage.BACKGROUND_COLOR;
		this.currentFGColor	= JInternalFrameWithBackgroundImage.FOREGROUND_COLOR;
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
