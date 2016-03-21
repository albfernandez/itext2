/*
 * $Id: ConcatenateForms.java 3373 2008-05-12 16:21:24Z xlv $
 *
 * This code is free software. It may only be copied or modified
 * if you include the following copyright notice:
 *
 * This class by Mark Thompson. Copyright (c) 2002 Mark Thompson.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 */
package com.lowagie.examples.general.copystamp;

import org.junit.Test;

import com.lowagie.text.pdf.PdfCopyFields;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfTestBase;

/**
 * Concatenates 2 PDF files with forms. The resulting PDF has 1 merged AcroForm.
 */
public class ConcatenateFormsTest {

	/**
	 * Concatenates 2 PDF files with forms. The resulting PDF has 1 merged AcroForm.
	 */
	@Test
	public void main() throws Exception{
			PdfReader reader1 = new PdfReader(PdfTestBase.RESOURCES_DIR + "SimpleRegistrationForm.pdf");
			PdfReader reader2 = new PdfReader(PdfTestBase.RESOURCES_DIR + "TextFields.pdf");
			PdfCopyFields copy = new PdfCopyFields(PdfTestBase.getOutputStream("concatenatedforms.pdf"));
			copy.addDocument(reader1);
			copy.addDocument(reader2);
			copy.close();
	}
}
