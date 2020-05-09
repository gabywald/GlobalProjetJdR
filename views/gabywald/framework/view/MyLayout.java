package gabywald.framework.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * Window organisation (layout) or panel. Useful for Interface's use.
 * <br><i>Graphical class</i>
 * @author St&eacute;fan Engelen (2006)
 * @author Gabriel Chandesris (2008-2012)
 * @see MyPanel
 */
public class MyLayout extends GridBagLayout {
	/** Serial number (46). */
	private static final long serialVersionUID = 46L;
	/** Length.  */
	private int length = 0;
	/** Unit Dimension.  */
	private Dimension dimUnit;

	/**
	 * To change the length of this layout.  
	 * @param container (Container)
	 * @param length (int)
	 */
	public void setTaille(Container container,  int length){	
		this.positionXY(container, new JPanel(), 0, 0, 1, 1);
		this.positionXY(container, new JPanel(), 0, (length-1), 1, 1);
		this.positionXY(container, new JPanel(), (length-1), 0, 1, 1);
		this.positionXY(container, new JPanel(), (length-1), (length-1), 1, 1);
		for (int i = 1 ; i < (length-1) ; i++){ 
			this.positionXY(container, new JPanel(), i, 0, 1, 1); 
			this.positionXY(container, new JPanel(), 0, i, 1, 1); 
			this.positionXY(container, new JPanel(), i, (length-1), 1, 1);
			this.positionXY(container, new JPanel(), (length-1), i, 1, 1);
		}
		Component[] tabPanel = container.getComponents();
		for (int i = 0 ; i < tabPanel.length ; i++)
			{ ((JPanel)(tabPanel[i])).setOpaque(false); }
		this.dimUnit	= tabPanel[0].getPreferredSize();
		this.length		= length;
	}

	/**
	 * To change item position.  
	 * @param container (Container) (parent item)
	 * @param componant (JComponent) (active component)
	 * @param x (int) (position relative)
	 * @param y (int) (position relative)
	 * @param width (int)
	 * @param height (int)
	 */
	public void positionXY(Container container, JComponent componant, 
						   int x, int y, int width, int height){
		GridBagConstraints c = new GridBagConstraints();
		c.gridx		= x;	c.gridy		= y;
		c.ipadx		= 0;	c.ipady		= 0;
		c.weightx	= 1;	c.weighty	= 1;
		c.gridwidth		= width;
		c.gridheight	= height;
		c.fill			= GridBagConstraints.BOTH;
		c.anchor		= GridBagConstraints.CENTER;
		c.insets		= new Insets(0, 0, 0, 0);
		((GridBagLayout)container.getLayout()).setConstraints(componant,c);
		container.add(componant);
		if (this.length != 0) 
			{ componant.setPreferredSize(
	 				new Dimension(width		* this.dimUnit.width,
	 							  height	* this.dimUnit.height)); }
	}

}
