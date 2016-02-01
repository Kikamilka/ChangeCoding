package com.epam.javatraining.changecoding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReaderWriterTest {
    
    public ReaderWriterTest() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCopy_4args() throws Exception {
        System.out.println("copy for null");
        File srcFile = null;
        File destFile = null;
        Charset srcCoding = null;
        Charset destCoding = null;
        ReaderWriter.copy(srcFile, destFile, srcCoding, destCoding);
    }

    @Test
    public void testCopy_BufferedReader_BufferedWriter() throws Exception {
        System.out.println("copy test for buffer");        
        String src = "Test string";
        BufferedReader reader = new BufferedReader(new StringReader(src));
        StringWriter strWriter = new StringWriter();
        BufferedWriter writer = new BufferedWriter(strWriter);
        ReaderWriter.copy(reader, writer);
        System.out.println("Src["+src+"]");
        System.out.println("Dest["+strWriter.toString()+"]");
        assertTrue(src.equals(strWriter.toString()));
    }
    
}
