package com.acme.edu;

import static java.lang.System.lineSeparator;

public class IntArrayCommand implements Command {
    private static Object message;
    private static State messageState;

    IntArrayCommand(int[] message) {
        this.message = message;
        this.messageState = State.NoSum;
    }

    public String typeName() {
        return "primitives array: ";
    }

    private static String intArrayToString(int[] array) {
        StringBuilder arrayElements = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                arrayElements.append(array[i]);
            } else {
                arrayElements.append(array[i]).append(", ");
            }
        }
        return arrayElements.toString();
    }

    public String typedMessage() {
        return typeName() + "{" + intArrayToString((int[]) message) + "}\n";
    }

    public Object getMessage() {
        return message;
    }

    public String toString() {
        return message.toString();
    }

    public State getState() {
        return messageState;
    }

    public Command sum(Command adjacentCommand) {
        return null;
    }
       /* if (!overflow(message)){
            return  (int)message + adjacentCommand;
        }*/
}