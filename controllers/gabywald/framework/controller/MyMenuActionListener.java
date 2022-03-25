package gabywald.framework.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import gabywald.framework.view.MyDesktop;
import gabywald.framework.view.MyFrame;
import gabywald.framework.view.MyInternalFrame;
import gabywald.framework.view.MyMenu;
import gabywald.global.data.StringUtils;

/**
 * 
 * @author Gabriel Chandesris (2008-2012)
 */
public class MyMenuActionListener implements ActionListener {
	
	public static final String OTHERSKEY = "others";
	/** Instance of MyMenu. */
	// private MyMenu currentMyMenu;
	
	private HashMap<JMenuItem, String> item2actions;
	
	/**
	 * Constructor with given Menu. 
	 * @param menu (MyMenu)
	 */
	public MyMenuActionListener(MyMenu menu) { 
		// this.currentMyMenu	= menu;
		this.item2actions	= new HashMap<JMenuItem, String>();
	}
	
	public void add(JMenuItem jmi, String action) 
		{ this.item2actions.put(jmi, action); }
	
	public void actionPerformed(ActionEvent e) {
		/** 'MyDesktop.getInstance()' WAS '((MyDesktop)(this.currentMyMenu.getRootPane().getContentPane()))' */
		
		JMenuItem[] items = this.item2actions.keySet().toArray(new JMenuItem[0]);
		for (int i = 0 ; i < items.length ; i++) {
			
			if (e.getSource().equals(items[i])) {
				/** System.out.println("\t'"+e.getSource().toString()+"'");
				System.out.println("\t'"+items[i]+"'"); */
				String acts = this.item2actions.get(items[i]);
				// System.out.println("\t AL '"+acts+"'\t'"+items[i]+"'");
				if (acts.startsWith("+")) {
					if (acts.endsWith("exit"))	{ System.exit(0); }
					if (acts.endsWith("close"))	{ MyDesktop.getInstance().close(); }
				} else {
					HashMap<String, String> datas	= MyInternalFrame.readFWFile(acts);
					if (acts.startsWith("wizard"))	{ ; } 
					else if (acts.startsWith("panel"))	{
						datas.put(MyMenuActionListener.OTHERSKEY, "0\t"+acts+StringUtils.repeat("\tfalse", 8)+"\n");
					} /** END 'if (acts.startsWith("panel"))' */
					
					String title	= datas.get("title");
					boolean compass	= Boolean.parseBoolean(datas.get("compass"));
					if ( (title == null) || (title.equals("<none>")) ) {
						title = (String)JOptionPane.showInputDialog(
						MyFrame.getInstance(),
						"Name of the new frame : ",
						"Build a new Frame...",
						JOptionPane.PLAIN_MESSAGE,
						null,
						null,
						"<Default>");
					}
					
					/** MyInternalFrame mif	= */
						new MyInternalFrame(title, MyDesktop.getInstance(), 
											compass, datas.get(MyMenuActionListener.OTHERSKEY));
				}
				break;
			} /** END 'if (e.getSource().equals(items[i]))' */
		}
		
//		if ( (e.getSource().equals(this.currentMyMenu.getNewInternalFrame()))
//				|| (e.getSource().equals(this.currentMyMenu.getNewIFMore())) ) {
//			String name = (String)JOptionPane.showInputDialog(
//							MyFrame.getInstance(),
//							"Name of the new frame : ",
//							"Build a new Frame...",
//							JOptionPane.PLAIN_MESSAGE,
//							null,
//							null,
//							"<Default>");
//			
//			if ( (name == null) || (name.length() <= 0) ) 
//				{ name = (e.getSource().equals(this.currentMyMenu.getNewIFMore()))
//							?"Default with Compass...":"Default..."; }
//			
//			MyDesktop.getInstance().createInternalFrame(name, e.getSource().equals(this.currentMyMenu.getNewIFMore()));
//			
//			/** Much readable...
//			if (e.getSource().equals(this.currentMyMenu.getNewInternalFrame()))
//				{ MyDesktop.getInstance().createInternalFrame(name, false); }
//			if (e.getSource().equals(this.currentMyMenu.getNewIFMore()))
//				{ MyDesktop.getInstance().createInternalFrame(name, true); } */
//		}
//		
//		if (e.getSource().equals(this.currentMyMenu.getClose()))
//			{ MyDesktop.getInstance().close(); }
//		
//		if (e.getSource().equals(this.currentMyMenu.getLeave()))
//			{ System.exit(0); }
//		
//		/** 
//		if (e.getSource().equals(this.currentMyMenu.getOpen()))
//			{ MyDesktop.getInstance().open(); }
//
//		if (e.getSource().equals(this.currentMyMenu.getRecord()))
//			{ MyDesktop.getInstance().record(); }
//		*/

	}
	
}
