package org.jugbd;

import org.isp.Adder;
import org.isp.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by shantonu on 3/12/16.
 */
public class TestAddition
{
    private Adder adder = null;
    @Before
    public void init(){
        adder = new Calculator();
    }

    @Test public void testAddition(){
        Assert.assertEquals(12.0, adder.add(Integer.valueOf(5),Integer.valueOf(7)));
        Assert.assertEquals(13.0, adder.add(Double.valueOf(5.2),Double.valueOf(7.8)));
        Assert.assertEquals(1.25334914E93, adder.add(6.2667457E92,6.2667457E92));
        //Assert.assertEquals("ShantonuSarker", (String) adder.add("Shantonu","Sarker"));
    }
}
