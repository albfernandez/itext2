/*
 * $Id: ImagesAlignment.java 3373 2008-05-12 16:21:24Z xlv $
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

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Testing Image alignment.
 */
public class ImagesAlignmentTest {

	/**
	 * Generates a PDF with Images that are aligned.
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document();
		// step 2:
		// we create a writer that listens to the document
		// and directs a PDF-stream to a file
		PdfWriter.getInstance(document, PdfTestBase.getOutputStream("imagesAlignment.pdf"));

		// step 3: we open the document
		document.open();

		// step 4: content
		Image gif = Image.getInstance(PdfTestBase.RESOURCES_DIR + "vonnegut.gif");
		gif.setAlignment(Image.RIGHT | Image.TEXTWRAP);
		Image jpeg = Image.getInstance(PdfTestBase.RESOURCES_DIR + "otsoe.jpg");
		jpeg.setAlignment(Image.MIDDLE);
		Image png = Image.getInstance(PdfTestBase.RESOURCES_DIR + "hitchcock.png");
		png.setAlignment(Image.LEFT | Image.UNDERLYING);

		for (int i = 0; i < 100; i++) {
			document.add(new Phrase("Who is this? "));
		}
		document.add(gif);
		for (int i = 0; i < 100; i++) {
			document.add(new Phrase("Who is this? "));
		}
		document.add(Chunk.NEWLINE);
		document.add(jpeg);
		for (int i = 0; i < 100; i++) {
			document.add(new Phrase("Who is this? "));
		}
		document.add(png);
		for (int i = 0; i < 100; i++) {
			document.add(new Phrase("Who is this? "));
		}
		document.add(gif);
		for (int i = 0; i < 100; i++) {
			document.add(new Phrase("Who is this? "));
		}
		document.add(Chunk.NEWLINE);
		document.add(jpeg);
		for (int i = 0; i < 100; i++) {
			document.add(new Phrase("Who is this? "));
		}
		document.add(png);
		for (int i = 0; i < 100; i++) {
			document.add(new Phrase("Who is this? "));
		}

		// step 5: we close the document
		document.close();
	}
}
