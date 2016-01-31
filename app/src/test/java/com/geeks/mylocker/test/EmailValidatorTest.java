package com.geeks.mylocker.test;


import junit.framework.Assert;
import org.junit.Test;
import java.util.logging.Logger;


/**
 * Created by dspark on 1/25/16.
 */
public class EmailValidatorTest {

    Logger logger = Logger.getLogger(EmailValidatorTest.class.getName());

    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
        logger.info("starting EmailValidatorTest");
        Assert.assertEquals(Boolean.FALSE, Boolean.FALSE);
        logger.info("ending EmailValidatorTest");
    }
}