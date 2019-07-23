package com.acme.edu;

public class LogControl {
    public static String buffer = "";
    private static LogTypeBuffer typeBuffer = new LogTypeBuffer();
    public static Command process(Command current, Command inputCommand) {
        typeBuffer.add(inputCommand.typedMessage());
        //try {
        current = current.sum(inputCommand);
       /* }
        catch (NullPointerException e){
            e.printStackTrace();
        }*/
        System.out.println(buffer + current + "\n");
        return current;
    }
}
