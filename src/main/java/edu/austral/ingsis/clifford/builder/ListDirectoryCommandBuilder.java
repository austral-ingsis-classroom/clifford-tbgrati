package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.command.ConsoleCommand;
import edu.austral.ingsis.clifford.command.ListDirectoryCommand;
import edu.austral.ingsis.clifford.file.Directory;
import edu.austral.ingsis.clifford.file.FileSystemObject;

import java.util.HashMap;
import java.util.Map;

public class ListDirectoryCommandBuilder implements CommandBuilder{
    @Override
    public ConsoleCommand build(String params, Directory currentDir) {
        Map<String, String> options = parseParams(params);
        String order = options.get("ord");

        return new ListDirectoryCommand(order, currentDir);
    }

    private Map<String, String> parseParams(String params) {
        Map<String, String> options = new HashMap<>();
        if (params != null && !params.trim().isEmpty()) {
            String[] parts = params.trim().split("\\s+");
            for (String part : parts) {
                if (part.startsWith("--ord=")) {
                    options.put("ord", part.substring("--ord=".length()));
                }
            }
        }
        return options;
    }
}
