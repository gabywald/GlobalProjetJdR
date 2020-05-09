package gabywald.rpg.tests;

import gabywald.global.data.Utils;
import gabywald.rpg.model.IdeesSousLesDes;
import junit.framework.TestCase;

public class IdeesSousLesDesTests extends TestCase {

	public void testIdeesSousLesDes00() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		
		System.out.println(test.toString());
		
		TestCase.assertTrue(true);
	}
	
	public void testIdeesSousLesDes01() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		
		System.out.println(test.getARandomElement());
		
		TestCase.assertTrue(true);
	}
	
	public void testIdeesSousLesDes02() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		
		for (int i = 0 ; i < Utils.randomValue(100) ; i++) 
			{ System.out.println(test.getARandomElement()); }
		System.out.println();
		
		TestCase.assertTrue(true);
	}
	
	public void testIdeesSousLesDes03() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		
		for (int j = 0 ; j < 1000 ;j++) {
			for (int i = 0 ; i < Utils.randomValue(100) ; i++) 
				{ System.out.println(test.getARandomElement()); }
		}
		System.out.println();
		
		TestCase.assertTrue(true);
	}
	
	public void testIdeesSousLesDes10() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		
		int index = 0;
		System.out.println(IdeesSousLesDes.ENVIRONMENTS[index]);
		for (int i = 0 ; i < 10 ; i++) 
			{ System.out.println("\t'"+test.getAnElementInto(index)+"'"); }
		System.out.println();
		
		TestCase.assertTrue(true);
	}
	
	public void testIdeesSousLesDes11() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		
		int index = 1;
		System.out.println(IdeesSousLesDes.ENVIRONMENTS[index]);
		for (int i = 0 ; i < 10 ; i++) 
			{ System.out.println("\t'"+test.getAnElementInto(index)+"'"); }
		System.out.println();
		
		TestCase.assertTrue(true);
	}
	
	public void testIdeesSousLesDes12() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		
		int index = 2;
		System.out.println(IdeesSousLesDes.ENVIRONMENTS[index]);
		for (int i = 0 ; i < 10 ; i++) 
			{ System.out.println("\t'"+test.getAnElementInto(index)+"'"); }
		System.out.println();
		
		TestCase.assertTrue(true);
	}
	
	public void testIdeesSousLesDes13() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		
		int index = 3;
		System.out.println(IdeesSousLesDes.ENVIRONMENTS[index]);
		for (int i = 0 ; i < 10 ; i++) 
			{ System.out.println("\t'"+test.getAnElementInto(index)+"'"); }
		System.out.println();
		
		TestCase.assertTrue(true);
	}
	
	public void testIdeesSousLesDes14() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		
		int index = 4;
		System.out.println(IdeesSousLesDes.ENVIRONMENTS[index]);
		for (int i = 0 ; i < 10 ; i++) 
			{ System.out.println("\t'"+test.getAnElementInto(index)+"'"); }
		System.out.println();
		
		TestCase.assertTrue(true);
	}
	
	public void testIdeesSousLesDes15() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		
		int index = 5;
		System.out.println(IdeesSousLesDes.ENVIRONMENTS[index]);
		for (int i = 0 ; i < 10 ; i++) 
			{ System.out.println("\t'"+test.getAnElementInto(index)+"'"); }
		System.out.println();
		
		TestCase.assertTrue(true);
	}
	
	public void testIdeesSousLesDes16() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		
		int index = -1;
		System.out.println(index+" !!");
		for (int i = 0 ; i < 10 ; i++) 
			{ System.out.println("\t'"+test.getAnElementInto(index)+"'"); }
		System.out.println();
		
		TestCase.assertTrue(true);
	}
	
	public void testIdeesSousLesDes17() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		
		int index = 6;
		System.out.println(index+" !!");
		for (int i = 0 ; i < 10 ; i++) 
			{ System.out.println("\t'"+test.getAnElementInto(index)+"'"); }
		System.out.println();
		
		TestCase.assertTrue(true);
	}
	
}
