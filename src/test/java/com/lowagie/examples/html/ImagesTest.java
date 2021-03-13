/*
 * $Id: Images.java 3373 2008-05-12 16:21:24Z xlv $
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

import java.io.File;
import java.io.FileOutputStream;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.html.HtmlWriter;
import com.lowagie.text.pdf.PdfTestBase;

/**
 * General Images example.
 */
public class ImagesTest {

	/**
	 * General Images example that generates an HTML file with wrong paths to
	 * the images where the paths are right.
	 */

	@Test
	public void main() throws Exception {


		// step 1: creation of a document-object
		Document document = new Document();

		// step 2:
		// we create a writer that listens to the document
		// and directs a PDF-stream to a file
		File outputFile = new File (PdfTestBase.getOutputDir(), "images_wrong.html");
		HtmlWriter.getInstance(document, new FileOutputStream(outputFile));
		HtmlWriter writer = HtmlWriter.getInstance(document, PdfTestBase.getOutputStream("images_right.html"));
		writer.setImagepath("./");

		// step 3: we open the document
		document.open();

		// step 4:
		document.add(new Paragraph("A picture of my dog: otsoe.jpg"));
		Image jpg = Image.getInstance(PdfTestBase.RESOURCES_DIR + "otsoe.jpg");
		document.add(jpg);
		document.add(new Paragraph("getacro.gif"));
		Image gif = Image.getInstance(PdfTestBase.RESOURCES_DIR + "getacro.gif");
		document.add(gif);
		document.add(new Paragraph("pngnow.png"));
		Image png = Image.getInstance(PdfTestBase.RESOURCES_DIR + "pngnow.png");
		document.add(png);
		document.add(new Paragraph("iText.bmp"));
		Image bmp = Image.getInstance(PdfTestBase.RESOURCES_DIR + "iText.bmp");
		document.add(bmp);
		document.add(new Paragraph("iText.wmf"));
		Image wmf = Image.getInstance(PdfTestBase.RESOURCES_DIR + "iText.wmf");
		document.add(wmf);
		document.add(new Paragraph("iText.tif"));
		Image tiff = Image.getInstance(PdfTestBase.RESOURCES_DIR + "iText.tif");
		document.add(tiff);

		// step 5: we close the document
		document.close();
	}
}