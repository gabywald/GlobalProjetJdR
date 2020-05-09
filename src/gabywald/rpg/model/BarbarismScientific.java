package gabywald.rpg.model;

import gabywald.global.data.Utils;
import gabywald.global.data.samples.RPGDataFile;

import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;

/**
 * 
 * <br>Re-se some elemnts of Biography
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2012)
 * @see Biography#BIOGRAPHIC_TABLES_PATTERNS
 * @see BiographicTable
 */
public class BarbarismScientific implements Generator {
	private static BarbarismScientific instance;
	
	private HashMap<String, BiographicTable> tables;
	
	private BarbarismScientific() {
		RPGDataFile file		= RPGDataFile.getBarbarismeScientifique();
		
		this.tables				= new HashMap<String, BiographicTable>();
		
		BiographicTable barSciTab	= null;
		
		String[] content = file.getTable();
		for (int i = 0 ; i < content.length ; i++) {
			String line = content[i];
			Matcher tableName = Biography.BIOGRAPHIC_TABLES_PATTERNS[0].matcher(line);
			Matcher subtaName = Biography.BIOGRAPHIC_TABLES_PATTERNS[1].matcher(line);
			
			if (tableName.matches()) {
				/** Name of the table !! */
				if (barSciTab != null) 
					{ this.tables.put(barSciTab.getName(), barSciTab); }
				barSciTab = new BiographicTable(tableName.group(1));
				if (tableName.group(2) != null) 
					{ barSciTab.setComment(tableName.group(2)); }
			} else if (subtaName.matches()) {
				if ( (barSciTab != null) && (subtaName.group(1) != null) ) {
					barSciTab.addContent(subtaName.group(1));
					if (subtaName.group(3) != null) 
						{ barSciTab.addLinkTo(subtaName.group(3)); }
					if (subtaName.group(5) != null) 
						{ barSciTab.addAddin(subtaName.group(5).split(" ; ")); }
				}
			} 
		}
		this.tables.put(barSciTab.getName(), barSciTab);
	}
	
	public static BarbarismScientific getInstance() {
		if (BarbarismScientific.instance == null) 
			{ BarbarismScientific.instance = new BarbarismScientific(); }
		return BarbarismScientific.instance;
	}
	
	public String toString() {
		String toReturn = new String("");
		
		Iterator<String> iteKeys	= this.tables.keySet().iterator();
		
		System.out.println(this.tables.keySet()+"\t"+this.tables.keySet().size());
		System.out.println(iteKeys+"\t"+iteKeys.hasNext());
		
		while (iteKeys.hasNext()) {
			String currentKey = iteKeys.next();
			toReturn += this.tables.get(currentKey).toString()+"\n";
		}
		
		return toReturn;
	}

	@Override
	public String getARandomElement() {
		String toReturn = new String("");
		// BiographicTable general	= this.tables.get("Générale");
		BiographicTable objects	= this.tables.get("Objet");
		BiographicTable natures	= this.tables.get("Nature");
		BiographicTable prefixe	= this.tables.get("Préfixe");
		BiographicTable fonctio	= this.tables.get("Fonction");
		BiographicTable positio	= this.tables.get("Position");
		BiographicTable pannes	= this.tables.get("VerbesPannes");
		
		toReturn += "[Le|La|L'] "; // TODO choix de l'article de début...
		
		int randPrefixe = Utils.randomValue(prefixe.size());
		toReturn += prefixe.getContent(randPrefixe)+"-";
		int randObjects = Utils.randomValue(objects.size());
		toReturn += objects.getContent(randObjects)+" à ";
		int randNatures = Utils.randomValue(natures.size());
		toReturn += natures.getContent(randNatures)+" ";
		int randFonctio = Utils.randomValue(fonctio.size());
		toReturn += fonctio.getContent(randFonctio)+" ";
		int randPositio = Utils.randomValue(positio.size());
		toReturn += positio.getContent(randPositio)+" ";
		int randPannes	= Utils.randomValue(pannes.size());
		toReturn += pannes.getContent(randPannes)+". ";
		
		
		return toReturn;
	}

}
