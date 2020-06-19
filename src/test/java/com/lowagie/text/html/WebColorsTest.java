package com.lowagie.text.html;

import java.awt.Color;


import org.junit.Assert;
import org.junit.Test;

public class WebColorsTest {

    public WebColorsTest() {
        super();
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNullName() {
         WebColors.getRGBColor(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testEmptyName() {
        WebColors.getRGBColor("");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testBlankName() {
         WebColors.getRGBColor(" ");
    }

    @Test
    public void testTransparency() {
        // Test for PR #378
        Color color = WebColors.getRGBColor("black");
        Color expected = new Color(0, 0, 0, 255);
        Assert.assertEquals(expected, color);
    }
    
    
    @Test
    public void testHexadecimalSintax() {
        Color expected = new Color(0xff, 0x00, 0x99, 0xff);
        Assert.assertEquals(expected, WebColors.getRGBColor("#f09"));
        Assert.assertEquals(expected, WebColors.getRGBColor("#F09"));
        Assert.assertEquals(expected, WebColors.getRGBColor("#ff0099"));
        Assert.assertEquals(expected, WebColors.getRGBColor("#FF0099"));
    }
    
    @Test
    public void testHexadecimalSintaxWithAlpha() {
        Color expected = new Color(0xff, 0x00, 0x99, 0xaa);
        // Hexadecimal syntax with alpha value 
        Assert.assertEquals(expected, WebColors.getRGBColor("#f09a"));
        Assert.assertEquals(expected, WebColors.getRGBColor("#F09A"));
        Assert.assertEquals(expected, WebColors.getRGBColor("#ff0099aa"));
        Assert.assertEquals(expected, WebColors.getRGBColor("#FF0099aa"));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testHexadecimalBadFormats1() {
        WebColors.getRGBColor("#");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testHexadecimalBadFormats2() {
        WebColors.getRGBColor("#ab");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testHexadecimalBadFormats3() {
        WebColors.getRGBColor("#zzz");
    }
   
    @Test
    public void testRGB() {
        Color expected = new Color(0xff, 0x00, 0x99, 0xff);
        Assert.assertEquals(expected, WebColors.getRGBColor("rgb(255,0,153)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("rgb(255, 0, 153)"));
    }
    @Test
    public void testRGBPercentage() {
        Color expected = new Color(0xff, 0x00, 0x99, 0xff);
        Assert.assertEquals(expected, WebColors.getRGBColor("rgb(100%,0%,60%)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("rgb(100%, 0%, 60%)"));
    }
    
    @Test
    public void testRGBSpaces() {
        Color expected = new Color(0xff, 0x00, 0x99, 0xff); 
        Assert.assertEquals(expected, WebColors.getRGBColor("rgb(255 0 153)"));
    }
    
    @Test
    public void testRGBAlpha() {
        Color expected = new Color(0xff, 0x00, 0x99, 0xff);
        Assert.assertEquals(expected, WebColors.getRGBColor("rgb(255, 0, 153, 1)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("rgb(255, 0, 153, 100%)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("rgb(255 0 153 / 1)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("rgb(255 0 153 / 100%)"));
        
        Color expected2 = new Color(0xff, 0x00, 0x99, 0x99);
        Assert.assertEquals(expected2, WebColors.getRGBColor("rgb(255, 0, 153, 0.6)"));
        Assert.assertEquals(expected2, WebColors.getRGBColor("rgb(255, 0, 153, 60%)"));
        Assert.assertEquals(expected2, WebColors.getRGBColor("rgb(255 0 153 / 0.6)"));
        Assert.assertEquals(expected2, WebColors.getRGBColor("rgb(255 0 153 / 60%)"));
    }
    @Test
    public void testRGBAAlias() {
        Color expected = new Color(0xff, 0x00, 0x99, 0xff);
        Assert.assertEquals(expected, WebColors.getRGBColor("rgba(255, 0, 153, 1)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("rgba(255, 0, 153, 100%)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("rgba(255 0 153 / 1)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("rgba(255 0 153 / 100%)"));
        
        Color expected2 = new Color(0xff, 0x00, 0x99, 0x99);
        Assert.assertEquals(expected2, WebColors.getRGBColor("rgba(255, 0, 153, 0.6)"));
        Assert.assertEquals(expected2, WebColors.getRGBColor("rgba(255, 0, 153, 60%)"));
        Assert.assertEquals(expected2, WebColors.getRGBColor("rgba(255 0 153 / 0.6)"));
        Assert.assertEquals(expected2, WebColors.getRGBColor("rgba(255 0 153 / 60%)"));
    }
    
    @Test
    public void testRGBFloatValues() {
        Color expected = new Color(0xff, 0x00, 0x99, 0xff);
        Assert.assertEquals(expected, WebColors.getRGBColor("rgb(255, 0, 153.0)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("rgb(255, 0, 153.6, 1)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("rgb(2.55e2, .1e0, 1.53e2, +.1e3%)"));
    }
    
    @Test
    public void testHSL () {
        Color expected = new Color(0xb3, 0x85, 0xe1, 0xff);
        Assert.assertEquals(expected, WebColors.getRGBColor("hsl(270,60%,70%)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("hsl(270, 60%, 70%)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("hsl(270 60% 70%)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("hsl(270deg, 60%, 70%)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("hsl(4.71239rad, 60%, 70%)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("hsl(.75turn, 60%, 70%)"));
    }
    
    @Test
    public void testHSLA () {
        Color expected = new Color(0xb3, 0x85, 0xe1, (int) (255*0.15));
        
        Assert.assertEquals(expected, WebColors.getRGBColor("hsl(270, 60%, 70%, .15)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("hsl(270, 60%, 70%, 15%)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("hsl(270 60% 70% / .15)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("hsl(270 60% 70% / 15%)"));

                
    }
    
    @Test
    public void testHSLAAlias () {
        Color expected = new Color(0xb3, 0x85, 0xe1, (int) (255*0.15));
        
        Assert.assertEquals(expected, WebColors.getRGBColor("hsla(270, 60%, 70%, .15)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("hsla(270, 60%, 70%, 15%)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("hsla(270 60% 70% / .15)"));
        Assert.assertEquals(expected, WebColors.getRGBColor("hsla(270 60% 70% / 15%)"));

                
    }
    
        
}
