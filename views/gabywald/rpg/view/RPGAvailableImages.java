package gabywald.rpg.view;

import gabywald.global.view.AvailableImages;

import javax.swing.ImageIcon;

/**
 * 
 * @author Gabriel Chandesris (2011, 2026)
 */
public abstract class RPGAvailableImages extends AvailableImages {
	
	private static String[] pathes = {
		AvailableImages.prefix + "resources/imgGraphics/rolePlayingGame/", 
		AvailableImages.prefix + "resources/imgGraphics/rolePlayingGame/SimulacreS/", 
		AvailableImages.prefix + "resources/imgGraphics/rolePlayingGame/SimulacreS/mini12x12/", 
		AvailableImages.prefix + "resources/imgGraphics/rolePlayingGame/SimulacreS/normal40x40/", 
	};

	private static final String[] pathToImages = {
		RPGAvailableImages.pathes[2]+"corps.png",			/** 0 */
		RPGAvailableImages.pathes[2]+"coeur.png",
		RPGAvailableImages.pathes[2]+"instinct.png",
		RPGAvailableImages.pathes[2]+"esprit.png",
		RPGAvailableImages.pathes[2]+"perception.png", 
		RPGAvailableImages.pathes[2]+"action.png", 			/** 5 */
		RPGAvailableImages.pathes[2]+"desir.png",
		RPGAvailableImages.pathes[2]+"resistance.png",
		RPGAvailableImages.pathes[2]+"mineral.png",
		RPGAvailableImages.pathes[2]+"vegetal.png",
		RPGAvailableImages.pathes[2]+"animal.png",			/** 10 */
		RPGAvailableImages.pathes[2]+"humain.png",
		RPGAvailableImages.pathes[2]+"mecanique.png",
		RPGAvailableImages.pathes[2]+"virtuel.png",
		RPGAvailableImages.pathes[2]+"neant.png",
		RPGAvailableImages.pathes[2]+"puissance.png",		/** 15 */
		RPGAvailableImages.pathes[2]+"rapidite.png",	
		RPGAvailableImages.pathes[2]+"precision.png",
		RPGAvailableImages.pathes[2]+"pouvoir.png",
		RPGAvailableImages.pathes[2]+"alien.png",
		RPGAvailableImages.pathes[2]+"forceJedi.png",		/** 20 */
		RPGAvailableImages.pathes[2]+"heroisme.png",
		RPGAvailableImages.pathes[2]+"universel.png",
		RPGAvailableImages.pathes[1]+"Simulacres_Alternative.jpg",
		RPGAvailableImages.pathes[1]+"CyberAge/ouv_ca.png",
		RPGAvailableImages.pathes[3]+"corps.png",			/** 25 */
		RPGAvailableImages.pathes[3]+"coeur.png",
		RPGAvailableImages.pathes[3]+"instinct.png",
		RPGAvailableImages.pathes[3]+"esprit.png",
		RPGAvailableImages.pathes[3]+"perception.png", 
		RPGAvailableImages.pathes[3]+"action.png", 			/** 30 */
		RPGAvailableImages.pathes[3]+"desir.png",
		RPGAvailableImages.pathes[3]+"resistance.png",
		RPGAvailableImages.pathes[3]+"mineral.png",
		RPGAvailableImages.pathes[3]+"vegetal.png",
		RPGAvailableImages.pathes[3]+"animal.png",			/** 35 */
		RPGAvailableImages.pathes[3]+"humain.png",
		RPGAvailableImages.pathes[3]+"mecanique.png",
		RPGAvailableImages.pathes[3]+"virtuel.png",
		RPGAvailableImages.pathes[3]+"neant.png",
		RPGAvailableImages.pathes[3]+"puissance.png",		/** 40 */
		RPGAvailableImages.pathes[3]+"rapidite.png",	
		RPGAvailableImages.pathes[3]+"precision.png",
		RPGAvailableImages.pathes[3]+"pouvoir.png",
		RPGAvailableImages.pathes[3]+"alien.png",
		RPGAvailableImages.pathes[3]+"forceJedi.png",		/** 45 */
		RPGAvailableImages.pathes[3]+"heroisme.png",
		RPGAvailableImages.pathes[3]+"universel.png",
		RPGAvailableImages.pathes[0]+"gurpsLogo.png",
	};
	
	public static ImageIcon getSimulacreSCorpsMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[0]); }

	public static ImageIcon getSimulacreSCoeurMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[1]); }
	
	public static ImageIcon getSimulacreSInstinctMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[2]); }
	
	public static ImageIcon getSimulacreSEspritMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[3]); }
	
	public static ImageIcon getSimulacreSPerceptionMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[4]); }
	
	public static ImageIcon getSimulacreSActionMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[5]); }
	
	public static ImageIcon getSimulacreSDesirMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[6]); }
	
	public static ImageIcon getSimulacreSResistanceMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[7]); }
	
	public static ImageIcon getSimulacreSMineralMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[8]); }
	
	public static ImageIcon getSimulacreSVegetalMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[9]); }
	
	public static ImageIcon getSimulacreSAnimalMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[10]); }
	
	public static ImageIcon getSimulacreSHumainMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[11]); }
	
	public static ImageIcon getSimulacreSMecaniqueMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[12]); }
	
	public static ImageIcon getSimulacreSVirtuelMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[13]); }
	
	public static ImageIcon getSimulacreSNeantMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[14]); }
	
	public static ImageIcon getSimulacreSPuissanceMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[15]); }
	
	public static ImageIcon getSimulacreSRapiditeMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[16]); }
	
	public static ImageIcon getSimulacreSPrecisionMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[17]); }
	
	public static ImageIcon getSimulacreSPouvoirMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[18]); }
	
	public static ImageIcon getSimulacreSAlienMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[19]); }
	
	public static ImageIcon getSimulacreSForceJediMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[20]); }
	
	public static ImageIcon getSimulacreSHeroismeMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[21]); }
	
	public static ImageIcon getSimulacreSUniverselMini() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[22]); }
	
	public static ImageIcon getSimulacreSAlternative() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[23]); }
	
	public static ImageIcon getSimulacreSCyberAge() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[24]); }
	
	
	public static ImageIcon getSimulacreSCorps() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[25]); }
	
	public static ImageIcon getSimulacreSCoeur() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[26]); }
	
	public static ImageIcon getSimulacreSInstinct() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[27]); }
	
	public static ImageIcon getSimulacreSEsprit() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[28]); }
	
	public static ImageIcon getSimulacreSPerception() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[29]); }
	
	public static ImageIcon getSimulacreSAction() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[30]); }
	
	public static ImageIcon getSimulacreSDesir() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[31]); }
	
	public static ImageIcon getSimulacreSResistance() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[32]); }
	
	public static ImageIcon getSimulacreSMineral() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[33]); }
	
	public static ImageIcon getSimulacreSVegetal() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[34]); }
	
	public static ImageIcon getSimulacreSAnimal() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[35]); }
	
	public static ImageIcon getSimulacreSHumain() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[36]); }
	
	public static ImageIcon getSimulacreSMecanique() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[37]); }
	
	public static ImageIcon getSimulacreSVirtuel() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[38]); }
	
	public static ImageIcon getSimulacreSNeant() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[39]); }
	
	public static ImageIcon getSimulacreSPuissance() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[40]); }
	
	public static ImageIcon getSimulacreSRapidite() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[41]); }
	
	public static ImageIcon getSimulacreSPrecision() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[42]); }
	
	public static ImageIcon getSimulacreSPouvoir() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[43]); }
	
	public static ImageIcon getSimulacreSAlien() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[44]); }
	
	public static ImageIcon getSimulacreSForceJedi() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[45]); }
	
	public static ImageIcon getSimulacreSHeroisme() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[46]); }
	
	public static ImageIcon getSimulacreSUniversel() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[47]); }
	
	
	public static ImageIcon getGurpsLogo() 
		{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[48]); }
	
	
	
	public static ImageIcon getAnIcon(int i) 		{ 
		if ( (i >=0) && (i < RPGAvailableImages.pathToImages.length) )
			{ return AvailableImages.getImageIcon(RPGAvailableImages.pathToImages[i]); }
		return null;
	}

}