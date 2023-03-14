package weiss.wordle;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class WordleControllerTest {

    private final WordleGame wordleGame = mock(WordleGame.class);
    private final WordleDictionary dictionary = mock(WordleDictionary.class);
    private final JLabel labels[][] = new JLabel[][]{
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()},
    };
    private final JButton keyboard[] = new JButton[]{mock()};
    private final JButton enter = mock();
    private final JButton backspace = mock();
    private final WordleController controller = new WordleController(
            wordleGame,
            dictionary,
            labels,
            keyboard,
            enter,
            backspace
    );

    @Test
    void addLetter() {

        //given

        doReturn("").when(labels[0][0]).getText();
        doReturn("").when(labels[0][1]).getText();
        doReturn("").when(labels[0][2]).getText();
        //when
        controller.addLetter("A");
        controller.addLetter("B");
        controller.addLetter("C");
        //then
        Mockito.verify(labels[0][0]).setText("A");
        Mockito.verify(labels[0][1]).setText("B");
        Mockito.verify(labels[0][2]).setText("C");
    }

    @Test
    void enterGuess() {

    }


}