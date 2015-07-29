package delight.strings;

public class SanitzeStrings {

    public static final char[] allowedCharacters = { 'a', 'b', 'c', 'd', 'e',
    'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
    's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '_', '-', '1', '2', '3',
    '4', '5', '6', '7', '8', '9', '0' };

    /**
     * Returns true if the given character is a 'standard' character. (a-z,
     * A-Z).
     * 
     * @param character
     * @return
     */
    public static boolean isSimpleCharacter(final char character) {
        boolean found = false;
        for (final char element : allowedCharacters) {
            found = found || character == element
                    || character == Character.toUpperCase(element);
        }
        return found;
    }

    /**
     * Simplifies any given string and makes it conformant as file name for an
     * URI. Illegal characters are replaced by an '_'.<br/>
     * <br />
     * For legal characters, see {@link #allowedCharacters}:<br/>
     * {@value #allowedCharacters}
     * 
     * @param forName
     * @return
     */
    public static String getSimpleName(final String forName) {
        final String n = forName;
        if (n.length() > 0) {
            String simple = "";
            for (int i = 0; i < n.length(); i++) {
                final boolean found = isSimpleCharacter(n.charAt(i));
                if (found) {
                    simple = simple + n.charAt(i);
                } else {
                    simple = simple + '_';
                }
            }
            return simple;
        } else {
            return n;
        }
    }

    /**
     * @see getSimpleName
     * 
     */
    public static String getSimpleName(final String forName, final int maxCharacters) {
        final String name = getSimpleName(forName);
        if (name.length() > maxCharacters) {
            return name.substring(0, maxCharacters);
        }
        return name;
    }

}
