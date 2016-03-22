/*
 * $Id: Scaling.java 3373 2008-05-12 16:21:24Z xlv $
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
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Scaling of images.
 */
public class ScalingTest {
	/**
	 * Scaling an image.
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document();

		// step 2:
		// we create a writer that listens to the document
		// and directs a PDF-stream to a file

		PdfWriter.getInstance(document, PdfTestBase.getOutputStream("scaling.pdf"));

		// step 3: we open the document
		document.open();

		// step 4: we add content
		Image jpg1 = Image.getInstance(PdfTestBase.RESOURCES_DIR + "otsoe.jpg");
		jpg1.scaleAbsolute(160, 120);
		document.add(new Paragraph("scaleAbsolute(160, 120)"));
		document.add(jpg1);
		Image jpg2 = Image.getInstance(PdfTestBase.RESOURCES_DIR + "otsoe.jpg");
		jpg2.scalePercent(50);
		document.add(new Paragraph("scalePercent(50)"));
		document.add(jpg2);
		Image jpg3 = Image.getInstance(PdfTestBase.RESOURCES_DIR + "otsoe.jpg");
		jpg3.scaleAbsolute(320, 120);
		document.add(new Paragraph("scaleAbsolute(320, 120)"));
		document.add(jpg3);
		Image jpg4 = Image.getInstance(PdfTestBase.RESOURCES_DIR + "otsoe.jpg");
		jpg4.scalePercent(100, 50);
		document.add(new Paragraph("scalePercent(100, 50)"));
		document.add(jpg4);

		// step 5: we close the document
		document.close();
	}
}
