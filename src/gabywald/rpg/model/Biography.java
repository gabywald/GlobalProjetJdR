package gabywald.rpg.model;

import gabywald.global.data.Utils;
import gabywald.rpg.data.samples.RPGDataFile;

import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This (abstract) class describes a generic item for biography and its generation. 
 * <br>Contains hash of tables needed for generation. 
 * @author Gabriel Chandesris (2011)
 * @see Biography#getARandomElement()
 */
public abstract class Biography implements Generator {
	
	public static final Pattern[] BIOGRAPHIC_TABLES_PATTERNS = {
		Pattern.compile("^Table (.*?)(\t.*?)?$"), 
		Pattern.compile("^\t(.*?)(\t\\[(.*?)\\])?(\t\\{(.*?)\\})?$"), 
	};
	
	private HashMap<String, BiographicTable> tables;
	
	/**
	 * Constructor.
	 * <br>Protected in order to be used by inheritant classes. 
	 * @param file (RPGDataFile) source file.
	 */
	protected Biography(RPGDataFile file) {
		this.tables = new HashMap<String, BiographicTable>();
		
		BiographicTable bioTab = null;
		
		String[] content = file.getTable();
		for (int i = 0 ; i < content.length ; i++) {
			String line = content[i];
			Matcher tableName = Biography.BIOGRAPHIC_TABLES_PATTERNS[0].matcher(line);
			Matcher subtaName = Biography.BIOGRAPHIC_TABLES_PATTERNS[1].matcher(line);
			
			if (tableName.matches()) {
				/** Name of the table !! */
				if (bioTab != null) 
					{ this.tables.put(bioTab.getName(), bioTab); }
				bioTab = new BiographicTable(tableName.group(1));
				if (tableName.group(2) != null) 
					{ bioTab.setComment(tableName.group(2)); }
			} else if (subtaName.matches()) {
				if ( (bioTab != null) && (subtaName.group(1) != null) ) {
					bioTab.addContent(subtaName.group(1));
					if (subtaName.group(3) != null) 
						{ bioTab.addLinkTo(subtaName.group(3)); }
					// else { bioTab.addLinkTo( "" ); }
					if (subtaName.group(5) != null) 
						{ bioTab.addAddin(subtaName.group(5).split(";")); }
					// else { bioTab.addAddin( new String[]{ "" } ); }
				} // END "if ( (bioTab != null) && (subtaName.group(1) != null) )"
			} 
		}
		this.tables.put(bioTab.getName(), bioTab);
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
	
	/**
	 * This method is the main to be called in order to get a line in a biography...
	 * @return (String)
	 */
	public String getARandomElement() {
		BiographicTable orientation = this.tables.get("d'Orientation");
		if (orientation == null) { return null; } 
		else {
			BiographicElement be = null;
			do {
				int rand = Utils.randomValue(orientation.size());
				String content	= orientation.getContent(rand);
				String[] specs	= orientation.getAddins(rand);
				String next		= orientation.getLinkTo(rand);
				if (be == null) { be = new BiographicElement(content, specs); }
				else {
					be.addContent(content);
					be.addSpecs(specs);
				}
				if ( (next != null) && (next.equals("Cicatrices")) ) {
					orientation = this.tables.get("Cicatrices-localisation");
					rand		= Utils.randomValue(orientation.size());
					content 	= "Cicatrice : "+orientation.getContent(rand);
					orientation = this.tables.get("Cicatrices-gravité");
					rand		= Utils.randomValue(orientation.size());
					content		+= orientation.getContent(rand);
					be.addContent(content);
					orientation = null;
				} else if ( (next != null) /** && (this.tables.get(next) != null) */ ) 
					{ orientation = this.tables.get(next); }
				else { orientation = null; }
			} while(orientation != null);
			return be.toString();
		}
	}
}
