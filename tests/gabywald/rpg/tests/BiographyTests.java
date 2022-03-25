package gabywald.rpg.tests;

import gabywald.global.data.StringUtils;
import gabywald.rpg.model.BTCyberAge;
import gabywald.rpg.model.BarbarismScientific;
import junit.framework.TestCase;

public class BiographyTests extends TestCase {

	
	public void testBiographyCyberAge00() {
		BTCyberAge test = BTCyberAge.getInstance();
		
		System.out.println(test.toString());
		
		TestCase.assertTrue(true);
	}
	
	
	public void testBiographyCyberAge01() {
		BTCyberAge test = BTCyberAge.getInstance();
		
		System.out.println(test.getARandomElement());
		
		TestCase.assertTrue(true);
	}
	
	public void testBiographyCyberAge02() {
		BTCyberAge test = BTCyberAge.getInstance();
		
		for (int i = 0 ; i < StringUtils.randomValue(100) ; i++) 
			{ System.out.println(test.getARandomElement()); }
		
		TestCase.assertTrue(true);
	}
	
	public void testBiographyCyberAge03() {
		BTCyberAge test = BTCyberAge.getInstance();
		
		for (int j = 0 ; j < 1000 ;j++) {
			for (int i = 0 ; i < StringUtils.randomValue(100) ; i++) 
				{ System.out.println(test.getARandomElement()); }
		}
		
		TestCase.assertTrue(true);
	}
	
	
	
	
	
	
	
	public void testBarbarismScientific00() {
		BarbarismScientific test = BarbarismScientific.getInstance();
		
		System.out.println(test.toString());
		
		TestCase.assertTrue(true);
	}
	
	
	public void testBarbarismScientific01() {
		BarbarismScientific test = BarbarismScientific.getInstance();
		
		System.out.println(test.getARandomElement());
		
		TestCase.assertTrue(true);
	}
	
	public void testBarbarismScientific02() {
		BarbarismScientific test = BarbarismScientific.getInstance();
		
		for (int i = 0 ; i < StringUtils.randomValue(100) ; i++) 
			{ System.out.println(test.getARandomElement()); }
		
		TestCase.assertTrue(true);
	}
	
	public void testBarbarismScientific03() {
		BarbarismScientific test = BarbarismScientific.getInstance();
		
		for (int j = 0 ; j < 1000 ;j++) {
			for (int i = 0 ; i < StringUtils.randomValue(100) ; i++) 
				{ System.out.println(test.getARandomElement()); }
		}
		
		TestCase.assertTrue(true);
	}
}
