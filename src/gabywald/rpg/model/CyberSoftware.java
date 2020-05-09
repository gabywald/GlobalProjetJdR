package gabywald.rpg.model;

/**
 * This table describes a CyberPunk software. 
 * @author Gabriel Chandesris (2011)
 */
public class CyberSoftware {
	/** 'name	Str	MU	Cost(eb)	Function	From	Type	IconDescription' */
	private String[] properties;
	
	public CyberSoftware(String name, String strengh, String memoryUnit, 
						 String cost, String function, String from, 
						 String type, String iconDescription) {
		this.properties = new String[8];
		this.properties[0] = name;
		this.properties[1] = strengh;
		this.properties[2] = memoryUnit;
		this.properties[3] = cost;
		this.properties[4] = function;
		this.properties[5] = from;
		this.properties[6] = type;
		this.properties[7] = iconDescription;
	}
	
	public CyberSoftware(String name, String strengh, String memoryUnit, 
						 String cost, String function, String from, 
						 String type) {
		this.properties = new String[8];
		this.properties[0] = name;
		this.properties[1] = strengh;
		this.properties[2] = memoryUnit;
		this.properties[3] = cost;
		this.properties[4] = function;
		this.properties[5] = from;
		this.properties[6] = type;
		this.properties[7] = null;
	}
	
	public void setIconDescription(String iconDescription) 
		{ this.properties[7] = iconDescription; }
	
	public String getName()				{ return this.properties[0]; }
	public String getStrengh()			{ return this.properties[1]; }
	public String getMemoryUnit()		{ return this.properties[2]; }
	public String getCost()				{ return this.properties[3]; }
	public String getFunction()			{ return this.properties[4]; }
	public String getFrom()				{ return this.properties[5]; }
	public String getType()				{ return this.properties[6]; }
	public String getIconDescription()	{ return this.properties[7]; }
	
	public String toString() {
		String toReturn = new String("");
		for (int i = 0 ; (i < this.properties.length) 
							&& (this.properties[i] != null) ; i++) 
			{ toReturn += ((i != 0)?"\t":"")+this.properties[i]; }
		return toReturn;
	}
}
