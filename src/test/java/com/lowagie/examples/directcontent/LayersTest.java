/*
 * $Id: Layers.java 3838 2009-04-07 18:34:15Z mstorer $
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
package com.lowagie.examples.directcontent;

import org.junit.Test;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Explains the concept concerning PdfContentByte layers.
 */
public class LayersTest {

	/**
	 * Draws different things into different layers.
	 */
	@Test
	public void main() throws Exception {


		// step 1: creation of a document-object
		Document document = new Document();

		
		// step 2: creation of the writer
		PdfWriter writer = PdfWriter.getInstance(document,	PdfTestBase.getOutputStream("layers.pdf"));

		// step 3: we open the document
		document.open();

		// step 4:

		// high level
		Paragraph p = new Paragraph();
		for (int i = 0; i < 100; i++)
			p.add(new Chunk("Blah blah blah blah blah. "));
		document.add(p);
		Image img = Image.getInstance(PdfTestBase.RESOURCES_DIR
				+ "hitchcock.png");
		img.setAbsolutePosition(100, 500);
		document.add(img);

		// low level
		PdfContentByte cb = writer.getDirectContent();
		PdfContentByte cbu = writer.getDirectContentUnder();
		cb.setRGBColorFill(0xFF, 0xFF, 0xFF);
		cb.circle(250.0f, 500.0f, 50.0f);
		cb.fill();
		cb.sanityCheck();

		cbu.setRGBColorFill(0xFF, 0x00, 0x00);
		cbu.circle(250.0f, 500.0f, 100.0f);
		cbu.fill();
		cbu.sanityCheck();

		// step 5: we close the document
		document.close();
	}

}
