package com.lowagie.text;

/**
* A collection of method for surrogate pair.
* 
*/
public class SurrogateUtility {
	 
    /**
     * Check if the value of a character belongs to a certain interval
     * that indicates it's the higher part of a surrogate pair.
     * @param c	the character
     * @return	true if the character belongs to the interval
     * @since	2.1.2
     */
    public static boolean isSurrogateHigh(char c) {
        return c >= '\ud800' && c <= '\udbff';
    }

    /**
     * Check if the value of a character belongs to a certain interval
     * that indicates it's the lower part of a surrogate pair.
     * @param c	the character
     * @return	true if the character belongs to the interval
     * @since	2.1.2
     */
    public static boolean isSurrogateLow(char c) {
        return c >= '\udc00' && c <= '\udfff';
    }

    /**
     * Checks if two subsequent characters in a String are
     * are the higher and the lower character in a surrogate
     * pair (and therefore eligible for conversion to a UTF 32 character).
     * @param text	the String with the high and low surrogate characters
     * @param idx	the index of the 'high' character in the pair
     * @return	true if the characters are surrogate pairs
     * @since	2.1.2
     */
    public static boolean isSurrogatePair(String text, int idx) {
        if (idx < 0 || idx > text.length() - 2)
            return false;
        return isSurrogateHigh(text.charAt(idx)) && isSurrogateLow(text.charAt(idx + 1));
    }

    /**
     * Checks if two subsequent characters in a character array are
     * are the higher and the lower character in a surrogate
     * pair (and therefore eligible for conversion to a UTF 32 character).
     * @param text	the character array with the high and low surrogate characters
     * @param idx	the index of the 'high' character in the pair
     * @return	true if the characters are surrogate pairs
     * @since	2.1.2
     */
    public static boolean isSurrogatePair(char[] text, int idx) {
        if (idx < 0 || idx > text.length - 2)
            return false;
        return isSurrogateHigh(text[idx]) && isSurrogateLow(text[idx + 1]);
    }
}
