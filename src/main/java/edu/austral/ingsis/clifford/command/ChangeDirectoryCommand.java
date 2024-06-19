package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.file.Directory;

public class ChangeDirectoryCommand implements ConsoleCommand{

    private final String params;

    private final String[] dirNames;

    private Directory currentDir;


    public ChangeDirectoryCommand(String params, String[] dirNames, Directory currentDir) {
        this.params = params;
        this.dirNames = dirNames;
        this.currentDir = currentDir;
    }

    @Override
    public String execute() {
        if(params.equals(",")){
            return String.format("Moved to directory: '%s'", currentDir.getName());
        }
        else if(params.equals("..")){
            if (currentDir.getParentDirectory() != null) {
                currentDir = currentDir.getParentDirectory();
                return String.format("Moved to directory: '%s'", currentDir.getName());
            } else {
                return "Already at the root directory.";
            }
        }
        else{
            Directory current = currentDir;

            for (String segment : dirNames) {
                if (!segment.isEmpty()) {
                    Directory nextDir = (Directory) current.getFile(segment);

                    if (nextDir == null) {
                        return String.format("Directory '%s' not found.", segment);
                    }

                    current = nextDir;
                }
            }

            currentDir = current;
            return String.format("Moved to directory: '%s'", currentDir.getName());
        }
    }
}
