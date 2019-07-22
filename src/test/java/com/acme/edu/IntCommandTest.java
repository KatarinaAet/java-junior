package com.acme.edu;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Java_1 on 22.07.2019.
 */
public class IntCommandTest {
    static Command dummy = new IntCommand(666);

    @Test
    public void shouldReturnPrimitiveTypeName() throws Exception {

        Assert.assertEquals("primitive: ", dummy.typeName());

    }

    @Test
    public void shouldReturnTypeMessageEndOfLine() throws Exception {
        Assert.assertEquals("primitive: 666\r\n", dummy.typedMessage());


    }

    @Test
    public void shouldReturnMessage() throws Exception {
        Assert.assertEquals(666, dummy.getMessage());


    }

    @Test
    public void shouldCheckState() throws Exception {
        Assert.assertEquals(State.Integer, dummy.getState());

    }


    @Test
    public void sumEqual() throws Exception {
        Assert.assertEquals(666,dummy.sum(dummy));
    }

    @Test
    public void sum() throws Exception {

    }

}