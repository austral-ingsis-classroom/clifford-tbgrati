package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.builder.*;
import edu.austral.ingsis.clifford.command.ConsoleCommand;
import edu.austral.ingsis.clifford.file.Directory;
import java.util.HashMap;
import java.util.Map;

public class CommandLineInterface {

  private Cursor directoryCursor;

  private Map<String, CommandBuilder> commandMap;

  public CommandLineInterface() {
    directoryCursor = new Cursor(new Directory("/"));
    this.commandMap = new HashMap<>();

    commandMap.put("cd", new ChangeDirectoryCommandBuilder());
    commandMap.put("ls", new ListDirectoryCommandBuilder());
    commandMap.put("mkdir", new MakeDirectoryCommandBuilder());
    commandMap.put("touch", new TouchCommandBuilder());
    commandMap.put("rm", new RemoveDirectoryCommandBuilder());
    commandMap.put("pwd", new PrintDirectoryCommandBuilder());
  }

  public String runCommand(String message) {
    if (message == null || message.trim().isEmpty()) {
      return "Invalid command";
    }

    String[] parts = message.split(" ");

    String commandName = parts[0];

    CommandBuilder builder = commandMap.get(commandName);
    if (builder == null) {
      return "Command not found";
    }

    StringBuilder argsMessage = new StringBuilder();
    for (int i = 1; i < parts.length; i++) {
      argsMessage.append(parts[i]).append(" ");
    }
    String argsOnlyMessage = argsMessage.toString().trim();

    ConsoleCommand command = builder.build(argsOnlyMessage, directoryCursor);

    return command.execute();
  }
}
