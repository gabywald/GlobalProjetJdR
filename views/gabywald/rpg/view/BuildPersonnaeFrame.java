package gabywald.rpg.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import gabywald.global.data.TextualInfoFile;
import gabywald.global.view.GenericJFrame;
import gabywald.global.view.GenericListRendererString;

/**
 * This class defines the main window / frame for the RPG Personnae Manipulator. 
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2011, 2026)
 */
@SuppressWarnings("serial")
public class BuildPersonnaeFrame extends GenericJFrame {
	private static BuildPersonnaeFrame instance;
	public static final TextualInfoFile confRPG	= TextualInfoFile.getRPGpersonnaeBuilder();
	public static final int WIDTH_EAST			= 150;
	
	private JList<String> listOfPersonae;

	private BuildPersonnaeFrame() {
		super(BuildPersonnaeFrame.confRPG.getValueOf("title"));
		/** For pre-build and recorded 'personnae' */
		this.listOfPersonae		= new JList<String>();
		this.listOfPersonae.setCellRenderer(new GenericListRendererString());
		JScrollPane eastListSet	= new JScrollPane(this.listOfPersonae);
		eastListSet.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		eastListSet.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		eastListSet.setPreferredSize(new Dimension(BuildPersonnaeFrame.WIDTH_EAST, 0));
		
		this.add(eastListSet, BorderLayout.EAST);
		this.add(PersonnaeBuildTabs.getInstance(), BorderLayout.CENTER);
		
		this.setVisible(true);
	}

	public static BuildPersonnaeFrame getInstance() {
		if (BuildPersonnaeFrame.instance == null) 
			{ BuildPersonnaeFrame.instance = new BuildPersonnaeFrame(); }
		return BuildPersonnaeFrame.instance;
	}

}
