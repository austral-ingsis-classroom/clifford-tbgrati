package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.file.Directory;

public class MakeDirectoryCommand implements ConsoleCommand{

    private final String params;

    private final Directory currentDir;

    public MakeDirectoryCommand(String params, Directory currentDir){
        this.params = params;
        this.currentDir = currentDir;
    }
    @Override
    public String execute() {
        if (params.contains(" ") || params.contains("/")) {
            return "Invalid directory name: cannot contain spaces or '/'";
        }

        currentDir.addFile(new Directory(params));
        return String.format("'%s' directory created", currentDir.getName());
    }
}
