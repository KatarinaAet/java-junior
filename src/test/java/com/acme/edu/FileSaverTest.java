package com.acme.edu;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Java_1 on 25.07.2019.
 */
public class FileSaverTest {
    //private File path = new File("log_Info.txt");
    @Test
    public void ShouldSaveInformation() throws IOException {
        FileSaver saver = new FileSaver();
        File path = saver.getPath();
        saver.print("Hello");
        saver.closeFile();
        List<String> info = Files.readAllLines(path.toPath());
        Assert.assertEquals("Hello", info.get(0));
        //Assert.assertEquals("Hello", Files.readAllLines(path.toPath()).forEach(a->a.toString()));
    }

    @Test
    public void ShouldSaveCyrillic() throws IOException {
        FileSaver saver = new FileSaver();
        File path = saver.getPath();
        saver.print("Привет");
        saver.closeFile();
        List<String> info = Files.readAllLines(path.toPath());
        Assert.assertEquals("Привет", info.get(0));
    }
}