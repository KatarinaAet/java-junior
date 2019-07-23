package com.acme.edu;

import java.lang.invoke.WrongMethodTypeException;

import static java.lang.System.lineSeparator;

public class StringCommand implements Command{
    private Object message;
    private State messageState;
    private int numbOfCurrentString = 1;
    StringCommand(String message) throws WrongMethodTypeException {
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
        return numbOfCurrentString > 1 ? message + " (x"+numbOfCurrentString+")" : message;
    }

    public String toString(){
        return (String) this.getMessage();
    }

    @Override
    public boolean typeEquals(Command adjacentCommand) {
        return adjacentCommand instanceof StringCommand;
    }

    public State getState() {
        return messageState;
    }

    public Command sum(Command adjacentCommand)  throws WrongMethodTypeException {
        if (message.equals((adjacentCommand.getMessage()))){
            numbOfCurrentString ++;
            return this;
        }
        else {
            String sumResult = (String) getMessage();
            LogControl.buffer += sumResult + "\n";
            message = adjacentCommand;
            return adjacentCommand;
        }

    }


}
