package edu.austral.ingsis.clifford.file;

import java.util.Date;

public interface FileSystemObject {
    String getName();

    FileSystemObject setParentDirectory(Directory parentDirectory);

    Directory getParentDirectory();

}
