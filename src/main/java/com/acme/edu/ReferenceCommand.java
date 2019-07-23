package com.acme.edu;

import static java.lang.System.lineSeparator;

public class ReferenceCommand implements Command {
    private static Object message;
    private static  State messageState;
    ReferenceCommand(Object message){
        this.message = message;
        this.messageState = State.NoSum;
    }
    public String typeName() {
        return "reference: ";
    }

    public String typedMessage(){
        String newLine = lineSeparator();
        return typeName() + message + newLine;
    }

    @Override
    public Command sum(Command adjacentCommand) {
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
        return adjacentCommand instanceof ReferenceCommand;
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
