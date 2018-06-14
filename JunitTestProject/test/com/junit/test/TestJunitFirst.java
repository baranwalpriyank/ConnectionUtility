package com.junit.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestJunitFirst {

	@Test
	public void testAdd(){
		String str="String";
		assertEquals("StringFail",str);
	}
}
