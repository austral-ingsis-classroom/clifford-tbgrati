package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.file.Directory;

public class PrintDirectoryCommand implements ConsoleCommand{

    private final String params;

    private final Directory currentDir;

    public PrintDirectoryCommand(String params, Directory currentDir) {
        this.params = params;
        this.currentDir = currentDir;
    }


    @Override
    public String execute() {
        return printPath(currentDir);
    }

    private String printPath(Directory dir) {
        if (dir.getParentDirectory() == null) {
            // Base case: the current directory has no parent, return its name
            return "/" + dir.getName();
        } else {
            // Recursive case: append the parent directory's path recursively
            return printPath(dir.getParentDirectory()) + "/" + dir.getName();
        }
    }
}
