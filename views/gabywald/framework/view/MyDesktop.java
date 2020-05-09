package gabywald.framework.view;

import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;

/**
 * Software virtual desktop. 
 * <br><i>Graphical class</i>
 * <br><i>DPSingleton</i>
 * @author St&eacute;fan Engelen (2006)
 * @author Gabriel Chandesris (2008-2012)
 */
public class MyDesktop extends JDesktopPaneWithBackgroundImage {
	/** Serial number (44).  */
	private static final long serialVersionUID = 44L;
	private static MyDesktop instance;
	
	private MyDesktop() { super(); }
	
	public static MyDesktop getInstance() {
		if (MyDesktop.instance == null) 
			{ MyDesktop.instance = new MyDesktop(); }
		return MyDesktop.instance;
	}
	
//	public MyInternalFrame createInternalFrame(String name, boolean compass) 
//		{ return new MyInternalFrame(name, this, compass); }
//	
//	public MyInternalFrame createInternalFrame(String name, String wizardData) 
//		{ return new MyInternalFrame(name, this, wizardData); }
	
	/** Desktop is no more used and memory can be freed. */
	public void close() {
		JInternalFrame fenetre = this.getSelectedFrame();
		if (fenetre != null)	{ this.getSelectedFrame().dispose(); }
	}
	
	/**
	 * When opening a file. (Item inactived in menu). 
	 * @deprecated (unused)
	 */
	public void open() {
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(getRootPane().getContentPane());
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You choose to open this file: " +chooser.getSelectedFile().getName());
		}
		System.out.println("open file (ouvrir())");
	}

	/**
	 * To save current state of the Desktop. (Item inactived in menu). 
	 * @deprecated (unused)
	 */
	public void record() { ; }

}

	
