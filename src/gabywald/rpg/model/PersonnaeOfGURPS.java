package gabywald.rpg.model;

import java.util.HashMap;

/**
 * 
 * @author Gabriel Chandesris (2011)
 */
public class PersonnaeOfGURPS extends Personnae {
	/** GURPS : Attributes names and abbreviations. */
	public static final String[] ATTRIBUTES_NAMES = 
		Personnae.confRPG.getValueOf("personnaeGURPSattributes").split(";");
	/** GURPS : Senses names and abbreviations (if any). */
	public static final String[] SENSES_NAMES = 
		Personnae.confRPG.getValueOf("personnaeGURPSsenses").split(";");
	/** GURPS : Other characteristics names and abbreviations (if any). */
	public static final String[] OTHERS_NAMES = 
		Personnae.confRPG.getValueOf("personnaeGURPSothers").split(";");
	/** Taille, poid, parade, blocage, niveau technologique */
	/** GURPS : Some lists names and abbreviations (if any). */
	protected static final String[] MORELIST_NAMES = 
		Personnae.confRPG.getValueOf("personnaeGURPSmoreSets").split(";");
	protected HashMap<String,Integer>[] moreLists;
	
	public static final String[][] GENERAL_NAMES = {
		PersonnaeOfGURPS.ATTRIBUTES_NAMES, 
		PersonnaeOfGURPS.SENSES_NAMES, 
		PersonnaeOfGURPS.OTHERS_NAMES
	};
	
	public PersonnaeOfGURPS() 
		{ super(PersonnaeOfGURPS.GENERAL_NAMES); }
	
	@Override
	public String toLaTeX() {
		String toReturn = new String("");
		toReturn += Personnae.getLaTeXbegin();
		/** TODO LaTeX content of GURPS Personnae. */
		toReturn += Personnae.getLaTeXend();
		return toReturn;
	}
	
	@Override
	public PersonnaeOfGURPS toPersonnaeOfGURPS() 
		{ return this; }
	
	@Override
	public PersonnaeOfBasics toPersonnaeOfBasics() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public PersonnaeOfSimulacreS toPersonnaeOfSimulacreS() {
		// TODO Auto-generated method stub
		return null;
	}
}
