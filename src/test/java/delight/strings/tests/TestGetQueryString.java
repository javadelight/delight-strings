package delight.strings.tests;

import static org.junit.Assert.assertEquals;

import delight.strings.UriUtils;

import org.junit.Test;

public class TestGetQueryString {

    @Test
    public void test() throws Exception {

        assertEquals("query", UriUtils.getQueryString("https://domain.com?query"));
        assertEquals("", UriUtils.getQueryString("https://domain.com?"));
        assertEquals("", UriUtils.getQueryString("https://domain.com"));

    }

}
