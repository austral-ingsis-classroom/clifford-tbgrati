package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.Cursor;
import edu.austral.ingsis.clifford.file.File;

public class TouchCommand implements ConsoleCommand {

  private final String params;
  private final Cursor directoryCursor;

  public TouchCommand(String params, Cursor directoryCursor) {
    this.params = params;
    this.directoryCursor = directoryCursor;
  }

  @Override
  public String execute() {
    if (params.contains(" ") || params.contains("/")) {
      return "Invalid file name: cannot contain spaces or '/'";
    }

    directoryCursor.getDirectory().addFile(new File(params));
    return String.format("'%s' file created", params);
  }
}
