package delight.strings.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import delight.strings.ClassNameUtils;
import junit.framework.Assert;

public class TestClassNameUtils {

	@Test
	public void testGetClassNameWithoutPackage() throws Exception {
		
		Assert.assertEquals("StringUtils", ClassNameUtils.getClassNameWithoutPackage(ClassNameUtils.class));
		
	}
	
}
