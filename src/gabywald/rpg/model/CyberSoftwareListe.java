package gabywald.rpg.model;

import java.util.ArrayList;
import java.util.HashMap;

import gabywald.rpg.data.samples.RPGDataFile;

/**
 * This table describes a list of CyberSoftware.
 * <br><i>DPSingleton</i>
 * @author Gabriel Chandesris (2011)
 * @see CyberSoftware
 */
public class CyberSoftwareListe extends ArrayList<CyberSoftware> {
	private static CyberSoftwareListe instance;

	private HashMap<String, String> hashOfDescriptions;

	private CyberSoftwareListe() {
		/** Implicit initialization... */
		/** ************************** */
		String[] descriptDatas = RPGDataFile.getGURPSCyberSoftwareOnlyDesc().getTable();
		
		this.hashOfDescriptions = new HashMap<String, String>();
		for (int i = 0 ; i < descriptDatas.length ; i++) {
			String[] cutter = descriptDatas[i].split("\t");
			if (cutter.length == 2) 
				{ this.hashOfDescriptions.put(cutter[0], cutter[1]); }
			/** System.out.println("\t"+this.hashOfDescriptions.size()+" : "+cutter[0]+"\t"+cutter[1]); */
		}
		/** System.out.println("\t'"+this.hashOfDescriptions.keySet().size()+"' names and descriptions..."); */
		String[] softwareDatas = RPGDataFile.getGURPSCyberSoftwareNotDesc().getTable();
		for (int i = 0 ; i < softwareDatas.length ; i++) {
			String[] splitter = softwareDatas[i].split("\t");
			if (splitter.length == 7) {
				CyberSoftware csTMP = new CyberSoftware(splitter[0], 
														splitter[1], 
														splitter[2], 
														splitter[3], 
														splitter[4], 
														splitter[5], 
														splitter[6]);
				String descrIcon = this.hashOfDescriptions.get(splitter[0]);
				this.hashOfDescriptions.remove(splitter[0]);
				if (descrIcon != null) { csTMP.setIconDescription(descrIcon); }
				else { System.out.println("\tDescription of '"+splitter[0]+"' not found !!");return; }
				this.add(csTMP);
				/** System.out.println("\t"+this.size()+" : '"+csTMP+"'"); */
			} else if (!softwareDatas[i].equals("")) 
				{ System.out.println("\t"+i+" : "+splitter.length+"\n\t\""+softwareDatas[i]+"\"");return; }
		}
		/** System.out.println("\t'"+this.size()+"' elements of CyberSoftware..."); */
	}
	
	public static CyberSoftwareListe getInstance() {
		if (CyberSoftwareListe.instance == null) 
			{ CyberSoftwareListe.instance = new CyberSoftwareListe(); }
		return CyberSoftwareListe.instance;
	}
	
	public String toString() {
		String toReturn = new String("");
		for (int i = 0 ; i< this.size() ; i++) 
			{ toReturn += this.get(i).toString()+"\n"; }
		return toReturn;
	}
	
	public String[] getNames() {
		String[] toReturn = new String[this.size()];
		for (int i = 0 ; i < this.size() ; i++) 
			{ toReturn[i] = this.get(i).getName(); }
		return toReturn;
	}
	
}
