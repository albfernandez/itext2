/*
 * $Id: FdfExample.java 3373 2008-05-12 16:21:24Z xlv $
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
package com.lowagie.examples.forms.fill;

import java.io.FileOutputStream;

import org.junit.Test;

import com.lowagie.text.RunAllExamplesTest;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.FdfReader;
import com.lowagie.text.pdf.FdfWriter;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfTestBase;

/**
 * How to create an FDF file. How to merge an FDF file with a PDF form.
 */
public class FdfExampleTest {
	/**
	 * Writes an FDF file and merges it with a PDF form.
	 */
	@Test
	public void main() throws Exception {

		// writing the FDF file
		FdfWriter fdf = new FdfWriter();
		fdf.setFieldAsString("name", "Bruno Lowagie");
		fdf.setFieldAsString("address", "Baeyensstraat 121, Sint-Amandsberg");
		fdf.setFieldAsString("postal_code", "BE-9040");
		fdf.setFieldAsString("email", "bruno@lowagie.com");
		fdf.setFile(RunAllExamplesTest.RESOURCES_DIR + "SimpleRegistrationForm.pdf");
		fdf.writeTo(PdfTestBase.getOutputStream("SimpleRegistrationForm.fdf"));

		// merging the FDF file
		PdfReader pdfreader = new PdfReader(RunAllExamplesTest.RESOURCES_DIR + "SimpleRegistrationForm.pdf");
		PdfStamper stamp = new PdfStamper(pdfreader, new FileOutputStream(RunAllExamplesTest.OUTPUT_DIR
				+ "registered_fdf.pdf"));
		FdfReader fdfreader = new FdfReader(RunAllExamplesTest.OUTPUT_DIR + "SimpleRegistrationForm.fdf");
		AcroFields form = stamp.getAcroFields();
		form.setFields(fdfreader);
		stamp.close();

	}
}
