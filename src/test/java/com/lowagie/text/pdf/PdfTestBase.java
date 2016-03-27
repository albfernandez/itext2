package com.lowagie.text.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;

public class PdfTestBase {
	
	public static final String RESOURCES_DIR = "src/test/resources/";
	public static final String OUTPUT_DIR = "target/test-output-files/";
	
	public static File getOutputDir() {
		File outputDir = new File(OUTPUT_DIR);
		if (!outputDir.exists()) {
			outputDir.mkdirs();
		}
		return outputDir;
	}
	public static File getOutputFile(String name) {
		return new File(getOutputDir(), name);
	}
	public static OutputStream getOutputStream(String name) throws FileNotFoundException {
		return new FileOutputStream(getOutputFile(name));
	}
	
	public static void createOutputDir() {
		getOutputDir();
	}
	public static Document createPdf(String filename)
			throws FileNotFoundException, DocumentException {
		
		return createPdf(new FileOutputStream(getOutputFile(filename)));

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
