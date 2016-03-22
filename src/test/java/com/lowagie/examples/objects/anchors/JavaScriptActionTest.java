/*
 * $Id: JavaScriptAction.java 3373 2008-05-12 16:21:24Z xlv $
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
 * Creates a documents with a javascript action.
 * 
 * @author blowagie
 */

public class JavaScriptActionTest {

	/**
	 * Creates a document with a javascript action.
	 * 
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document();

		// step 2:
		PdfWriter writer = PdfWriter.getInstance(document, PdfTestBase.getOutputStream("JavaScriptAction.pdf"));
		// step 3: we add Javascript as Metadata and we open the document
		document.open();
		// step 4: we add some content
		Paragraph p = new Paragraph(new Chunk("Click to say Hello").setAction(PdfAction.javaScript(
				"app.alert('Hello');\r", writer)));
		document.add(p);

		// step 5: we close the document
		document.close();

	}
}