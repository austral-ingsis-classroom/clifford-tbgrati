package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.Cursor;
import edu.austral.ingsis.clifford.command.ConsoleCommand;
import edu.austral.ingsis.clifford.command.PrintDirectoryCommand;

public class PrintDirectoryCommandBuilder implements CommandBuilder {
  @Override
  public ConsoleCommand build(String params, Cursor directoryCursor) {
    return new PrintDirectoryCommand(directoryCursor);
  }
}
