package gabywald.rpg.view;

import javax.swing.ImageIcon;

import gabywald.global.data.StringUtils;
import gabywald.global.view.AvailableImages;

public abstract class RetroFuturAvailableImages extends AvailableImages {
	private static String[] pathes = {
		"resources/imgGraphics/retrofutur/", 
		"resources/imgGraphics/retrofutur/affiches/",
		"resources/imgGraphics/retrofutur/bannieres/",
		"resources/imgGraphics/retrofutur/decors/",
		"resources/imgGraphics/retrofutur/logos/",
	};

	private static final String[] pathToImages = {
		RetroFuturAvailableImages.pathes[1]+"afficheCatacombes.jpg", 		/** 000 */
		RetroFuturAvailableImages.pathes[1]+"afficheComiteMondial.jpg", 		
		RetroFuturAvailableImages.pathes[1]+"rf_administre.jpg", 		
		RetroFuturAvailableImages.pathes[1]+"rf_agencepaix.jpg", 		
		RetroFuturAvailableImages.pathes[1]+"rf_agences.jpg", 		
		RetroFuturAvailableImages.pathes[1]+"rf_concours.jpg", 				/** 005 */
		RetroFuturAvailableImages.pathes[1]+"rf_enseignement.jpg", 		
		RetroFuturAvailableImages.pathes[1]+"rf_famille.jpg", 		
		RetroFuturAvailableImages.pathes[1]+"rf_indiscretion.jpg", 		
		RetroFuturAvailableImages.pathes[1]+"rf_marchenoir.jpg", 		
		RetroFuturAvailableImages.pathes[1]+"rf_sermentagent.jpg", 			/** 010 */
		RetroFuturAvailableImages.pathes[1]+"rf_urbanisme.jpg", 		
		RetroFuturAvailableImages.pathes[0]+"agenceTransverse.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ab-atelier-c.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ab-bloc-c.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ab-cave-c.jpg", 				/** 015 */
		RetroFuturAvailableImages.pathes[2]+"ab-cave2-c.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ab-cloche-c.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ab-cond-c.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ab-cpt-c.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ab-cpt2-c.jpg", 				/** 020 */
		RetroFuturAvailableImages.pathes[2]+"ab-gare-c.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ab-hall-c.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ab-hall2-c.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ab-hall3-c.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ab-machine-c.jpg", 			/** 025 */
		RetroFuturAvailableImages.pathes[2]+"ab-passerelles-c.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ab-roues-c.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ab-tel-c.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ab-train-c.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ab-tubes-c.jpg", 				/** 030 */
		RetroFuturAvailableImages.pathes[2]+"ab-tunnel-c.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ab-usine-c.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ab-usine2-c.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ad-Scientists-Radiat.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"bf-bill.jpg", 					/** 035 */
		RetroFuturAvailableImages.pathes[2]+"bf-bodysn.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"bf-bord.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"bf-city.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"bf-city2.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"bf-city3.jpg", 				/** 040 */
		RetroFuturAvailableImages.pathes[2]+"bf-cover.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"bf-hamster.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"bf-lucy.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"bf-machines.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"bf-mafieuse.jpg", 				/** 045 */
		RetroFuturAvailableImages.pathes[2]+"bf-sarah.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"bf-simon.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"bf-skull.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"bf-talent.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"br-agent.jpg", 				/** 050 */
		RetroFuturAvailableImages.pathes[2]+"br-buro.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"br-hall.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"br-jouet.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"br-plat.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"br-porte.jpg", 				/** 055 */
		RetroFuturAvailableImages.pathes[2]+"br-portier.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-CabineTel.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-alien.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-apparition-porte.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-batiment.jpg", 				/** 060 */
		RetroFuturAvailableImages.pathes[2]+"dc-ceremonie.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-cinema.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-city.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-city2.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-city3.jpg", 				/** 065 */
		RetroFuturAvailableImages.pathes[2]+"dc-city4.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-couloir-ascenseur.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-couloir-cabinet.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-couloir.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-fastfood.jpg", 				/** 070 */
		RetroFuturAvailableImages.pathes[2]+"dc-grue.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-hotel-reception.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-hotel-reception2.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-hotel.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-interieur-commiss.jpg", 	/** 075 */
		RetroFuturAvailableImages.pathes[2]+"dc-interieur-commiss_002.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-interieur-resto.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-interieur-resto2.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-interieur-resto3.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-la-ville.jpg", 				/** 080 */
		RetroFuturAvailableImages.pathes[2]+"dc-labo.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-metro.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-mur-mer.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-piscine.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-piscine2.jpg", 				/** 085 */
		RetroFuturAvailableImages.pathes[2]+"dc-river.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-river2.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-river3.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-riverbank.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-riverbank2.jpg", 			/** 090 */
		RetroFuturAvailableImages.pathes[2]+"dc-rue-avec-voitures.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-rue-avec-voitures_002.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-rue-avec-voitures_003.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-rue.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-rue2.jpg", 					/** 095 */
		RetroFuturAvailableImages.pathes[2]+"dc-rue3.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-seringue.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-seringues.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-space-city.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-space.jpg", 				/** 100 */
		RetroFuturAvailableImages.pathes[2]+"dc-sunrise.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-train-aerien.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-train-aerien2.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-train-aerien3.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"dc-ubik.jpg", 					/** 105 */
		RetroFuturAvailableImages.pathes[2]+"dc-vehicule.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"jr-attentat.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"jr-city1.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"jr-city2.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"jr-city3.jpg", 				/** 110 */
		RetroFuturAvailableImages.pathes[2]+"jr-city4.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"jr-city5.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"jr-city6.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"jr-city7.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"jr-city8.jpg", 				/** 115 */
		RetroFuturAvailableImages.pathes[2]+"jr-construct.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"jr-construct2.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"jr-construct3.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"jr-construct4.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"jr-construct5.jpg", 			/** 120 */
		RetroFuturAvailableImages.pathes[2]+"jr-crs.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"jr-crs2.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"jr-egout1.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"jr-egout2.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"jr-mercedes.jpg", 				/** 125 */
		RetroFuturAvailableImages.pathes[2]+"jr-moon.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"jr-soldier1.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"jr-soldier2.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"jr-soldier3.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-blow.jpg", 					/** 130 */
		RetroFuturAvailableImages.pathes[2]+"mp-building-1.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-building-2.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-building-2b.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-building-3.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-building-4.jpg", 			/** 135 */
		RetroFuturAvailableImages.pathes[2]+"mp-bureau-1.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-city-1.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-city-2.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-city-3.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-city10.jpg", 				/** 140 */
		RetroFuturAvailableImages.pathes[2]+"mp-escalator.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-foule-1.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-hall-1.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-labo-2.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-labo-3.jpg", 				/** 145 */
		RetroFuturAvailableImages.pathes[2]+"mp-labo-entrance.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-machine-1.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-machine.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-machine2.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-machine3.jpg", 				/** 150 */
		RetroFuturAvailableImages.pathes[2]+"mp-machine4.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-machine5.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-machine6.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-machine7.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-machine8.jpg", 				/** 155 */
		RetroFuturAvailableImages.pathes[2]+"mp-machine9.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-projo.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-radio-house.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-road-snow.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-snow.jpg", 					/** 160 */
		RetroFuturAvailableImages.pathes[2]+"mp-statue.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-tour.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-tower-1.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-tower-3.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-tower-5.jpg", 				/** 165 */
		RetroFuturAvailableImages.pathes[2]+"mp-tower-6.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-tower11.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-tower12.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-tower13.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-traffic-2.jpg", 			/** 170 */
		RetroFuturAvailableImages.pathes[2]+"mp-trainhotel.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-trame.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-usine1.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-usine2.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-usine3.jpg", 				/** 175 */
		RetroFuturAvailableImages.pathes[2]+"mp-ville-1.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-ville-2.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-ville-3.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-zone-1.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-zone-1b.jpg", 				/** 180 */
		RetroFuturAvailableImages.pathes[2]+"mp-zone-1c.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-zone-1d.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-zone-2.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-zone-2b.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-zone-2c.jpg", 				/** 185 */
		RetroFuturAvailableImages.pathes[2]+"mp-zone-3.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-zone2d.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-zoomout-1.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-zoomout-3.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"mp-zoomout-4.jpg", 			/** 190 */
		RetroFuturAvailableImages.pathes[2]+"mp-zoomout-5.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ob-cadran.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ob-console.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ob-console2.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"ob-console3.jpg", 				/** 195 */
		RetroFuturAvailableImages.pathes[2]+"rf-aff.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"rf-resist.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"sig-angel-of-rust.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"sig-astacus.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"sub-connieuberfemme.jpg", 		/** 200 */
		RetroFuturAvailableImages.pathes[2]+"vi-LeSabre.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"vi-atelier.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"vi-bal.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"vi-lit.jpg", 		
		RetroFuturAvailableImages.pathes[2]+"vi-magasin.jpg", 				/** 205 */
		RetroFuturAvailableImages.pathes[2]+"vi-prison.jpg", 		
		RetroFuturAvailableImages.pathes[0]+"cartemonde2qe.jpg", 		
		RetroFuturAvailableImages.pathes[0]+"conseils19dt.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"bluebalcony.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"bluebase.jpg", 				/** 210 */
		RetroFuturAvailableImages.pathes[3]+"blueentrance.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"blueentrytop.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"blueflag.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"blueramp.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"redbase.jpg", 					/** 215 */
		RetroFuturAvailableImages.pathes[3]+"redcomp.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"redentrance.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"redentrytop.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"redflag.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"redramp.jpg", 					/** 220 */
		RetroFuturAvailableImages.pathes[3]+"rf_pic1.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"rf_pic10.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"rf_pic11.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"rf_pic12.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"rf_pic13.jpg", 				/** 225 */
		RetroFuturAvailableImages.pathes[3]+"rf_pic14.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"rf_pic15.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"rf_pic16.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"rf_pic17.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"rf_pic18.jpg", 				/** 230 */
		RetroFuturAvailableImages.pathes[3]+"rf_pic19.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"rf_pic2.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"rf_pic20.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"rf_pic21.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"rf_pic22.jpg", 				/** 235 */
		RetroFuturAvailableImages.pathes[3]+"rf_pic23.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"rf_pic24.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"rf_pic3.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"rf_pic4.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"rf_pic5.jpg", 					/** 240 */
		RetroFuturAvailableImages.pathes[3]+"rf_pic6.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"rf_pic7.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"rf_pic8.jpg", 		
		RetroFuturAvailableImages.pathes[3]+"rf_pic9.jpg", 		
		RetroFuturAvailableImages.pathes[0]+"ghma2noy.jpg", 				/** 245 */
		RetroFuturAvailableImages.pathes[4]+"agence_bien_logo.gif", 		
		RetroFuturAvailableImages.pathes[4]+"agence_comm_logo.gif", 		
		RetroFuturAvailableImages.pathes[4]+"agence_concours_logo.gif", 		
		RetroFuturAvailableImages.pathes[4]+"agence_eau_logo.gif", 		
		RetroFuturAvailableImages.pathes[4]+"agence_etrangers_logo.gif", 	/** 250 */
		RetroFuturAvailableImages.pathes[4]+"agence_gouv_logo.gif", 		
		RetroFuturAvailableImages.pathes[4]+"agence_hygiene_logo.gif", 		
		RetroFuturAvailableImages.pathes[4]+"agence_paix_logo.gif", 		
		RetroFuturAvailableImages.pathes[4]+"agence_pharma_logo.gif", 		
		RetroFuturAvailableImages.pathes[4]+"agence_rehab_logo.gif", 		/** 255 */
		RetroFuturAvailableImages.pathes[4]+"agence_techno_logo.gif", 		
		RetroFuturAvailableImages.pathes[4]+"agence_urb_logo.gif", 		
		RetroFuturAvailableImages.pathes[0]+"metro.jpg", 		
		RetroFuturAvailableImages.pathes[0]+"systeme.jpg", 		
	};
	
	
	public static ImageIcon getRandomAffiche() { 
		/** Affiches [0-11] */
		int start =   0, endin =  11;
		return RetroFuturAvailableImages.getRandom(start, endin); 
	}
	
	public static ImageIcon getRandomBanniere() { 
		/** Bannieres [13-206] */
		int start =  13, endin = 206;
		return RetroFuturAvailableImages.getRandom(start, endin);  
	}
	
	public static ImageIcon getRandomDecor() { 
		/** Decors [209-244] */
		int start = 209, endin 	= 244;
		return RetroFuturAvailableImages.getRandom(start, endin);  
	}
	
	public static ImageIcon getRandomLogo() { 
		/** Logos [246-257] */
		int start = 246, endin 	= 257;
		return RetroFuturAvailableImages.getRandom(start, endin);  
	}
	
	public static ImageIcon getRandomGeneral() { 
		/** General { 12, 207, 208, 245, 258, 259} */
		int[] possibles = { 12, 207, 208, 245, 258, 259};
		return RetroFuturAvailableImages.getRandom(possibles);
	}
	
	public static ImageIcon getRandom() { 
		int select	= StringUtils.randomValue(RetroFuturAvailableImages.pathToImages.length);
		return new ImageIcon(RetroFuturAvailableImages.pathToImages[select]); 
	}
	
	public static ImageIcon getRandom(int start, int endin) {
		int select	= StringUtils.randomValue(endin-start);
		select 		+= start;
		return RetroFuturAvailableImages.getImageIcon(select);
	}
	
	public static ImageIcon getRandom(int[] possibles) {
		int select	= StringUtils.randomValue(possibles.length);
		return RetroFuturAvailableImages.getImageIcon(select); 
	}
	
	public static ImageIcon getImageIcon(int i) { 
		if ( (i >= 0) && (i < RetroFuturAvailableImages.pathToImages.length) )
			{ return new ImageIcon(RetroFuturAvailableImages.pathToImages[i]); }
		else { return null; }
	}
}
