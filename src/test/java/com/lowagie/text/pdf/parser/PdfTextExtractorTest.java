package com.lowagie.text.pdf.parser;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;


public class PdfTextExtractorTest {

	
	@Test(expected=IOException.class)
	public void testPageExceeded() throws Exception {
		getString("HelloWorldMeta.pdf", 5);
	}
	@Test(expected=IOException.class)
	public void testInvalidPageNumber() throws Exception {
		getString("HelloWorldMeta.pdf", 0);
	}
	
	@Test
	public void testHelloWorld() throws Exception {
		String result = getString("HelloWorldMeta.pdf", 1);
		Assert.assertEquals("Hello World", result);

	}
	
	@Test
	public void testConcatenate() throws Exception {
		String result = getString("Concatenate.pdf", 5);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.contains("2. This is chapter 2"));
	}
	
	@Test
	public void testConcatenateWatermark() throws Exception {
		String result = getString("Concatenate-acroforms-watermark.pdf", 5);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.contains("2. This is chapter 2"));
		Assert.assertTrue(result.contains("Hello World watermark-concatenate"));
	}
	
	@Test
	public void test1() throws Exception {		
		String result = getString("yaxiststar.pdf", 9);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.contains("Remember to CATCH IT, BIN IT, KILL IT."));		
	}
	
	@Test
	public void testExtractFromEmptyPage() throws Exception {
		String fileName = "example-empty-page.pdf";
		String result1 = getString(fileName, 1);
		Assert.assertEquals("Example 1 \n   ", result1);
		String result2 = getString(fileName, 2);
		Assert.assertEquals("   ", result2);
		String result3 = getString(fileName, 3);
		Assert.assertEquals("Example 3 ", result3);
	}
	
	@Test
	public void testExtractFromEmptyPage2() throws Exception {
		Document document = new Document();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, baos);
		document.open();
		
		document.add(new Paragraph("Example 1"));
		document.newPage();
		document.add(new Paragraph(" "));
		document.newPage();
		document.add(new Paragraph("Example 3"));
		document.close();
		
		byte[] data = baos.toByteArray();
		String result1 = getString(data, 1);
		Assert.assertEquals("Example 1", result1);
		String result2 = getString(data, 2);
		Assert.assertEquals(" ", result2);
		String result3 = getString(data, 3);
		Assert.assertEquals("Example 3", result3);
	}
	
	private String getString(String fileName, int pageNumber) throws Exception {
		return getString(new File("src/test/resources", fileName), pageNumber);
	}
	private String getString(File file, int pageNumber) throws Exception {
		byte[] pdfBytes = readDocument(file);				
		return getString(pdfBytes, pageNumber);
	}
	private String getString(byte[] pdfBytes, int pageNumber) throws Exception {
		final PdfReader pdfReader = new PdfReader(pdfBytes);		
		return new PdfTextExtractor(pdfReader).getTextFromPage( pageNumber);
	}
	
	protected static byte[] readDocument(final File file) throws IOException {
		ByteArrayOutputStream fileBytes = null;
		InputStream inputStream = null;
		try  {
			fileBytes = new ByteArrayOutputStream();
			inputStream = new FileInputStream(file);
			final byte[] buffer = new byte[8192];
			while (true) {
				final int bytesRead = inputStream.read(buffer);
				if (bytesRead == -1) {
					break;
				}
				fileBytes.write(buffer, 0, bytesRead);
			}
			return fileBytes.toByteArray();
		}
		finally {
			if (fileBytes != null ) {
				fileBytes.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}

	}
}
