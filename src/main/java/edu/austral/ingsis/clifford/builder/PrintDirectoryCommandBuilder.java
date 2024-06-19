package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.command.ConsoleCommand;
import edu.austral.ingsis.clifford.command.PrintDirectoryCommand;
import edu.austral.ingsis.clifford.file.Directory;

public class PrintDirectoryCommandBuilder implements CommandBuilder{
    @Override
    public ConsoleCommand build(String params, Directory currentDir) {
        return new PrintDirectoryCommand(params, currentDir);
    }
}
