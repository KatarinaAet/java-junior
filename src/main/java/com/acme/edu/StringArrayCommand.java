package com.acme.edu;

import static java.lang.System.lineSeparator;

public abstract class StringArrayCommand implements Command {
    private static Object message;
    private static  State messageState;
    public StringArrayCommand(String... message){
        this.message = message;
        this.messageState = State.NoSum;
    }
    public String typeName() {
        return "string array: ";
    }//NOT USED IN TESTS

    private static String stringArrayToString(String[] array)
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


    public String typedMessage(){
        return stringArrayToString((String[])message);
    }

    public Object getMessage() {
        return message;
    }

    public String toString(){
        return message.toString();
    }

    public State getState() {
        return messageState;
    }

    public Object sum(Object adjacentCommand) {
        return 0;
       /* if (!overflow(message)){
            return  (int)message + adjacentCommand;
        }*/
    }


}
