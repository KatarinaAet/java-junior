package com.acme.edu;

import static java.lang.System.lineSeparator;

public class StringCommand implements Command{
    private static Object message;
    private static  State messageState;
    public StringCommand(String message){
        this.message = message;
        this.messageState = State.String;
    }
    public String typeName() {
        return "string: ";
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
       /* if (message.equals(adjacentCommand)) {
            numbOfCurrentString += 1;
            printBuffer(current + " (x"+numbOfCurrentString+")");
        }
        else {
            DropStringBuffer();
            current = message;
            numbOfCurrentString = 1;
        }*/

    }


}
