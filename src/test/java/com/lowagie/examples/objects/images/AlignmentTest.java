/*
 * $Id: Alignment.java 3373 2008-05-12 16:21:24Z xlv $
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
package com.lowagie.examples.objects.images;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Demonstrates the alignment method and parameters.
 */
public class AlignmentTest {
	/**
	 * Demonstrates the alignment method.
	 */
	@Test
	public void main() throws Exception {
		// step 1: creation of a document-object
		Document document = new Document();
		// step 2: creation of a writer
		PdfWriter.getInstance(document, PdfTestBase.getOutputStream("alignment.pdf"));

		// step 3: we open the document
		document.open();

		Image gif = Image.getInstance(PdfTestBase.RESOURCES_DIR + "vonnegut.gif");
		gif.setAlignment(Image.RIGHT);
		Image jpeg = Image.getInstance(PdfTestBase.RESOURCES_DIR + "otsoe.jpg");
		jpeg.setAlignment(Image.MIDDLE);
		Image png = Image.getInstance(PdfTestBase.RESOURCES_DIR + "hitchcock.png");
		png.setAlignment(Image.LEFT);

		document.add(gif);
		document.add(jpeg);
		document.add(png);

		// step 5: we close the document
		document.close();
	}
}
