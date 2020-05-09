package gabywald.framework.view;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This Interface defines some functions (and implicitely properties) for Components. 
 * @author Gabriel Chandesris (2012)
 */
public interface HasBackgroundImage {
	/**
	 * To determine distance between imageIcon and Component border. 
	 * @param marginTopTop (int)
	 * @param marginBottom (int)
	 * @param marginLeftLF (int)
	 * @param marginRightR (int)
	 */
	public void setMargins(int marginTopTop, int marginBottom, 
						   int marginLeftLF, int marginRightR);
	
	/**
	 * Component background color. 
	 * @param red (int)
	 * @param green (int)
	 * @param blue (int)
	 */
	public void setBackgroundColor(int red, int green, int blue);
	public void setBackgroundColor(Color color);
	
	/**
	 * Component foreground color. 
	 * @param red (int)
	 * @param green (int)
	 * @param blue (int)
	 */
	public void setForegroundColor(int red, int green, int blue);
	public void setForegroundColor(Color color);
	
	public MyImage getImage();
	public void setImage(MyImage image);
	public void paintComponent(Graphics g);
}
