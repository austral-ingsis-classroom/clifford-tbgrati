package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.command.ChangeDirectoryCommand;
import edu.austral.ingsis.clifford.command.ConsoleCommand;
import edu.austral.ingsis.clifford.file.Directory;
import edu.austral.ingsis.clifford.file.FileSystemObject;

import java.util.Arrays;

public class ChangeDirectoryCommandBuilder implements CommandBuilder {

    @Override
    public ConsoleCommand build(String params, Directory currentDir) {
        if (params == null || params.isEmpty()) {
            return new ChangeDirectoryCommand(params, new String[0], currentDir);
        }

        String[] dirNames;
        if (params.equals("..") || params.equals(".")) {
            dirNames = new String[] { params };
        } else {
            // Split params by '/' to get individual directory names
            dirNames = params.split("/");
        }

        // Filter out empty strings resulting from split (e.g., leading/trailing slashes)
        dirNames = Arrays.stream(dirNames)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);

        return new ChangeDirectoryCommand(params, dirNames, currentDir);
    }
}
