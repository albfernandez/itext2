/*
 * $Id: RawData.java 3373 2008-05-12 16:21:24Z xlv $
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
package com.lowagie.examples.objects.images;

import java.io.RandomAccessFile;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Using raw data to construct an Image object.
 */
public class RawDataTest {
	/**
	 * Raw data.
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document();

		// step 2:
		// we create a writer that listens to the document
		// and directs a PDF-stream to a file

		PdfWriter.getInstance(document, PdfTestBase.getOutputStream("rawdata.pdf"));

		// step 3: we open the document
		document.open();

		// step 4: we add content (example by Paulo Soares)

		// creation a jpeg passed as an array of bytes to the Image
		RandomAccessFile rf = new RandomAccessFile(PdfTestBase.RESOURCES_DIR + "otsoe.jpg", "r");
		int size = (int) rf.length();
		byte imext[] = new byte[size];
		rf.readFully(imext);
		rf.close();
		Image img1 = Image.getInstance(imext);
		img1.setAbsolutePosition(50, 500);
		document.add(img1);

		// creation of an image of 100 x 100 pixels (x 3 bytes for the Red,
		// Green and Blue value)
		byte data[] = new byte[100 * 100 * 3];
		for (int k = 0; k < 100; ++k) {
			for (int j = 0; j < 300; j += 3) {
				data[k * 300 + j] = (byte) (255 * Math.sin(j * .5 * Math.PI / 300));
				data[k * 300 + j + 1] = (byte) (256 - j * 256 / 300);
				data[k * 300 + j + 2] = (byte) (255 * Math.cos(k * .5 * Math.PI / 100));
			}
		}
		Image img2 = Image.getInstance(100, 100, 3, 8, data);
		img2.setAbsolutePosition(200, 200);
		document.add(img2);

		// step 5: we close the document
		document.close();
	}

}
