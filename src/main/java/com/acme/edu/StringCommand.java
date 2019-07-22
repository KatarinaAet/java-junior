package com.acme.edu;

import static java.lang.System.lineSeparator;

public class StringCommand implements Command{
    public static Object message;
    private static  State messageState;
    private static int numbOfCurrentString = 0;
    public StringCommand(String message){
        this.message = message;
        this.messageState = State.String;
        //this.numbOfCurrentString = 1;
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

    public Command sum(Command adjacentCommand) {
        if (message.equals((adjacentCommand.toString()))) {
        //if (message.equals((Logger.currentLogger.toString()))) {
            //это чтобы избежать такой ситуации: str2\n str2(x2)\n
            //т.е очищаем то, что записали
            //LogControl.buffer = LogControl.buffer.replace(Logger.currentLogger.toString()+"\n","");

            LogControl.buffer.replace(Logger.currentLogger.toString()+"\n","");
            numbOfCurrentString++;
        } else {
            LogControl.buffer += getMessage() +"\n";
            numbOfCurrentString = 1;

        }
        return adjacentCommand;
    }
}
