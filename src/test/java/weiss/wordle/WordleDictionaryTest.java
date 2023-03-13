package weiss.wordle;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;


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


}