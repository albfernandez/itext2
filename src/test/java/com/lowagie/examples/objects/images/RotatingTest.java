/*
 * $Id: Rotating.java 3373 2008-05-12 16:21:24Z xlv $
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
 * Rotating images.
 */
public class RotatingTest {
	/**
	 * Rotating images.
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document();

		// step 2:
		// we create a writer that listens to the document
		// and directs a PDF-stream to a file

		PdfWriter.getInstance(document, PdfTestBase.getOutputStream("rotating.pdf"));

		// step 3: we open the document
		document.open();

		// step 4: we add content
		Image jpg = Image.getInstance(PdfTestBase.RESOURCES_DIR + "otsoe.jpg");
		jpg.setAlignment(Image.MIDDLE);

		jpg.setRotation((float) Math.PI / 6);
		document.add(new Paragraph("rotate 30 degrees"));
		document.add(jpg);
		document.newPage();

		jpg.setRotation((float) Math.PI / 4);
		document.add(new Paragraph("rotate 45 degrees"));
		document.add(jpg);
		document.newPage();

		jpg.setRotation((float) Math.PI / 2);
		document.add(new Paragraph("rotate pi/2 radians"));
		document.add(jpg);
		document.newPage();

		jpg.setRotation((float) (Math.PI * 0.75));
		document.add(new Paragraph("rotate 135 degrees"));
		document.add(jpg);
		document.newPage();

		jpg.setRotation((float) Math.PI);
		document.add(new Paragraph("rotate pi radians"));
		document.add(jpg);
		document.newPage();

		jpg.setRotation((float) (2.0 * Math.PI));
		document.add(new Paragraph("rotate 2 x pi radians"));
		document.add(jpg);

		// step 5: we close the document
		document.close();
	}

}