package gabywald.rpg.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class describes an element / item in a biography. 
 * @author @author Gabriel Chandesris (2011)
 */
public class BiographicElement {
	private String content;
	private String[] addins;
	
	public BiographicElement(String cont) {
		this.content	= cont;
		this.addins		= new String[0];
	}
	
	public BiographicElement(String cont, String[] specs) {
		this.content	= cont;
		this.addins		= (specs != null)?specs:new String[0];
	}
	
	public void addContent(String cont) {
		Pattern table = Pattern.compile("^Table (.*?)$");
		Matcher tabMa = table.matcher(this.content);
		if (tabMa.matches()) { this.content = "["+tabMa.group(1)+"] "+cont; }
		else { this.content += "\n\t"+cont; }
	}
	
	public void addSpec(String spec) {
		String[] nextAddins	= new String[this.addins.length+1];
		for (int i = 0 ; i < this.addins.length ; i++) 
			{ nextAddins[i]	= this.addins[i]; }
		nextAddins[this.addins.length] = spec;
		this.addins	= nextAddins;
	}
	
	public void addSpecs(String[] specs) {
		if (specs == null) { specs = new String[0]; }
		String[] nextAddins	= new String[this.addins.length+specs.length];
		for (int i = 0 ; i < this.addins.length ; i++) 
			{ nextAddins[i]	= this.addins[i]; }
		
		for (int i = this.addins.length ; i < (this.addins.length + specs.length) ; i++) 
			{ nextAddins[i] = specs[i - this.addins.length]; }
		this.addins	= nextAddins;
	}
	
	public String getContent()	{ return this.content; }
	public String[] getAddins()	{ return this.addins; }
	
	public String toString() {
		String toReturn = new String("");
		
		toReturn += "\""+this.content+"\"\n";
		for (int i = 0 ; i < this.addins.length ; i++) 
			{ toReturn += "\t'"+this.addins[i]+"'\n"; }
		
		return toReturn;
	}
}
