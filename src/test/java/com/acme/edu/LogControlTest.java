package com.acme.edu;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Java_1 on 23.07.2019.
 */
public class LogControlTest {
    Command dummyNullCommand = null;
    IntCommand dummy = new IntCommand(1);
    @Test(expected = NullPointerException.class)
    public void shouldProcessNullCurrentCorrectly() throws Exception {
        LogControl.process(dummyNullCommand, dummy);
    }
}