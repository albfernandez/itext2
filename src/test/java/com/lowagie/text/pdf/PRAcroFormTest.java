package com.lowagie.text.pdf;

import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;

public class PRAcroFormTest {
	
    @Test(timeout=1000)
    public void infiniteLoopTest() throws Exception {
        try (InputStream is = new FileInputStream("src/test/resources/pades_opposite_infinite_loop.pdf")) {
        	PdfReader reader = new PdfReader(is);
        	reader.getAcroForm();
        	reader.close();
        }        
    }

}
