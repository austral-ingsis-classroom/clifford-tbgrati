package edu.austral.ingsis.clifford.file;

public class File implements FileSystemObject {

  private final String name;

  private Directory parentDirectory = null;

  public File(String name) {
    this.name = name;
  }

  public File(String name, Directory parentDirectory) {
    this.name = name;
    this.parentDirectory = parentDirectory;
  }

  @Override
  public Directory getParentDirectory() {
    return parentDirectory;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public FileSystemObject setParentDirectory(Directory parentDirectory) {
    return new File(name, parentDirectory);
  }
}
