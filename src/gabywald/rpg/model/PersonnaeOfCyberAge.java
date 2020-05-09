package gabywald.rpg.model;

/**
 * 
 * @author Gabriel Chandesris (2015)
 */
public class PersonnaeOfCyberAge extends PersonnaeOfBasics {
	
	/** Basics-CyberAge : Attributes names and abbreviations. */
	public static final String[] ATTRIBUTES_NAMES = 
		Personnae.confRPG.getValueOf("personnaeCyberAgeAttributes").split(";");
	
	public static final String[][] GENERAL_NAMES = {
		PersonnaeOfCyberAge.ATTRIBUTES_NAMES
	};
	
	public PersonnaeOfCyberAge() 
		{ super(PersonnaeOfCyberAge.GENERAL_NAMES); }

	@Override
	public String toLaTeX() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonnaeOfBasics toPersonnaeOfBasics() 
		{ return null; }

	@Override
	public PersonnaeOfGURPS toPersonnaeOfGURPS() 
		{ return null; }

	@Override
	public PersonnaeOfSimulacreS toPersonnaeOfSimulacreS() 
		{ return null; }

}
