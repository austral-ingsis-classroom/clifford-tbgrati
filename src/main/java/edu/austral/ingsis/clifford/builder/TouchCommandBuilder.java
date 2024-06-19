package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.command.ConsoleCommand;
import edu.austral.ingsis.clifford.command.TouchCommand;
import edu.austral.ingsis.clifford.file.Directory;

public class TouchCommandBuilder implements CommandBuilder{


    @Override
    public ConsoleCommand build(String params, Directory currentDir) {
        return new TouchCommand(params, currentDir);
    }
}
