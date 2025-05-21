import java.io.*;
import java.net.*;
import java.util.*;

public class WordCheck {

    private static Set<String> words = new HashSet<>();

    static {

        String url = "https://raw.githubusercontent.com/dwyl/english-words/master/words.txt";


        try {

            URL wordListURL = new URL(url);
            InputStreamReader ISR = new InputStreamReader(wordListURL.openStream());
            Scanner scnr = new Scanner(ISR);
            String currLine;

            while (scnr.hasNextLine()) {
                currLine = scnr.nextLine().toLowerCase();
                words.add(currLine);
            }

        } catch (IOException e) {
            System.out.println("[DEBUG] IO Exception Thrown: " + e.getMessage());
        }
    }

        public boolean checkWord(String userInput) {

            String userWord = userInput.toLowerCase();

            if (words.contains(userWord)) {
                return true;
                //System.out.println("[OUTPUT] Found Word");
            } else {
                return false;
                //System.out.println("[OUTPUT] Word NOT Found");
            }

        }

}