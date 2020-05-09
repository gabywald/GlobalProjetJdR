package gabywald.rpg.tests;

import gabywald.global.data.Fichier;
import gabywald.rpg.model.CyberSoftwareListe;
import junit.framework.TestCase;

public class CyberSoftwareListeTests extends TestCase {

	public void testCyberSoftware00() {
		CyberSoftwareListe test = CyberSoftwareListe.getInstance();
		
		System.out.println(test.toString());
		
		String content = test.toString();
		Fichier output = new Fichier("resources/conf/dataRPG/listOfGURPSsoftware.txt");
		output.empty();
		output.addString(content);
		output.write();
		
		TestCase.assertTrue(true);
	}
	
}
