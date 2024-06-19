package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.file.Directory;

public class Cursor {

  private Directory currentDir;

  private Directory root;

  public Cursor(Directory currentDir) {
    this.currentDir = currentDir;
    this.root = currentDir;
  }

  public void moveCursor(Directory dir) {
    this.currentDir = dir;
  }

  public Directory getRoot() {
    return root;
  }

  public Directory getDirectory() {
    return currentDir;
  }
}
