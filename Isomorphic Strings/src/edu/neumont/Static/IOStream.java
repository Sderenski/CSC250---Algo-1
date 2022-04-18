package edu.neumont.Static;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class IOStream {
    public static void writeToStream(InputStream input, OutputStream output) throws IOException{
        int c;
        while ((c = input.read()) != -1){
            output.write(c);
        }
    }

    public static void writeToStream(String string, OutputStream output) throws IOException{
        byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
        output.write(bytes);
    }

    public static void writeToConsole(InputStream input) throws IOException{
        int c;
        while ((c = input.read()) != -1){
            System.out.print((char) c);
        }
    }

    // Passing an array of bytes from a file to a string Constructor to read from a file
    public static String readToString(InputStream input) throws IOException{
        int size = input.available();
        byte[] bytes = new byte[size];
        input.read(bytes);

        return new String(bytes);
    }

}
