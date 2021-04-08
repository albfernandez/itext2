package com.lowagie.text.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;

public class WritePdfTest {
	private static final int PAGE_NUMBER_FONT_SIZE = 12;
    private static final int PAGE_NUMBER_HEIGHT = 20;
    private static final int PAGE_NUMBER_WIDTH = 30;
    
    public WritePdfTest() {
    	super();
    }
    
    @Test
    public void writeSimpeFile () throws IOException, DocumentException {
    	File file = PdfTestBase.getOutputFile("testfileVersion.pdf");
    	Document document = new Document();
    	PdfWriter.getInstance(document, new FileOutputStream(file));
    	document.open();
    	document.add(new Paragraph(Document.getProduct()));
    	document.add(new Paragraph(Document.getVersion()));
    	document.add(new Paragraph(Document.getRelease()));
    	document.close();
    }

	@Test
	public void writeFile() throws IOException, DocumentException {
		File file = PdfTestBase.getOutputFile("testfile01.pdf");
		File fileWithPageNumbers = PdfTestBase.getOutputFile("testfile01withpagenumbers.pdf");
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		for(int i = 0; i < 100; i++) {
			document.add(new Paragraph("Test"));
		}
		document.close();
		addPageNumbers(file, fileWithPageNumbers.getAbsolutePath());
		Assert.assertTrue(file.length() > 0);
		Assert.assertTrue(fileWithPageNumbers.length() > 0);
	}
	
	private void addPageNumbers(File file, String fileName) throws IOException, DocumentException {
            PdfReader reader = new PdfReader(file.getAbsolutePath());
            int n = reader.getNumberOfPages();
            PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(fileName));
            int i = 0;
            PdfContentByte over;
            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI,
                    BaseFont.EMBEDDED);
            float width = reader.getPageSize(1).getWidth();
            while (i < n) {
                i++;
                over = stamp.getOverContent(i);
                over.beginText();
                over.setFontAndSize(bf, PAGE_NUMBER_FONT_SIZE);
                over.setTextMatrix((width / 2) - (PAGE_NUMBER_WIDTH / 2), PAGE_NUMBER_HEIGHT);
                over.showText(i + "/" + n);
                over.endText();
            }
            stamp.close();

    }
}
