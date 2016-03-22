/*
 * $Id: OpenTypeFont.java 3373 2008-05-12 16:21:24Z xlv $
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
package com.lowagie.examples.fonts.getting;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Using an Open Type Font (CFF only).
 */
public class OpenTypeFontTest {
	/**
	 * Using oth
	 */
	@Test
	public void main() throws Exception {
		// step 1
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		// step 2
		PdfWriter.getInstance(document,
				PdfTestBase.getOutputStream("opentypefont.pdf"));
		// step 3
		document.open();
		// step 4
		BaseFont bf = BaseFont.createFont(PdfTestBase.RESOURCES_DIR
				+ "liz.otf", BaseFont.CP1252, true);
		String text = "Some text with the otf font LIZ.";
		document.add(new Paragraph(text, new Font(bf, 14)));
		// step 5
		document.close();
	}
}
