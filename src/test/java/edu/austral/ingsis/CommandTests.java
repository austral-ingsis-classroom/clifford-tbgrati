package edu.austral.ingsis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.austral.ingsis.clifford.Cursor;
import edu.austral.ingsis.clifford.command.ListDirectoryCommand;
import edu.austral.ingsis.clifford.command.MakeDirectoryCommand;
import edu.austral.ingsis.clifford.command.RemoveCommand;
import edu.austral.ingsis.clifford.command.TouchCommand;
import edu.austral.ingsis.clifford.file.Directory;
import edu.austral.ingsis.clifford.file.File;
import org.junit.jupiter.api.Test;

public class CommandTests {

  @Test
  public void testLsCommandReturnsFileNames() {
    Directory folder = new Directory("testFolder");
    Cursor cursor = new Cursor(folder);
    folder.addFile(new Directory("listedFolder1"));
    folder.addFile(new Directory("listedFolder2"));
    folder.addFile(new File("listedFile1"));

    ListDirectoryCommand ls = new ListDirectoryCommand("", cursor);
    String result = ls.execute();

    assertEquals("listedFolder1 listedFolder2 listedFile1", result);
  }

  @Test
  public void testLsCommandReturnsInAsc() {
    Directory folder = new Directory("testFolder");
    Cursor cursor = new Cursor(folder);
    folder.addFile(new Directory("bFolder"));
    folder.addFile(new Directory("aFolder"));
    folder.addFile(new File("cFile"));

    ListDirectoryCommand ls = new ListDirectoryCommand("asc", cursor);
    String result = ls.execute();

    assertEquals("aFolder bFolder cFile", result);
  }

  @Test
  public void testLsCommandReturnsInDesc() {
    Directory folder = new Directory("testFolder");
    Cursor cursor = new Cursor(folder);
    folder.addFile(new Directory("bFolder"));
    folder.addFile(new Directory("aFolder"));
    folder.addFile(new File("cFile"));

    ListDirectoryCommand ls = new ListDirectoryCommand("desc", cursor);
    String result = ls.execute();

    assertEquals("cFile bFolder aFolder", result);
  }

  @Test
  public void testTouchCommandCreatesFile() {
    Directory folder = new Directory("testFolder");
    Cursor cursor = new Cursor(folder);

    TouchCommand touch = new TouchCommand("testFile.txt", cursor);

    touch.execute();

    ListDirectoryCommand ls = new ListDirectoryCommand("", cursor);
    String result = ls.execute();

    assertEquals("testFile.txt", result);
  }

  @Test
  public void testMkdirCommandCreatesDirectory() {
    Directory folder = new Directory("testFolder");
    Cursor cursor = new Cursor(folder);

    MakeDirectoryCommand mkdir = new MakeDirectoryCommand("testFolder2", cursor);

    mkdir.execute();

    ListDirectoryCommand ls = new ListDirectoryCommand("", cursor);
    String result = ls.execute();

    assertEquals("testFolder2", result);
  }

  @Test
  public void testRmCommandDeletsFile() {
    Directory folder = new Directory("testFolder");
    Cursor cursor = new Cursor(folder);

    folder.addFile(new File("removedFile.txt"));

    RemoveCommand rm = new RemoveCommand("removedFile.txt", "", cursor);

    rm.execute();

    assertTrue(folder.getFiles().isEmpty());
  }

  @Test
  public void testPwdCommandPrintsCurrentDir() {
    Directory folder = new Directory("currentFolder");
    Cursor cursor = new Cursor(folder);
    folder.addFile(new Directory("listedFolder1"));
    folder.addFile(new Directory("listedFolder2"));
    folder.addFile(new File("listedFile1"));

    ListDirectoryCommand ls = new ListDirectoryCommand("", cursor);
    String result = ls.execute();

    assertEquals("listedFolder1 listedFolder2 listedFile1", result);
  }
}
