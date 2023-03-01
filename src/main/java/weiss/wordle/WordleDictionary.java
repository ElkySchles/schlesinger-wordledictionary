package weiss.wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordleDictionary {

    ArrayList<String> justWords;

    ArrayList<String> definition;


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
                justWords.add(dictLine[0]);
                definition.add(dictLine[1]);
            } else {
                justWords.add(dictLine[0]);
                definition.add("");
            }
        }
    }


    //GetDefiniton takes in a word and returns the definition
    public String getDefinition(String word) {
        word = word.toUpperCase();
        for (int i = 0; i < justWords.size(); i++) {
            if (word.equals(justWords.get(i))) {
                return definition.get(i);
            }
        }
        return null;
    }

    //GetList returns only the words from the dictionary
    public ArrayList<String> getList() {

        return justWords;
    }

}

