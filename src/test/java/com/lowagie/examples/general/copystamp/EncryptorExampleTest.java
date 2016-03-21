/*
 * $Id: EncryptorExample.java 3373 2008-05-12 16:21:24Z xlv $
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
package com.lowagie.examples.general.copystamp;

import org.junit.Test;

import com.lowagie.text.pdf.PdfEncryptor;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Encrypts an existing PDF file.
 */
public class EncryptorExampleTest {

	/**
	 * Reads and encrypts an existing PDF file.
	 */
	@Test
	public void main() throws Exception {
		PdfReader reader = new PdfReader(PdfTestBase.RESOURCES_DIR + "ChapterSection.pdf");
		PdfEncryptor.encrypt(reader, PdfTestBase.getOutputStream("encrypted.pdf"), "Hello".getBytes(),
				"World".getBytes(), PdfWriter.ALLOW_PRINTING | PdfWriter.ALLOW_COPY, false);
	}
}
