package gabywald.framework.view;

import javax.swing.ImageIcon;
import gabywald.global.view.AvailableImages;

public class FWAvailableImages extends AvailableImages {
	private static final String[] pathToImages = {
		"resources/imgGraphics/framework/adn-rouge.jpg",	/** 0 */
		"resources/imgGraphics/framework/adn-vert.jpg",	
		"resources/imgGraphics/framework/adn-bleu.jpg",	
		"resources/imgGraphics/framework/adn.jpg",	
		"resources/imgGraphics/framework/folder03.gif",		
		"resources/imgGraphics/framework/folder05.gif",		/** 5 */
	};
	
	public static ImageIcon getADNrouge() 			{ return new ImageIcon(FWAvailableImages.pathToImages[0]); }
	public static ImageIcon getADNvert() 			{ return new ImageIcon(FWAvailableImages.pathToImages[1]); }
	public static ImageIcon getADNbleu() 			{ return new ImageIcon(FWAvailableImages.pathToImages[2]); }
	public static ImageIcon getADN() 				{ return new ImageIcon(FWAvailableImages.pathToImages[3]); }
	public static ImageIcon getFolder03() 			{ return new ImageIcon(FWAvailableImages.pathToImages[4]); }
	public static ImageIcon getFolder05() 			{ return new ImageIcon(FWAvailableImages.pathToImages[5]); }
	
}
