/*
 * $Id: PdfVersion.java 3373 2008-05-12 16:21:24Z xlv $
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

package com.lowagie.examples.general.faq;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Demonstrates the use of setPdfVersion.
 * 
 * @author blowagie
 */
public class PdfVersionTest {
	/**
	 * Creates a PDF document and shows the PDF version.
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document();

		// step 2:
		// we create a writer that listens to the document
		// and directs a PDF-stream to a file
		PdfWriter writer = PdfWriter.getInstance(document, PdfTestBase.getOutputStream("pdfversion.pdf"));
		writer.setPdfVersion(PdfWriter.VERSION_1_2);
		// step 3: we open the document
		document.open();

		// step 4:
		document.add(new Paragraph("This is a PDF-1.2 document"));

		// step 5: we close the document
		document.close();
	}
}