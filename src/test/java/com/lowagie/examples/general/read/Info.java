/*
 * $Id: Info.java 3373 2008-05-12 16:21:24Z xlv $
 *
 * This code is part of the 'iText Tutorial'.
 * You can find the complete tutorial at the following address:
 * http://itextdocs.lowagie.com/tutorial/
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * itext-questions@lists.sourceforge.net
 */
package com.lowagie.examples.general.read;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.junit.Test;

import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfTestBase;

/**
 * Getting information from a PDF file.
 */
public class Info {
	
	@Test
	public void test () throws Exception {
		main(
				PdfTestBase.RESOURCES_DIR + "HelloWorldMeta.pdf", 
				PdfTestBase.RESOURCES_DIR + "ChapterSection.pdf", 
				PdfTestBase.RESOURCES_DIR + "Concatenate.pdf"	
		);

	}
	
	/**
	 * Getting information from a PDF file
	 * @param args 	the names of paths to PDF files.
	 */
	public void main(String... args) throws Exception {
		BufferedWriter out = new BufferedWriter(new FileWriter(PdfTestBase.getOutputFile("info.txt")));
        for (int i = 0; i < args.length; i++) { 
        	PdfReader r = new PdfReader(args[i]);
            out.write(args[i]);
            out.write("\r\n------------------------------------\r\n");
        	out.write(r.getInfo().toString());
        	out.write("\r\n------------------------------------\r\n");
        }
        out.flush();
        out.close();
	}

}
