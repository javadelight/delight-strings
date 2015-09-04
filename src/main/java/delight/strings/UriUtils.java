package delight.strings;

import java.util.ArrayList;
import java.util.List;

public class UriUtils {

    /**
     * <p>
     * Determines the domain of a URI.
     * 
     * @param uri
     * @return
     */
    public static String getDomain(final String uri) {
        return getPathComponents(uri)[0];
    }

    /**
     * <p>
     * From a path such as http://me.com/folder/node
     * <p>
     * Return ["me.com", "folder", "node"]
     */
    public static String[] getPathComponents(final String uri) {
        final String withoutProtocol = removeProtocol(uri);

        return withoutProtocol.split("/");
    }

    // public final boolean

    public static String removeProtocol(final String uri) {
        final int lengthProtocol;
        if (uri.startsWith("https://")) {
            lengthProtocol = "https://".length();
        } else if (uri.startsWith("http://")) {
            lengthProtocol = "http://".length();
        } else {
            throw new IllegalArgumentException("Protocol not supported for uri : " + uri);
        }

        final String withoutProtocol = uri.substring(lengthProtocol);
        return withoutProtocol;
    }

    public static String nodeUriToVersionUri(final String nodeUri) {
        final String withoutProtocol = removeProtocol(nodeUri);

        return "https://v." + withoutProtocol;

    }

    private static final String asNodeUri(final String originUri, final String path) {
        final String protocol;
        if (originUri.startsWith("https://")) {
            protocol = "https://";
        } else if (originUri.startsWith("http://")) {
            protocol = "http://";
        } else {
            throw new IllegalArgumentException("Invalid uri: " + originUri);
        }

        return protocol + path;

    }

    private static final String buildNodeUri(final String originUri, final String[] components,
            final int upToComponentIdx) {
        String s = "";
        for (int i = 0; i <= upToComponentIdx; i++) {
            s += components[i] + "/";
        }

        final String uri = asNodeUri(originUri, s);
        return uri.substring(0, uri.length() - 1);
    }

    public static List<String> getParentNodes(final String uri) {
        final String[] components = getPathComponents(uri);

        if (components.length == 1) {
            return new ArrayList<String>(0);
        }

        final List<String> parents = new ArrayList<String>(components.length - 1);

        for (int i = components.length - 2; i >= 0; i--) {
            parents.add(buildNodeUri(uri, components, i));
        }

        return parents;

    }

    public static String getParent(final String pathorUri) {

        final int lastSlash = pathorUri.lastIndexOf("/");

        if (lastSlash == -1) {
            return "";
        }

        return pathorUri.substring(0, lastSlash);

    }

    /**
     * Retrives the last element of this path.
     * 
     * @return
     */
    public static String getName(final String uri) {
        final int lastSlash = uri.lastIndexOf("/");

        return uri.substring(lastSlash + 1);

    }

    /**
     * from http://stackoverflow.com/questions/941272/how-do-i-trim-a-file-
     * extension-from-a-string-in-java
     * 
     * @param s
     * @return
     */
    public static String removeExtension(final String s) {
        final String works = s + "";
        final String separator = "/"; // System.getProperty("file.separator");

        final String filename;

        // Remove the path up to the filename.
        final int lastSeparatorIndex = works.replaceAll("\\\\", "/").lastIndexOf(separator);
        if (lastSeparatorIndex == -1) {
            filename = s;
        } else {
            filename = s.substring(lastSeparatorIndex + 1);
        }

        // Remove the extension.
        final int extensionIndex = filename.lastIndexOf(".");
        if (extensionIndex == -1) {
            return s;
        }

        return s.substring(0, lastSeparatorIndex + 1) + filename.substring(0, extensionIndex);
    }

    /**
     * Returns the extension of a given filename (excluding the .). If there is
     * no extension defined, this function returns "".
     * 
     * @param path
     * @return
     */
    public static String getExtension(final String path) {
        final int dotPos = path.lastIndexOf(".");
        if (dotPos > 0) {
            return path.substring(dotPos + 1);
        }
        return "";
    }

    public static String removeLastElement(final String path) {
        final int lastIdx = path.lastIndexOf("/");

        if (lastIdx == -1) {
            throw new IllegalArgumentException("Path does not have elements: " + path);
        }

        return path.substring(0, lastIdx);
    }

    public static String assertNoSlash(final String ofString) {
        if (!ofString.endsWith("/")) {
            return ofString;
        }
    
        return ofString.substring(0, ofString.length() - 1);
    }

    public static String assertSlash(final String ofString) {
        if (ofString.endsWith("/")) {
            return ofString;
        }
    
        return ofString.concat("/");
    }

}
