package gabywald.global.view;

import java.net.URL;

import javax.swing.ImageIcon;

import gabywald.rpg.view.panels.WelcomePanel;

/**
 * 
 * @author Gabriel Chandesris (2011, 2026)
 */
public abstract class AvailableImages {
	
	public static String prefix = (WelcomePanel.getInstance().getClass().getResource("").toString().startsWith("file:")?"":"/");
	
	/**
	 * Get Image Icon, difference between Execution Environment (Eclipse and JAR
	 * @param path2file (String) relative
	 * @return (ImageIcon)
	 */
	protected static ImageIcon getImageIcon(String path2file) { 
		URL fromResource = WelcomePanel.getInstance().getClass().getResource(path2file);
//		if (fromResource == null) { Logger.printlnLog(LoggerLevel.LL_DEBUG, "-----:" + path2file); }
//		else { Logger.printlnLog(LoggerLevel.LL_DEBUG, "+++++:" + fromResource); }
//		Logger.printlnLog(LoggerLevel.LL_DEBUG, "*****:" + path2file);
		return (fromResource != null) ? new ImageIcon( fromResource ) : new ImageIcon( path2file ); 
	}

	public static final String[] pathToImages = {
		AvailableImages.prefix + "resources/imgGraphics/icons/favicon.png",						/** 0 */
		AvailableImages.prefix + "resources/imgGraphics/icons/moreIconsImgs/done.png",
		AvailableImages.prefix + "resources/imgGraphics/icons/moreIconsImgs/todo.png",
		AvailableImages.prefix + "resources/imgGraphics/icons/moreIconsImgs/loadingFlower.png", 	
		AvailableImages.prefix + "resources/imgGraphics/icons/moreIconsImgs/info.png",			
		AvailableImages.prefix + "resources/imgGraphics/icons/moreIconsImgs/HelpIcon.png",		/** 5 */
	};
	
	public static ImageIcon getFavoriteIcon()		
		{ return AvailableImages.getImageIcon(AvailableImages.pathToImages[0]); }
	public static ImageIcon getDONEicon()		
		{ return AvailableImages.getImageIcon(AvailableImages.pathToImages[1]); }
	public static ImageIcon getTODOicon()		
		{ return AvailableImages.getImageIcon(AvailableImages.pathToImages[2]); }
	public static ImageIcon getLoadingLittleIcon()		
		{ return AvailableImages.getImageIcon(AvailableImages.pathToImages[3]); }
	public static ImageIcon getHelpImage()		
		{ return AvailableImages.getImageIcon(AvailableImages.pathToImages[4]); }
}
