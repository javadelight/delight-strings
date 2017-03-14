package delight.strings.tests;

import delight.strings.UriUtils;

import org.junit.Test;

import junit.framework.Assert;

public class TestUriUtils {

    @Test
    public void test() throws Exception {

        Assert.assertEquals("localhost:14372", UriUtils.getDomain("http://localhost:14372/"));
        // Assert.assertEquals("localhost:14372",
        // UriUtils.getDomain("localhost:14372/*0/node1"));

    }

}
