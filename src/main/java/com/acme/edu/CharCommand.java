package com.acme.edu;

import static java.lang.System.lineSeparator;

public class CharCommand implements Command{
    private static Object message;
    private static  State messageState;
    CharCommand(char message){
        this.message = message;
        this.messageState = State.NoSum;
    }
    public String typeName() {
        return "char: ";
    }

    public String typedMessage(){
        String newLine = lineSeparator();
        return typeName() + message + newLine;
    }

    public Object getMessage() {
        return message;
    }

    public String toString(){
        return message.toString();
    }

    @Override
    public boolean typeEquals(Command adjacentCommand) {
        return adjacentCommand instanceof CharCommand;
    }

    public State getState() {
        return messageState;
    }

    public Command sum(Command adjacentCommand) {
        return adjacentCommand;
       /* if (!overflow(message)){
            return  (int)message + adjacentCommand;
        }*/
    }


}
