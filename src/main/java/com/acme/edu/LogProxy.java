package com.acme.edu;

import java.io.IOException;

/**
 * Created by Java_1 on 26.07.2019.
 */
public class LogProxy {
    static private LogClient client = new LogClient();


    public static void log(int message) throws IOException {
        client.sendToServer(message);
    }

 /*   public static void log(int[] message) throws IOException {
        IntArrayCommand inputCommand = new IntArrayCommand(message);
        currentBufferCommand = LogControl.process(currentBufferCommand, inputCommand);
    }

    public static void log(char message) throws IOException {
        CharCommand inputCommand = new CharCommand(message);
        currentBufferCommand = LogControl.process(currentBufferCommand, inputCommand);
    }


    public static void log(String... message) throws IOException {
        StringArrayCommand inputCommand = new StringArrayCommand(message);
        currentBufferCommand = LogControl.process(currentBufferCommand, inputCommand);
    }

*/
    public static void log(String message) throws IOException {
        client.sendToServer(message);
    }

/*//TODO
    public static void log(boolean message) {
        Command inputCommand = new Command(message);
        LogControl.process(inputCommand);
    }*/
   /*
    public static void log(boolean message) {
        logNoSum(message);
    }
*/ //ENDOF TODO

    public static void log(Object message) throws IOException {
        client.sendToServer(message);
    }


}