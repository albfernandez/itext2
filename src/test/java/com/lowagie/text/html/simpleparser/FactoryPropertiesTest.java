package com.lowagie.text.html.simpleparser;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;


public class FactoryPropertiesTest {
	 @Test
	    public void shouldCreateRelativeLeadingForLineHeightNUmber() throws Exception {
	        // given
	        final HashMap h = new HashMap<>();
	        final String style = "line-height:1.4";
	        h.put("style", style);
	        final ChainedProperties cprops = new ChainedProperties();
	        // when
	        FactoryProperties.insertStyle(h, cprops);
	        // then
	        Assert.assertEquals("0,1.4", h.get("leading"));
	    }
}
