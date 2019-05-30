package com.lowagie.text.pdf;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;


// not completed
// how to reproduce??
public class DuplicateRowOnPageSplitTest {
	
    public static final float ANCHO_TABLAS = 100f;
    
    public static final Font fuente0= FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.BLACK);
    public static final Font fuente1= FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, Color.BLACK);
    public static final Font fuente2= FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL, Color.BLACK);
    public static final Font fuente3= FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD, Color.BLACK);
    public static final Font fuente4= FontFactory.getFont(FontFactory.HELVETICA, 6, Font.NORMAL, Color.BLACK);
    public static final Font fuente5= FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD, Color.BLACK);
    public static final Font fuente6= FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLDITALIC, Color.BLACK);
    public static final Font fuente10= FontFactory.getFont(FontFactory.HELVETICA, 46, Font.BOLDITALIC, Color.BLACK);
	public DuplicateRowOnPageSplitTest() {
		super();
	}
	
	
	@Test
	public void test () throws Exception {
		File file = File.createTempFile("testfile", ".pdf");
		System.out.println(file.getAbsolutePath());
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		PdfPTable tabla_global = new PdfPTable(new float[]{1f});
        disableBorders(tabla_global.getDefaultCell());
        tabla_global.getDefaultCell().setPaddingTop(0);
        document.add( new Paragraph("abc"));
        Paragraph parrafo = new Paragraph("abccx");
        parrafo.setAlignment(Element.ALIGN_JUSTIFIED);
        tabla_global.addCell(parrafo);
        tabla_global.setSplitLate(true);
        
		PdfPTable psolicitud = new PdfPTable(new float[] { 1f });
		psolicitud.setSpacingBefore(170f);
		 psolicitud.setWidthPercentage(ANCHO_TABLAS);
	        psolicitud.setSplitLate(false);
	        Paragraph p = new Paragraph("Datos de la solicitud", fuente0);
	        p.setAlignment(Element.ALIGN_CENTER);
	        PdfPCell cell = new PdfPCell(p);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell.setColspan(1);
	        cell.setBackgroundColor(new Color(200, 200, 200));
	        psolicitud.addCell(cell);
	        
	        cell = new PdfPCell();
	        cell.setVerticalAlignment(Element.ALIGN_TOP);

	        PdfPTable tabla2 = new PdfPTable(new float[] { 2f, 1f });
	        tabla2.setWidthPercentage(100);
	        cell.addElement(tabla2);

	        psolicitud.addCell(cell);
	        for (int i = 1; i < 100; i++) {
	        	anadirTextoTabla(tabla2, Integer.toString(i), Integer.toString(i));
	        }
		
	        tabla_global.addCell(psolicitud);
	        parrafo = new Paragraph("");
	        parrafo.setAlignment(Element.ALIGN_JUSTIFIED);
	        tabla_global.addCell(parrafo);
	        document.add(tabla_global);
		document.close();
	}
	  private static void anadirTextoTabla(PdfPTable tabla, String titulo, String desc) {
	        PdfPCell cell = new PdfPCell();
	        disableBorders(cell);
	        
	        cell.setVerticalAlignment(Element.ALIGN_TOP);     
	        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	        cell.addElement(new Phrase(titulo,fuente10));
	        tabla.addCell(cell);       
	        
	        cell = new PdfPCell();
	        disableBorders(cell);
	       
	        cell.setVerticalAlignment(Element.ALIGN_TOP);
	        cell.addElement(new Phrase(defaultString(desc),fuente10));
	        tabla.addCell(cell);        
	    }
	  
		public static void disableBorders( Rectangle element ) {
			element.disableBorderSide( Rectangle.LEFT );
			element.disableBorderSide( Rectangle.RIGHT );
			element.disableBorderSide( Rectangle.TOP );
			element.disableBorderSide( Rectangle.BOTTOM );
		}

		public static void enableBorders( Rectangle element ) {
			element.enableBorderSide( Rectangle.LEFT );
			element.enableBorderSide( Rectangle.RIGHT );
			element.enableBorderSide( Rectangle.TOP );
			element.enableBorderSide( Rectangle.BOTTOM );
		}
		
		public static String defaultString(String orig) {
			if (orig!= null) {
				return orig;
			}
			return "";
		}
}
