package edu.austral.ingsis.clifford.file;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Directory implements FileSystemObject {

    private final String name;
    private final List<FileSystemObject> files;
    private Directory parentFolder;

    public Directory(String name) {
        this.name = name;
        this.files = new ArrayList<>();
    }

    public Directory(String name, List<FileSystemObject> files, Directory parentFolder) {
        this.name = name;
        this.files = new ArrayList<>(files);
        this.parentFolder = parentFolder;
    }

    @Override
    public Directory getParentDirectory() {
        return parentFolder;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public FileSystemObject setParentDirectory(Directory parentDirectory) {
        return new Directory(name, files, parentDirectory);
    }

    public void addFile(FileSystemObject file) {
        files.add(file.setParentDirectory(this));
    }

    public void removeFile(String name) {
        Iterator<FileSystemObject> iterator = files.iterator();
        while (iterator.hasNext()) {
            FileSystemObject file = iterator.next();
            if (file.getName().equals(name)) {
                iterator.remove();
                break;
            }
        }
    }

    public List<FileSystemObject> getFiles() {
        return new ArrayList<>(files);
    }

    public FileSystemObject getFile(String name) throws IllegalArgumentException {
        for (FileSystemObject file: files){
            if(file.getName().equals(name)){
                return file;
            }
        }
        throw new IllegalArgumentException("File not found");
    }
}
