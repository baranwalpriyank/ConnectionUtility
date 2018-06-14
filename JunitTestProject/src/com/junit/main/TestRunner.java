package com.junit.main;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.junit.test.TestJunitFirst;;

public class TestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestJunitFirst.class);
		
		for(Failure failure : result.getFailures()){
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}

}
