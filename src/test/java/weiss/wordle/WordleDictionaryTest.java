package weiss.wordle;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static weiss.wordle.CharResult.*;


class WordleDictionaryTest {
    @Test
    public void getDefinition() throws FileNotFoundException {

        WordleDictionary wordle = new WordleDictionary();

        String actual = wordle.getDefinition("AE");

        assertEquals("one [adj]", actual);

    }

    @Test
    public void getDefinitionOfOther() throws FileNotFoundException {

        WordleDictionary wordle = new WordleDictionary();

        String actual = wordle.getDefinition("ORCHESTRATING");

        assertEquals("", actual);

    }


    @Test
    public void getList() throws FileNotFoundException {

        WordleDictionary wordle = new WordleDictionary();

        int total = wordle.getList().size();

        assertEquals(167964, total);

    }

    @Test
    public void guess() throws FileNotFoundException {
        //given
        WordleDictionary dictionary = Mockito.mock(WordleDictionary.class);
        ArrayList<String> words = new ArrayList<>(List.of("APPLE"));
        doReturn(words).when(dictionary).getList();
        WordleGame game = new WordleGame(dictionary);

        //when
        CharResult[] results = game.guess("APPLE");

        //then
        CharResult[] answer = {Correct, Correct, Correct, Correct, Correct};
        assertArrayEquals(answer, results);

    }

    @Test
    public void guessTwo() throws FileNotFoundException {
        //given
        WordleDictionary dictionary = Mockito.mock(WordleDictionary.class);
        ArrayList<String> words = new ArrayList<>(List.of("APPLE"));
        doReturn(words).when(dictionary).getList();
        WordleGame game = new WordleGame(dictionary);

        //when
        CharResult[] results = game.guess("SUPER");

        //then
        CharResult[] answer = {NotFound, NotFound, Correct, WrongPlace, NotFound};
        assertArrayEquals(answer, results);

    }

}