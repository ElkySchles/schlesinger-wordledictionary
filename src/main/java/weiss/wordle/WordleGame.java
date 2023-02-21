package weiss.wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class WordleGame {
    private final ArrayList<String> dictionary = new ArrayList<String>();
    private final Random random = new Random();
    CharResult correct = CharResult.Correct;
    CharResult notPresent = CharResult.NotFound;
    CharResult wrongPlace = CharResult.WrongPlace;
    private String correctWord;


    public WordleGame() throws FileNotFoundException {
        File file = new File("src/main/java/weiss/wordle/dictionary.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            dictionary.add(sc.nextLine());
        }

        ArrayList<String> words = new ArrayList<String>();
        ArrayList<String> fiveLetterWords = new ArrayList<String>();
        String[] dictLine;
        for (int i = 0; i < dictionary.size(); i++) {
            dictLine = dictionary.get(i).split(" ", 2);
            words.add(dictLine[0]);
        }
        for (int x = 0; x < words.size(); x++) {
            if (words.get(x).length() == 5) {
                fiveLetterWords.add(words.get(x));
            }
        }
        int number = random.nextInt(fiveLetterWords.size());
        correctWord = fiveLetterWords.get(number);

    }
    public String getCorrectWord(){
        return this.correctWord;
    }

    public CharResult[] guess(String guessString) {

        CharResult[] results = new CharResult[guessString.length()];

        for(int i = 0; i < guessString.length(); i++) {
          if (!(correctWord.contains(Character.toString(guessString.charAt(i))))){
              results[i] = CharResult.NotFound;
          }else if(guessString.charAt(i) == correctWord.charAt(i)){
              results[i] = CharResult.Correct;
            }else{
              results[i] = CharResult.WrongPlace;
            }
        }

    return results;
    }
}
