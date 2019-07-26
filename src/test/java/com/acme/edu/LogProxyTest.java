package com.acme.edu;

import org.junit.Test;

import java.io.IOException;


import static java.lang.System.setOut;
import static org.junit.Assert.*;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import java.io.*;

import static java.lang.System.lineSeparator;

/**
 * Created by Java_1 on 26.07.2019.
 */
public class LogProxyTest {
    @Test
    public void shouldLogInteger() throws IOException {
        //region when
        LogProxy.log(1);
        LogProxy.log(0);
        LogProxy.log(-1);
        //endregion
        System.out.println("!");
        //endregion
    }


    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        LogProxy.log("str 1");
        LogProxy.log("str 2");
        LogProxy.log("str 2");
        LogProxy.log(0);
        LogProxy.log("str 2");
        LogProxy.log("str 3");
        LogProxy.log("str 3");
        LogProxy.log("str 3");
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() throws IOException {
        //region when
        LogProxy.log("str 1");
        LogProxy.log(10);
        LogProxy.log(Integer.MAX_VALUE);
        LogProxy.log("str 2");
        LogProxy.log(0);
        //endregion

    }
}
