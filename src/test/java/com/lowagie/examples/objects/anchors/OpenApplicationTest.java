/*
 * $Id: OpenApplication.java 3373 2008-05-12 16:21:24Z xlv $
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

import java.io.File;

import org.junit.Test;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Creates a documents with different named actions.
 * 
 * @author blowagie
 */

public class OpenApplicationTest {

	@Test
	public void test() throws Exception {
		// In linux (evince) can open files but not executables by default
		main(new File("LICENSE").getAbsolutePath());
	}

	/**
	 * Creates a document with Named Actions.
	 * 
	 * @param args The file to open
	 */
	public void main(String... args) throws Exception {

		// step 1: creation of a document-object
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);

		// step 2: we create a writer that listens to the document
		PdfWriter.getInstance(document, PdfTestBase.getOutputStream("OpenApplication.pdf"));
		// step 3: we open the document
		document.open();
		// step 4: we add some content
		String application = args[0];
		Paragraph p = new Paragraph(new Chunk("Click to open " + application).setAction(
				new PdfAction(application, null, null, null)));
		document.add(p);

		// step 5: we close the document
		document.close();

	}
}