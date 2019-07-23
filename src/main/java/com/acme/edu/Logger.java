package com.acme.edu;

public class Logger {
    static private LogControl controller = new LogControl();
    static private Command currentBufferCommand = new NoneCommand();

    public static void log(int message) {
        IntCommand inputCommand = new IntCommand(message);
        currentBufferCommand = controller.process(currentBufferCommand, inputCommand);
    }

    public static void log(int[] message) {
        IntArrayCommand inputCommand = new IntArrayCommand(message);
        currentBufferCommand = LogControl.process(currentBufferCommand, inputCommand);
}

    public static void log(char message) {
        CharCommand inputCommand = new CharCommand(message);
        currentBufferCommand = LogControl.process(currentBufferCommand, inputCommand);
    }


   public static void log(String... message) {
       StringArrayCommand inputCommand = new StringArrayCommand(message);
       currentBufferCommand = LogControl.process(currentBufferCommand, inputCommand);
   }


   public static void log(String message) {
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

   public static void log(Object message) {
       ReferenceCommand inputCommand = new ReferenceCommand(message);
       currentBufferCommand = LogControl.process(currentBufferCommand, inputCommand);
   }


}
