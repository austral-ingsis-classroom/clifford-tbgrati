package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.command.ConsoleCommand;
import edu.austral.ingsis.clifford.command.MakeDirectoryCommand;
import edu.austral.ingsis.clifford.file.Directory;

public class MakeDirectoryCommandBuilder implements CommandBuilder{
    @Override
    public ConsoleCommand build(String params, Directory currentDir) {
        return new MakeDirectoryCommand(params, currentDir);
    }
}
