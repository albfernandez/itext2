/*
 * $Id: Register.java 3373 2008-05-12 16:21:24Z xlv $
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
package com.lowagie.examples.general.copystamp;

import org.junit.Test;

import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfTestBase;

/**
 * Fill in a simple registration form.
 */
public class RegisterTest {
	/**
	 * Reads a form and fills in the fields.
	 */
	@Test
	public void main() throws Exception {
		// we create a reader for a certain document
		PdfReader reader = new PdfReader(PdfTestBase.RESOURCES_DIR + "SimpleRegistrationForm.pdf");
		// filling in the form
		PdfStamper stamp1 = new PdfStamper(reader, PdfTestBase.getOutputStream( "registered.pdf"));
		AcroFields form1 = stamp1.getAcroFields();
		form1.setField("name", "Bruno Lowagie");
		form1.setField("address", "Baeyensstraat 121, Sint-Amandsberg");
		form1.setField("postal_code", "BE-9040");
		form1.setField("email", "bruno@lowagie.com");
		stamp1.close();
		// filling in the form and flatten
		reader = new PdfReader(PdfTestBase.RESOURCES_DIR + "SimpleRegistrationForm.pdf");
		PdfStamper stamp2 = new PdfStamper(reader, PdfTestBase.getOutputStream( "registered_flat.pdf"));
		AcroFields form2 = stamp2.getAcroFields();
		form2.setField("name", "Bruno Lowagie");
		form2.setField("address", "Baeyensstraat 121, Sint-Amandsberg");
		form2.setField("postal_code", "BE-9040");
		form2.setField("email", "bruno@lowagie.com");
		stamp2.setFormFlattening(true);
		stamp2.close();

	}
}
