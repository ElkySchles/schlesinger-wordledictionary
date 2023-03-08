package weiss.wordle;

import javax.swing.*;

public class WordleController {

    private WordleGame wordleGame;
    private WordleDictionary dictionary;

    private JLabel labels[][];
    private JButton keyboard[];
    private JButton enter;
    private JButton backspace;

    public WordleController(WordleGame wordleGame, WordleDictionary dictionary, JLabel[][] labels, JButton[] keyboard, JButton enter, JButton backspace) {
        this.wordleGame = wordleGame;
        this.dictionary = dictionary;
        this.labels = labels;
        this.keyboard = keyboard;
        this.enter = enter;
        this.backspace = backspace;
    }

    //Called when you type the letter in or press a letter on the onscreen keyboard
    public void addLetter(String letter) {
        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j < labels[i].length; j++) {
                if (labels[i][j].getText().equals("")) {
                    labels[i][j].setText(letter);

                }
                break;
            }
            break;
        }

    }

    //when you press the enter button
    public void enterGuess() {

    }

    //when you press backspace
    public void backspace() {

    }
}
