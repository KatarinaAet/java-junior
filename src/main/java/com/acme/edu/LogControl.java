package com.acme.edu;

public class LogControl {
    //private static LogBuffer buffer = new LogBuffer();
    static Command current = new NoneCommand();
    public static String buffer = "";
    private static LogTypeBuffer typeBuffer = new LogTypeBuffer();
    public static void process(Command inputCommand) {
        typeBuffer.add(inputCommand.typedMessage());
        current = current.sum(inputCommand);
        //buffer.add(inputCommand);
    }
}
