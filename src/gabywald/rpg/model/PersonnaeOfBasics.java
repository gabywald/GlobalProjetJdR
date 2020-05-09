package gabywald.rpg.model;

/**
 * 
 * @author Gabriel Chandesris (2011)
 */
public class PersonnaeOfBasics extends Personnae {
	/** Basics : Attributes names and abbreviations. */
	public static final String[] ATTRIBUTES_NAMES = 
		Personnae.confRPG.getValueOf("personnaeBasicsAttributes").split(";");
	
	public static final String[][] GENERAL_NAMES = {
		PersonnaeOfBasics.ATTRIBUTES_NAMES
	};
	
	public PersonnaeOfBasics() 
		{ super(PersonnaeOfBasics.GENERAL_NAMES); }
	
	protected PersonnaeOfBasics(String[][] attributes) 
		{ super(attributes); }
	
	@Override
	public String toLaTeX() {
		String toReturn = new String("");
		toReturn += Personnae.getLaTeXbegin();
		/** TODO LaTeX content of Basics Personnae. */
		toReturn += Personnae.getLaTeXend();
		return toReturn;
	}

	@Override
	public PersonnaeOfGURPS toPersonnaeOfGURPS() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public PersonnaeOfBasics toPersonnaeOfBasics() 
		{ return this; }

	@Override
	public PersonnaeOfSimulacreS toPersonnaeOfSimulacreS() {
		// TODO Auto-generated method stub
		return null;
	}

}
