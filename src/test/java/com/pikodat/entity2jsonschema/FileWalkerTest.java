package com.pikodat.entity2jsonschema;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author veit.weber@gmail.com, 16.11.2016
 */
public class FileWalkerTest {
  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void transformExampleEntities() throws IOException {
    FileWalker fileWalker = new FileWalker("/Users/veit/Development/source/ulc/ee-rating/EEG_Backend/src/main/java/de/ulc/eegrating/db/entities");
  }

  @After
  public void tearDown() throws Exception {

  }

}