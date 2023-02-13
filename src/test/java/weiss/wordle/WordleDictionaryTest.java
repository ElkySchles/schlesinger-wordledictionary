package weiss.wordle;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class WordleDictionaryTest {
    @Test
    public void getDefinition() throws FileNotFoundException {

        WordleDictionary wordle = new WordleDictionary();

        String actual = wordle.getDefinition("AA");

        assertEquals("rough, cindery lava [n -S]", actual);

    }
    @Test
    public void getList() throws FileNotFoundException {

        WordleDictionary wordle = new WordleDictionary();

        int total = wordle.getList().size();

        assertEquals(167964, total);

    }

}