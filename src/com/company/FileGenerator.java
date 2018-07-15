package com.company;

import java.io.*;

public class FileGenerator {

    public void genenrateFile(String fileName,String value) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
        try {
            outStream.writeUTF(value);
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
