package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.Cursor;
import edu.austral.ingsis.clifford.command.ConsoleCommand;
import edu.austral.ingsis.clifford.command.RemoveCommand;

public class RemoveDirectoryCommandBuilder implements CommandBuilder {
  @Override
  public ConsoleCommand build(String params, Cursor directoryCursor) {
    String[] parts = params.split(" ");
    String parameters = null;
    String options = null;

    if (parts.length == 1) {
      parameters = parts[0];
    } else if (parts.length == 2 && parts[0].startsWith("--")) {
      options = parts[0];
      parameters = parts[1];
    } else {
      throw new IllegalArgumentException("Invalid command format");
    }

    return new RemoveCommand(parameters, options, directoryCursor);
  }
}
