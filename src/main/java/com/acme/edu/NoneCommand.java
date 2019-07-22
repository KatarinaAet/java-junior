package com.acme.edu;

public class NoneCommand implements Command {
    private static  State messageState;
    public NoneCommand(){
        messageState = State.None;
    }

    @Override
    public String typeName() {
        return null;
    }

    @Override
    public String typedMessage() {
        return null;
    }

    @Override
    public Command sum(Command adjacentCommand) {
        LogControl.buffer += adjacentCommand.getMessage().toString() + "\n";
        return adjacentCommand;
    }

    @Override
    public Object getMessage() {
        return null;
    }

    @Override
    public State getState() {
        return messageState;
    }

   // IntCommand sum(IntCommand adjacentCommand) {


}
