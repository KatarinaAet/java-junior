package com.acme.edu;

import static java.lang.System.lineSeparator;

public class IntCommand implements Command{
    private Object message;
    private State messageState;
    private LogBuffer localBuffer;

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

    /*
        @Override
        public boolean typeEquals(Command adjacentCommand) {
            return message instanceof adjacentCommand.getMessage();
        }
    */
    public State getState() {
        return messageState;
    }

    public Command sum(Command adjacentCommand){
        if (typeEquals(adjacentCommand)&& (!overflow((int)adjacentCommand.getMessage()))){
            int result = (int)message + (int)adjacentCommand.getMessage();
            return new IntCommand(result);
        }
        else{
            LogControl.buffer += message.toString() + "\n";
            return adjacentCommand;
        }

    }



    /*
    public Command sum(Command adjacentCommand){
        LogControl.buffer += message.toString();
        return adjacentCommand;
    }
    */
/*
    public Object sum(Object adjacentCommand) {
        if (!overflow((int) adjacentCommand)){
            message = (int)message + (int)adjacentCommand;
            return message;
        }
        else{
            //message = ;
            localBuffer.add((Command) adjacentCommand);
        }

    }
*/
    private boolean overflow (int adjacentCommand){
        if (adjacentCommand > Integer.MAX_VALUE - (int)message){
            return true;
        }
        return false;
    }


}
