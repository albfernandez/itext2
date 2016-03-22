/*
 * $Id: NamedActions.java 3373 2008-05-12 16:21:24Z xlv $
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

package com.lowagie.examples.objects.anchors;

import org.junit.Test;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Creates a documents with different named actions.
 * 
 * @author blowagie
 */

public class NamedActionsTest {

	/**
	 * Creates a document with Named Actions.
	 * 
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);

		// step 2: we create a writer that listens to the document
		PdfWriter.getInstance(document, PdfTestBase.getOutputStream("NamedActions.pdf"));
		// step 3: we open the document
		document.open();
		// step 4: we add some content
		Paragraph p = new Paragraph(new Chunk("Click to print").setAction(new PdfAction(PdfAction.PRINTDIALOG)));
		PdfPTable table = new PdfPTable(4);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(new Phrase(new Chunk("First Page").setAction(new PdfAction(PdfAction.FIRSTPAGE))));
		table.addCell(new Phrase(new Chunk("Prev Page").setAction(new PdfAction(PdfAction.PREVPAGE))));
		table.addCell(new Phrase(new Chunk("Next Page").setAction(new PdfAction(PdfAction.NEXTPAGE))));
		table.addCell(new Phrase(new Chunk("Last Page").setAction(new PdfAction(PdfAction.LASTPAGE))));
		for (int k = 1; k <= 10; ++k) {
			document.add(new Paragraph("This is page " + k));
			document.add(Chunk.NEWLINE);
			document.add(table);
			document.add(p);
			document.newPage();
		}

		// step 5: we close the document
		document.close();

	}
}