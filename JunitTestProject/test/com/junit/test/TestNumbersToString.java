package com.junit.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.junit.business.NumbersToString;



public class TestNumbersToString {

	/*//using mockito
	
	@Test
	public void test1(){
		NumbersToString obj = Mockito.mock(NumbersToString.class);
		 when(obj.numToStringMethod(10)).thenReturn(false);

	}*/

	
	
	// using junit 
	 
	NumbersToString nu = new NumbersToString();

	@Test
	public void testOneDigitNumberPass() {
		assertEquals("Nine", nu.numToStringMethod(9));
	}
	
	@Test
	public void testTwoDigitNumberPass(){
		assertEquals("NinetyNine", nu.numToStringMethod(99));
	}

	@Test
	public void testThreeDigitNumberPass(){
		assertEquals("Nine hundread NinetyNine", nu.numToStringMethod(999));
	}
	
	@Test
	public void testNumberLessThanZero() {
		assertEquals("number is less than 0", nu.numToStringMethod(0));
	}
	
	@Test
	public void testNumberMoreThan999() {
		assertEquals("number is more than 999", nu.numToStringMethod(1000));
	}
	
	@Test
	public void testOneDigitNumberFail() {
		assertEquals("NINE", nu.numToStringMethod(9));
	}
	
	@Test
	public void testTwoDigitNumberFail() {
		assertEquals("NinetyNINE", nu.numToStringMethod(99));
	}
	
	@Test
	public void testThreeDigitNumberFail() {
		assertEquals("NinetyNINE", nu.numToStringMethod(999));
	}
}
