package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.command.ConsoleCommand;
import edu.austral.ingsis.clifford.command.RemoveCommand;
import edu.austral.ingsis.clifford.file.Directory;

public class RemoveDirectoryCommandBuilder implements CommandBuilder{
    @Override
    public ConsoleCommand build(String params, Directory currentDir) {
        String[] parts = params.split(" ");
        String parameters = null;
        String options = null;

        if (parts.length == 2) {
            parameters = parts[1];
        } else if (parts.length == 3 && parts[1].startsWith("--")) {
            options = parts[1];
            parameters = parts[2];
        } else {
            throw new IllegalArgumentException("Invalid command format");
        }

        return new RemoveCommand(parameters, options, currentDir);
    }
}
