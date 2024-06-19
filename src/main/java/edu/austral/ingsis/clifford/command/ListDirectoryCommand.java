package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.Cursor;
import edu.austral.ingsis.clifford.file.Directory;
import edu.austral.ingsis.clifford.file.FileSystemObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDirectoryCommand implements ConsoleCommand {
  private final String order;
  private final Cursor directoryCursor;

  public ListDirectoryCommand(String order, Cursor directoryCursor) {
    this.order = order;
    this.directoryCursor = directoryCursor;
  }

  @Override
  public String execute() {
    if (directoryCursor.getDirectory() instanceof Directory) {
      List<FileSystemObject> fileObjects = ((Directory) directoryCursor.getDirectory()).getFiles();
      List<String> fileNames = new ArrayList<>();

      for (FileSystemObject fileObject : fileObjects) {
        fileNames.add(fileObject.getName());
      }

      if ("asc".equals(order)) {
        Collections.sort(fileNames);
      } else if ("desc".equals(order)) {
        fileNames.sort(Collections.reverseOrder());
      }

      String result = String.join(" ", fileNames);
      return result;
    }
    return "/";
  }
}
