package weiss.wordle;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class WordleGameFrame extends JFrame /*visual window*/ {
    //How do we instatiate a 2-d array?
    JTextField[][] fields;
    String wordGuess;


    public WordleGameFrame(WordleGame game) {


        //layout manager defines in a panel how the views get laid out
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, 1));


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 0));

        //This is the guess word box
        JTextField guessWord = new JTextField("Guess Word Here");
        centerPanel.add(guessWord);

        //this displays the output
        JLabel output = new JLabel();
        centerPanel.add(output);

        //this is the button to guess the word
        JButton button = new JButton("Guess Word");
        centerPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wordGuess = guessWord.getText();
                CharResult[] answers = game.guess(wordGuess);
                output.setText(Arrays.toString(answers));

            }
        });

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        /*JButton button = new JButton("Guess");
        mainPanel.add(button, BorderLayout.SOUTH);*/

        //allows views
        setContentPane(mainPanel);
        setSize(600, 1000);
        setTitle("Wordle Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}
