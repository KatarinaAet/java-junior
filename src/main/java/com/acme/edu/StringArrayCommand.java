package com.acme.edu;

import java.lang.invoke.WrongMethodTypeException;

import static java.lang.System.lineSeparator;

public class StringArrayCommand implements Command {
    private static Object message;
    private static  State messageState;
    public StringArrayCommand(String... message) throws WrongMethodTypeException {
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

    @Override
    public Command sum(Command adjacentCommand)  throws WrongMethodTypeException {
        return adjacentCommand;
    }

    public Object getMessage() {
        return message;
    }

    public String toString(){
        return message.toString();
    }

    @Override
    public boolean typeEquals(Command adjacentCommand) {
        return adjacentCommand instanceof StringArrayCommand;
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
