/*******************************************************************************
 * Copyright 2011 Max Erik Rohde http://www.mxro.de
 * 
 * All rights reserved.
 ******************************************************************************/
package delight.strings;

import java.util.Random;

/**
 * from http://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-
 * numeric-string-in-java
 * 
 * author: http://stackoverflow.com/users/3474/erickson
 * 
 * 
 */
public class RandomString {

    private static final char[] symbols = new char[36];

    static {
        for (int idx = 0; idx < 10; ++idx) {
            symbols[idx] = (char) ('0' + idx);
        }
        for (int idx = 10; idx < 36; ++idx) {
            symbols[idx] = (char) ('a' + idx - 10);
        }
    }

    private final Random random = new Random();

    private final char[] buf;

    public static RandomString INSTANCE = new RandomString(15);

    public RandomString(final int length) {
        if (length < 1) {
            throw new IllegalArgumentException("length < 1: " + length);
        }
        buf = new char[length];
    }

    public String nextString() {
        for (int idx = 0; idx < buf.length; ++idx) {
            buf[idx] = symbols[random.nextInt(symbols.length)];
        }
        return new String(buf);
    }

    public String nextStringWithoutNumbers() {
        for (int idx = 0; idx < buf.length; ++idx) {
            buf[idx] = symbols[random.nextInt(symbols.length - 10) + 10];
        }
        return new String(buf);
    }

    public static String newRandomString() {
        return INSTANCE.nextString();
    }

}
