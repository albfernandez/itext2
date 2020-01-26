package com.lowagie.text.pdf;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Security;
import java.util.ArrayList;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;

public class AcroFieldsTest {
    
	@Before
	public void createOpututDir() {
		PdfTestBase.createOutputDir();
	}
    @Test
    public void testSetFields() throws Exception {
        singleTest(PdfTestBase.RESOURCES_DIR +"register.xfdf");
    }

    @Test
    public void testListInSetFields() throws Exception {
        singleTest(PdfTestBase.RESOURCES_DIR +"list_register.xfdf");
    }
    
    private void singleTest(String xfdfFileName) throws Exception {
        // merging the FDF file
        PdfReader pdfreader = new PdfReader(PdfTestBase.RESOURCES_DIR +"SimpleRegistrationForm.pdf");
        PdfStamper stamp = new PdfStamper(pdfreader, new ByteArrayOutputStream());
        XfdfReader fdfreader = new XfdfReader(xfdfFileName);
        AcroFields form = stamp.getAcroFields();
        form.setFields(fdfreader);
        stamp.close();
    }
    

    /**
     * This test fails, because signatureCoversWholeDocument does only check the
     * last signed block.
     */
    @Test
	public void testGetSignatures() throws Exception {
		// for algorithm SHA256 (without dash)
		Security.addProvider(new BouncyCastleProvider());
		InputStream moddedFile = AcroFieldsTest.class.getResourceAsStream("/siwa.pdf");
		PdfReader reader = new PdfReader(moddedFile);
		Document document = new Document(PageSize.A4);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PdfWriter writer = PdfWriter.getInstance(document, out);

		AcroFields fields = new AcroFields(reader, writer);
		@SuppressWarnings("unchecked")
		ArrayList<String> names = fields.getSignatureNames();
		Assert.assertEquals(1, names.size());

		for (String signName : names) {
			Assert.assertFalse(fields.signatureCoversWholeDocument(signName));
			PdfPKCS7 pdfPkcs7 = fields.verifySignature(signName, "BC");
			Assert.assertTrue(pdfPkcs7.verify());
		}

	}
    
    @Test(timeout = 1000)
	public void infiniteLoopTest() throws Exception {
		try (InputStream is = new FileInputStream("src/test/resources/pades_infinite_loop.pdf")) {
			PdfReader reader = new PdfReader(is);
			reader.getAcroFields();
			reader.close();
		}
	}

}
