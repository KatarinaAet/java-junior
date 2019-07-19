package com.acme.edu;

import static java.lang.System.lineSeparator;

public class StringCommand implements Command{
    private static Object message;
    private static  State messageState;
    private static int numbOfCurrentString = 0;
    public StringCommand(String message){
        this.message = message;
        this.messageState = State.String;
        this.numbOfCurrentString = 1;
    }
    public String typeName() {
        return "string: ";
    }

    public String typedMessage(){
        String newLine = lineSeparator();
        return typeName() + message + newLine;
    }

    public Object getMessage() {
        return numbOfCurrentString > 1 ? message + " (x"+numbOfCurrentString+")" : message;
    }

    public String toString(){
        return message.toString();
    }

    public State getState() {
        return messageState;
    }

    public Object sum(Object adjacentCommand) {
        if (message.equals((adjacentCommand))){
            numbOfCurrentString ++;
            return getMessage();
        }
        else {
            String sumResult = (String) getMessage();
            message = adjacentCommand;
            return sumResult;
        }
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
