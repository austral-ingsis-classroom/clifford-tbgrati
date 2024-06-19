package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.command.ConsoleCommand;
import edu.austral.ingsis.clifford.file.Directory;
import edu.austral.ingsis.clifford.file.FileSystemObject;

public interface CommandBuilder {

    public abstract ConsoleCommand build(String params, Directory currentDir);
}
