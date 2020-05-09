package gabywald.rpg.model;

import gabywald.global.data.TextualInfoFile;
import gabywald.global.data.samples.RPGDataFile;

/**
 * This (abstract) class describe generic properties for a RPC (Role-Playing game Character). 
 * @author Gabriel Chandesris (2011)
 */
public abstract class Personnae {
	public static final TextualInfoFile confRPG	= TextualInfoFile.getRPGpersonnaeBuilder();
	/** General attributes and characteristics. 
	 * [nom, prenom, sex, taille, poid, dataNaissance, especeRace, profession, nationality, player, dateCreation, campagne]. */
	public static String[] GENERAL_ATTR_NAMES = 
		Personnae.confRPG.getValueOf("personnaeGenericAttributes").split(";");
	protected String[] generalAttributes;
	/** Attributes : attributes+senses+others (GURPS), composantes+moyens+domaines+energies+useful (SimulacreS). */
	protected int[][] attributesAndOthers;
	
	/** Default constructor (set size to 0). */
	protected Personnae() 
		{ this.init(new String[0][]); }
	
	/**
	 * Constructor with set of set of Attributes. 
	 * @param attributes (String[][]) Set of set of attributes description. 
	 */
	protected Personnae(String[][] attributes) 
		{ this.init(attributes); }
	
	/**
	 * Constructors Helper. 
	 * @param attributes (String[][]) Set of set of attributes description. 
	 */
	private void init(String[][] attributes) {
		this.generalAttributes = new String[Personnae.GENERAL_ATTR_NAMES.length];
		for (int i = 0 ; i < this.generalAttributes.length ; i++) 
			{ this.generalAttributes[i] = new String(""); }
		this.attributesAndOthers = new int[attributes.length][];
		for (int i = 0 ; i < attributes.length ; i++) {
			this.attributesAndOthers[i] = new int[attributes[i].length];
			for (int j = 0 ; j < attributes[i].length ; j++) 
				{ this.attributesAndOthers[i][j] = 0; }
		}
	}
	
	public abstract PersonnaeOfGURPS toPersonnaeOfGURPS();
	public abstract PersonnaeOfBasics toPersonnaeOfBasics();
	public abstract PersonnaeOfSimulacreS toPersonnaeOfSimulacreS();
	
	public abstract String toLaTeX();
	
	protected static String getLaTeXbegin() 
		{ return RPGDataFile.getLaTeXheaderPersonnae().getChaine(); }
	
	protected static String getLaTeXend() 
		{ return RPGDataFile.getLaTeXbottomPersonnae().getChaine(); }
	
}
