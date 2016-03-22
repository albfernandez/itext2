/*
 * $Id: SplitTable.java 3373 2008-05-12 16:21:24Z xlv $
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
package com.lowagie.examples.objects.tables.pdfptable;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Break a large table up into different smaller tables in order to save memory.
 */
public class SplitTableTest {
	/**
	 * Break a large table up into several smaller tables for memory management
	 * purposes.
	 * 
	 */
	@Test
	public void main() throws Exception {
		// step1
		Document document = new Document(PageSize.A4, 10, 10, 10, 10);
		// step2
		PdfWriter writer = PdfWriter.getInstance(document, PdfTestBase.getOutputStream("SplitTable.pdf"));
		// step3
		document.open();
		// step4

		PdfContentByte cb = writer.getDirectContent();
		PdfPTable table = new PdfPTable(10);
		for (int k = 1; k <= 100; ++k) {
			table.addCell("The number " + k);
		}
		table.setTotalWidth(800);
		table.writeSelectedRows(0, 5, 0, -1, 50, 650, cb);
		document.newPage();
		table.writeSelectedRows(5, -1, 0, -1, 50, 650, cb);
		document.close();

		// step5
		document.close();
	}
}