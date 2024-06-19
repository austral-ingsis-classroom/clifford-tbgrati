package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.Cursor;
import edu.austral.ingsis.clifford.command.ConsoleCommand;
import edu.austral.ingsis.clifford.command.TouchCommand;

public class TouchCommandBuilder implements CommandBuilder {

  @Override
  public ConsoleCommand build(String params, Cursor directoryCursor) {
    return new TouchCommand(params, directoryCursor);
  }
}
