package gabywald.rpg.tests;

import gabywald.global.data.StringUtils;
import gabywald.rpg.model.IdeesSousLesDes;
import junit.framework.TestCase;

public class IdeesSousLesDesTests extends TestCase {

	public void testIdeesSousLesDes00() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		TestCase.assertNotNull(test);
		
		System.out.println(test.toString());
	}
	
	public void testIdeesSousLesDes01() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		TestCase.assertNotNull(test);
		
		System.out.println(test.getARandomElement());
		TestCase.assertNotNull( test.getARandomElement() );
	}
	
	public void testIdeesSousLesDes02() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		TestCase.assertNotNull(test);
		
		for (int i = 0 ; i < StringUtils.randomValue(100) ; i++)  { 
			System.out.println(test.getARandomElement());
			TestCase.assertNotNull( test.getARandomElement() );
		}
		System.out.println();
	}
	
	public void testIdeesSousLesDes03() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		TestCase.assertNotNull(test);
		
		for (int j = 0 ; j < 1000 ;j++) {
			for (int i = 0 ; i < StringUtils.randomValue(100) ; i++) { 
				System.out.println(test.getARandomElement());
				TestCase.assertNotNull( test.getARandomElement() );
			}
		}
		System.out.println();
	}
	
	public void testIdeesSousLesDes10() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		TestCase.assertNotNull(test);
		
		int index = 0;
		System.out.println(IdeesSousLesDes.ENVIRONMENTS[index]);
		for (int i = 0 ; i < 10 ; i++) { 
			System.out.println("\t'"+test.getAnElementInto(index)+"'");
			TestCase.assertNotNull( test.getAnElementInto(index) );
		}
		System.out.println();
	}
	
	public void testIdeesSousLesDes11() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		TestCase.assertNotNull(test);
		
		int index = 1;
		System.out.println(IdeesSousLesDes.ENVIRONMENTS[index]);
		for (int i = 0 ; i < 10 ; i++) { 
			System.out.println("\t'"+test.getAnElementInto(index)+"'");
			TestCase.assertNotNull( test.getAnElementInto(index) );
		}
		System.out.println();
	}
	
	public void testIdeesSousLesDes12() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		TestCase.assertNotNull(test);
		
		int index = 2;
		System.out.println(IdeesSousLesDes.ENVIRONMENTS[index]);
		for (int i = 0 ; i < 10 ; i++) { 
			System.out.println("\t'"+test.getAnElementInto(index)+"'");
			TestCase.assertNotNull( test.getAnElementInto(index) );
		}
		System.out.println();
	}
	
	public void testIdeesSousLesDes13() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		TestCase.assertNotNull(test);
		
		int index = 3;
		System.out.println(IdeesSousLesDes.ENVIRONMENTS[index]);
		for (int i = 0 ; i < 10 ; i++) { 
			System.out.println("\t'"+test.getAnElementInto(index)+"'");
			TestCase.assertNotNull( test.getAnElementInto(index) );
		}
		System.out.println();
	}
	
	public void testIdeesSousLesDes14() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		TestCase.assertNotNull(test);
		
		int index = 4;
		System.out.println(IdeesSousLesDes.ENVIRONMENTS[index]);
		for (int i = 0 ; i < 10 ; i++) { 
			System.out.println("\t'"+test.getAnElementInto(index)+"'");
			TestCase.assertNotNull( test.getAnElementInto(index) );
		}
		System.out.println();
	}
	
	public void testIdeesSousLesDes15() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		TestCase.assertNotNull(test);
		
		int index = 5;
		System.out.println(IdeesSousLesDes.ENVIRONMENTS[index]);
		for (int i = 0 ; i < 10 ; i++) { 
			System.out.println("\t'"+test.getAnElementInto(index)+"'");
			TestCase.assertNotNull( test.getAnElementInto(index) );
		}
		System.out.println();
	}
	
	public void testIdeesSousLesDes16() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		TestCase.assertNotNull(test);
		
		int index = -1;
		System.out.println(index+" !!");
		for (int i = 0 ; i < 10 ; i++) { 
			System.out.println("\t'"+test.getAnElementInto(index)+"'");
			TestCase.assertNull( test.getAnElementInto(index) );
		}
		System.out.println();
	}
	
	public void testIdeesSousLesDes17() {
		IdeesSousLesDes test = IdeesSousLesDes.getInstance();
		TestCase.assertNotNull(test);
		
		int index = 6;
		System.out.println(index+" !!");
		for (int i = 0 ; i < 10 ; i++) { 
			System.out.println("\t'"+test.getAnElementInto(index)+"'");
			TestCase.assertNull( test.getAnElementInto(index) );
		}
		System.out.println();
	}
	
}
