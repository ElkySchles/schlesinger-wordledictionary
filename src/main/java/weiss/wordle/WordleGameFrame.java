package weiss.wordle;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WordleGameFrame extends JFrame /*visual window*/ {
    //How do we instatiate a 2-d array?
    JTextField[][] fields;
    String wordGuess;

    int guessAmount;
    private JLabel[][] letters = new JLabel[6][5];
    private JButton[] keyboard = new JButton[26];
    private String[] alphabet = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
            "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M"};

    //hard code the abc's
    private JButton backspace;
    private JButton enter;
    private WordleController controller;


    public WordleGameFrame(WordleGame wordleGame, WordleDictionary dictionary) {

        controller = new WordleController(
                wordleGame,
                dictionary,
                letters,
                keyboard,
                enter,
                backspace
        );

        setFocusable(true);


        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //we only listen to this

                controller.addLetter(String.valueOf(e.getKeyChar()));
                requestFocus();
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        //layout manager defines in a panel how the views get laid out
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        //JPanel headPanel = new JPanel();

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(6, 5));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 100, 50, 100));
        JPanel southPanel = new JPanel();
        //southPanel1.setLayout(new GridLayout(3, 10));
        southPanel.setLayout(new BorderLayout());

        JPanel southPanel1 = new JPanel();
        JPanel southPanel2 = new JPanel();
        JPanel southPanel3 = new JPanel();
        southPanel.add(southPanel1, BorderLayout.NORTH);
        southPanel.add(southPanel2, BorderLayout.CENTER);
        southPanel.add(southPanel3, BorderLayout.SOUTH);


        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        JButton text = new JButton();

        //sets the grid of word guesses
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters[i].length; j++) {
                letters[i][j] = new JLabel();
                centerPanel.add(letters[i][j]);
                letters[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
            }
        }
        //sets the first row of the keyboard
        for (int i = 0; i < keyboard.length - 16; i++) {
            keyboard[i] = new JButton(alphabet[i]);
            southPanel1.add(keyboard[i]);
            int finalI = i;
            keyboard[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.addLetter(keyboard[finalI].getText());
                }
            });

        }
        //sets the second row of the keyboard
        for (int i = 10; i < keyboard.length - 7; i++) {
            keyboard[i] = new JButton(alphabet[i]);
            southPanel2.add(keyboard[i]);
            int finalI = i;
            keyboard[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.addLetter(keyboard[finalI].getText());
                }
            });
        }
        //sets enter
        JButton enter = new JButton("ENTER");
        southPanel3.add(enter);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.enterGuess();
            }
        });

        //sets the last row of the keyboard
        for (int i = 19; i < keyboard.length; i++) {
            keyboard[i] = new JButton(alphabet[i]);
            southPanel3.add(keyboard[i]);
            int finalI = i;
            keyboard[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.addLetter(keyboard[finalI].getText());
                }
            });
        }
        //sets the backspace button
        JButton backspace = new JButton("BACKSPACE");
        southPanel3.add(backspace);
        backspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.backspace();
            }
        });


        setContentPane(mainPanel);
        setSize(1200, 1000);
        setTitle("Wordle Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }


}
