package com.pikodat.entity2jsonschema;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * Looking JPA Entities to JSON Schema
 *
 * @author veit@pikodat.com, 16.11.2016
 */
public class FileWalker {

  private static Logger LOGGER = Logger.getLogger(FileWalker.class.getName());

  /**
   * Create FileWalker
   *
   * @param directory Directory to look for JPA Entities
   * @throws IOException
   */
  public FileWalker(String directory) throws IOException {
    this(Files.walk(Paths.get(directory)));
  }

  /**
   * Create FileWalker
   *
   * @param pathStream Directory to look for JPA Entities
   * @throws IOException
   */
  public FileWalker(Stream<Path> pathStream) {
    pathStream
        .filter(path -> path.getFileName().toString().toLowerCase().endsWith(".java"))
        .forEach(path -> this.process(path.toAbsolutePath().toString()));
  }

  /**
   * Analyze Java source code file
   *
   * @param sourceFilePath Full path to source file
   */
  private void process(String sourceFilePath) {
    CompilationUnit cu = null;

    try (FileInputStream in = new FileInputStream(sourceFilePath)) {
      cu = JavaParser.parse(in);
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, e.getMessage(), e);
    }
    if (cu != null) {
      // todo nur mit @entity annotierte klassen auslesen
    }
  }
}
