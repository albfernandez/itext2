/*
 * $Id: Tiff2Pdf.java 3373 2008-05-12 16:21:24Z xlv $
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

package com.lowagie.examples.objects.images.tiff;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.RandomAccessFileOrArray;
import com.lowagie.text.pdf.codec.TiffImage;

/**
 * Demonstrates how the Tiff to PDF conversion works.
 * 
 * @author psoares
 * @author blowagie
 */

public class Tiff2PdfTest {

	@Test
	public void test() throws Exception {
		main(PdfTestBase.RESOURCES_DIR + "12.tif", PdfTestBase.RESOURCES_DIR + "338814-00.tif",
				PdfTestBase.RESOURCES_DIR + "odd.tif", PdfTestBase.RESOURCES_DIR + "even.tif");
	}

	/**
	 * Demonstrates some TIFF functionality.
	 * 
	 * @param args
	 *            a list of tiff files to convert
	 */
	public void main(String... args) throws Exception {
		if (args.length < 1) {
			System.err.println("Tiff2Pdf needs an argument.");
			System.out
					.println("Usage: com.lowagie.examples.objects.images.tiff.Tiff2Pdf file1.tif [file2.tif ... fileN.tif]");
			return;
		}
		File destDir = new File(PdfTestBase.OUTPUT_DIR);
		String tiff_file;
		String pdf_file;
		for (int i = 0; i < args.length; i++) {
			tiff_file = args[i];
			File tf = new File(tiff_file);
			pdf_file = tf.getName().substring(0, tf.getName().lastIndexOf('.') + 1) + "pdf";
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File(destDir, pdf_file)));
			document.open();
			PdfContentByte cb = writer.getDirectContent();
			RandomAccessFileOrArray ra = null;
			int comps = 0;

			ra = new RandomAccessFileOrArray(tiff_file);
			comps = TiffImage.getNumberOfPages(ra);

			for (int c = 0; c < comps; ++c) {

				Image img = TiffImage.getTiffImage(ra, c + 1);
				if (img != null) {
					if (img.getScaledWidth() > 500 || img.getScaledHeight() > 700) {
						img.scaleToFit(500, 700);
					}
					img.setAbsolutePosition(20, 20);
					document.add(new Paragraph(tiff_file + " - page " + (c + 1)));
					cb.addImage(img);
					document.newPage();
				}

			}
			ra.close();
			document.close();

		}
	}
}