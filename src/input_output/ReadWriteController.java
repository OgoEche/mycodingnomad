package input_output;

import java.io.*;

public class ReadWriteController {

    public static void main(String[] args) {
        readWrite();

    }

    public static void readWrite() {

        // Using the BufferedInputStream, read a text file 5 bytes at a time and write each byte to a new file.
        // Make sure you close the connections to both files.
        var file = "src/input_output/files/text_file.txt";
        var newFile = "src/input_output/files/new_text_file.txt";
        byte[] buffer = new byte[5];
        int bytesRead = 0;

        try (var in = new BufferedInputStream(new FileInputStream(file));
             var out = new BufferedOutputStream(new FileOutputStream(newFile))) {

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(bytesRead);
                System.out.println(new String(buffer, 0, bytesRead));
            }
        } catch (java.io.IOException e) {
            System.out.println(e);
        }

    }



}
