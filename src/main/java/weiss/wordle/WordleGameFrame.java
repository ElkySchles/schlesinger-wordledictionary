package weiss.wordle;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordleGameFrame extends JFrame /*visual window*/ {
    //How do we instatiate a 2-d array?
    JTextField[][] fields;
    String wordGuess;


    public WordleGameFrame() {
        //layout manager defines in a panel how the views get laid out
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, 1));

        JPanel centerPanel = new JPanel();
        //mainPanel.setLayout(new GridLayout(4, 3));
        centerPanel.setLayout(new GridLayout(3, 0));

        for (int i = 0; i < 1; i++) {
            //for (int j = 0; j < 3; j++) {
            JTextField field = new JTextField("Guess Word Here");
            wordGuess = field.getText();
            centerPanel.add(field);
            //}
        }
        for (int i = 0; i < 1; i++) {
            //for (int j = 0; j < 3; j++) {
            JLabel output = new JLabel();// + "," + j);
            //utput.getText();
            centerPanel.add(output);
            //}
        }
        for (int i = 0; i < 1; i++) {
            //for (int j = 0; j < 3; j++) {
            JButton button = new JButton("Guess Word");// + "," + j);
            button.getText();
            centerPanel.add(button);
            //}
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("GUESS CLICKED");
                }
            });
        }
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
