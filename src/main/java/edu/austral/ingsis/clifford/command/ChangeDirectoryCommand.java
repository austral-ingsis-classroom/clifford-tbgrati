package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.Cursor;
import edu.austral.ingsis.clifford.file.Directory;
import java.util.Objects;

public class ChangeDirectoryCommand implements ConsoleCommand {

  private final String params;

  private final String[] dirNames;

  private Cursor directoryCursor;

  public ChangeDirectoryCommand(String params, String[] dirNames, Cursor directoryCursor) {
    this.params = params;
    this.dirNames = dirNames;
    this.directoryCursor = directoryCursor;
  }

  @Override
  public String execute() {
    Directory currentDir = directoryCursor.getDirectory();
    if (params.equals(",")) {
      return String.format("moved to directory '%s'", currentDir.getName());
    } else if (params.equals("..")) {
      if (currentDir.getParentDirectory() != null) {
        directoryCursor.moveCursor(currentDir.getParentDirectory());
        if (Objects.equals(directoryCursor.getDirectory().getName(), "/")) {
          return String.format("moved to directory '/'");
        }
        return String.format("moved to directory '%s'", directoryCursor.getDirectory().getName());
      } else {
        return "moved to directory '/'";
      }
    } else {
      Directory current = directoryCursor.getRoot();

      for (String segment : dirNames) {
        if (!segment.isEmpty()) {
          Directory nextDir = (Directory) current.getFile(segment);

          if (nextDir == null) {
            return String.format("'%s' directory does not exist", segment);
          }

          current = nextDir;
        }
      }
      directoryCursor.moveCursor(current);
      return String.format("moved to directory '%s'", directoryCursor.getDirectory().getName());
    }
  }
}
