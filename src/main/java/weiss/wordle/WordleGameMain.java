package weiss.wordle;

import java.io.FileNotFoundException;

public class WordleGameMain {
    public static void main(String[] args) throws FileNotFoundException {
        //WordleGameFrame frame = new WordleGameFrame(new WordleGame(new WordleDictionary()));
        WordleGameFrame frame = new WordleGameFrame(new WordleGame(new WordleDictionary()), new WordleDictionary());
        frame.setVisible(true);
    }
}
