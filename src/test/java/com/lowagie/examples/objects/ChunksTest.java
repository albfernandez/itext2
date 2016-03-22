/*
 * $Id: Chunks.java 3373 2008-05-12 16:21:24Z xlv $
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

package com.lowagie.examples.objects;

import java.awt.Color;

import org.junit.Test;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Demonstrates some Chunk functionality.
 * 
 * @author blowagie
 */

public class ChunksTest {

	/**
	 * Demonstrates some Chunk functionality.
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document();
		// step 2:
		// we create a writer that listens to the document
		PdfWriter.getInstance(document, PdfTestBase.getOutputStream("Chunks.pdf"));

		// step 3: we open the document
		document.open();
		// step 4:
		Chunk fox = new Chunk("quick brown fox");
		float superscript = 8.0f;
		fox.setTextRise(superscript);
		fox.setBackground(new Color(0xFF, 0xDE, 0xAD));
		Chunk jumps = new Chunk(" jumps over ");
		Chunk dog = new Chunk("the lazy dog");
		float subscript = -8.0f;
		dog.setTextRise(subscript);
		dog.setUnderline(new Color(0xFF, 0x00, 0x00), 3.0f, 0.0f, -5.0f + subscript, 0.0f,
				PdfContentByte.LINE_CAP_ROUND);
		document.add(fox);
		document.add(jumps);
		document.add(dog);

		// step 5: we close the document
		document.close();
	}
}