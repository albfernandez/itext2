/*
 * $Id: FontEncoding.java 3373 2008-05-12 16:21:24Z xlv $
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
package com.lowagie.examples.fonts;

import org.junit.Test;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Specifying an encoding.
 */
public class FontEncodingTest {
    
    /**
     * Specifying an encoding.
     */
	@Test
    public void main() throws Exception {
        
        
        // step 1: creation of a document-object
        Document document = new Document();
        
            
            // step 2: creation of the writer
            PdfWriter.getInstance(document, PdfTestBase.getOutputStream("fontencoding.pdf"));
            
            // step 3: we open the document
            document.open();
            
            // step 4: we add content to the document
            BaseFont helvetica = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.EMBEDDED);
            Font font = new Font(helvetica, 12, Font.NORMAL);
            Chunk chunk = new Chunk("Sponsor this example and send me 1\u20ac. These are some special characters: \u0152\u0153\u0160\u0161\u0178\u017D\u0192\u02DC\u2020\u2021\u2030", font);
            document.add(chunk);
        
        // step 5: we close the document
        document.close();
    }
}