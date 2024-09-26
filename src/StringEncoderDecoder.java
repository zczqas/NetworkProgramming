// WAP to encode “This string has space” and then decode it to the
// original string

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class StringEncoderDecoder {
    public static void main(String[] args) {
        String originalString = "This string has space";
        System.out.println("Original String: " + originalString);
        try {
            // Encode the string
            String encodedString = URLEncoder.encode(originalString, "UTF-8");
            System.out.println("Encoded String: " + encodedString);

            // Decode the string
            String decodedString = URLDecoder.decode(encodedString, "UTF-8");
            System.out.println("Decoded String: " + decodedString);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
