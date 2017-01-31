package com.lowagie.examples.forms;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;

public class CreatePdfFromAcroFormTemplate {

	public CreatePdfFromAcroFormTemplate() {
		super();
	}

	@Test
	public void test1() throws Exception {
		InputStream templateInputStream = null;

		try {
			templateInputStream = this.getClass().getClassLoader().getResourceAsStream("template-acroforms.pdf");
			String fieldName = "MarcaDeAgua_Texto";
			String watermarkText = "Hello World watermark-concatenate";
			byte[] template = createTemplateWithWatermark(watermarkText, templateInputStream, fieldName);
			
			File origin = new File("src/test/resources/Concatenate.pdf");
			File destination = PdfTestBase.getOutputFile("Concatenate-acroforms-watermark.pdf");
			joinWatermarkToDocument(template, origin, destination);

		} finally {
			if (templateInputStream != null) {
				templateInputStream.close();
			}
		}
	}

	public static byte[] createTemplateWithWatermark(String watermarkText, InputStream template, String fieldName)
			throws Exception {

		Document document = null;
		PdfReader reader = null;
		PdfStamper stamper = null;
		ByteArrayOutputStream output = null;
		PdfWriter writer = null;
		try {
			document = new Document(PageSize.A4);
			document.setMargins(0.0F, 0.0F, 0.0F, 0.0F);
			output = new ByteArrayOutputStream();
			writer = PdfWriter.getInstance(document, output);
			reader = new PdfReader(template);
			stamper = new PdfStamper(reader, output);
			AcroFields form = stamper.getAcroFields();
			form = stamper.getAcroFields();
			document.open();

			form.setField(fieldName, watermarkText);

			stamper.setFormFlattening(true);
			stamper.close();
			reader = new PdfReader(output.toByteArray());

			PdfImportedPage page = writer.getImportedPage(reader, 1);
			Image image = Image.getInstance(page);

			document.add(image);

		} finally {
			if (reader != null) {
				reader.close();
			}
			if (stamper != null) {
				stamper.close();
			}
			if (writer != null) {
				writer.close();
			}
			if (output != null) {
				output.close();
			}
			if (document != null && document.isOpen()) {
				document.close();
			}
		}

		return output.toByteArray();
	}

	public static void joinWatermarkToDocument(byte[] template, File originalFile, File destinationFile) throws Exception {

		Document document = null;
		PdfReader templateReader = null;
		PdfReader contentReader = null;
		PdfStamper stamper = null;
		OutputStream outputFinal = null;
		InputStream inputStream = null;
		float initialScale = 86.2f;
		float scale = initialScale;

		try {
			document = new Document(PageSize.A4);
			document.setMargins(0.0F, 0.0F, 0.0F, 0.0F);

			outputFinal = new FileOutputStream(destinationFile);
			PdfWriter writer = PdfWriter.getInstance(document, outputFinal);

			document.open();

			templateReader = new PdfReader(template);

			inputStream = new FileInputStream(originalFile);

			ByteArrayOutputStream outputFlattened = new ByteArrayOutputStream();
			try {
				contentReader = new PdfReader(inputStream);
				stamper = new PdfStamper(contentReader, outputFlattened);
				stamper.setFormFlattening(true);
				stamper.close();
				stamper = null;
				contentReader.close();
				contentReader = new PdfReader(outputFlattened.toByteArray());
			} catch (Exception e) {
				throw e;
			}

			
			

			PdfImportedPage page = writer.getImportedPage(templateReader, 1);
			Image watermarkImage = Image.getInstance(page);
			watermarkImage.setAlignment(9);

			for (int i = 1; i <= contentReader.getNumberOfPages(); i++) {

				document.add(watermarkImage);

				int incomingPageRotation = contentReader.getPageRotation(i);
				int rotationToAply = 0;
				if (incomingPageRotation != 0) {
					if (incomingPageRotation == 90) {
						rotationToAply = 270;
					}
					if (incomingPageRotation == 180) {
						rotationToAply = 180;
					}
					if (incomingPageRotation == 270) {
						rotationToAply = 90;
					}
				}

				PdfImportedPage importedPage = writer.getImportedPage(contentReader, i);

				float pageHeight = importedPage.getHeight();
				float pageWidth = importedPage.getWidth();

				Image image = Image.getInstance(importedPage);

				scale = initialScale;

				if (pageHeight > PageSize.A4.getHeight() && pageWidth > PageSize.A4.getWidth()) {
					float porcentajeAuxHe = PageSize.A4.getWidth() * 100.0F / pageWidth;
					float porcentajeAuxWi = PageSize.A4.getHeight() * scale / pageHeight;

					if (porcentajeAuxHe > porcentajeAuxWi) {
						scale = porcentajeAuxWi;
					} else {
						scale = porcentajeAuxHe;
					}
				} else if (pageWidth == PageSize.A4.getHeight() && pageHeight == PageSize.A4.getWidth()) {
					
				} else if (pageWidth > PageSize.A4.getWidth() && pageHeight < PageSize.A4.getHeight()) {
					float tmpScale = PageSize.A4.getWidth() * 100.0F / pageWidth;
					if (scale > tmpScale) {
						scale = tmpScale;
					}
				} else if (pageHeight > PageSize.A4.getHeight() && pageWidth < PageSize.A4.getWidth()) {
					float porcentajeAux = PageSize.A4.getHeight() * scale / pageHeight;
					if (scale > porcentajeAux) {
						scale = porcentajeAux;
					}
				}

				if (pageWidth > pageHeight && rotationToAply == 0) {

					importedPage.setHeight(PageSize.A4.getHeight());
					importedPage.setWidth(PageSize.A4.getWidth());

					image.setRotation(-1.5707964F);

					importedPage.setHeight(pageHeight);
					importedPage.setWidth(pageWidth);
				} else if (pageWidth > pageHeight && rotationToAply != 0) {
					if (rotationToAply == 90) {
						image.setRotation(1.5707964F);
					} else if (rotationToAply == 180) {
						image.setRotation(3.1415927F);
					} else if (rotationToAply == 270) {
						image.setRotation(4.712389F);
					}
				}

				image.scalePercent(scale);
				image.setAlignment(1);
				document.add(image);
			}

		}  finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				if (contentReader != null) {
					contentReader.close();
				}
				if (templateReader != null) {
					templateReader.close();
				}
				if (document != null && document.isOpen()){
					document.close();
				}
				if (outputFinal != null) {
					outputFinal.flush();
					outputFinal.close();
				}

				originalFile = null;
			} catch (Exception e) {
				// ignore
			}
		}

	}

}
