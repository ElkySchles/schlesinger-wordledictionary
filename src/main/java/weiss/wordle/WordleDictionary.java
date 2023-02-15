package weiss.wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordleDictionary {
    //ArrayList to store all the lines in the dictionary
    private final ArrayList<String> dictionary = new ArrayList<String>();
    //private String definition;
    private final ArrayList<String> justWords = new ArrayList<String>();

    public WordleDictionary() throws FileNotFoundException {
        File file = new File("src/main/java/weiss/wordle/dictionary.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            dictionary.add(sc.nextLine());
        }
    }


    //getDefiniton takes in a word and returns the definition
    public String getDefinition(String word) {
        String[] dictLine;


        for (int i = 0; i < dictionary.size(); i++) {

            dictLine = dictionary.get(i).split(" ", 2);
            if (word.equalsIgnoreCase((dictLine[0]))) {
                String definition = dictLine[1];
                return definition;
            }
        }
        return null;
    }

    //GetList returns only the words from the dictionary
    public ArrayList<String> getList() {
        String[] dictLine;

        for (int i = 0; i < dictionary.size(); i++) {
            dictLine = dictionary.get(i).split(" ", 2);
            justWords.add(dictLine[0]);
        }
        return justWords;
    }

}

