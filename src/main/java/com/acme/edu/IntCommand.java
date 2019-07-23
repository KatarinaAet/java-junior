package com.acme.edu;

import java.lang.invoke.WrongMethodTypeException;

import static java.lang.System.lineSeparator;

public class IntCommand implements Command{
    private Object message;
    private State messageState;


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

    @Override
    public boolean typeEquals(Command adjacentCommand) {
        return adjacentCommand instanceof IntCommand;
    }

    public State getState() {
        return messageState;
    }

    public Command sum(Command adjacentCommand) throws WrongMethodTypeException {
        if (typeEquals(adjacentCommand)&& (!overflow((int)adjacentCommand.getMessage()))){
            int result = (int)message + (int)adjacentCommand.getMessage();
            return new IntCommand(result);
        }
        else{
            LogControl.buffer += message.toString() + "\n";
            return adjacentCommand;
        }

    }


    private boolean overflow (int adjacentCommand){
        if (adjacentCommand > Integer.MAX_VALUE - (int)message){
            return true;
        }
        return false;
    }


}
