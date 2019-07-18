package com.acme.edu;

public class LogTypeBuffer {
    private static String buffer = "";
    public static void add(String bufMessage){
        buffer += bufMessage;
        System.out.println(buffer);
    }
}
