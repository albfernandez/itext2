/*
 * $Id: LargeCell.java 3373 2008-05-12 16:21:24Z xlv $
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
package com.lowagie.examples.objects.tables.alternatives;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Using CellsFitPage for a Cell that doesn't fit the page.
 */
public class LargeCellTest {
	/**
	 * Demonstrates the features of the old Table class.
	 */
	@Test
	public void main() throws Exception {
		// step 1: creation of a document-object
		Document document = new Document(PageSize.A6);
		// step 2: creation of the writer-object
		PdfWriter.getInstance(document, PdfTestBase.getOutputStream("largecell.pdf"));
		// step 3: we open the document
		document.open();
		// step 4: we create a table and add it to the document
		Table table = new Table(3);
		table.setCellsFitPage(true);
		String text = "long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long text";
		table.addCell("text");
		table.addCell("text");
		table.addCell("text");
		table.addCell(text);
		table.addCell(text + text);
		table.addCell(text);
		table.addCell("text");
		table.addCell("text");
		table.addCell("text");
		document.add(table);

		// step 5: we close the document
		document.close();
	}

}
