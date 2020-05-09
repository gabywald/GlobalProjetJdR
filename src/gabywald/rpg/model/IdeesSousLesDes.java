package gabywald.rpg.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gabywald.global.data.Utils;
import gabywald.global.data.samples.RPGDataFile;

/**
 * Specific generator for ideas for Scenarii. 
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2011)
 */
public class IdeesSousLesDes implements Generator {
	private static IdeesSousLesDes instance			= null;
	/** Enumeration of contexts (periods of time). */
	public static final String[] ENVIRONMENTS		= {
		"Post-Apocalyptique",	"Médiéval-Fantastique",	"CyberPunk", 
		"Contemporain",			"Space Opéra",			"Début XXème siècle"
	};
	
	private static final Pattern TABLE_PATTERN		= Pattern.compile("^Table (.*?)(\t.*?)?$");

	/** Enumeration of kinds of Tables (personnae, locations, interactions)... */
	private static final String[] POSSIBLE_TABLES	= 
		{ "Personnages", "Lieux", "Interactions" };
	
	private HashMap<String, String> tables;

	private HashMap<String, String> persos, lieux, actions;
	
	private IdeesSousLesDes() {
		this.tables			= new HashMap<String, String>();
		RPGDataFile file	= RPGDataFile.getSousLesDesLidee();
		String[] content 	= file.getTable();
		String currentTable	= null;
		String currentConte	= new String("");
		for (int i = 0 ; i < content.length ; i++) {
			String line			= content[i];
			Matcher tableName	= IdeesSousLesDes.TABLE_PATTERN.matcher(line);
			if (tableName.matches()) {
				if (currentTable != null)  {
					this.tables.put(currentTable, currentConte);
					currentConte = new String("");
				}
				currentTable = tableName.group(1);
			} else {
				if (line.startsWith("\t\t")) 
					{ currentConte += line.substring(2)+";"; }
				else if (line.startsWith("\t")) 
					{ currentConte += ((currentConte.length() > 0)?"\n":"")
										+line.substring(1)+":"; }
			}
		}
		
		if (currentTable != null)  {
			this.tables.put(currentTable, currentConte);
			currentConte = new String("");
		}
		
		/** ***** */
		for (int i = 0 ; i < IdeesSousLesDes.POSSIBLE_TABLES.length ; i++)
			{ this.getTable(i); }
	}

	private void getTable(int which) {
		if ( (which < 0) || (which > 2) )
			{ return; }
		String tabName		= 
			IdeesSousLesDes.POSSIBLE_TABLES[which];
		HashMap<String, String> current = null;
		switch(which) {
		case(0):
			this.persos		= new HashMap<String, String>();
			current			= this.persos;
			break;
		case(1):
			this.lieux		= new HashMap<String, String>();
			current			= this.lieux;
			break;
		case(2):
			this.actions	= new HashMap<String, String>();
			current			= this.actions;
			break;
		default:;
		}
		
		String elements			= this.tables.get(tabName);
		String[] elementsTable	= elements.split("\n");
		for (int i = 0 ; i < elementsTable.length ; i++) {
			String eltsTableName	= elementsTable[i].split(":")[0];
			String restOfEltsTab	= elementsTable[i].split(":")[1];
			// String[] restOfElts	= restOfEltsTab.split(";");
			// System.out.println("\t'"+eltsTableName+"'");
			current.put(eltsTableName, restOfEltsTab);
			/** for (int j = 0 ; j < restOfElts.length ; j++) 
				{ System.out.println("\t\t'"+restOfElts[j]+"'"); } */
		}
		// System.out.println("\n\n");
	}
	
	public static IdeesSousLesDes getInstance() {
		if (IdeesSousLesDes.instance == null) 
			{ IdeesSousLesDes.instance = new IdeesSousLesDes(); }
		return IdeesSousLesDes.instance;
	}
	
	public String toString() {
		String toReturn				= new String("");

		toReturn += IdeesSousLesDes.toStringHelper(this.tables);
		toReturn += IdeesSousLesDes.toStringHelper(this.persos);
		toReturn += IdeesSousLesDes.toStringHelper(this.lieux);
		toReturn += IdeesSousLesDes.toStringHelper(this.actions);
		
		return toReturn;
	}
	
	private static String toStringHelper(HashMap<String, String> hashTable) {
		String toReturn = new String("");
		
		Iterator<String> iteKeys	= hashTable.keySet().iterator();
		System.out.println(hashTable.keySet()+"\t"+hashTable.keySet().size());
		// System.out.println(iteKeys+"\t"+iteKeys.hasNext());
		while (iteKeys.hasNext()) {
			String currentKey = iteKeys.next();
			toReturn += currentKey+"\n";
			toReturn += "\t"+hashTable.get(currentKey).toString()+"\n";
		}
		toReturn += "\n\n";
		
		return toReturn;
	}
	
	public String getARandomElement() {
		int mainSelector	= Utils.randomValue(IdeesSousLesDes.ENVIRONMENTS.length);
		return this.getAnElement(mainSelector);
	}
	
	public String getAnElementInto(int envir) {
		if ( (envir < 0) || (envir >= IdeesSousLesDes.ENVIRONMENTS.length) )
			{ return null; }
		return this.getAnElement(envir);
	}
	
	private String getAnElement(int selection) {
		String main	= IdeesSousLesDes.ENVIRONMENTS[selection];
		return this.getAnElement(main);
	}
	
	private String getAnElement(String mainSelection) {
		String[] persos		= this.persos.get(mainSelection).split(";");
		int firstSelector	= Utils.randomValue(persos.length);
		String firstResult	= persos[firstSelector];
		
		String actionResult	= null;
		String secondResult	= null;
		boolean toLocation	= (Utils.randomValue(100)%3 == 0);
		if (toLocation) {
			String[] actions		= this.actions.get("Personnages et lieux").split(";");
			int actionSelector		= Utils.randomValue(actions.length);
			actionResult			= actions[actionSelector];
		
			String[] lieux			= this.lieux.get(mainSelection).split(";");
			int secondarySelector	= Utils.randomValue(lieux.length);
			secondResult			= lieux[secondarySelector];
		} else {
			String[] actions		= this.actions.get("Entre personnages").split(";");
			int actionSelector		= Utils.randomValue(actions.length);
			actionResult			= actions[actionSelector];
			
			int secondarySelector	= Utils.randomValue(persos.length);
			secondResult			= persos[secondarySelector];
		}
		
		if (actionResult.split(" / ").length > 0) {
			String[] toChoose	= actionResult.split(" / ");
			int choice			= Utils.randomValue(toChoose.length);
			actionResult		= toChoose[choice];
		}
		
		return firstResult+" "+actionResult+" "+secondResult;
	}

}