package gabywald.framework.view;

import javax.swing.JProgressBar;

/**
 * Main item of graphical interface (it is NOT a graphical item), 
 * it is used for computing and drive the user from interface to interface 
 * @author St&eacute;fan Engelen (2006)
 * @author Gabriel Chandesris (2008-2012)
 */
public class MyProcessus implements Runnable {
	private MyInternalFrame internalFrame;
	private JProgressBar progressBar 	= new JProgressBar();
	private int currentStep				= 0, 
				destinaStep				= 0, 
				timeTime				= 0;
	private boolean stop				= false;
	private Thread runner				= null;

	/**
	 * Constructor. 
	 * @param internalFrame (int)
	 */
	public MyProcessus(MyInternalFrame internalFrame)	
		{ this.internalFrame = internalFrame; }
 
	/**
	 * When current instance is launched.  
	 * @see MyProcessus#run
	 */
	public void start() {
		if (this.runner == null){
			this.runner = new Thread(this);
			this.runner.start();
		}
	}

	public void run() {
		
		int t = 0;
		while (this.stop == false) {
			if (this.timeTime != 0) {
				if (t <= this.timeTime)	{ t++; }
				else					{ this.stop(); }
			} else {
				if (this.destinaStep != this.currentStep)
					{ this.move(); }
				else {
					try	{ Thread.sleep(1000); }
					catch (InterruptedException signal) { ; }
				}
			}
		}
	}

	/** 
	 * Stop AloneProcessus for a computing time or as user ask.  
	 * @see MyProcessus#run()
	 */
	public void stop(){
		if (this.runner != null){
			this.stop	= true;
			this.runner	= null;
		}
		this.internalFrame.dispose();
	}
	
	/**
	 * AloneProcessus instance is driving and get the destinaStep token
	 * to select and visualize the good interface with content. 
	 */
	public void goForward() {
		
		this.currentStep = this.destinaStep;
	}
	
	/**
	 * Go to previous step.  
	 * @see MyProcessus#goForward()
	 */
	public void goBackward() { 
		
		this.currentStep = this.destinaStep;
	}
	
	/**
	 * AloneProcessus moving control.   
	 * @see MyProcessus#goForward()
	 * @see MyProcessus#goBackward()
	 */
	public void move(){
		this.internalFrame.setSize(
					(int)this.internalFrame.getDesktopPane().getBounds().getWidth(),
					(int)this.internalFrame.getDesktopPane().getBounds().getHeight());
		if (this.destinaStep > this.currentStep) 
				{ this.goForward(); } 
		else	{ this.goBackward(); } 
	}
	
   


	/**
	 * Destination / interface is changed for user. 
	 * @param destinaStep (int)
	 */
	public void changerDestination (int destinaStep)
		{ this.destinaStep = destinaStep; }

	/**
	 * Progression Bar is inserted in interface. 
	 * @param min (int)
	 * @param max (int)
	 * @param inter (Interface)
	 * @see MyProcessus#goForward()
	 * @see MyPanel
	 */
	public void showProgressBar(int min, int max, MyPanel inter){
		this.progressBar.setMinimum(min);
		this.progressBar.setMaximum(max);
		this.progressBar.setValue(min);
		this.progressBar.setStringPainted(true);
		inter.addProgressBar(this.progressBar); 
	}
	
	/**
	 * Stop Progression Bar. 
	 * Arr&ecirc;t de la barre de progression et retrait de l'interface graphique. 
	 * @param inter Interface
	 * @see MyProcessus#goForward()
	 * @see MyPanel
	 */
	public void hideProgressBar(MyPanel inter){
		this.progressBar.setValue(this.progressBar.getMaximum());
		inter.remProgressBar(this.progressBar);
		this.progressBar.setValue(0);			
	}

	/**
	 * When computing, to make progression bar to progress. 
	 * @param val (int)
	 * @see MyProcessus#goForward()
	 * @see MyPanel
	 */
	public void pushProgressBar(int val){
		this.progressBar.setValue(this.progressBar.getValue() + val);
		this.progressBar.repaint();
	}
}
	
