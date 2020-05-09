package gabywald.rpg.model;

/**
 * Tjis class describes a table / array of elements, items and links in a biographical context. 
 * @author Gabriel Chandesris (2011)
 */
public class BiographicTable {
	private String name, comment;
	private String[] contents;
	private String[] linkTo;
	private String[][] addins;
	
	public BiographicTable(String name) {
		this.name		= name;
		this.contents	= new String[0];
		this.linkTo		= new String[0];
		this.addins		= new String[0][];
	}
	
	public void setComment(String comm) 
		{ this.comment = comm; }	

	public void addContent(String content) {
		String[] nextContents	= new String[this.contents.length+1];
		String[] nextLinkTo		= new String[this.contents.length+1];
		String[][] nextAddins	= new String[this.contents.length+1][];
		for (int i = 0 ; i < this.contents.length ; i++) {
			nextContents[i]	= this.contents[i];
			nextLinkTo[i]	= this.linkTo[i];
			nextAddins[i]	= this.addins[i];
		}
		nextContents[this.contents.length]	= content;
		nextLinkTo[this.contents.length]	= null;
		nextAddins[this.contents.length]	= null;
		this.contents	= nextContents;
		this.linkTo		= nextLinkTo;
		this.addins		= nextAddins;
	}
	
	public void addLinkTo(String link) {
		if (this.linkTo.length > 0) 
			{ this.linkTo[this.linkTo.length-1] = link; }
	}
	
	public void addAddin(String[] addin) {
		if (this.addins.length > 0) 
			{ this.addins[this.addins.length-1] = addin; }
	}
	
	public String getName() { return this.name ; }
	
	public String getContent(int i) { 
		if ( (i >= 0) && (i < this.contents.length) ) 
			{ return this.contents[i]; }
		else { return null; }
	}
	
	public String getLinkTo(int i) { 
		if ( (i >= 0) && (i < this.linkTo.length) ) 
			{ return this.linkTo[i]; }
		else { return null; }
	}
	
	public String[] getAddins(int i) { 
		if ( (i >= 0) && (i < this.addins.length) ) 
			{ return this.addins[i]; }
		else { return null; }
	}
	
	public int size() { return this.contents.length; }
	
	
	public String toString() {
		String toReturn = new String("");
		
		toReturn += "Table "+this.name+((this.comment != null)?this.comment:"")+"\n";
		for (int i = 0 ; i < this.contents.length ; i++) {
			toReturn += "\t"+this.contents[i];
			if (this.linkTo[i] != null) 
				{ toReturn += "\t["+this.linkTo[i]+"]"; }
			if ( (this.addins[i] != null) && (this.addins[i].length > 0) ) { 
				String[] currentAddin = this.addins[i];
				toReturn += "\t{";
				String tmp = new String("");
				for (int j = 0 ; j < currentAddin.length ; j++) 
					{ tmp += currentAddin[j]+" ; "; }
				toReturn += tmp.substring(0, tmp.length()-3)+"}";
			}
			toReturn += "\n";
		}
		
		return toReturn;
	}
}
