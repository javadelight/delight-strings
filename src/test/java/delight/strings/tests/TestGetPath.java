package delight.strings.tests;

import delight.strings.UriUtils;

import org.junit.Assert;
import org.junit.Test;

public class TestGetPath {

    @Test
    public void test() {

        Assert.assertEquals("/rpc/gwtJsonpRpc/v1", UriUtils.getPath("https://objecthub.io/rpc/gwtJsonpRpc/v1"));

    }

}
