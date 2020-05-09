package gabywald.global.view;

import javax.swing.ImageIcon;

public abstract class AvailableImages {

	public static final String[] pathToImages = {
		"resources/imgGraphics/icons/favicon.png",						/** 0 */
		"resources/imgGraphics/icons/moreIconsImgs/done.png",
		"resources/imgGraphics/icons/moreIconsImgs/todo.png",
		"resources/imgGraphics/icons/moreIconsImgs/loadingFlower.png", 	
		"resources/imgGraphics/icons/moreIconsImgs/info.png",			
		"resources/imgGraphics/icons/moreIconsImgs/HelpIcon.png",		/** 5 */
	};
	
	public static ImageIcon getFavoriteIcon()		
		{ return new ImageIcon(AvailableImages.pathToImages[0]); }
	public static ImageIcon getDONEicon()		
		{ return new ImageIcon(AvailableImages.pathToImages[1]); }
	public static ImageIcon getTODOicon()		
		{ return new ImageIcon(AvailableImages.pathToImages[2]); }
	public static ImageIcon getLoadingLittleIcon()		
		{ return new ImageIcon(AvailableImages.pathToImages[3]); }
	public static ImageIcon getHelpImage()		
		{ return new ImageIcon(AvailableImages.pathToImages[4]); }
}
