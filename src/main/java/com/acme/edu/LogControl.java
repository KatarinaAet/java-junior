package com.acme.edu;

public class LogControl {
    private static LogBuffer buffer = new LogBuffer();
    private static LogTypeBuffer typeBuffer = new LogTypeBuffer();
    public static void process(Command inputCommand) {
        typeBuffer.add(Command.typedMessage());
        buffer.add(inputCommand);
    }
}
