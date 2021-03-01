package com.logic.testcase;
import static org.junit.Assert.*;
import com.logic.*;
import org.junit.Test;
public class TestLogic {
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
	@Test
	public void checkPrime3(){
	System.out.println("3 is Prime or not? --------"+Prime.checkPrimeNumber(3));
	assertEquals(true,Prime.checkPrimeNumber(3));
	}
	@Test
	public void checkPrime4(){
	System.out.println("4 is Prime or not? --------"+Prime.checkPrimeNumber(4));
	assertEquals(false,Prime.checkPrimeNumber(4));
	}
	@Test
	public void checkPrime5(){
	System.out.println("5 is Prime or not? --------"+Prime.checkPrimeNumber(5));
	assertEquals(true,Prime.checkPrimeNumber(5));
	System.out.println("");
	System.out.println("");
	}
	@Test
	public void checkPrime99(){
	System.out.println("99 is Prime or not? -------"+Prime.checkPrimeNumber(99));
	assertEquals(false,Prime.checkPrimeNumber(99));
	}
}
