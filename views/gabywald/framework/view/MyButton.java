package gabywald.framework.view;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 * Personnalized Button.  
 * <br><i>Graphical class</i>
 * @author St&eacute;fan Engelen (2006)
 * @author Gabriel Chandesris (2008-2012)
 */
public class MyButton extends JButton {
	/** Serial number (43). */
	private static final long serialVersionUID = 43L;
	/** Icon with image.  */
	private ImageIcon buttonIcon			= null;
	/** Icon with image.  */
	private ImageIcon buttonIconSelected	= null;

	/**
	 * Constructor with link to image.  
	 * @param image URL
	 */
	public MyButton(String pathToImage){
		super(new ImageIcon(pathToImage));
		this.buttonIcon = new ImageIcon(pathToImage); 
	}
	
	/**
	 * To change selected image.  
	 * @param imagesel URL
	 */
	public void setSelectedIcon(String pathToImage){
		super.setSelectedIcon(new ImageIcon(pathToImage));
		this.buttonIconSelected = new ImageIcon(pathToImage);
	}

	public void paint(Graphics g){
		if (this.isSelected())
			{ this.buttonIconSelected.paintIcon(this, g, 0, 0); } 
		else { this.buttonIcon.paintIcon(this, g, 0, 0); }
	}
}
