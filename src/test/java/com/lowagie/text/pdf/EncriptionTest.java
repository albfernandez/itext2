package com.lowagie.text.pdf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.exceptions.BadPasswordException;

public class EncriptionTest {

	
	
	private byte[] createEncryptedPDF () throws DocumentException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		Rectangle rec = new Rectangle(PageSize.A4.getWidth(),
				PageSize.A4.getHeight());
		Document document = new Document(rec);		
		PdfWriter writer = PdfWriter.getInstance(document, baos);
		writer.setEncryption("Hello".getBytes(), "World".getBytes(), PdfWriter.ALLOW_COPY | PdfWriter.ALLOW_PRINTING, PdfWriter.STANDARD_ENCRYPTION_128);
		document.open();
		document.add(new Paragraph("Hello World"));
		document.close();
				
		return baos.toByteArray();
	}
	
	@Test
	public void testEncrypt () throws DocumentException {
		byte[] data = createEncryptedPDF();
		Assert.assertNotNull(data);
		Assert.assertTrue(data.length > 0);
	}
	
	@Test
	public void testEncryptDecryptWithOwnerPassword() throws DocumentException, IOException {
		byte[] crypted = createEncryptedPDF();
		
		PdfReader reader = new PdfReader(crypted, "World".getBytes());
		Assert.assertEquals(1, reader.getNumberOfPages());
		reader.close();
	}
	
	@Test
	public void testEncryptDecryptWithUserPassword() throws DocumentException, IOException {
		byte[] crypted = createEncryptedPDF();
		
		PdfReader reader = new PdfReader(crypted, "Hello".getBytes());
		Assert.assertEquals(1, reader.getNumberOfPages());
		reader.close();
	}
	
	
	@Test(expected=BadPasswordException.class)
	public void testDecyptNoPassword() throws DocumentException, IOException {
		byte[] crypted = createEncryptedPDF();
		// NO password supplied, will throw BaddPasswordException
		PdfReader reader = new PdfReader(crypted);
		Assert.assertEquals(1, reader.getNumberOfPages());
		reader.close();
		
	}
	
	@Test(expected=BadPasswordException.class)
	public void testDecyptBadPassword() throws DocumentException, IOException {
		byte[] crypted = createEncryptedPDF();
		// NO password supplied, will throw BaddPasswordException
		PdfReader reader = new PdfReader(crypted, "badpassword".getBytes());
		Assert.assertEquals(1, reader.getNumberOfPages());
		reader.close();
		
	}
}
