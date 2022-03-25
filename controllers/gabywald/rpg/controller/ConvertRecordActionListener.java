package gabywald.rpg.controller;

import java.awt.event.ActionEvent;
import gabywald.global.controller.BooleanActionListener;
import gabywald.global.data.StringUtils;
import gabywald.rpg.view.panels.RPGPersonnaeAnyPanel;
import gabywald.rpg.view.panels.RPGPersonnaeBasicsPanel;
import gabywald.rpg.view.panels.RPGPersonnaeGURPSPanel;
import gabywald.rpg.view.panels.RPGPersonnaeSimulacreSPanel;

/**
 * 
 * @author Gabriel Chandesris (2011)
 */
public class ConvertRecordActionListener extends BooleanActionListener {
	public static final RPGPersonnaeAnyPanel[] SOURCE_PANELS =  {
		RPGPersonnaeBasicsPanel.getInstance(), 
		RPGPersonnaeGURPSPanel.getInstance(), 
		RPGPersonnaeSimulacreSPanel.getInstance(), 
	};
	private int toWhich, fromWhich;
	
	/** 
	 * Constructor for one conversion. 
	 * @param which (int)
	 * @see gabywald.rpg.view.SpecificityPanel#setConvertAndRecords(int)
	 */
	public ConvertRecordActionListener(int to, int from) 
		{ super(false);	this.toWhich = to;	this.fromWhich = from; }
	
	/** Constructor for Action to all Conversions and Record. */
	public ConvertRecordActionListener() 
		{ super(true);	this.toWhich = -1;	this.fromWhich = -1; }

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (this.isAware) { ; } 
		else {
			RPGPersonnaeAnyPanel orgPane = 
				ConvertRecordActionListener.SOURCE_PANELS[this.fromWhich];
			RPGPersonnaeAnyPanel desPane = 
				ConvertRecordActionListener.SOURCE_PANELS[this.toWhich];
			/**
			 * Basics
			 * 		[Force:FOR;Dexterité:DEX;Intelligence:INT;Apparence:APP;Taille:TAI;Pouvoir:POU;Constitution:CON;Education:EDU]
			 * GURPS
			 * 		[Force:FO;Dexterité:DX;Intelligence:QI;Santé:SA;Points de Fatigue:PF;Points de vie:PV;Volonté:VO;Vitesse de base:VB;Déplacement de base:VO]
			 * SimulacreS
			 * 		[...]
			 */
			
			switch(this.toWhich) {
			case(0): /** Basics */
				System.out.println("to Basics");
				switch(this.fromWhich) {
				case(1): /** GURPS */
					System.out.println("from GURPS");
				
					int FO = orgPane.getFieldValueAt(0);
					int DX = orgPane.getFieldValueAt(1);
					int QI = orgPane.getFieldValueAt(2);
					int SA = orgPane.getFieldValueAt(3);
					
					desPane.setFieldValueAt(0, FO); // FOR
					desPane.setFieldValueAt(1, DX); // DEX
					desPane.setFieldValueAt(2, QI); // INT
					desPane.setFieldValueAt(3, StringUtils.randomValue(11) + 8);
					desPane.setFieldValueAt(4, SA);
					desPane.setFieldValueAt(5, StringUtils.randomValue(11) + 8);
					desPane.setFieldValueAt(6, SA);
					desPane.setFieldValueAt(7, StringUtils.randomValue(11) + 8);
					
					System.out.println("CONVERSION GURPS TO BASICS DONE !!!");
				
					break;
				case(2): /** SimulacreS */
					System.out.println("from SimulacreS");
				
					int corps = orgPane.getFieldValueAt(0);
					int insti = orgPane.getFieldValueAt(1);
					int coeur = orgPane.getFieldValueAt(2);
					int espri = orgPane.getFieldValueAt(3);
					
					int perce = orgPane.getFieldValueAt(4);
					int actio = orgPane.getFieldValueAt(5);
					int desir = orgPane.getFieldValueAt(6);
					int resis = orgPane.getFieldValueAt(7);
					/** 
					int miner = orgPane.getFieldValueAt(8);
					int veget = orgPane.getFieldValueAt(9);
					int anima = orgPane.getFieldValueAt(10);
					int humai = orgPane.getFieldValueAt(11);
					int mater = orgPane.getFieldValueAt(12);
					int virtu = orgPane.getFieldValueAt(13);
					*/ 
					int puiss = orgPane.getFieldValueAt(14);
					int rapid = orgPane.getFieldValueAt(15);
					int preci = orgPane.getFieldValueAt(16);
					/** int pouvo = orgPane.getFieldValueAt(17);
					
					int alien = orgPane.getFieldValueAt(18);
					int force = orgPane.getFieldValueAt(19);
					int heroi = orgPane.getFieldValueAt(20);
					int unive = orgPane.getFieldValueAt(21);
					
					int viepv = orgPane.getFieldValueAt(22);
					int malai = orgPane.getFieldValueAt(23);
					int souff = orgPane.getFieldValueAt(24);
					int eqpsy = orgPane.getFieldValueAt(25); */
					
					int FOR = 3 * (corps - 2) + puiss;
					int DEX = insti + ( preci + rapid ) / 2 + resis + perce;
					int INT = 2 * espri + perce + 1;
					int APP = 3 * coeur + desir - 6;
					int TAI = 3 * actio + (puiss + 1) / 2 + corps;
					int POU = insti + 2 * desir + preci;
					int CON = corps + 3 * resis + puiss;
					int EDU = 2 * espri + coeur / 2 + actio - 6;
					
					FOR = ConvertRecordActionListener.appliance(FOR, 0, 18);
					DEX = ConvertRecordActionListener.appliance(DEX, 0, 18);
					INT = ConvertRecordActionListener.appliance(INT, 0, 18);
					APP = ConvertRecordActionListener.appliance(APP, 0, 18);
					TAI = ConvertRecordActionListener.appliance(TAI, 0, 18);
					POU = ConvertRecordActionListener.appliance(POU, 0, 18);
					CON = ConvertRecordActionListener.appliance(CON, 0, 18);
					EDU = ConvertRecordActionListener.appliance(EDU, 0, 18);
					
					desPane.setFieldValueAt(0, FOR);
					desPane.setFieldValueAt(1, DEX);
					desPane.setFieldValueAt(2, INT);
					desPane.setFieldValueAt(3, APP);
					desPane.setFieldValueAt(4, TAI);
					desPane.setFieldValueAt(5, POU);
					desPane.setFieldValueAt(6, CON);
					desPane.setFieldValueAt(7, EDU);
					/**
					System.out.println("corps : '"+corps+"'");
					System.out.println("insti : '"+insti+"'");
					System.out.println("coeur : '"+coeur+"'");
					System.out.println("espri : '"+espri+"'");
					System.out.println("perce : '"+perce+"'");
					System.out.println("actio : '"+actio+"'");
					System.out.println("desir : '"+desir+"'");
					System.out.println("resis : '"+resis+"'");
					System.out.println("puiss : '"+puiss+"'");
					System.out.println("rapid : '"+rapid+"'");
					System.out.println("preci : '"+preci+"'");
					System.out.println("\tFOR '"+FOR+"'");
					System.out.println("\tDEX '"+DEX+"'");
					System.out.println("\tINT '"+INT+"'");
					System.out.println("\tAPP '"+APP+"'");
					System.out.println("\tTAI '"+TAI+"'");
					System.out.println("\tPOU '"+POU+"'");
					System.out.println("\tCON '"+CON+"'");
					System.out.println("\tEDU '"+EDU+"'");
					*/
					System.out.println("CONVERSION SIMULACRES TO BASICS DONE !!!");
					
					break;
				}
				break;
			case(1): /** GURPS */
				System.out.println("to GURPS");
				switch(this.fromWhich) {
				case(0): /** Basics */
					System.out.println("from Basics");
				
				int FOR = orgPane.getFieldValueAt(0);
				int DEX = orgPane.getFieldValueAt(1);
				int INT = orgPane.getFieldValueAt(2);
				/* int APP = orgPane.getFieldValueAt(3); */
				int TAI = orgPane.getFieldValueAt(4);
				/* int POU = orgPane.getFieldValueAt(5); */
				int CON = orgPane.getFieldValueAt(6);
				/* int EDU = orgPane.getFieldValueAt(7); */
				
				int SAN = ( CON + TAI ) / 2;
				
				
				desPane.setFieldValueAt(0, FOR);
				desPane.setFieldValueAt(1, DEX);
				desPane.setFieldValueAt(2, INT);
				desPane.setFieldValueAt(3, SAN);
				desPane.setFieldValueAt(4, SAN); // Fatigue
				desPane.setFieldValueAt(5, FOR); // PV
				desPane.setFieldValueAt(6, INT); // Volonté
				
				desPane.setFieldValueAt(7, (double)( SAN + DEX ) / 4 );	// Vitesse Base
				desPane.setFieldValueAt(8, ( SAN + DEX ) / 4);			// Déplacement Base
				
				System.out.println("CONVERSION BASICS TO GURPS DONE !!!");
				
					break;
				case(2): /** SimulacreS */
					System.out.println("from SimulacreS");
				
				for (int i = 0 ; i < 8 ; i++) 
					{ desPane.setFieldValueAt( i, i); }
				System.out.println("\tTODO"); // TODO !!
				
					break;
				}
				break;
			case(2): /** SimulacreS */
				System.out.println("to SimulacreS");
				switch(this.fromWhich) {
				case(0): /** Basics */
					System.out.println("from Basics");
				
					int FOR = orgPane.getFieldValueAt(0);
					int DEX = orgPane.getFieldValueAt(1);
					int INT = orgPane.getFieldValueAt(2);
					int APP = orgPane.getFieldValueAt(3);
					int TAI = orgPane.getFieldValueAt(4);
					int POU = orgPane.getFieldValueAt(5);
					int CON = orgPane.getFieldValueAt(6);
					/* int EDU = orgPane.getFieldValueAt(7); */
					
					// int[] destVal = new int[11];
					int corps /** destVal[0] */		= ( FOR + CON + DEX ) / 9;
					int insti /** destVal[1] */		= ( DEX + POU ) / 6;
					int coeur /** destVal[2] */		= ( APP + POU ) / 6;
					int espri /** destVal[3] */		= ( INT + POU ) / 6;
				
					int perce /** destVal[4] */		= ( INT + DEX ) / 6 - 1;
					int actio /** destVal[5] */		= ( TAI + DEX ) / 6 - 1;
					int desir /** destVal[6] */		= ( POU / 3 ) - 1;
					int resis /** destVal[7] */		= ( CON / 3 ) - 1;
					
					int puiss /** destVal[8] */		= ( FOR + TAI ) / 6;
					int rapid /** destVal[9] */		= ( DEX - 3 ) / 4;
					int preci /** destVal[10] */	= ( DEX + POU - 6) / 4;
					
					corps = ConvertRecordActionListener.appliance(corps, 3, 6); // - Utils.randomValue(4);
					insti = ConvertRecordActionListener.appliance(insti, 3, 6); // - Utils.randomValue(4);
					coeur = ConvertRecordActionListener.appliance(coeur, 3, 6); // - Utils.randomValue(4);
					espri = ConvertRecordActionListener.appliance(espri, 3, 6); // - Utils.randomValue(4);
					
					perce = ConvertRecordActionListener.appliance(perce, 0, 4); // - Utils.randomValue(4);
					actio = ConvertRecordActionListener.appliance(actio, 0, 4); // - Utils.randomValue(4);
					desir = ConvertRecordActionListener.appliance(desir, 0, 4); // - Utils.randomValue(4);
					resis = ConvertRecordActionListener.appliance(resis, 0, 4); // - Utils.randomValue(4);
					
					puiss = ConvertRecordActionListener.appliance(puiss, 0, 2); // - Utils.randomValue(2);
					rapid = ConvertRecordActionListener.appliance(rapid, 0, 2); // - Utils.randomValue(2);
					preci = ConvertRecordActionListener.appliance(preci, 0, 2); // - Utils.randomValue(2);
					
					desPane.setFieldValueAt( 0, corps);
					desPane.setFieldValueAt( 1, insti);
					desPane.setFieldValueAt( 2, coeur);
					desPane.setFieldValueAt( 3, espri);
					desPane.setFieldValueAt( 4, perce);
					desPane.setFieldValueAt( 5, actio);
					desPane.setFieldValueAt( 6, desir);
					desPane.setFieldValueAt( 7, resis);
					desPane.setFieldValueAt(14, puiss);
					desPane.setFieldValueAt(15, rapid);
					desPane.setFieldValueAt(16, preci);
					
					/** String[] names = { "corps", "insti", "coeur", "espri", 
										   "perce", "actio", "desir", "resis", 
										   "puiss", "rapid", "preci", }; */
					
//					for (int i = 0 ; i < destVal.length ; i++) {
//						int index = i + ((i >= 8)?6:0);
//						desPane.setFieldValueAt(index, destVal[i]);
//						/** System.out.println("\t'"+names[i]+"'\t'"+destVal[i]+"'"); */
//					}
					
					System.out.println("CONVERSION BASICS TO SIMULACRES DONE !!!");
					
					break;
				case(1): /** GURPS */
					System.out.println("from GURPS");
				
				for (int i = 0 ; i < 8 ; i++) 
					{ desPane.setFieldValueAt( i, i); }
				System.out.println("\tTODO"); // TODO !!
				
					break;
				}
				break;
			default:;
			}
			
			// System.out.println(orgPane+"\n"+desPane); 
		}
		
		System.out.println("#########################################################################\n\n");
	}
	
	private static int appliance(int value, int min, int max) {
		value = Math.max(value, min);
		value = Math.min(value, max);
		return value;
	}

}
