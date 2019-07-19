package com.acme.edu;

import static java.lang.System.lineSeparator;

public class IntCommand implements Command{
    private static Object message;
    private static  State messageState;
    IntCommand(int message){
        this.message = message;
        this.messageState = State.Integer;
    }
    public String typeName() {
        return "primitive: ";
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

    public Object sum(Object adjacentCommand) {
        return 0;
       /* if (!overflow(message)){
            return  (int)message + adjacentCommand;
        }*/
    }


}
