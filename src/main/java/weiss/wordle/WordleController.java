package weiss.wordle;

import javax.swing.*;
import java.awt.*;

public class WordleController {

    int row = 0;
    int column = 0;

    StringBuilder theWord = new StringBuilder();
    private WordleGame wordleGame;
    private WordleDictionary dictionary;
    private JLabel labels[][];
    private JButton keyboard[];
    private JButton enter;
    private JButton backspace;


    public WordleController(WordleGame wordleGame, WordleDictionary dictionary,
                            JLabel[][] labels, JButton[] keyboard,
                            JButton enter, JButton backspace) {
        this.wordleGame = wordleGame;
        this.dictionary = dictionary;
        this.labels = labels;
        this.keyboard = keyboard;
        this.enter = enter;
        this.backspace = backspace;


    }

    //Called when you type the letter in or press a letter on the onscreen keyboard
    public void addLetter(String letter) {

        if (labels[row][column].getText().equals("")) {
            labels[row][column].setText(letter);
            column++;
            if (column == 5) {
                column = 0;
                row++;
            }

        }
    }

    //when you press the enter button
    public void enterGuess() {
        row -= 1;
        for (column = 0; column < 5; column++) {
            theWord.append(labels[row][column].getText());
        }
        for (int i = 0; i < dictionary.justWords.size(); i++) {
            if (!theWord.toString().equals(dictionary.justWords.get(i))) {
                System.out.println("Not a word, try again");
                break;
            }

        }
        CharResult[] answers = wordleGame.guess(theWord.toString());
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].equals(CharResult.Correct)) {
                labels[row][i].setForeground(Color.GREEN);
            } else if (answers[i].equals(CharResult.NotFound)) {
                labels[row][i].setForeground(Color.GRAY);
            } else if (answers[i].equals(CharResult.WrongPlace)) {
                labels[row][i].setForeground(Color.ORANGE);
            }
        }
        theWord.delete(0, 6);
        column = 0;
        row++;

    }


    //when you press backspace
    public void backspace() {
        row -= 1;

    }
}
