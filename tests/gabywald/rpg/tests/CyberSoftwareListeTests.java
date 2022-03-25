package gabywald.rpg.tests;

import java.io.IOException;

import gabywald.global.data.File;
import gabywald.rpg.model.CyberSoftwareListe;
import junit.framework.TestCase;

/**
 * 
 * @author Gabriel Chandesris (2011, 2022)
 */
public class CyberSoftwareListeTests extends TestCase {

	public void testCyberSoftware00() {
		CyberSoftwareListe test = CyberSoftwareListe.getInstance();
		
		// System.out.println(test.toString());
		TestCase.assertNotNull( test );
		
		File output = new File("resources/conf/dataRPG/listOfGURPSsoftware.txt");
		try {
			output.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		output.empty();
//		output.addString(content);
//		output.write();
		
		TestCase.assertNotNull( output );
	}
	
}
