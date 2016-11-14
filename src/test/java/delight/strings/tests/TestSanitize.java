package delight.strings.tests;

import delight.strings.SanitizeStrings;

import org.junit.Assert;
import org.junit.Test;

public class TestSanitize {

    @Test
    public void test() {

        Assert.assertEquals("v____________________objecthub_io_hub_users_main__objecthub_hom",
                SanitizeStrings.getBasicName("v1-12347952976158189-objecthub.io_hub_users_main__objecthub_hom"));

    }

}
