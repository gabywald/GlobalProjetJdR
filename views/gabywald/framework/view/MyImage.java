package gabywald.framework.view;

import javax.swing.ImageIcon;

/**
 * For images visualization. 
 * <br><i>Graphical class</i>
 * @author St&eacute;fan Engelen (2006)
 * @author Gabriel Chandesris (2008-2012)
 */
public class MyImage extends ImageIcon {
	/** Serial number (45).  */
	private static final long serialVersionUID = 45L;
	
	/**
	 * Constructor with file name to read and to see. 
	 * @param fichier (String)
	 */
	public MyImage(String fichier)
		{ super(fichier); }
	   
}
	
