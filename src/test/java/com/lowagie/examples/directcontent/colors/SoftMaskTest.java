/*
 * $Id: SoftMask.java 3838 2009-04-07 18:34:15Z mstorer $
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
package com.lowagie.examples.directcontent.colors;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.RunAllExamplesTest;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Demonstrates transparency and images.
 */
public class SoftMaskTest {

	/**
	 * Demonstrates the Transparency functionality.
	 */
	@Test
	public  void main() throws Exception {
		// step 1: creation of a document-object
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		// step 2: creation of a writer
		PdfWriter writer = PdfWriter.getInstance(document,PdfTestBase.getOutputStream("softmask.pdf"));
		// step 3: we open the document
		document.open();
		// step 4: content
		PdfContentByte cb = writer.getDirectContent();
		String text = "text ";
		text += text;
		text += text;
		text += text;
		text += text;
		text += text;
		text += text;
		text += text;
		text += text;
		document.add(new Paragraph(text));
		Image img = Image.getInstance(RunAllExamplesTest.RESOURCES_DIR	+ "otsoe.jpg");
		img.setAbsolutePosition(100, 550);
		byte gradient[] = new byte[256];
		for (int k = 0; k < 256; ++k) {
			gradient[k] = (byte) k;
		}
		Image smask = Image.getInstance(256, 1, 1, 8, gradient);
		smask.makeMask();
		img.setImageMask(smask);
		cb.addImage(img);
		cb.sanityCheck();
		// step 5: we close the document
		document.close();
	}
}