package com.dj.automation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyCalculatorTest {
    private Logger LOGGER = LoggerFactory.getLogger(MyCalculatorTest.class);

    @Test
    void additionTest() {
        assertEquals(1,1);
        LOGGER.info("My Addition Test Passed");
    }

    @Test
    void substractionTest() {
        assertEquals(1,1);
        LOGGER.info("My Substraction Test passed");
    }

    @Test
    void MultiplicationTest() {
        assertEquals(1,1);
        LOGGER.info("My Multiplication Test passed");
    }
}
