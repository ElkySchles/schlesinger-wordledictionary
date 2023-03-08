package weiss.wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class WordleDictionary {

    ArrayList<String> justWords;

    ArrayList<String> definition;

    HashMap<String, String> map = new HashMap<String, String>();


    public WordleDictionary() throws FileNotFoundException {
        justWords = new ArrayList<>();
        definition = new ArrayList<>();

        final ArrayList<String> dictionary = new ArrayList<>();
        File file = new File("src/main/java/weiss/wordle/dictionary.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            dictionary.add(sc.nextLine());
        }
        for (int i = 0; i < dictionary.size(); i++) {
            String[] dictLine = dictionary.get(i).split(" ", 2);
            if (dictLine.length != 1) {
                map.put(dictLine[0], dictLine[1]);
            } else {
                map.put(dictLine[0], "");
            }
        }
    }


    //GetDefiniton takes in a word and returns the definition
    public String getDefinition(String word) {
        word = word.toUpperCase();
        for (int i = 0; i < map.size(); i++) {
            if (map.containsKey(word)) {
                return map.get(word);
            }
        }
        return null;
    }

    //GetList returns only the words from the dictionary
    public Set<String> getList() {

        return map.keySet();
    }

}

