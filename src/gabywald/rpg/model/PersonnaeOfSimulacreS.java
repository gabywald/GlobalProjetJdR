package gabywald.rpg.model;

/**
 * 
 * @author Gabriel Chandesris (2011)
 */
public class PersonnaeOfSimulacreS extends Personnae {
	/** SimulacreS (alternate) : Composantes names and abbreviations. [3-6 points each ; total of 18] */
	private static final String[] COMPOSANTES_NAMES = 
		Personnae.confRPG.getValueOf("personnaeSimulacreSComposantes").split(";");
	/** SimulacreS (alternate) : Moyens names and abbreviations. [0-4 points each ; total of 10] */
	private static final String[] MOYENS_NAMES = 
		Personnae.confRPG.getValueOf("personnaeSimulacreSMoyens").split(";");
	/** SimulacreS (alternate) : Domaines names and abbreviations. [0-2 points each ; total of 7 for domaines and energies] */
	private static final String[] DOMAINES_NAMES = 
		Personnae.confRPG.getValueOf("personnaeSimulacreSDomaines").split(";");
	/** SimulacreS (alternate) : Energies names and abbreviations. [0-2 points each ; total of 7 for domaines and energies] ; !! max for 'Pouvoir' is 1 !! */
	private static final String[] ENERGIES_NAMES = 
		Personnae.confRPG.getValueOf("personnaeSimulacreSEnergies").split(";");
	/** SimulacreS (&lt;&lt;Specials&gt;&gt;) : Some more precisions (StarWars, StarGate...)... */
	private static final String[] SPECIAL_NAMES = 
		Personnae.confRPG.getValueOf("personnaeSimulacreSSpecial").split(";");
	/** SimulacreS (alternate) : Some more useful precisions... */
	private static final String[] LIFEUSEFUL_NAMES = 
		Personnae.confRPG.getValueOf("personnaeSimulacreSUseful").split(";");

	public static final String[][] GENERAL_NAMES = {
		PersonnaeOfSimulacreS.COMPOSANTES_NAMES, 
		PersonnaeOfSimulacreS.MOYENS_NAMES, 
		PersonnaeOfSimulacreS.DOMAINES_NAMES, 
		PersonnaeOfSimulacreS.ENERGIES_NAMES,
		PersonnaeOfSimulacreS.SPECIAL_NAMES,
		PersonnaeOfSimulacreS.LIFEUSEFUL_NAMES
	};
	
	public PersonnaeOfSimulacreS() 
		{ super(PersonnaeOfSimulacreS.GENERAL_NAMES); }
	
	
	@Override
	public String toLaTeX() {
		String toReturn = new String("");
		toReturn += Personnae.getLaTeXbegin();
		/** TODO LaTeX content of SimulacreS Personnae. */
		toReturn += Personnae.getLaTeXend();
		return toReturn;
	}

	@Override
	public PersonnaeOfGURPS toPersonnaeOfGURPS() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public PersonnaeOfBasics toPersonnaeOfBasics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonnaeOfSimulacreS toPersonnaeOfSimulacreS() 
		{ return this; }

}
