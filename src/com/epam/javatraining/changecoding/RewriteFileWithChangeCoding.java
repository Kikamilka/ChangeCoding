package com.epam.javatraining.changecoding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class RewriteFileWithChangeCoding {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Invalid arguments");
            System.exit(-1);
        }

        try {
            File srcFile = new File(args[0]);
            File destFile = new File(args[1]);
            ReaderWriter.copy(srcFile, destFile, Charset.forName("UTF-16LE"), Charset.forName("WINDOWS-1251"));
        } catch (FileNotFoundException ex) {
            System.out.println("File is not found:" + ex.getMessage());
            System.exit(-1);

        } catch (UnsupportedEncodingException ex) {
            System.out.println("Unsupported encoding:" + ex.getMessage());
            System.exit(-1);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }
}
