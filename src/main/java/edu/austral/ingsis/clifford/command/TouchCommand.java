package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.file.Directory;
import edu.austral.ingsis.clifford.file.File;

public class TouchCommand implements ConsoleCommand{

    private final String params;
    private final Directory currentDir;


    public TouchCommand(String params, Directory currentDir){
        this.params = params;
        this.currentDir = currentDir;
    }
    @Override
    public String execute() {
        if (params.contains(" ") || params.contains("/")) {
            return "Invalid file name: cannot contain spaces or '/'";
        }

        currentDir.addFile(new File(params));
        return String.format(currentDir.getName(), " file created");
    }
}
