package weiss.wordle;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class WordleGame {


    //private final ArrayList<String> dictionary = new ArrayList<String>();
    private final Random random = new Random();
    private final String correctWord;


    public WordleGame(WordleDictionary dictionary) throws FileNotFoundException {

        Random random = new Random();

        ArrayList<String> fiveLetterWords = new ArrayList<String>();

        for (int i = 0; i < dictionary.getList().size(); i++) {
            if (dictionary.getList().get(i).length() == 5) {
                fiveLetterWords.add(dictionary.getList().get(i));
            }
        }
        int number = random.nextInt(fiveLetterWords.size());
        correctWord = fiveLetterWords.get(number);
    }


    public CharResult[] guess(String guessString) {

        CharResult[] results = new CharResult[guessString.length()];

        for (int i = 0; i < guessString.length(); i++) {
            if (!(correctWord.contains(Character.toString(guessString.charAt(i))))) {
                results[i] = CharResult.NotFound;
            } else if (guessString.charAt(i) == correctWord.charAt(i)) {
                results[i] = CharResult.Correct;
            } else {
                results[i] = CharResult.WrongPlace;
            }
        }

        return results;
    }
}
