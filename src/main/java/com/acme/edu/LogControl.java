package com.acme.edu;

public class LogControl {
    //private static LogBuffer buffer = new LogBuffer();
    public static Command current = new NoneCommand();
    public static String buffer = "";
    private static LogTypeBuffer typeBuffer = new LogTypeBuffer();
    public static void process(Command inputCommand) {
        typeBuffer.add(inputCommand.typedMessage());
        //Command sum = Logger.current.sum(inputCommand);
        //Logger.currentLogger.sum(inputCommand);
        current = current.sum(inputCommand);
        Logger.currentLogger = current.getMessage();
        System.out.println(buffer + current + "\n");
        //return Logger.current;
        //buffer.add(inputCommand);
    }
}
