package delight.strings.jre;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class ConvertToString {

    public static String inputStream(final InputStream is) {
        try {
            return new String(read(is), "UTF-8");
        } catch (final UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] read(final InputStream inputStream) {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final byte[] buffer = new byte[1024];
        int length = 0;
        try {
            while ((length = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
        return baos.toByteArray();
    }

}
