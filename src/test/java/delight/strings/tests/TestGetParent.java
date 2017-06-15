package delight.strings.tests;

import delight.strings.UriUtils;

import org.junit.Test;

import junit.framework.Assert;

public class TestGetParent {

    @Test
    public void testGetParent() throws Exception {

        Assert.assertEquals("https://u1.objecthub.io/objecthub/home/my/~*3/data/.n/Tests_7/.n/The_App",
                UriUtils.getParent("https://u1.objecthub.io/objecthub/home/my/~*3/data/.n/Tests_7/.n/The_App/app_js"));
    }

}
