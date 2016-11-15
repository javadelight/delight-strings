package delight.strings;

public final class SanitizeStrings {

    public static final char[] URL_PATH_CHARACTERS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '_', '-', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', '0', '.', '+', '$' };

    public static final char[] BASIC_CHARACTERS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '_', '-', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', '0' };

    /**
     * Returns true if the given character is valid in an URL path portion
     * 
     * @param character
     * @return
     */
    public static final boolean isUrlPathCharacter(final char character) {
        boolean found = false;
        for (final char element : URL_PATH_CHARACTERS) {
            found = found || character == element || character == Character.toUpperCase(element);
        }
        return found;
    }

    public static final boolean isBasicCharacter(final char character) {
        boolean found = false;
        for (final char element : BASIC_CHARACTERS) {
            found = found || character == element || character == Character.toUpperCase(element);
        }
        return found;
    }

    /**
     * Returns true if all characters in input are ASCII characters.
     * 
     * @param input
     * @return
     */
    public static boolean isASCII(final String input) {
        boolean match = true;
        for (int i = 0; i < input.length(); i++) {
            final int c = input.charAt(i);
            if (c > 0x7F) {
                match = false;
                break;
            }
        }
        return match;
    }

    /**
     * Only contains letters or underscore
     * 
     * @return
     */
    public final static String getBasicName(final String forName) {
        final String n = forName;
        if (n.length() > 0) {
            String simple = "";
            for (int i = 0; i < n.length(); i++) {
                final boolean found = isBasicCharacter(n.charAt(i));
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
     * Simplifies any given string and makes it conformant as file name for an
     * URI. Illegal characters are replaced by an '_'.<br/>
     * <br />
     * For legal characters, see {@link #URL_PATH_CHARACTERS}:<br/>
     * {@value #URL_PATH_CHARACTERS}
     * 
     * @param forName
     * @return
     */
    public final static String getSimpleName(final String forName) {
        final String n = forName;
        if (n.length() > 0) {
            String simple = "";
            for (int i = 0; i < n.length(); i++) {
                final boolean found = isUrlPathCharacter(n.charAt(i));
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

    public static String getDatabaseName(final String forName) {
        final String n = forName;
        if (n.length() > 0) {
            String simple = "";
            for (int i = 0; i < n.length(); i++) {
                final char c = n.charAt(i);
                final boolean found = isUrlPathCharacter(c) || c == '_' || c == '-' || c == '.' || c == '%' || c == '#'
                        || c == '$' || c == '!' || c == '+';
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

    public static String getSimpleFileName(final String forName) {
        final String n = forName;
        if (n.length() > 0) {
            String simple = "";
            for (int i = 0; i < n.length(); i++) {
                final boolean found = isUrlPathCharacter(n.charAt(i)) || n.charAt(i) == '.';
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

    public static boolean isSimplePath(final String path) {
        final String n = path;
        if (n.length() > 0) {

            for (int i = 0; i < n.length(); i++) {
                final char c = n.charAt(i);
                final boolean found = isUrlPathCharacter(c) || c == '/' || c == '.' || c == '*';
                if (!found) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
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

    public final static String getBasicName(final String forName, final int maxCharacters) {
        final String name = getBasicName(forName);
        if (name.length() > maxCharacters) {
            return name.substring(0, maxCharacters);
        }
        return name;
    }

}
