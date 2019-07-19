package com.acme.edu;

import java.sql.SQLOutput;

public class LogBuffer {
    private static Object current = null;
    //private static Command current = null;
    private static State currentState = State.None;
    private static int numbOfCurrentString = 0;
    private static String buffer = "";

    public void add(Command inputCommand) {
        State commandState = inputCommand.getState();
        Object message = inputCommand.getMessage();
        if ((commandState != currentState)||(commandState == State.NoSum)){
            dropBuffer();
            currentState = commandState;
            current = inputCommand.getMessage();
            print(current);
        }
        else{
            switch (currentState){
                case Integer:
                    if (!overflow((int)message)){
                        current = (int)current + (int)message;
                        print(current);
                    }
                    break;
                case String:
                    if (current.equals(message)) {
                        numbOfCurrentString += 1;
                        print(current + " (x"+numbOfCurrentString+")");
                    }
                    else {
                        DropStringBuffer();
                        current = message;
                        numbOfCurrentString = 1;
                        print(current);
                    }
                    break;
            }
            //current = Command.sum(inputCommand);
        }

    }

    private static boolean overflow (int message){
        if (message > Integer.MAX_VALUE - (int)current){
            buffer += current + "\n";
            current = Integer.MAX_VALUE;
            return true;
        }
        return false;
    }

    private static void dropBuffer() {
        switch (currentState) {
            case String:
                DropStringBuffer();
                break;
            case None:
                break;
            default:
                buffer += current + "\n";
                break;
        }
    }
    private static void DropStringBuffer(){
        if (numbOfCurrentString > 1){
            buffer += current + " (x"+numbOfCurrentString+")\n";
        }
        else{
            buffer += current + "\n";
        }
        numbOfCurrentString = 0;
    }

    private static void print(Object current) {
        System.out.println(buffer + current + "\n");
    }
}
