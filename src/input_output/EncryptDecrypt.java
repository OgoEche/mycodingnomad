package input_output;

import java.io.*;

public class EncryptDecrypt {

    public static void main(String[] args) {
        encryptDecrypt();
    }

    public static void encryptDecrypt() {
        // Using the BufferedReader, read a file character by character and write an encrypted version to a new file
        // make sure you close the connections to both files
        // Then, read back the encrypted file using the BufferedReader and
        // print out the unencrypted version. Does it match the original file?

        var file = "src/input_output/files/unencrypted.txt";
        var newFile = "src/input_output/files/encrypted.txt";


        try (var in = new BufferedReader(new FileReader(file));
             var out = new BufferedWriter(new FileWriter(newFile))) {
            String data;

            while ((data = in.readLine()) != null ) {
                var encrypted = data.replaceAll("a","-").replaceAll("e", "~");
                out.write(encrypted);
                System.out.println(encrypted);
            }

        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("print out the unencrypted version. Does it match the original file?");
        try (var in2 = new BufferedReader(new FileReader(newFile))) {
            String data;
            while ((data = in2.readLine()) != null ) {
                var unencrypted = data.replaceAll("-","a").replaceAll("~", "e");
                System.out.println(unencrypted);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
