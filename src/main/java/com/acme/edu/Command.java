package com.acme.edu;

import static java.lang.System.lineSeparator;

public interface Command {
   /* private static Object message;
    private static  State messageState;
    */
    /*public Command(int message){
        this.message = message;
        this.messageState = State.Integer;
    }
/*
    public Command(int[] message){
        this.message = message;
        this.messageState = State.NoSum;
    }

    public Command(byte message){
        this.message = message;
        this.messageState = State.Byte;
    }

    public Command(String message){
        this.message = message;
        this.messageState = State.String;
    }

    public Command(String ... message){
        this.message = message;
        this.messageState = State.NoSum;
    }

    public Command(char message){
        this.message = message;
        this.messageState = State.NoSum;
    }

    public Command(boolean message){
        this.message = message;
        this.messageState = State.NoSum;
    }

    public Command(Object message){
        this.message = message;
        this.messageState = State.NoSum;
    }
*/

   String typeName();

   String typedMessage();

   Command sum(Command adjacentCommand);
   Object getMessage();
   State getState();
   public String toString();
   boolean typeEquals(Command adjacentCommand);
   /* private static String typeName() {
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

    private static String intArrayToString(int[] array){
        StringBuilder arrayElements = new StringBuilder();
        for(int i = 0; i < array.length; i++){
            if (i == array.length - 1){
                arrayElements.append(array[i]);
            }
            else {
                arrayElements.append(array[i]).append(", ");
            }
        }
        return arrayElements.toString();
    }

    private static String stringArrayToString(String... array)
    {
        StringBuilder arrayElements = new StringBuilder();
        for(int i = 0; i < array.length; i++){
            if (i == array.length - 1){
                arrayElements.append(array[i]);
            }
            else {
                arrayElements.append(array[i]).append("\n");
            }
        }
        return arrayElements.toString();
    }

    public static String typedMessage(){
        String name = message.getClass().getName();
        String newLine = lineSeparator();
        switch (name) {
            case "[I":
                return typeName()+ "{" + intArrayToString((int[])message) + "}\n";
            case "[Ljava.lang.String;":
                return stringArrayToString((String[])message);
            default:
                return typeName() + message + newLine;
        }
    }
/*
    public static int sum(int adjacentCommand) {
        if (!overflow(message)){
            return  (int)message + adjacentCommand;
        }
    }r

    public static String sum(String adjacentCommand) {
        if (message.equals(adjacentCommand)) {
            numbOfCurrentString += 1;
            printBuffer(current + " (x"+numbOfCurrentString+")");
        }
        else {
            DropStringBuffer();
            current = message;
            numbOfCurrentString = 1;
        }
    }
*//*
    public Object getMessage()
    {
        return message;
    }

    public String toString(){
        if(message instanceof String[]) {
            return stringArrayToString((String[]) message);
        }
        else
            if(message instanceof int[]){
                return intArrayToString((int[]) message);
            }
            else {
                return message.toString();
            }
    }

    public State getState() {
        return messageState;
    }
    */
}
