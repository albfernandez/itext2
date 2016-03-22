/*
 * $Id: ImageChunks.java 3373 2008-05-12 16:21:24Z xlv $
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

import java.awt.Color;

import org.junit.Test;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Wrapping Images in a Chunk.
 */
public class ImageChunksTest {
	/**
	 * Images wrapped in a Chunk.
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document();
		// step 2:
		// we create a writer that listens to the document
		// and directs a PDF-stream to a file
		PdfWriter.getInstance(document, PdfTestBase.getOutputStream("imageChunks.pdf"));
		// step 3: we open the document
		document.open();
		// step 4: we create a table and add it to the document
		Image img = Image.getInstance(PdfTestBase.RESOURCES_DIR + "pngnow.png");
		img.scalePercent(70);
		Chunk ck = new Chunk(img, 0, -5);
		PdfPTable table = new PdfPTable(3);
		PdfPCell cell = new PdfPCell();
		cell.addElement(new Chunk(img, 5, -5));
		cell.setBackgroundColor(new Color(0xC0, 0xC0, 0xC0));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell("I see an image\non my right");
		table.addCell(cell);
		table.addCell("I see an image\non my left");
		table.addCell(cell);
		table.addCell("I see images\neverywhere");
		table.addCell(cell);
		table.addCell("I see an image\non my right");
		table.addCell(cell);
		table.addCell("I see an image\non my left");

		Phrase p1 = new Phrase("This is an image ");
		p1.add(ck);
		p1.add(" just here.");
		document.add(p1);
		document.add(p1);
		document.add(p1);
		document.add(p1);
		document.add(p1);
		document.add(p1);
		document.add(p1);
		document.add(table);

		// step 5: we close the document
		document.close();
	}
}
