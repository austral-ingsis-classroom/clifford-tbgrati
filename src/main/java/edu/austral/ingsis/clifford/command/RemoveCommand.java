package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.Cursor;
import edu.austral.ingsis.clifford.file.Directory;
import java.util.Objects;

public class RemoveCommand implements ConsoleCommand {

  private final String params;

  private final String options;

  private final Cursor directoryCursor;

  public RemoveCommand(String params, String options, Cursor directoryCursor) {
    this.params = params;
    this.options = options;
    this.directoryCursor = directoryCursor;
  }

  @Override
  public String execute() {

    if (Objects.equals(options, "--recursive")) {
      directoryCursor.getDirectory().removeFile(params);
    } else {
      if (!(directoryCursor.getDirectory().getFile(params) instanceof Directory)) {
        directoryCursor.getDirectory().removeFile(params);
      } else {
        return String.format("cannot remove '%s', is a directory", params);
      }
    }

    return String.format("'%s' removed", params);
  }
}
