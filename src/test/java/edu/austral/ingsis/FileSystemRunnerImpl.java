package edu.austral.ingsis;

import edu.austral.ingsis.clifford.CommandLineInterface;
import java.util.ArrayList;
import java.util.List;

public class FileSystemRunnerImpl implements FileSystemRunner {
  private final CommandLineInterface cli = new CommandLineInterface();

  @Override
  public List<String> executeCommands(List<String> commands) {
    List<String> result = new ArrayList<String>();
    for (String command : commands) {
      result.add(cli.runCommand(command));
    }
    return result;
  }
}
