package com.lowagie.text;

import static org.junit.Assert.fail;

import java.io.File;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class RunAllExamplesTest {
	
	public static final String OUTPUT_DIR = "target/test-output-files/";
	public static final String RESOURCES_DIR = "src/test/resources/";

    public static void main(String args[]) throws Exception {
        RunAllExamplesTest r = new RunAllExamplesTest();
        r.testImageExamples();

        r.testBookmarkExamples();
        r.testMiscExamples();
        r.testTableExamples();
        r.testAnchorExamples();
        r.testColumnExamples();
        r.testChunkExamples();
    }

    public void runSingleTest(Class<?> c, String... args) {
        try {
            Method m = c.getMethod("main", String[].class);
            m.invoke(null, new Object[] {args});
        } catch (Exception e) {
            e.printStackTrace();
            fail("Test " + c.getName() + " failed: " + e.getCause());
        }
    }
    @Before
    public void before() {
    	createOutputDir();
    }

	public static void createOutputDir() {
		File dest = new File(OUTPUT_DIR);
    	if (!dest.exists()) {
    		dest.mkdirs();
    	}
	}




    @Test
    public void testBookmarkExamples() {
        runSingleTest(com.lowagie.examples.objects.bookmarks.ViewerPreferences.class);
        runSingleTest(com.lowagie.examples.objects.bookmarks.PageLabels.class);
        runSingleTest(com.lowagie.examples.objects.bookmarks.ChapterSection.class);
        runSingleTest(com.lowagie.examples.objects.bookmarks.OutlineActions.class);
        runSingleTest(com.lowagie.examples.objects.bookmarks.Layers.class);
        runSingleTest(com.lowagie.examples.objects.bookmarks.Destinations.class);
        runSingleTest(com.lowagie.examples.objects.bookmarks.Bookmarks.class);
    }

    @Test
    public void testMiscExamples() {
        runSingleTest(com.lowagie.examples.objects.SymbolSubstitution.class);

        runSingleTest(com.lowagie.examples.objects.NegativeLeading.class);
        runSingleTest(com.lowagie.examples.objects.FancyLists.class);

        runSingleTest(com.lowagie.examples.objects.Paragraphs.class);
        runSingleTest(com.lowagie.examples.objects.DifferentFonts.class);
        runSingleTest(com.lowagie.examples.objects.ParagraphAttributes.class);

        runSingleTest(com.lowagie.examples.objects.SpaceWordRatio.class);
        runSingleTest(com.lowagie.examples.objects.Chunks.class);
        runSingleTest(com.lowagie.examples.objects.Lists.class);

        runSingleTest(com.lowagie.examples.objects.Phrases.class);
        runSingleTest(com.lowagie.examples.objects.FontSelection.class);
    }

    @Test
    public void testImageExamples() {
        runSingleTest(com.lowagie.examples.objects.images.ImageSequence.class);
        runSingleTest(com.lowagie.examples.objects.images.Images.class);
        runSingleTest(com.lowagie.examples.objects.images.DvdCover.class,
        		RunAllExamplesTest.OUTPUT_DIR + "dvdcover.pdf",
                "My Sunflower Movie",
                "808080",
                RunAllExamplesTest.RESOURCES_DIR +"sunflower-front.jpg",
                RunAllExamplesTest.RESOURCES_DIR +"sunflower-back.jpg"
                );
        runSingleTest(com.lowagie.examples.objects.images.ImagesAlignment.class);
        runSingleTest(com.lowagie.examples.objects.images.Scaling.class);
        runSingleTest(com.lowagie.examples.objects.images.AnnotatedImage.class);
        runSingleTest(com.lowagie.examples.objects.images.Alignment.class);
        runSingleTest(com.lowagie.examples.objects.images.ImageChunks.class);
        runSingleTest(com.lowagie.examples.objects.images.Rotating.class);
        runSingleTest(com.lowagie.examples.objects.images.AbsolutePositions.class);
        runSingleTest(com.lowagie.examples.objects.images.ImageMasks.class);
        runSingleTest(com.lowagie.examples.objects.images.tiff.ExamplePDF417.class);
        runSingleTest(com.lowagie.examples.objects.images.tiff.Barcodes.class);
        runSingleTest(com.lowagie.examples.objects.images.tiff.ExampleEAN128.class);
        runSingleTest(com.lowagie.examples.objects.images.tiff.OddEven.class, RESOURCES_DIR +"odd.tif", RESOURCES_DIR +"even.tif", OUTPUT_DIR +  "OddEven.pdf");
        runSingleTest(com.lowagie.examples.objects.images.tiff.Tiff2Pdf.class, RESOURCES_DIR + "12.tif", RESOURCES_DIR + "338814-00.tif", RESOURCES_DIR + "odd.tif", RESOURCES_DIR + "even.tif");
        runSingleTest(com.lowagie.examples.objects.images.RawData.class);
        /**/
    }

    @Test
    public void testTableExamples() {
        runSingleTest(com.lowagie.examples.objects.tables.pdfptable.FloatingBoxes.class);
        runSingleTest(com.lowagie.examples.objects.tables.pdfptable.SplitTable.class);
        runSingleTest(com.lowagie.examples.objects.tables.pdfptable.FragmentTable.class, new String[]{"50"});
        runSingleTest(com.lowagie.examples.objects.tables.pdfptable.VerticalTextInCells.class);
        runSingleTest(com.lowagie.examples.objects.tables.pdfptable.TableEvents2.class);
        runSingleTest(com.lowagie.examples.objects.tables.pdfptable.Tables.class);
        runSingleTest(com.lowagie.examples.objects.tables.pdfptable.WriteSelectedRows.class);
        runSingleTest(com.lowagie.examples.objects.tables.pdfptable.TableEvents1.class);
        runSingleTest(com.lowagie.examples.objects.tables.pdfptable.CellEvents.class);
        runSingleTest(com.lowagie.examples.objects.tables.CellWidths.class);
        runSingleTest(com.lowagie.examples.objects.tables.MyFirstTable.class);
        runSingleTest(com.lowagie.examples.objects.tables.SplitRows.class);
        runSingleTest(com.lowagie.examples.objects.tables.DefaultCell.class);
        runSingleTest(com.lowagie.examples.objects.tables.TableSpacing.class);
        runSingleTest(com.lowagie.examples.objects.tables.AddBigTable.class);
        runSingleTest(com.lowagie.examples.objects.tables.TableBorders.class);
        runSingleTest(com.lowagie.examples.objects.tables.NestedTables.class);
        runSingleTest(com.lowagie.examples.objects.tables.ImageCell.class);
        runSingleTest(com.lowagie.examples.objects.tables.CellAlignment.class);
        runSingleTest(com.lowagie.examples.objects.tables.TableWidthAlignment.class);
        runSingleTest(com.lowagie.examples.objects.tables.CellColors.class);
        runSingleTest(com.lowagie.examples.objects.tables.CellPaddingLeading.class);
        runSingleTest(com.lowagie.examples.objects.tables.CellHeights.class);
        runSingleTest(com.lowagie.examples.objects.tables.alternatives.TableWithImage.class);
        runSingleTest(com.lowagie.examples.objects.tables.alternatives.SpecificCells.class);
        runSingleTest(com.lowagie.examples.objects.tables.alternatives.LargeCell.class);
        runSingleTest(com.lowagie.examples.objects.tables.alternatives.OldTable.class);
        runSingleTest(com.lowagie.examples.objects.tables.alternatives.MyFirstTable.class);
        runSingleTest(com.lowagie.examples.objects.tables.alternatives.PaddingBorders.class);
        runSingleTest(com.lowagie.examples.objects.tables.alternatives.RepeatingTable.class);
        runSingleTest(com.lowagie.examples.objects.tables.alternatives.NestedTables.class);
    }

    @Test
    public void testAnchorExamples() {
        runSingleTest(com.lowagie.examples.objects.anchors.OpenApplication.class, System.getenv("WINDIR") + File.separatorChar);
        runSingleTest(com.lowagie.examples.objects.anchors.ChainedActions.class);
        runSingleTest(com.lowagie.examples.objects.anchors.JavaScriptAction.class);
        runSingleTest(com.lowagie.examples.objects.anchors.Actions.class);
        runSingleTest(com.lowagie.examples.objects.anchors.NamedActions.class);
        runSingleTest(com.lowagie.examples.objects.anchors.AHref.class);
        runSingleTest(com.lowagie.examples.objects.anchors.SimpleAnnotations.class);
        runSingleTest(com.lowagie.examples.objects.anchors.LocalGoto.class);
        runSingleTest(com.lowagie.examples.objects.anchors.Annotations.class);
        runSingleTest(com.lowagie.examples.objects.anchors.RemoteGoto.class);
        runSingleTest(com.lowagie.examples.objects.anchors.LocalDestination.class);
    }

    @Test
    public void testColumnExamples() {
        runSingleTest(com.lowagie.examples.objects.columns.ColumnObjects.class);
        runSingleTest(com.lowagie.examples.objects.columns.Column.class);
        runSingleTest(com.lowagie.examples.objects.columns.ColumnSimple.class);
        runSingleTest(com.lowagie.examples.objects.columns.MultiColumnIrregular.class);
        runSingleTest(com.lowagie.examples.objects.columns.ColumnIrregular.class);
        runSingleTest(com.lowagie.examples.objects.columns.MultiColumnR2L.class);
        runSingleTest(com.lowagie.examples.objects.columns.MultiColumnSimple.class);
    }

    @Test
    public void testChunkExamples() {
        runSingleTest(com.lowagie.examples.objects.chunk.Width.class);
        runSingleTest(com.lowagie.examples.objects.chunk.Generic.class);
        runSingleTest(com.lowagie.examples.objects.chunk.Skew.class);
        runSingleTest(com.lowagie.examples.objects.chunk.Glossary.class);
        runSingleTest(com.lowagie.examples.objects.chunk.Lines.class);
        runSingleTest(com.lowagie.examples.objects.chunk.Background.class);
        runSingleTest(com.lowagie.examples.objects.chunk.EndOfLine.class);
        runSingleTest(com.lowagie.examples.objects.chunk.ChunkColor.class);
        runSingleTest(com.lowagie.examples.objects.chunk.Rendering.class);
        runSingleTest(com.lowagie.examples.objects.chunk.Hyphenation.class);
        runSingleTest(com.lowagie.examples.objects.chunk.SubSupScript.class);
        runSingleTest(com.lowagie.examples.objects.chunk.SplitChar.class);
    }


}

