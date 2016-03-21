/*
 * $Id: HelloHtml.java 3373 2008-05-12 16:21:24Z xlv $
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

package com.lowagie.examples.html;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.html.HtmlWriter;
import com.lowagie.text.pdf.PdfTestBase;

/**
 * Generates a simple 'Hello World' HTML page.
 * 
 * @author blowagie
 */

public class HelloHtmlTest {

	/**
	 * Generates an HTML page with the text 'Hello World'
	 * 
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document();
		// step 2:
		// we create a writer that listens to the document
		// and directs a HTML-stream to a file
		HtmlWriter.getInstance(document, PdfTestBase.getOutputStream("HelloWorld.html"));

		// step 3: we open the document
		document.open();
		// step 4: we add a paragraph to the document
		document.add(new Paragraph("Hello World"));

		// step 5: we close the document
		document.close();
	}
}