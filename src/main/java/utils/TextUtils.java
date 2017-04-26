package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by luke_c on 26/04/2017.
 */
public class TextUtils {
    public static String loadFile(String location) {
        try {
            return new String(Files.readAllBytes(Paths.get(location)));
        } catch(IOException e) {
            System.out.println("IOException occurred");
            return "";
        }
    }
}
