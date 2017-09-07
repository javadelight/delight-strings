package delight.strings;

public final class ClassNameUtils {

	/**
	 * <p>Returns the name of a class without the package.
	 * <p>For instance <code>delight.strings.StringUtils</code> will become <code>StringUtils</code>
	 * @return
	 */
	public static String getClassNameWithoutPackage(Class<?> clazz) {
		
		String name = clazz.getName();
		
		return name.substring(name.lastIndexOf(".")+1);
			
	}
	
	
	
}
