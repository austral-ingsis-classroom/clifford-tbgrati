package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.file.Directory;

public class RemoveCommand implements ConsoleCommand{

    private final String params;

    private final String options;

    private final Directory currentDir;

    public RemoveCommand(String params, String options, Directory currentDir) {
        this.params = params;
        this.options = options;
        this.currentDir = currentDir;
    }

    @Override
    public String execute() {

        if(options == "--recursive"){
            currentDir.removeFile(params);
        }
        else{
            if(!(currentDir.getFile(params) instanceof Directory)){
                currentDir.removeFile(params);
            }
        }


        return String.format(params, " removed");
    }
}
