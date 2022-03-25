package gabywald.rpg.data.samples;

import gabywald.global.data.DataFile;

/**
 * 
 * @author Gabriel Chandesris (2011, 2022)
 */
@SuppressWarnings("serial")
public class RPGDataFile extends DataFile {
	private static final String DEFAULT_DIRECTORY	= "dataRPG/";
	private static final String[] FILENAMES_SET		= {
		"headerFichePerso.tex",					"bottomFichePerso.tex",				
		"CyberAgeBiography.txt", 				"CyberAgeMetiersEtTalents.txt", 	
		"CyberAgeTalents.txt", 					"talentsSimulacreS.txt", 			
		"sousLesDesLidee.txt", 					"talentsGURPS.txt", 				
		"niveauxTechnologiquesV01.txt", 		"niveauxTechnologiquesV02.txt", 	
		"tableDesArmesGURPSlite.txt", 			"tableDesArmesMeleeGURPSlite.txt",
		"tableDesArmesDistMuscGURPSlite.txt", 	"tableDesArmesDistEnerGURPSlite.txt",
		"listOfGURPSsoftwareWithoutDescr.txt",	"listOfGURPSsoftwareDescriptionIcon.txt",
		"tableEquipementsProtections.txt",		"tableEquipementsMagiques.txt",
		"listOfGURPSsoftware.txt",				"pouvoirsPsySimulacreS.txt",
		"pouvoirsForceGeneric.txt",				"barbarismeScientifique.txt", 
		"", 	"",
	};

	private RPGDataFile(String name) 
		{ super(RPGDataFile.DEFAULT_DIRECTORY + name, true); }
	
	@Override
	public String getDefaultDirectory() 
		{ return RPGDataFile.DEFAULT_DIRECTORY; }
	
	@Override
	public String[] getFileNamesSet() 
		{ return RPGDataFile.FILENAMES_SET; }
	
	public static RPGDataFile getLaTeXheaderPersonnae() 
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[0]); }
	
	public static RPGDataFile getLaTeXbottomPersonnae() 
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[1]); }
	
	public static RPGDataFile getCyberAgeBiography() 
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[2]); }
	
	public static RPGDataFile getCyberAgeJobsAndTalents() 
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[3]); }
	
	public static RPGDataFile getCyberAgeTalents() 
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[4]); }
	
	public static RPGDataFile getSimulacreSTalents() 
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[5]); }

	public static RPGDataFile getSousLesDesLidee() 
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[6]); }
	
	public static RPGDataFile getGURPSTalents() 
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[7]); }
	
	public static RPGDataFile getNTv01() 
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[8]); }
	
	public static RPGDataFile getNTv02() 
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[9]); }

	public static RPGDataFile getGURPSArmes() 
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[10]); }
	
	public static RPGDataFile getGURPSArmesMelee() 
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[11]); }
	
	public static RPGDataFile getGURPSArmesDistMusc() 
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[12]); }
	
	public static RPGDataFile getGURPSArmesDistEner() 
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[13]); }
	
	public static RPGDataFile getGURPSCyberSoftwareNotDesc() 
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[14]); }
	
	public static RPGDataFile getGURPSCyberSoftwareOnlyDesc() 
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[15]); }
	
	public static RPGDataFile getSimulacreSProtections() 
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[16]); }
	
	public static RPGDataFile getSimulacreSMagiques() 
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[17]); }
	
	public static RPGDataFile getGURPSCyberSoftware()
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[18]); }
	
	public static RPGDataFile getSimulacreSpouvoirsPsy()
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[19]); }
	
	public static RPGDataFile getGenericPouvoirsForce()
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[20]); }
	
	public static RPGDataFile getBarbarismeScientifique()
		{ return new RPGDataFile(RPGDataFile.FILENAMES_SET[21]); }
}
