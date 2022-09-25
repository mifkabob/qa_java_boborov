import com.example.Lion;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void isDoesHaveManeTrue() throws Exception {
        Lion lion = new Lion("Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void isDoesHaveManeFalse() throws Exception {
        Lion lion = new Lion("Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void isDoesHaveManeThrowsException() throws Exception {
        Lion lion = new Lion("Капибара");
        String message = "Используйте допустимые значения пола животного - самец или самка";
        Exception thrown = assertThrows(Exception.class, () -> {
            throw new Exception(message);
        });
        assertEquals(thrown, lion.doesHaveMane());
    }

    @Test
    public void isLionGetKittensCallsFeline() {
        MockitoAnnotations.openMocks(this);
        Lion lion = new Lion(feline);
        Mockito.when(feline.getKittens()).thenReturn(666);
        int kittens = lion.getKittens();
        assertEquals(666, kittens);
    }

    @Test
    public void isGetFoodCallsFeline() throws Exception {
        MockitoAnnotations.openMocks(this);
        List<String> amazingList = List.of("bobr", "gus", "fish");
        Lion lion = new Lion(feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(amazingList);
        List<String> food = lion.getFood();
        assertEquals(amazingList, food);
    }
}