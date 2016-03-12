package com.lowagie.text.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.RunAllExamplesTest;

public class PdfTestBase {

	
	public static void createOutputDir() {
		RunAllExamplesTest.createOutputDir();
	}
	public static Document createPdf(String filename)
			throws FileNotFoundException, DocumentException {
		createOutputDir();
		return createPdf(new FileOutputStream(new File(RunAllExamplesTest.OUTPUT_DIR + filename)));

	}
	
	public static Document createPdf(OutputStream out) throws DocumentException {
		// create a new document
		Rectangle rec = new Rectangle(PageSize.A4.getWidth(),
				PageSize.A4.getHeight());
		Document document = new Document(rec);

		// create a new file
		

		// generate file
		PdfWriter.getInstance(document, out);
		return document;
	}

}
