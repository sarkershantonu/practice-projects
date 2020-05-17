package org.practice.devskill.dcp327;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by SSarker on 5/30/2017.
 */
public class TestDcp327 {

    private SolutionDcp327 solution;

    @Before
    public void init(){
        solution = new SolutionDcp327();

    }

    @Test
    public void testEncryption(){
        byte[] accepted_encryped_value = null;//this is accepter values
        int[] testData = {4,10};
        Assert.assertEquals("Not Encrypted Properly", accepted_encryped_value, solution.encrypt(testData));

    }

}
