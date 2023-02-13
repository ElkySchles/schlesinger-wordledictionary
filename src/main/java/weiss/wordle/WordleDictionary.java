package weiss.wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordleDictionary {
    //ArrayList to store all the lines in the dictionary
    ArrayList<String> dictionary = new ArrayList<String>();
    String word;
    String definition;
    String[] dictLine;
    ArrayList<String> justWords = new ArrayList<String>();


    //getDefiniton takes in a word and returns the definition
    public String getDefinition(String word) throws FileNotFoundException {
        File file = new File("src/main/java/weiss/wordle/dictionary.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            dictionary.add(sc.nextLine());
        }

        for (int i = 0; i < dictionary.size(); i++) {
            dictLine = dictionary.get(i).split(" ", 2);
            //how to compare strings in java.
            if (word.equals(dictLine[0])) {
                definition = dictLine[1];
            }

        }
        return definition;
    }

    //GetList returns only the words from the dictionary
    public ArrayList<String> getList() throws FileNotFoundException {
        File file = new File("src/main/java/weiss/wordle/dictionary.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            dictionary.add(sc.nextLine());
        }

        for (int i = 0; i < dictionary.size(); i++) {
            dictLine = dictionary.get(i).split(" ", 2);
            justWords.add(dictLine[0]);
        }
        return justWords;
    }

}

