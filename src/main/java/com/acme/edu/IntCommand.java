package com.acme.edu;

import com.sun.corba.se.impl.interceptors.InterceptorInvoker;

import static java.lang.System.lineSeparator;

public class IntCommand implements Command{
    private static Object message;
    private static  State messageState;
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


    public boolean typeEquals(Command adjacentCommand) {
        //Logger.currentLogger = message;
        return adjacentCommand instanceof IntCommand;
    }

    public State getState() {
        return messageState;
    }


    public IntCommand sumEqual(IntCommand adjacentCommand){
        if (!overflow((int)adjacentCommand.getMessage())){
            int result = (int)Logger.currentLogger + (int)adjacentCommand.getMessage();
            Logger.currentLogger = result;
            return new IntCommand(result);
        }
        else{
            LogControl.buffer += Logger.currentLogger.toString() + "\n";
            return adjacentCommand;
        }

    }

    @Override
    public Command sum(Command adjacentCommand){
        if (typeEquals(adjacentCommand)){
            return sumEqual((IntCommand) adjacentCommand);
        }
        else{
            LogControl.buffer += message.toString()+"\n";
            return adjacentCommand;
        }
    }

    /*
        @Override
        public Command sum(Command adjacentCommand) {
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
    private static boolean overflow (int adjacentCommand){
        if (adjacentCommand > Integer.MAX_VALUE - (int)message){
            return true;
        }
        return false;
    }


}
