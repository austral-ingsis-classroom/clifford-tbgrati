package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.Cursor;
import edu.austral.ingsis.clifford.command.ChangeDirectoryCommand;
import edu.austral.ingsis.clifford.command.ConsoleCommand;
import java.util.Arrays;

public class ChangeDirectoryCommandBuilder implements CommandBuilder {

  @Override
  public ConsoleCommand build(String params, Cursor directoryCursor) {
    if (params == null || params.isEmpty()) {
      return new ChangeDirectoryCommand(params, new String[0], directoryCursor);
    }

    String[] dirNames;
    if (params.equals("..") || params.equals(".")) {
      dirNames = new String[] {params};
    } else {
      dirNames = params.split("/");
    }

    dirNames = Arrays.stream(dirNames).filter(s -> !s.isEmpty()).toArray(String[]::new);

    return new ChangeDirectoryCommand(params, dirNames, directoryCursor);
  }
}
