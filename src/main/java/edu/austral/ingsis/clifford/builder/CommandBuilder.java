package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.Cursor;
import edu.austral.ingsis.clifford.command.ConsoleCommand;

public interface CommandBuilder {

  public abstract ConsoleCommand build(String params, Cursor directoryCursor);
}
