package com.junit.main;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.junit.test.TestJunitMessage;

public class MessageUtilRunner {

	public static void main(String[] args) {
		Result rs = JUnitCore.runClasses(TestJunitMessage.class);
		
		for(Failure fail:rs.getFailures()){
			System.out.println(fail.toString());
		}
		System.out.println(rs.wasSuccessful());

	}

}
