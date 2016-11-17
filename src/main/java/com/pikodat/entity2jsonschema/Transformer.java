package com.pikodat.entity2jsonschema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Transforming JPA Entities to JSON Schema
 *
 * @author veit@pikodat.com, 16.11.2016
 */
public class Transformer {

  /**
   * Create Transformer
   *
   * @param directory Directory to look for JPA Entities
   * @throws IOException
   */
  public Transformer(String directory) throws IOException {
    this(Files.walk(Paths.get(directory)));
  }

  /**
   * Create Transformer
   *
   * @param pathStream Directory to look for JPA Entities
   * @throws IOException
   */
  public Transformer(Stream<Path> pathStream) throws IOException {
    pathStream
        .filter(path -> path.getFileName().toString().toLowerCase().endsWith(".java"))
        .forEach(this::process);
  }

  /**
   * Analyze Java source code file
   *
   * @param sourceFile
   */
  private void process(Path sourceFile) {
    System.out.println(sourceFile.getFileName());
  }
}
