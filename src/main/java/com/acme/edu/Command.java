package com.acme.edu;

import java.lang.invoke.WrongMethodTypeException;

import static java.lang.System.lineSeparator;

public interface Command {

   String typeName();

   String typedMessage();

   Command sum(Command adjacentCommand) throws WrongMethodTypeException;
   Object getMessage();
   State getState();
   String toString();
   boolean typeEquals(Command adjacentCommand);
}
