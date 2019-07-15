package com.acme.edu;

public class Logger {

    public static void log(int message) {
        printLog("primitive: " + message);
    }

    public static void log(byte message) {
        printLog("primitive: " + message);
    }

    public static void log(char message) {
        printLog("char: " + message);
    }

    public static void log(String message) {
        printLog("string: " + message);
    }

    public static void log(boolean message) {
        printLog("primitive: " + message);
    }

    public static void log(Object message) {
        printLog("reference: " + message);
    }

    public static void printLog(String message){
        System.out.println(message);
    }

}
