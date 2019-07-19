package com.acme.edu;

public class LogControl {
    private static LogBuffer buffer = new LogBuffer();
    private static LogTypeBuffer typeBuffer = new LogTypeBuffer();
    public static void process(Command inputCommand) {
        typeBuffer.add(inputCommand.typedMessage());
        buffer.add(inputCommand);
    }
}
