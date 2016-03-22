/*
 * $Id: ChainedActions.java 3373 2008-05-12 16:21:24Z xlv $
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
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Creates a documents with chained actions.
 * 
 * @author blowagie
 */

public class ChainedActionsTest {

	/**
	 * Creates a document with chained Actions.
	 * 
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document();

		// step 2:
		PdfWriter writer = PdfWriter.getInstance(document, PdfTestBase.getOutputStream("ChainedActions.pdf"));
		// step 3: we add Javascript as Metadata and we open the document
		document.open();
		// step 4: we add some content
		PdfAction action = PdfAction.javaScript("app.alert('Welcome at my site');\r", writer);
		action.next(new PdfAction("http://www.lowagie.com/iText/"));
		Paragraph p = new Paragraph(new Chunk("Click to go to Bruno's site").setAction(action));
		document.add(p);

		// step 5: we close the document
		document.close();

	}
}