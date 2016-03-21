/*
 * $Id: StudentCardForm.java 3373 2008-05-12 16:21:24Z xlv $
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

package com.lowagie.examples.forms.create;

import java.awt.Color;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfFormField;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPCellEvent;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTestBase;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.TextField;

/**
 * Generates a StudentCard as a form
 * 
 * @author blowagie
 */
public class StudentCardFormTest implements PdfPCellEvent {

	/** the writer with the acroform */
	private PdfFormField field;

	/**
	 * Construct an implementation of PdfPCellEvent.
	 * 
	 * @param field
	 *            a form field
	 * 
	 */
	public StudentCardFormTest() {
		super();
	}

	/**
	 * @see com.lowagie.text.pdf.PdfPCellEvent#cellLayout(com.lowagie.text.pdf.PdfPCell,
	 *      com.lowagie.text.Rectangle, com.lowagie.text.pdf.PdfContentByte[])
	 */
	public void cellLayout(PdfPCell cell, Rectangle position, PdfContentByte[] canvases) {
		field.setWidget(position, null);
	}

	/**
	 * Generates a StudentCard as a form
	 */
	@Test
	public void main() throws Exception {

		// step 1: creation of a document-object
		Rectangle rect = new Rectangle(243, 153);
		rect.setBackgroundColor(new Color(0xFF, 0xFF, 0xCC));
		Document document = new Document(rect, 10, 10, 10, 10);

		// step 2:
		PdfWriter writer = PdfWriter.getInstance(document, PdfTestBase.getOutputStream("studentcardform.pdf"));

		// step 3: we open the document
		document.open();

		// step 4:
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, Color.BLUE);
		Paragraph p = new Paragraph("Ghent University", font);
		p.setAlignment(Element.ALIGN_CENTER);
		document.add(p);
		Font f = FontFactory.getFont(FontFactory.HELVETICA, 8);
		PdfPTable outertable = new PdfPTable(3);
		outertable.setTotalWidth(200);
		outertable.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		float[] outer = { 60, 25, 15 };
		outertable.setWidths(outer);
		PdfPTable innertable = new PdfPTable(2);
		float[] inner = { 35, 65 };
		innertable.setWidths(inner);
		PdfPCell cell;
		TextField text;
		innertable.addCell(new Paragraph("name:", f));
		cell = new PdfPCell();
		text = new TextField(writer, new Rectangle(0, 0), "name");
		text.setOptions(TextField.MULTILINE);
		text.setFontSize(8);
		PdfFormField name = text.getTextField();
		cell.setCellEvent(createForm(name));
		innertable.addCell(cell);
		innertable.addCell(new Paragraph("date of birth:", f));
		cell = new PdfPCell();
		text = new TextField(writer, new Rectangle(0, 0), "birthday");
		text.setOptions(TextField.MULTILINE);
		text.setFontSize(8);
		PdfFormField birthdate = text.getTextField();
		cell.setCellEvent(createForm(birthdate));
		innertable.addCell(cell);
		innertable.addCell(new Paragraph("Study Program:", f));
		cell = new PdfPCell();
		text = new TextField(writer, new Rectangle(0, 0), "studyprogram");
		text.setOptions(TextField.MULTILINE);
		text.setFontSize(8);
		PdfFormField studyprogram = text.getTextField();
		studyprogram.setFieldName("studyprogram");
		cell.setCellEvent(createForm(studyprogram));
		innertable.addCell(cell);
		innertable.addCell(new Paragraph("option:", f));
		cell = new PdfPCell();
		text = new TextField(writer, new Rectangle(0, 0), "option");
		text.setOptions(TextField.MULTILINE);
		text.setFontSize(8);
		PdfFormField option = text.getTextField();
		option.setFieldName("option");
		cell.setCellEvent(createForm(option));
		innertable.addCell(cell);
		outertable.addCell(innertable);
		cell = new PdfPCell();
		cell.setBackgroundColor(new Color(0xFF, 0xDE, 0xAD));
		PdfFormField picture = PdfFormField.createPushButton(writer);
		picture.setFieldName("picture");
		cell.setCellEvent(createForm(picture));
		outertable.addCell(cell);
		cell = new PdfPCell();
		cell.setBackgroundColor(Color.WHITE);
		PdfFormField barcode = PdfFormField.createPushButton(writer);
		barcode.setFieldName("barcode");
		cell.setCellEvent(createForm(barcode));
		outertable.addCell(cell);
		outertable.writeSelectedRows(0, -1, 20, 100, writer.getDirectContent());
		writer.addAnnotation(name);
		writer.addAnnotation(birthdate);
		writer.addAnnotation(studyprogram);
		writer.addAnnotation(option);
		writer.addAnnotation(picture);
		writer.addAnnotation(barcode);

		// step 5: we close the document
		document.close();
	}
	private static StudentCardFormTest createForm (PdfFormField field) {
		StudentCardFormTest form = new StudentCardFormTest();
		form.field = field;
		return form;
	}
}