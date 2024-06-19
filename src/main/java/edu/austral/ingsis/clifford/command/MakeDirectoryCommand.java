package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.Cursor;
import edu.austral.ingsis.clifford.file.Directory;

public class MakeDirectoryCommand implements ConsoleCommand {

  private final String params;

  private final Cursor directoryCursor;

  public MakeDirectoryCommand(String params, Cursor directoryCursor) {
    this.params = params;
    this.directoryCursor = directoryCursor;
  }

  @Override
  public String execute() {
    if (params.contains(" ") || params.contains("/")) {
      return "Invalid directory name: cannot contain spaces or '/'";
    }

    directoryCursor.getDirectory().addFile(new Directory(params));
    return String.format("'%s' directory created", params);
  }
}
