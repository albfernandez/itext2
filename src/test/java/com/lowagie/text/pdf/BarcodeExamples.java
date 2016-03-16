package com.lowagie.text.pdf;


import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;

public class BarcodeExamples {

	
	@Test
	public void testCode128 () throws FileNotFoundException, DocumentException {
		
		File outputFile = PdfTestBase.getOutputFile("barcode-ean128.pdf");
		
		FileOutputStream fos = new FileOutputStream(outputFile);
		Rectangle rec = new Rectangle(PageSize.A4.getWidth(),
				PageSize.A4.getHeight());
		Document document = new Document(rec);
		PdfWriter writer = PdfWriter.getInstance(document, fos);
		document.open();
		Barcode128 barCode = new Barcode128();
        barCode.setX(0.75f);
        barCode.setN(1.5f);
        barCode.setChecksumText(true);
        barCode.setGenerateChecksum(true);
        barCode.setSize(10f);
        barCode.setTextAlignment(Element.ALIGN_CENTER);
        barCode.setBaseline(10f);
        barCode.setCode("1111223344444");
        barCode.setBarHeight(25f);
        barCode.setFont(null);
        
        Image image = barCode.createImageWithBarcode(writer.getDirectContent(), Color.BLACK, Color.WHITE);
        document.add(image);
        
        
        document.close();
        
	}
}
