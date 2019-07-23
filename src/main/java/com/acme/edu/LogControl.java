package com.acme.edu;

public class LogControl {
    //private static LogBuffer buffer = new LogBuffer();
   // static Command current = new NoneCommand();
    public static String buffer = "";
    private static LogTypeBuffer typeBuffer = new LogTypeBuffer();
    public static Command process(Command current, Command inputCommand) {
        typeBuffer.add(inputCommand.typedMessage());
        current = current.sum(inputCommand);
        System.out.println(buffer + current + "\n");
        return current;
        //buffer.add(inputCommand);
    }
}
