package delight.strings;

import java.util.ArrayList;
import java.util.List;

public class UriUtils {

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

    public static String getParentInPath(final String path) {

        final int lastSlash = path.lastIndexOf("/");

        if (lastSlash == -1) {
            return "";
        }

        return path.substring(0, lastSlash);

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

}
