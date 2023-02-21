package weiss.wordle;

import java.io.File;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        WordleDictionary wordle = new WordleDictionary();
        System.out.println(wordle.getDefinition("faithful"));
        WordleGame game = new WordleGame();
        //System.out.println(game.guess("apple"));
        CharResult[] array = game.guess("TRULY");
        for(int i =0; i <array.length; i++){
            System.out.println(array[i]);
        }
        System.out.println(game.getCorrectWord());
    }

}
