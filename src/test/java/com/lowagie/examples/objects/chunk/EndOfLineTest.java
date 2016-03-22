/*
 * $Id: EndOfLine.java 3373 2008-05-12 16:21:24Z xlv $
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

package com.lowagie.examples.objects.chunk;

import java.awt.Color;

import org.junit.Test;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Shows what happens if the end of the line is reached
 * 
 * @author blowagie
 */

public class EndOfLineTest {

	/**
	 * Demonstrates the use of the Phrase object.
	 * 
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document();
		// step 2:
		// we create a writer that listens to the document
		PdfWriter.getInstance(document, PdfTestBase.getOutputStream("EndOfLine.pdf"));

		// step 3: we open the document
		document.open();
		// step 4:
		Chunk chunk = new Chunk("quick brown fox jumps over the lazy dog ");
		for (int i = 0; i < 5; i++) {
			chunk.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_STROKE, 0.3f, new Color(i * 30, i * 30, i * 30));
			document.add(chunk);
		}
		document.newPage();
		Phrase p = new Phrase(16f);
		for (int i = 0; i < 5; i++) {
			chunk = new Chunk("quick brown fox jumps over the lazy dog ");
			chunk.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_STROKE, 0.3f, new Color(i * 30, i * 30, i * 30));
			p.add(chunk);
		}
		document.add(p);

		// step 5: we close the document
		document.close();
	}
}