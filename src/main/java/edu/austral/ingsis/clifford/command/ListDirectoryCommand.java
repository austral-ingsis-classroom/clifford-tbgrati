package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.file.Directory;
import edu.austral.ingsis.clifford.file.FileSystemObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDirectoryCommand implements ConsoleCommand {
    private final String order;
    private final FileSystemObject currentDir;

    public ListDirectoryCommand(String order, FileSystemObject currentDir) {
        this.order = order;
        this.currentDir = currentDir;
    }

    @Override
    public String execute() {
        if (currentDir instanceof Directory) {
            List<FileSystemObject> fileObjects = ((Directory) currentDir).getFiles();
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
        return "";
    }
}
