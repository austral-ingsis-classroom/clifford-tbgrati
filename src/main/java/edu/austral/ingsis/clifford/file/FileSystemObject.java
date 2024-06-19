package edu.austral.ingsis.clifford.file;

public interface FileSystemObject {
  String getName();

  FileSystemObject setParentDirectory(Directory parentDirectory);

  Directory getParentDirectory();
}
