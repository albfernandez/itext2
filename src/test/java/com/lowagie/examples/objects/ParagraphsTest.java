/*
 * $Id: Paragraphs.java 3373 2008-05-12 16:21:24Z xlv $
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

package com.lowagie.examples.objects;

import org.junit.Test;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Demonstrates some Paragraph functionality.
 * 
 * @author blowagie
 */

public class ParagraphsTest {

	/**
	 * Demonstrates some Paragraph functionality.
	 * 
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document();
		// step 2:
		// we create a writer that listens to the document
		PdfWriter.getInstance(document, PdfTestBase.getOutputStream("Paragraphs.pdf"));

		// step 3: we open the document
		document.open();
		// step 4:
		Paragraph p1 = new Paragraph(new Chunk("This is my first paragraph. ", FontFactory.getFont(
				FontFactory.HELVETICA, 10)));
		p1.add("The leading of this paragraph is calculated automagically. ");
		p1.add("The default leading is 1.5 times the fontsize. ");
		p1.add(new Chunk("You can add chunks "));
		p1.add(new Phrase("or you can add phrases. "));
		p1.add(new Phrase(
				"Unless you change the leading with the method setLeading, the leading doesn't change if you add text with another leading. This can lead to some problems.",
				FontFactory.getFont(FontFactory.HELVETICA, 18)));
		document.add(p1);
		Paragraph p2 = new Paragraph(new Phrase("This is my second paragraph. ", FontFactory.getFont(
				FontFactory.HELVETICA, 12)));
		p2.add("As you can see, it started on a new line.");
		document.add(p2);
		Paragraph p3 = new Paragraph("This is my third paragraph.", FontFactory.getFont(FontFactory.HELVETICA, 12));
		document.add(p3);

		// step 5: we close the document
		document.close();
	}
}