package com.epam.javatraining.changecoding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class ReaderWriter {
    
    private ReaderWriter() {        
    }

    public static void copy(File srcFile, File destFile, Charset srcCoding, Charset destCoding) throws UnsupportedEncodingException, FileNotFoundException, IOException {

        if (srcFile == null || destFile == null) {
            throw new IllegalArgumentException("Could not find file !");
        }
        if (srcCoding == null || destCoding == null) {
            throw new IllegalArgumentException("Could not find coding !");
        }
        InputStreamReader streamReader = new InputStreamReader(new FileInputStream(srcFile), srcCoding);
        OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream(destFile), destCoding);
        copy(streamReader, streamWriter);
    }

    public static void copy(InputStreamReader in, OutputStreamWriter out) throws IOException {
        if (in == null || out == null) {
            throw new IllegalArgumentException();
        }
        copy(new BufferedReader(in), new BufferedWriter(out));
    }
    
    public static void copy(BufferedReader reader, BufferedWriter writer) throws IOException {
        if (reader == null || writer == null) {
            throw new IllegalArgumentException();
        }
        try {
            String thisLine;
            if (((thisLine = reader.readLine()) != null)) {
                writer.write(thisLine);
            }
            while ((thisLine = reader.readLine()) != null) {
                writer.write("\n");
                writer.write(thisLine);                
            }
        } finally {
            reader.close();
            writer.close();
        }
    }
}
