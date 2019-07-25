package com.acme.edu;

import java.io.IOException;

public class LogControl {
    public static String buffer = "";
    private static LogTypeBuffer typeBuffer = new LogTypeBuffer();
    private static ConsolSaver consolOut = new ConsolSaver();
    private static FileSaver fileOut = new FileSaver();
    public static Command process(Command current, Command inputCommand) throws IOException {
        typeBuffer.add(inputCommand.typedMessage());
        //try {
        current = current.sum(inputCommand);
       /* }
        catch (NullPointerException e){
            e.printStackTrace();
        }*/
        //System.out.println(buffer + current + "\n");
        consolOut.print(buffer + current + "\n");
        fileOut.print(buffer + current + "\n");
        fileOut.closeFile();
        return current;
    }
}
