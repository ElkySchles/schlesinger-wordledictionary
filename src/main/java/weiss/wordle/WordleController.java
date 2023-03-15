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

        row--;
        for (column = 0; column < 5; column++) {
            theWord.append(labels[row][column].getText());
        }

        if (!dictionary.getList().contains(theWord.toString().toUpperCase())) {
            System.out.println("Not a word, try again");
            theWord.delete(0, 6);
            labels[row][column - 1].setText("");
            labels[row][column - 2].setText("");
            labels[row][column - 3].setText("");
            labels[row][column - 4].setText("");
            labels[row][column - 5].setText("");
            row--;
            return;

        }
        CharResult[] answers = wordleGame.guess(theWord.toString());
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].equals(CharResult.Correct)) {
                labels[row][i].setBackground(Color.GREEN);
                labels[row][i].setOpaque(true);
            } else if (answers[i].equals(CharResult.NotFound)) {
                labels[row][i].setBackground(Color.GRAY);
                labels[row][i].setOpaque(true);
            } else if (answers[i].equals(CharResult.WrongPlace)) {
                labels[row][i].setBackground(Color.ORANGE);
                labels[row][i].setOpaque(true);
            }
        }
        theWord.delete(0, 6);
        column = 0;
        row++;


    }


    //when you press backspace
    public void backspace() {
        labels[row][column - 1].setText("");
        column--;
        //if (column == 4) {
        //    labels[row][column].setText("");
        //}
    }
}
