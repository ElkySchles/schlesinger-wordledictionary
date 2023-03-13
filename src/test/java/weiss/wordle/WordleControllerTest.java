package weiss.wordle;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class WordleControllerTest {

    WordleGame wordleGame = mock(WordleGame.class);
    WordleDictionary dictionary = mock(WordleDictionary.class);
    JLabel labels[][] = new JLabel[][]{
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()},
    };
    JButton keyboard[] = new JButton[]{mock()};
    JButton enter = mock();
    JButton backspace = mock();

    @Test
    void addLetter() {

        //given
        WordleController controller = new WordleController(
                wordleGame,
                dictionary,
                labels,
                keyboard,
                enter,
                backspace
        );
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


}