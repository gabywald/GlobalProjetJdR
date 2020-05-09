package gabywald.framework.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import gabywald.global.view.SpecificSouthPanel;

/**
 * Main windows and catch Events 
 * <br><i>Graphical class</i>
 * <br><i>DPSingleton</i>
 * @author St&eacute;fan Engelen (2006)
 * @author Gabriel Chandesris (2008-2012)
 */
public class MyFrame extends JFrame {
	/** Serial number (42).  */
	private static final long serialVersionUID = 42L;
	private static MyFrame instance;

	/** 
	 * A menuBar. 
	 * @see MyMenu
	 */
	private MyMenu menuBar			= MyMenu.getInstance();
	/**
	 * A virtual Desktop.  
	 * @see MyDesktop
	 */
	private MyDesktop desktop		= MyDesktop.getInstance();
	
	private SpecificSouthPanel toolbar	= SpecificSouthPanel.getInstance(false);
	
	/**
	 * Default constructor of window. To fix fix height and width of the 
	 * window, and fix some actionListener's.  
	 * <br>Inherited method from JFrame are used. 
	 */
	private MyFrame(){
		this.setTitle("Desktop -- Swing / Java Interface");
		this.setJMenuBar(this.menuBar);
		
		JPanel forToolBar	= new JPanel(new BorderLayout());
		forToolBar.add(this.toolbar, BorderLayout.CENTER);
		JPanel intermediate = new JPanel(new BorderLayout());
		intermediate.add(this.desktop, BorderLayout.CENTER);
		intermediate.add(forToolBar, BorderLayout.SOUTH);
		
		this.setContentPane(intermediate);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocation (100, 100);
		this.setSize(this.toolbar.getWidth(), 900);
		this.setVisible(true);
	}
	
	public static MyFrame getInstance() {
		if (MyFrame.instance == null) 
			{ MyFrame.instance = new MyFrame(); }
		return MyFrame.instance;
	}

}

	
