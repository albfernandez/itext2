/*
 * $Id: ImageCell.java 3373 2008-05-12 16:21:24Z xlv $
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
package com.lowagie.examples.objects.tables;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * A cell with an Image.
 */
public class ImageCellTest {

	/**
	 * A cell with an image.
	 * 
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document();

		// step 2:
		PdfWriter.getInstance(document, PdfTestBase.getOutputStream("ImageCell.pdf"));

		// step 3: we open the document
		document.open();
		Image image = Image.getInstance(PdfTestBase.RESOURCES_DIR + "otsoe.jpg");
		float[] widths = { 1f, 4f };
		PdfPTable table = new PdfPTable(widths);
		table.addCell("This is my dog");
		table.addCell(image);
		table.addCell("This two");
		table.addCell(new PdfPCell(image, true));
		table.addCell("This three");
		table.addCell(new PdfPCell(image, false));
		document.add(table);

		// step 5: we close the document
		document.close();
	}
}