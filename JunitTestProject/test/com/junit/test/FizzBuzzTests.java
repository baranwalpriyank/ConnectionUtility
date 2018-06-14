package com.junit.test;
import org.junit.*;

import com.junit.business.FizzBuzz;


public class FizzBuzzTests {

    FizzBuzz nu = new FizzBuzz();
    
   /* @Test
    public void test9() {
        Assert.assertEquals("Nine", "Nine", nu.numToStringMethod(9));
    }
    
    @Test
    public void test99(){
        Assert.assertEquals("NinetyNine", "NinetyNine", nu.numToStringMethod(99));
    }
    
    @Test
    public void test999(){
        Assert.assertEquals("Nine hundread NinetyNine", "Nine hundread NinetyNine", nu.numToStringMethod(999));
    }*/
    
    @Test
    public void test1989() {
        Assert.assertEquals("number is greater than 999", "number is greater than 999", nu.numToStringMethod(1989));
    }
    
   /* @Test
    public void test0() {
        Assert.assertEquals("Number is equal to 0 so exiting the application", nu.numToStringMethod(0));
    }*/

}

