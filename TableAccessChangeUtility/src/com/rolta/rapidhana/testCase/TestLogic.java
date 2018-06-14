package com.rolta.rapidhana.testCase;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.rolta.rapidhana.utility.Calculator;
import com.rolta.rapidhana.utility.PracticeTest;
import com.rolta.rapidhana.utility.TimerTaskExample;

public class TestLogic {

	@InjectMocks
	Calculator cal;
	
	TimerTaskExample pt = new TimerTaskExample();
	@Test
	public void testMethod(){
		System.out.println("inside Test method");
		assertEquals("failure",pt.method());
	}
}
