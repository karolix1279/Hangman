package prepareWord;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadWords {

    private String filePath;

    public LoadWords(String filePath) {
        this.filePath = filePath;
    }

    public String[] loadWordFromFile() {

        String[] words = null;

        try (BufferedReader input = new BufferedReader(new FileReader(this.filePath))) {

            StringBuilder sb = new StringBuilder();
            String word;

            while ((word = input.readLine()) != null) {
                word = word.toLowerCase();
                sb.append(word);
                sb.append(";");

            }

            words = sb.toString().split(";");


        } catch (FileNotFoundException e) {
            System.out.println("Found not found exceptions from loading words");
        } catch (IOException e) {
            System.out.println("IO Exceptions from loading words");
        }

        return words;
    }
}
