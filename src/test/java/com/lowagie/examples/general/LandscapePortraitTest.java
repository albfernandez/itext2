/*
 * $Id: LandscapePortrait.java 3373 2008-05-12 16:21:24Z xlv $
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

package com.lowagie.examples.general;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Demonstrates the creating PDF in portrait/landscape.
 * 
 * @author blowagie
 */
public class LandscapePortraitTest {
	/**
	 * Creates a PDF document with pages in portrait/landscape.
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document(PageSize.A4.rotate());

		// step 2:
		// we create a writer that listens to the document
		// and directs a PDF-stream to a file

		PdfWriter.getInstance(document, PdfTestBase.getOutputStream("LandscapePortrait.pdf"));

		// step 3: we open the document
		document.open();

		// step 4: we add some content
		document.add(new Paragraph(
				"To create a document in landscape format, just make the height smaller than the width. For instance by rotating the PageSize Rectangle: PageSize.A4.rotate()"));
		document.setPageSize(PageSize.A4);
		document.newPage();
		document.add(new Paragraph("This is portrait again"));

		// step 5: we close the document
		document.close();
	}
}