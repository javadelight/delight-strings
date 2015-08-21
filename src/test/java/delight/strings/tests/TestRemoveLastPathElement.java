package delight.strings.tests;

import delight.strings.UriUtils;

import org.junit.Test;

import junit.framework.Assert;

public class TestRemoveLastPathElement {

    @Test
    public void test() {
        Assert.assertEquals("my", UriUtils.removeLastElement("my/path"));
    }

}
