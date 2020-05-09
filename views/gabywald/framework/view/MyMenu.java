package gabywald.framework.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import gabywald.framework.controller.MyMenuActionListener;
import gabywald.global.data.Utils;

/**
 * Window Menu Bar. 
 * <br><i>Some items are inactivated. </i>
 * <br><i>Graphical class</i>
 * <br><i>Graphical class</i>
 * @author St&eacute;fan Engelen (2006)
 * @author Gabriel Chandesris (2008-2012)
 */
public class MyMenu extends JMenuBar {
	private static MyMenu instance;
	/** Serial number (47).  */
	private static final long serialVersionUID = 47L;
	
	private MyMenuActionListener mmal;
	
	/** Just add "\t{*}" before... */
	private static final String BASE_MENU_RECOGNITION = 
		new String("([^\t]*?)(\t([^\t]+))?$");
	
	/**
	 * Default constructor. To add items to the menu and ativate 
	 * user action listeners. 
	 */
	private MyMenu() {
		this.mmal		= new MyMenuActionListener(this);
	
		MyMenuFile conf = MyMenuFile.getInstance(); /** XXX ... */
		int indexOfLine = 0;
		indexOfLine		= MyMenu.menuRecognitionAndAdding
									(this, indexOfLine, conf, this.mmal);
	}
	
	public static MyMenu getInstance() {
		if (MyMenu.instance == null) 
			{ MyMenu.instance = new MyMenu(); }
		return MyMenu.instance;
	}
	
	private static int menuRecognitionAndAdding(JMenuBar menuBar, 
												int indexOfLine, MyMenuFile conf, 
												MyMenuActionListener mmal) {
		
		String currLine		= conf.getLine(indexOfLine);
		/** For current-level menu items. */
		Pattern ppp			= Pattern.compile("^"+Utils.repeat("\t", 0)
								+MyMenu.BASE_MENU_RECOGNITION);
		Matcher mmm			= ppp.matcher(currLine);
		
		while (indexOfLine < conf.getNbLines()) {
			if (mmm.matches()) {
				JMenu firstLvl = new JMenu(mmm.group(1));
				indexOfLine++;
				indexOfLine = MyMenu.menuRecognitionAndAdding(1, firstLvl, indexOfLine, conf, mmal);
				/** System.out.println("\tmenuBar\t"+indexOfLine+"\t'"+currLine+"'"); */
				menuBar.add(firstLvl);
			} /** else { System.out.println("\t.......\t"+indexOfLine+"\t'"+currLine+"'"); } */
			if (indexOfLine < conf.getNbLines()) {
				currLine	= conf.getLine(indexOfLine);
				mmm			= ppp.matcher(currLine);
			}
		}
		
		return indexOfLine;
	}
	
	/**
	 * Iterative / recursive building of Menu. 
	 * <br>More than 2 levels (and automatic). 
	 * @param lvl (int)
	 * @param upperLevel (JMenu)
	 * @param indexOfLine (int)
	 * @param conf (DSCatiaMenuFile)
	 * @return (int)
	 */
	private static int menuRecognitionAndAdding(int lvl, JMenu upperLevel, 
												int indexOfLine, MyMenuFile conf, 
												MyMenuActionListener mmal) {
		String currLine		= conf.getLine(indexOfLine);
		// System.out.println("\tnextLvls\t"+indexOfLine+"\t'"+currLine+"'");
		/** For current-level menu items. */
		Pattern ppp			= Pattern.compile("^"+Utils.repeat("\t", lvl)
								+MyMenu.BASE_MENU_RECOGNITION);
		Matcher mmm			= ppp.matcher(currLine);
		/** For next-level menu items. */
		Pattern pppNext		= Pattern.compile("^"+Utils.repeat("\t", lvl+1)
								+MyMenu.BASE_MENU_RECOGNITION);
		Matcher mmmNext		= pppNext.matcher(currLine);
		
		String prevName		= null;
		String prevActs		= null;

		while (indexOfLine < conf.getNbLines()) { 
			currLine	= conf.getLine(indexOfLine);
			/** System.out.println("\t"+indexOfLine+"\t'"+currLine+"'"); */
			mmm			= ppp.matcher(currLine);
			mmmNext		= pppNext.matcher(currLine);
			/** Matches current level... */
			String name = ((mmm.matches())?mmm.group(1):null);
			String acts = ((mmm.matches())?mmm.group(3):null);

			if (mmmNext.matches()) { 
				if ( (prevName != null) && (prevActs != null) ) {
					JMenu currentLvl = new JMenu(prevName);
					/** Matches next level and current can be extended. */
					indexOfLine = MyMenu.menuRecognitionAndAdding(lvl+1, currentLvl, indexOfLine, conf, mmal); 
					upperLevel.add(currentLvl);
					prevName	= name;
					prevActs	= acts;
				}
			} else if (mmm.matches()) {
				if ( (prevName != null) && (prevActs != null) ) {
					if (prevName.equals("-----")) 
						{ upperLevel.addSeparator(); }
					else { MyMenu.addJMenuItemTo(prevName, prevActs, mmal, upperLevel); }
					prevName	= name;
					prevActs	= acts;
				} else { prevName = name;prevActs = acts; }
				indexOfLine++; /** Current line treated : next ! */
			} /** END 'if (mmm.matches())' */
			else { break; } /** No match, get level UP !! */
		} /** END 'while (indexOfLine < conf.getNbLines())' */
		
		if ( (prevName != null) && (prevActs != null) ) 
			{ MyMenu.addJMenuItemTo(prevName, prevActs, mmal, upperLevel); }

		return indexOfLine;
	}
	
	private static void addJMenuItemTo(String name, String action, 
									   MyMenuActionListener mmal, 
									   JMenu upperLevel) {
		JMenuItem jmi = new JMenuItem(name);
		jmi.setName(name);
		jmi.addActionListener(mmal);
		mmal.add(jmi, action);
		upperLevel.add(jmi); 
	}

}
	
