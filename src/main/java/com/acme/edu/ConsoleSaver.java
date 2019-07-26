package com.acme.edu;

import java.io.IOException;

/**
 * Created by Java_1 on 25.07.2019.
 */
public class ConsoleSaver implements Saver{
    @Override
    public void print(String message) throws IOException {
        System.out.println(message);
    }
}