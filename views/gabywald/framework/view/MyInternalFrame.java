package gabywald.framework.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import gabywald.framework.controller.MyInternalFrameActionListener;
import gabywald.framework.controller.MyMenuActionListener;
import gabywald.global.data.FrameworkDataFile;
import gabywald.global.data.StringUtils;
import gabywald.utilities.logger.Logger;
import gabywald.utilities.logger.Logger.LoggerLevel;

/**
 * 
 * <br><i>Graphical class</i>
 * @author Gabriel Chandesris (2012)
 */
public class MyInternalFrame extends JInternalFrameWithBackgroundImage {
	/** Serial number (49).  */
	private static final long serialVersionUID = 49L;
	/** Current JPanel instance. */
	private MyPanel currentPanel;
	/** If much panels. */
	private MyPanel[] tabPanels;
	private MyInternalFrameActionListener mifal;
	private CardLayout cardlayout;
	
	public MyInternalFrame(String name, MyDesktop desktop, boolean compass, String wizardData) {
		super(name, true, true, false, false);
		this.init(desktop, compass, wizardData);
	}
	
	public MyInternalFrame(String name, MyDesktop desktop) {
		super(name, true, true, false, false);
		this.init(desktop, false, null);
	}
	
	public MyInternalFrame(String name, MyDesktop desktop, boolean compass) {
		super(name, true, true, false, false);
		this.init(desktop, compass, null);
	}
	
	/**
	 * Constructors helper. 
	 * @param desktop (MyDesktop)
	 * @param compass (boolean)
	 */
	private void init(MyDesktop desktop, boolean compass, String wizardData) {
		this.setLayout(null);
		this.show();
		this.pack();
		this.setLocation (0, 0);
		this.setVisible(true);
		
		if (desktop != null) {
			this.setSize((int)desktop.getBounds().getWidth(),
						 (int)desktop.getBounds().getHeight());
			desktop.add(this);
		}
		
		if (wizardData == null) {
			this.cardlayout		= null;
			this.tabPanels		= new MyPanel[0];
			this.currentPanel	= new MyPanel(compass);
			this.currentPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
			this.add(this.currentPanel, BorderLayout.CENTER);
		} else {
			/** System.out.println("\t++ '"+wizardData+"' ++"); */
			String[] tabData	= wizardData.split("\n");
			this.tabPanels		= new MyPanel[tabData.length];
			this.mifal			= new MyInternalFrameActionListener(this);
			this.cardlayout		= new CardLayout();
			this.getContentPane().setLayout(this.cardlayout);
			
			for (int i = 0 ; i < tabData.length ; i++) {
				/** System.out.println("\t\t++ '"+tabData[i]+"' ++"); */
				String[] panelData	= tabData[i].split("\t");
//				int numberOfPanel	= Integer.parseInt(panelData[0]);
				String nameOfPanel	= panelData[1];
				boolean prevShow	= Boolean.parseBoolean(panelData[2]);
				boolean prevEnab	= Boolean.parseBoolean(panelData[3]);
				boolean nextShow	= Boolean.parseBoolean(panelData[4]);
				boolean nextEnab	= Boolean.parseBoolean(panelData[5]);
				boolean finiShow	= Boolean.parseBoolean(panelData[6]);
				boolean finiEnab	= Boolean.parseBoolean(panelData[7]);
				boolean cancShow	= Boolean.parseBoolean(panelData[8]);
				boolean cancEnab	= Boolean.parseBoolean(panelData[9]);
				this.tabPanels[i]	= MyInternalFrame.initPanel(nameOfPanel);/** new MyPanel(); */
				this.tabPanels[i].setPrevVisible(prevShow);
				this.tabPanels[i].setPrevEnabled(prevEnab);
				this.tabPanels[i].setNextVisible(nextShow);
				this.tabPanels[i].setNextEnabled(nextEnab);
				this.tabPanels[i].setFiniVisible(finiShow);
				this.tabPanels[i].setFiniEnabled(finiEnab);
				this.tabPanels[i].setCancVisible(cancShow);
				this.tabPanels[i].setCancEnabled(cancEnab);
				this.tabPanels[i].setListenerForWizard(this.mifal);
				this.tabPanels[i].setBounds(0, 0, this.getWidth(), this.getHeight());
				this.getContentPane().add(this.tabPanels[i], /** nameOfPanel */(i+""));
			}
			
			this.cardlayout.show(this.getContentPane(), "0"); /** !! */
		}
	}
	
	private static MyPanel initPanel(String panelFileName) {
		HashMap<String, String> datas	= MyInternalFrame.readFWFile(panelFileName);
		
		String title	= datas.get("title");
		boolean compass	= Boolean.parseBoolean(datas.get("compass"));
		
		MyPanel mp		= new MyPanel(compass);
		mp.setName(title);
		mp.setLayout(null);
		
		String otherContent			= datas.get(MyMenuActionListener.OTHERSKEY);
		if ( (otherContent != null) && (otherContent.length() > 0) ) {
			/** TODO ... (tests) */
			int defaultWidth = 300, 	defaultHeight	= 20, defaultPos = 20;
			int posX	= defaultPos, posY		= defaultPos, 
				width	= defaultWidth, height	= defaultHeight;
			String[] othersTable	= otherContent.split("\n");
			for (int i = 0 ; i < othersTable.length ; i++) {
				/** System.out.println("\t** '"+othersTable[i]+"' **"); */
				String[] splitter = othersTable[i].split(";;;;;");		/** !! */
				
				for (int j = 0 ; j < splitter.length ; j++) {
					// System.out.println("\t  ''"+splitter[j]+"''");
					String[] moreSplit	= splitter[j].split(":::::");	/** !! */
					/** System.out.println("\t\t'"+moreSplit[0]+"'\t'"+moreSplit[1]+"'"); */
					String type			= moreSplit[0].substring(0, moreSplit[0].indexOf("["));
					String name			= moreSplit[0].substring(moreSplit[0].indexOf("[")+1, 
																 moreSplit[0].indexOf("]"));
					String content		= moreSplit[1];
					if (type.equals("label")) {
						JLabel jl = new JLabel(content);
						jl.setName(name);
						if (name.equals("title")) { 
							height	= defaultHeight * 3;
							width	= defaultWidth	* 2 + defaultHeight;
						} else { 
							height	= defaultHeight; 
							width	= defaultWidth;
						}
						jl.setBounds(posX, posY, width, height);
						jl.setOpaque(true);jl.setHorizontalAlignment(SwingConstants.CENTER);
						jl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
						mp.add(jl); /** XXX !! */
					} else if (type.equals("field")) {
						JTextField jtf = new JTextField(content);
						jtf.setName(name);
						jtf.setBounds(posX, posY, width, height);
						mp.add(jtf); /** XXX !! */
					} else { System.out.println("\t'"+type+"'\t'"+name+"'\t'"+content+"'"); }
					
					System.out.println("\t"+posX+"\t"+posY+"\t"+width+"\t"+height);
					
					posX	+= width + height;
				}
				posX	= defaultPos;
				posY	+= height+5;
			}
		} /** END 'if (otherContent != null)' */
		
		return mp;
	}
	
	public static HashMap<String, String> readFWFile(String wizardFileName) {
		FrameworkDataFile fdf			= MyInternalFrame.getDataFile(wizardFileName);
		try {
			fdf.load();
		} catch (IOException e) {
			Logger.printlnLog(LoggerLevel.LL_ERROR, "FrameworkDataFile file [" + wizardFileName + "] cannot be loaded !" + e.getMessage());
		}
		HashMap<String, String> datas	= new HashMap<String, String>();
		datas.put(MyMenuActionListener.OTHERSKEY, "");
		Pattern keyValue				= Pattern.compile("^([^\t]+?)\t([^\t]+?)$");
		for (String line : fdf.getChampsAsTable()) {
			System.out.println("\t* '"+wizardFileName+"'\t'" + line + "'");
			Matcher keyValM	= keyValue.matcher( line );
			if (keyValM.matches()) { 
				datas.put(keyValM.group(1), keyValM.group(2)); 
				/** System.out.println("\t**'"+keyValM.group(1)+"'\t'"+keyValM.group(2)+"'"); */
			} else {
				System.out.println("\t  '"+wizardFileName+"'\t'" + line + "'");
				String others	= datas.get(MyMenuActionListener.OTHERSKEY);
				others			+=  line + "\n";
				
				System.out.println(StringUtils.repeat("*", 25) + "\n" + others + "" + StringUtils.repeat("*", 25));
				
				datas.put(MyMenuActionListener.OTHERSKEY, others);
			}
		}
		return datas;
	}
	
	public static FrameworkDataFile getDataFile(String baseName) 
		{ return new FrameworkDataFile(baseName+".txt"); }
	
	public JPanel getCurrentPanel() { return this.currentPanel; }
	
	public int getNumberOfCards() { return this.tabPanels.length; }
	
	public void goToCard(int i) {
		if ( (this.cardlayout != null) 
				&& ( (i >= 0) && (i < this.tabPanels.length) ) ) {
			this.cardlayout.show(this.getContentPane(), (i+"") ); /** !! */
		}
	}
	
//	public void createInternalFrame() {
//		JInternalFrame fenetre	= new JInternalFrame();
//		fenetre.setResizable(true);
//		fenetre.setIconifiable(true);
//		fenetre.show();
//		fenetre.pack();
//		fenetre.setLocation (0, 0);
//		fenetre.setVisible(true);
//		MyProcessus proc = new MyProcessus(fenetre);
//		proc.start();
//		
//		fenetre.setSize((int)this.getBounds().getWidth(),
//				(int)this.getBounds().getHeight());
//		this.add(fenetre);
//	}
	
	/**
	 * TODO use processus to make 'wizards' -- procedural following panels...
	 * 
	 * liste de panels avec attributs concernant : <nomDuPanel ++ atributs séparés par '\t'>
	 * 		[previousShowHide;previousEnabledOrNot;nextShowHide;nextEnabledOrNot;finishShowHide;finishEnabledOrNot;...]
	 * 		Cancel par défaut
	 * un panel décrit par
	 * 		label[<nomID>]:::::content
	 * 		field[<nomID>]:::::content
	 * 		...
	 * 			checkbox ??
	 * 			combobox ??
	 * 		éléments sur même ligne séparés par tab '\t' (sinon un élément par ligne (ou un élément 'invisible')
	 */
//	public MyInternalFrame getWizard(MyDesktop desktop, String wizardConf) {
//		
//	}

}
