package com.acme.edu;

import java.io.IOException;

public class Logger {
    static private LogControl controller = new LogControl();
    static private Command currentBufferCommand = new NoneCommand();

    public static void log(int message) throws IOException {
        IntCommand inputCommand = new IntCommand(message);
        currentBufferCommand = controller.process(currentBufferCommand, inputCommand);
    }

    public static void log(int[] message) throws IOException {
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


   public static void log(String message) throws IOException {
       StringCommand inputCommand = new StringCommand(message);
       currentBufferCommand = LogControl.process(currentBufferCommand, inputCommand);
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
       ReferenceCommand inputCommand = new ReferenceCommand(message);
       currentBufferCommand = LogControl.process(currentBufferCommand, inputCommand);
   }


}
