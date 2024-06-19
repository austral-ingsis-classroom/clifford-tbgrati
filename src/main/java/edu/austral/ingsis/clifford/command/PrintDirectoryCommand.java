package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.Cursor;
import edu.austral.ingsis.clifford.file.Directory;
import java.util.Objects;

public class PrintDirectoryCommand implements ConsoleCommand {

  private final Cursor directoryCursor;

  public PrintDirectoryCommand(Cursor directoryCursor) {
    this.directoryCursor = directoryCursor;
  }

  @Override
  public String execute() {
    return printPath(directoryCursor.getDirectory());
  }

  private String printPath(Directory dir) {
    if (dir.getParentDirectory() == null) {
      return "/" + dir.getName();
    } else {
      if (!Objects.equals(dir.getParentDirectory().getName(), "/")) {
        return printPath(dir.getParentDirectory()) + "/" + dir.getName();
      }
      return ("/" + dir.getName());
    }
  }
}
