package delight.strings.tests;

import delight.strings.UriUtils;

import org.junit.Assert;
import org.junit.Test;

public class TestRemoveQueryString {

    @Test
    public void test() {
        final String uri = "http://objecthub.io/?utm_source=analytics_test&utm_medium=referral";

        Assert.assertEquals("http://objecthub.io/", UriUtils.removeQueryString(uri));
    }

    @Test
    public void test_none() {
        final String uri = "http://objecthub.io/";

        Assert.assertEquals("http://objecthub.io/", UriUtils.removeQueryString(uri));
    }

}
