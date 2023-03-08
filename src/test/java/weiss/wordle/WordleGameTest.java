package weiss.wordle;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;
import static weiss.wordle.CharResult.*;

class WordleGameTest {
    @Test
    public void guess() throws FileNotFoundException {
        //given
        WordleDictionary dictionary = Mockito.mock(WordleDictionary.class);
        Set<String> words = new HashSet<>(List.of("APPLE"));
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
        Set<String> words = new HashSet<>(List.of("APPLE"));
        doReturn(words).when(dictionary).getList();
        WordleGame game = new WordleGame(dictionary);

        //when
        CharResult[] results = game.guess("SUPER");

        //then
        CharResult[] answer = {NotFound, NotFound, Correct, WrongPlace, NotFound};
        assertArrayEquals(answer, results);

    }

}