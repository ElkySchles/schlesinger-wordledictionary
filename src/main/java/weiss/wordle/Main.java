package weiss.wordle;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        WordleDictionary wordle = new WordleDictionary();
        System.out.println(wordle.getDefinition("faithful"));
    }

}
