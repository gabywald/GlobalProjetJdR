package gabywald.rpg.view;

import gabywald.global.view.AvailableImages;
import gabywald.rpg.view.panels.WelcomePanel;

import javax.swing.ImageIcon;

public abstract class RPGAvailableImages extends AvailableImages {
	
	private static String[] pathes = {
		"/resources/imgGraphics/rolePlayingGame/", 
		"/resources/imgGraphics/rolePlayingGame/SimulacreS/", 
		"/resources/imgGraphics/rolePlayingGame/SimulacreS/mini12x12/", 
		"/resources/imgGraphics/rolePlayingGame/SimulacreS/normal40x40/", 
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
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[0]) ); }

	public static ImageIcon getSimulacreSCoeurMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[1]) ); }
	
	public static ImageIcon getSimulacreSInstinctMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[2]) ); }
	
	public static ImageIcon getSimulacreSEspritMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[3]) ); }
	
	public static ImageIcon getSimulacreSPerceptionMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[4]) ); }
	
	public static ImageIcon getSimulacreSActionMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[5]) ); }
	
	public static ImageIcon getSimulacreSDesirMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[6]) ); }
	
	public static ImageIcon getSimulacreSResistanceMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[7]) ); }
	
	public static ImageIcon getSimulacreSMineralMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[8]) ); }
	
	public static ImageIcon getSimulacreSVegetalMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[9]) ); }
	
	public static ImageIcon getSimulacreSAnimalMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[10]) ); }
	
	public static ImageIcon getSimulacreSHumainMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[11]) ); }
	
	public static ImageIcon getSimulacreSMecaniqueMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[12]) ); }
	
	public static ImageIcon getSimulacreSVirtuelMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[13]) ); }
	
	public static ImageIcon getSimulacreSNeantMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[14]) ); }
	
	public static ImageIcon getSimulacreSPuissanceMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[15]) ); }
	
	public static ImageIcon getSimulacreSRapiditeMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[16]) ); }
	
	public static ImageIcon getSimulacreSPrecisionMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[17]) ); }
	
	public static ImageIcon getSimulacreSPouvoirMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[18]) ); }
	
	public static ImageIcon getSimulacreSAlienMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[19]) ); }
	
	public static ImageIcon getSimulacreSForceJediMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[20]) ); }
	
	public static ImageIcon getSimulacreSHeroismeMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[21]) ); }
	
	public static ImageIcon getSimulacreSUniverselMini() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[22]) ); }

	
	public static ImageIcon getSimulacreSAlternative() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[23]) ); }
	
	public static ImageIcon getSimulacreSCyberAge() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[24]) ); }
	
	
	public static ImageIcon getSimulacreSCorps() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[25]) ); }
	
	public static ImageIcon getSimulacreSCoeur() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[26]) ); }
	
	public static ImageIcon getSimulacreSInstinct() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[27]) ); }
	
	public static ImageIcon getSimulacreSEsprit() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[28]) ); }
	
	public static ImageIcon getSimulacreSPerception() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[29]) ); }
	
	public static ImageIcon getSimulacreSAction() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[30]) ); }
	
	public static ImageIcon getSimulacreSDesir() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[31]) ); }
	
	public static ImageIcon getSimulacreSResistance() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[32]) ); }
	
	public static ImageIcon getSimulacreSMineral() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[33]) ); }
	
	public static ImageIcon getSimulacreSVegetal() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[34]) ); }
	
	public static ImageIcon getSimulacreSAnimal() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[35]) ); }
	
	public static ImageIcon getSimulacreSHumain() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[36]) ); }
	
	public static ImageIcon getSimulacreSMecanique() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[37]) ); }
	
	public static ImageIcon getSimulacreSVirtuel() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[38]) ); }
	
	public static ImageIcon getSimulacreSNeant() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[39]) ); }
	
	public static ImageIcon getSimulacreSPuissance() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[40]) ); }
	
	public static ImageIcon getSimulacreSRapidite() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[41]) ); }
	
	public static ImageIcon getSimulacreSPrecision() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[42]) ); }
	
	public static ImageIcon getSimulacreSPouvoir() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[43]) ); }
	
	public static ImageIcon getSimulacreSAlien() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[44]) ); }
	
	public static ImageIcon getSimulacreSForceJedi() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[45]) ); }
	
	public static ImageIcon getSimulacreSHeroisme() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[46]) ); }
	
	public static ImageIcon getSimulacreSUniversel() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[47]) ); }
	
	
	public static ImageIcon getGurpsLogo() 
		{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[48]) ); }
	
	
	
	public static ImageIcon getAnIcon(int i) 		{ 
		if ( (i >=0) && (i < RPGAvailableImages.pathToImages.length) )
			{ return new ImageIcon(WelcomePanel.getInstance().getClass().getResource(RPGAvailableImages.pathToImages[i]) ); }
		return null;
	}

}