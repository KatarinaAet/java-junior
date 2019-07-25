package com.acme.edu;

import java.io.*;

/**
 * Created by Java_1 on 25.07.2019.
 */
public class FileSaver implements Saver {
    private File path = new File("log_Info.txt");
    private BufferedWriter out;

    //public FileSaver(){}

    @Override
    public void print(String message) throws IOException {
        try {
            //path.createNewFile();
            out = new BufferedWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(
                                    new FileOutputStream(path))));

        } catch (IOException e) {
            e.printStackTrace();
        }
        out.write(message);
    }

    public File getPath(){
        return path;
    }

    public void closeFile() throws IOException {
        out.close();
    }

}