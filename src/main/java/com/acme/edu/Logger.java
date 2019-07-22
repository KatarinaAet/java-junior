package com.acme.edu;

import static com.acme.edu.LogControl.*;

public class Logger {
    static private LogControl controller = new LogControl();
    //static Command current = null;
    static Object currentLogger;

    public static void log(int message) {
        Command inputCommand = new IntCommand(message);
        controller.process(inputCommand);
    }

    public static void log(int[] message) {
        IntArrayCommand inputCommand = new IntArrayCommand(message);
        controller.process(inputCommand);
}


    public static void log(char message) {
        CharCommand inputCommand = new CharCommand(message);
        controller.process(inputCommand);
    }
   /* public static void log(char message) {
        logNoSum(message);
    }
    */

   public static void log(String... message) {
       //StringArrayCommand inputCommand = new StringArrayCommand(message);
       //LogControl.process(inputCommand);
   }


   /*
    public static void log(String ... message){
        printTypeLog(message);
    }

    */
   public static void log(String message) {
       StringCommand inputCommand = new StringCommand(message);
       controller.process(inputCommand);
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
       controller.process(inputCommand);
   }

}
