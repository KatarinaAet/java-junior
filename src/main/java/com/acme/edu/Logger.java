package com.acme.edu;

public class Logger {
    static private LogControl controller = new LogControl();
    /*
    private static Object current = null;
    private static State currentState = State.None;
    private static int numbOfCurrentString = 0;
    private static String buffer = "";
    */
/*
    private static String typeName(Object message){
        if (message == null) return "null: ";
        String name = message.getClass().getName();
        switch (name){
            case "java.lang.Integer":
            case "java.lang.Byte":
            case "java.lang.Boolean":
                return "primitive: ";
            case "java.lang.Character":
                return "char: ";
            case "java.lang.String":
                return "string: ";
            case "[I":
                return "primitives array: ";
            case "[[I":
                return "primitives matrix: ";
            default:
                return "reference: ";
        }
    }
    */
    public static void log(int message) {
        IntCommand inputCommand = new IntCommand(message);
        controller.process(inputCommand);
    }
/*    public static void log(int message) {
        printTypeLog(message);
        switch (currentState){
            case None:
                current = message;
                printBuffer(current);
                break;
            case String:
                DropStringBuffer();
                current = message;
                printBuffer(current);
                break;
            case Integer:
            case Byte:
                if (!overflow(message)){
                    current = (int) current + message;
                    printBuffer(current);
                 }
                break;
            default:
                buffer += current + "\n";
                current = message;
                printBuffer(current);
                break;
        }
        currentState = State.Integer;
    }
*/

    public static void log(int[] message) {
        IntArrayCommand inputCommand = new IntArrayCommand(message);
        LogControl.process(inputCommand);
}

 /*   public static void log(int[] message){
        printTypeLog(message);
    }



    public static void log(int[][] message){
        typeName(message);
    }
*//*
    public static void log(byte message) {
        printTypeLog(message);
        if (current == null){
            current = message;
            printBuffer(current);
        }
        else {
            String curType = current.getClass().getName();
            if(( curType.equals("java.lang.Integer"))||(curType.equals("java.lang.Byte"))) {
                current = (int) current + message;
                printBuffer(current);
            }
            else {
                buffer += current + "\n";
                current = message;
                printBuffer(current);
            }
        }
    }
*/

    public static void log(char message) {
        CharCommand inputCommand = new CharCommand(message);
        LogControl.process(inputCommand);
    }
   /* public static void log(char message) {
        logNoSum(message);
    }
    */

   public static void log(String... message) {
       StringArrayCommand inputCommand = new StringArrayCommand(message);
       LogControl.process(inputCommand);
   }


   /*
    public static void log(String ... message){
        printTypeLog(message);
    }

    */
   public static void log(String message) {
       StringCommand inputCommand = new StringCommand(message);
       LogControl.process(inputCommand);
   }
   /*
    public static void log(String message) {
        printTypeLog(message);
        switch (currentState) {
            case None:
                current = message;
                break;
            case String:
                if (current.equals(message)) {
                    numbOfCurrentString += 1;
                    printBuffer(current + " (x"+numbOfCurrentString+")");
                }
                else {
                    DropStringBuffer();
                    current = message;
                    numbOfCurrentString = 1;
                }
                break;
            default:
                buffer += current + "\n";
                current = message;
                numbOfCurrentString = 1;
                break;
        }
            printBuffer(current);
            currentState = State.String;
    }
*//*
    private static void DropStringBuffer(){
        if (numbOfCurrentString > 1){
            buffer += current + " (x"+numbOfCurrentString+")\n";
        }
        else{
            buffer += current + "\n";
        }
        numbOfCurrentString = 0;
    }*/
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
       LogControl.process(inputCommand);
   }
   /*
    public static void log(Object message) {
         logNoSum(message);
    }
*/
   /*
    private static void logNoSum(Object message) {
        printTypeLog(message);
        switch (currentState) {
            case None: break;
            case String:
                DropStringBuffer();
                break;
            default:
                buffer += current + "\n";
                break;
        }
        current = message;
        printBuffer(current);
        currentState = State.NoSum;
    }
    private static boolean overflow (int message){
        if (message > Integer.MAX_VALUE - (int)current){
            buffer += current + "\n";
            current = Integer.MAX_VALUE;
            return true;
        }
        return false;
    }
    private static void printBuffer(Object message)
    {
        System.out.println(buffer + message+"\n");
    }


    private static void printTypeLog(String... message){
        /*for(String item: message){
            System.out.print(item + "\n");
        }
*//*
        StringBuilder arrayElements = new StringBuilder();
        for(int i = 0; i < message.length; i++){
            if (i == message.length - 1){
                arrayElements.append(message[i]);
            }
            else {
                arrayElements.append(message[i]).append("\n");
            }
        }
        System.out.print(arrayElements);
    }*/
    /*
    private static void printTypeLog(int[] message) {
        StringBuilder arrayElements = new StringBuilder();
        for(int i = 0; i < message.length; i++){
            if (i == message.length - 1){
                arrayElements.append(message[i]);
            }
            else {
                arrayElements.append(message[i]).append(", ");
            }
        }
        System.out.print(typeName(message)+ "{" + arrayElements + "}\n");
    }

     *//*
    private static void printTypeLog(Object message) {
        System.out.print(typeName(message)+ message+"\n");
    }*/

}
