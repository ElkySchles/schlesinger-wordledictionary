package weiss.wordle;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        //Given
        WordleDictionary dictionary = Mockito.mock(WordleDictionary.class);
        Set<String> words = new HashSet<>(List.of("APPLE"));
        doReturn(words).when(dictionary).getList();
        //doReturn("").when(dictionary).getList();
        CharResult[] answers = {CharResult.Correct, CharResult.Correct, CharResult.Correct, CharResult.Correct, CharResult.Correct};
        doReturn(answers).when(wordleGame).guess("APPLE");

        //when

        controller.enterGuess();

        //then
        Mockito.verify(labels[0][0]).setBackground(Color.GREEN);
        Mockito.verify(labels[0][1]).setBackground(Color.GREEN);
        Mockito.verify(labels[0][2]).setBackground(Color.GREEN);
        Mockito.verify(labels[0][3]).setBackground(Color.GREEN);
        Mockito.verify(labels[0][4]).setBackground(Color.GREEN);


    }

    @Test
    void backspace() {

        //given

        doReturn("A").when(labels[0][0]).getText();
        doReturn("B").when(labels[0][1]).getText();
        doReturn("C").when(labels[0][2]).getText();
        //when
        controller.backspace();


        //then
        Mockito.verify(labels[0][0]).setText("");
        Mockito.verify(labels[0][1]).setText("");
        Mockito.verify(labels[0][2]).setText("");

    }


}