/*
 * $Id: CellEvents.java 3373 2008-05-12 16:21:24Z xlv $
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
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPCellEvent;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * General example using CellEvents.
 */
public class CellEventsTest implements PdfPCellEvent {

	/**
	 * @see com.lowagie.text.pdf.PdfPCellEvent#cellLayout(com.lowagie.text.pdf.PdfPCell,
	 *      com.lowagie.text.Rectangle, com.lowagie.text.pdf.PdfContentByte[])
	 */
	public void cellLayout(PdfPCell cell, Rectangle position, PdfContentByte[] canvases) {
		PdfContentByte cb = canvases[PdfPTable.TEXTCANVAS];
		cb.moveTo(position.getLeft(), position.getBottom());
		cb.lineTo(position.getRight(), position.getTop());
		cb.stroke();
	}

	/**
	 * General example using cell events.
	 * 
	 */
	@Test
	public void main() throws Exception {
		// step1
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		// step2
		PdfWriter writer = PdfWriter.getInstance(document, PdfTestBase.getOutputStream("CellEvents.pdf"));
		// step3
		document.open();
		// step4
		CellEventsTest event = new CellEventsTest();
		Image im = Image.getInstance(PdfTestBase.RESOURCES_DIR + "otsoe.jpg");
		im.setRotationDegrees(30);
		PdfPTable table = new PdfPTable(4);
		table.addCell("text 1");
		PdfPCell cell = new PdfPCell(im, true);
		cell.setCellEvent(event);
		table.addCell(cell);
		table.addCell("text 3");
		im.setRotationDegrees(0);
		table.addCell(im);
		table.setTotalWidth(300);
		PdfContentByte cb = writer.getDirectContent();
		table.writeSelectedRows(0, -1, 50, 600, cb);
		table.setHeaderRows(3);
		document.add(table);

		// step5
		document.close();
	}
}