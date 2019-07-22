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

    public Object getMessage() {
        return message;
    }

    public String toString(){
        return message.toString();
    }

    public State getState() {
        return messageState;
    }

    public Command sum(Command adjacentCommand) {
        return null;
       /* if (!overflow(message)){
            return  (int)message + adjacentCommand;
        }*/
    }
}
