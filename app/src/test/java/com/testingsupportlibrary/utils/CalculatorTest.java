package com.testingsupportlibrary.utils;

import junit.framework.Assert;

import org.junit.Test;
/**
 * Created by Hafiz Waleed Hussain on 7/11/2015.
 */
public class CalculatorTest {

    @Test
    public void testAdd() throws Exception {
        Calculator calculator = new Calculator();
        int result = calculator.add(2,2);
        Assert.assertEquals(4, result);
    }

    @Test
    public void testSubtract() throws Exception {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(2,2);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testMultiply() throws Exception {

    }

    @Test
    public void testDivide() throws Exception {

    }
}