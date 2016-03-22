/*
 * $Id: Rendering.java 3373 2008-05-12 16:21:24Z xlv $
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
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Special rendering of Chunks.
 * 
 * @author blowagie
 */

public class RenderingTest {

	/**
	 * Special rendering of Chunks.
	 * 
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document();
		// step 2:
		// we create a writer that listens to the document
		PdfWriter.getInstance(document, PdfTestBase.getOutputStream("Rendering.pdf"));

		// step 3: we open the document
		document.open();
		// step 4:
		Paragraph p = new Paragraph("Text Rendering:");
		document.add(p);
		Chunk chunk = new Chunk("rendering test");
		chunk.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_FILL, 100f, new Color(0xFF, 0x00, 0x00));
		document.add(chunk);
		document.add(Chunk.NEWLINE);
		chunk.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_FILL_STROKE, 0.3f, new Color(0xFF, 0x00, 0x00));
		document.add(chunk);
		document.add(Chunk.NEWLINE);
		chunk.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_INVISIBLE, 100f, new Color(0x00, 0xFF, 0x00));
		document.add(chunk);
		document.add(Chunk.NEWLINE);
		chunk.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_STROKE, 0.3f, new Color(0x00, 0x00, 0xFF));
		document.add(chunk);
		document.add(Chunk.NEWLINE);
		Chunk bold = new Chunk("This looks like Font.BOLD");
		bold.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_FILL_STROKE, 0.5f, new Color(0x00, 0x00, 0x00));
		document.add(bold);

		// step 5: we close the document
		document.close();
	}
}