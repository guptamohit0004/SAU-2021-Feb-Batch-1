package com.logic.testcase;
import static org.junit.Assert.*;
import com.logic.*;
import org.junit.*;

public class TestLogic2 {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Befor Running Class");
	}
	@Before
	public void setUp() throws Exception {
		System.out.println("Before");
	}
	
	@Test
	public void checkPrime1(){
		System.out.println("1 is Prime or not? --------"+Prime.checkPrimeNumber(1));
		assertEquals(false,Prime.checkPrimeNumber(1));
	}
	@Test
	public void checkPrime2(){
	System.out.println("2 is Prime or not? --------"+Prime.checkPrimeNumber(2));
	assertEquals(true,Prime.checkPrimeNumber(2));
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Running Class");
		System.out.println("");
		System.out.println("");
	}
}
