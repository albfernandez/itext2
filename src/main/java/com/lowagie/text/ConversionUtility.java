package com.lowagie.text;

/**
* A collection of conversion methods 
* 
*/
public class ConversionUtility {

	/**
	 * Measurement conversion from millimeters to points.
	 * @param	value	a value in millimeters
	 * @return	a value in points
	 * @since	2.1.2
	 */
	public static final float millimetersToPoints(float value) {
	    return inchesToPoints(millimetersToInches(value));
	}

	/**
	 * Measurement conversion from millimeters to inches.
	 * @param	value	a value in millimeters
	 * @return	a value in inches
	 * @since	2.1.2
	 */
	public static final float millimetersToInches(float value) {
	    return value / 25.4f;
	}

	/**
	 * Measurement conversion from points to millimeters.
	 * @param	value	a value in points
	 * @return	a value in millimeters
	 * @since	2.1.2
	 */
	public static final float pointsToMillimeters(float value) {
	    return inchesToMillimeters(pointsToInches(value));
	}

	/**
	 * Measurement conversion from points to inches.
	 * @param	value	a value in points
	 * @return	a value in inches
	 * @since	2.1.2
	 */
	public static final float pointsToInches(float value) {
	    return value / 72f;
	}

	/**
	 * Measurement conversion from inches to millimeters.
	 * @param	value	a value in inches
	 * @return	a value in millimeters
	 * @since	2.1.2
	 */
	public static final float inchesToMillimeters(float value) {
	    return value * 25.4f;
	}

	/**
	 * Measurement conversion from inches to points.
	 * @param	value	a value in inches
	 * @return	a value in points
	 * @since	2.1.2
	 */
	public static final float inchesToPoints(float value) {
	    return value * 72f;
	}
	
	 /**
     * Returns the code point of a UTF32 character corresponding with
     * a high and a low surrogate value.
     * @param highSurrogate	the high surrogate value
     * @param lowSurrogate	the low surrogate value
     * @return	a code point value
     * @since	2.1.2
     */
    public static int convertToUtf32(char highSurrogate, char lowSurrogate) {
         return (((highSurrogate - 0xd800) * 0x400) + (lowSurrogate - 0xdc00)) + 0x10000;
    }

    /**
     * Converts a unicode character in a character array to a UTF 32 code point value.
     * @param text	a character array that has the unicode character(s)
     * @param idx	the index of the 'high' character
     * @return	the code point value
     * @since	2.1.2
     */
    public static int convertToUtf32(char[] text, int idx) {
         return (((text[idx] - 0xd800) * 0x400) + (text[idx + 1] - 0xdc00)) + 0x10000;
    }

    /**
     * Converts a unicode character in a String to a UTF32 code point value
     * @param text	a String that has the unicode character(s)
     * @param idx	the index of the 'high' character
     * @return	the codepoint value
     * @since	2.1.2
     */
    public static int convertToUtf32(String text, int idx) {
         return (((text.charAt(idx) - 0xd800) * 0x400) + (text.charAt(idx + 1) - 0xdc00)) + 0x10000;
    }

    /**
     * Converts a UTF32 code point value to a String with the corresponding character(s).
     * @param codePoint	a Unicode value
     * @return	the corresponding characters in a String
     * @since	2.1.2
     */
    public static String convertFromUtf32(int codePoint) {
        if (codePoint < 0x10000)
            return Character.toString((char)codePoint);
        codePoint -= 0x10000;
        return new String(new char[]{(char)((codePoint / 0x400) + 0xd800), (char)((codePoint % 0x400) + 0xdc00)});
    }
}
