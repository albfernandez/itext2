package com.lowagie.text.pdf;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import org.junit.Test;

public class UnicodePdfTest {

	private static final String INPUT = "Symbol: '\u25b2' Latin: 'äöüÄÖÜß'";

	public UnicodePdfTest() {
		super();
	}

	@Test
	public void testSimplePdf() throws FileNotFoundException, DocumentException {

		BaseFont font = null;
		try {
			font = BaseFont.createFont("LiberationSerif-Regular.ttf", BaseFont.IDENTITY_H, false);
		}
		catch (IOException ioe) {
			// nop
		}
		Document document = null;
		try {
			document = PdfTestBase.createPdf("unicode.pdf");
			// new page with a rectangle
			document.open();			
			Element unicodeParagraph = new Paragraph(INPUT, new Font(font, 12));
			document.add(unicodeParagraph);
		} 
		finally {
			// close document
			if (document != null)
				document.close();
		}
	}

}
