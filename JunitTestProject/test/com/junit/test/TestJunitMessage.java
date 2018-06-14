package com.junit.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.junit.main.MessageUtil;

public class TestJunitMessage {

	String message = "Hello String";
	MessageUtil mu = new MessageUtil(message);
	
	@Test
	public void testPrintMessageSuccess(){
		//message = "change";
		assertEquals("correct string Passed",message,mu.printMessage());
	}
	
	@Test
	public void testPrintMessageFail(){
		message = "change";
		assertEquals("wrong string Passed",message,mu.printMessage());
	}
}
