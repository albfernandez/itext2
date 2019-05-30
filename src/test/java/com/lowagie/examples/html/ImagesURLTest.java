/*
 * $Id: ImagesURL.java 3998 2009-06-28 13:22:47Z blowagie $
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
import java.net.URL;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.html.HtmlWriter;
import com.lowagie.text.pdf.PdfTestBase;

/**
 * Images example that uses the complete URL of the Image.
 */
public class ImagesURLTest {

	/**
	 * Images example with a complete path to the images.
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document();

		// step 2:
		// we create a writer that listens to the document
		// and directs a PDF-stream to a file
		HtmlWriter.getInstance(document, PdfTestBase.getOutputStream("images.html"));

		// step 3: we open the document
		document.open();

		File current = new File(".");
		File resources = new File(current, PdfTestBase.RESOURCES_DIR);

		// step 4:
		document.add(new Paragraph("A picture of my dog: otsoe.jpg"));
		File otsoe = new File(resources, "otsoe.jpg");
		Image jpg = Image.getInstance(new URL("file:///" + otsoe.getAbsolutePath()));
		document.add(jpg);

		document.add(new Paragraph("getacro.gif"));
		File getacro = new File(resources, "getacro.gif");
		Image gif = Image.getInstance(new URL("file:///" + getacro.getAbsolutePath()));
		document.add(gif);

		document.add(new Paragraph("pngnow.png"));
		File pngNow = new File(resources, "pngnow.png");
		Image png = Image.getInstance(new URL("file:///" + pngNow.getAbsolutePath()));
		document.add(png);

		document.add(new Paragraph("iText.bmp"));
		File itextBmp = new File(resources, "iText.bmp");
		Image bmp = Image.getInstance(new URL("file:///" + itextBmp.getAbsolutePath()));
		document.add(bmp);

		document.add(new Paragraph("iText.wmf"));
		File itextWmf = new File(resources, "iText.wmf");
		Image wmf = Image.getInstance(new URL("file:///" + itextWmf.getAbsolutePath()));
		document.add(wmf);

		document.add(new Paragraph("iText.tif"));
		File itextTif = new File(resources, "iText.tif");
		Image tiff = Image.getInstance(new URL("file:///" + itextTif.getAbsolutePath()));
		document.add(tiff);

		// step 5: we close the document
		document.close();
	}
}