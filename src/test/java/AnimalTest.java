import com.example.Feline;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    @Test
    public void eatMeatReturnsGetFood() throws Exception {
        Feline feline = new Feline();
        String expectedReturn = "[Животные, Птицы, Рыба]";
        String actualReturn = feline.eatMeat().toString();

        assertEquals("Animal kind is incorrect", expectedReturn, actualReturn);

    }

    @Test
    public void getFamilyReturnsFeline() {
        Feline feline = new Feline();
        String expectedReturn = "Кошачьи";
        String actualReturn = feline.getFamily();

        assertEquals("Must return Feline", expectedReturn, actualReturn);

    }

    @Test
    public void getKittensReturnsGetKittens() {
        Feline feline = new Feline();
        int expectedReturn = 1;
        int actualReturn = feline.getKittens();

        assertEquals("Must return 1", expectedReturn, actualReturn);

    }

    @Test
    public void getKittensReturnsKittenCount() {
        Feline feline = new Feline();
        int expectedReturn = 3;
        int actualReturn = feline.getKittens(3);

        assertEquals("Must return kittens count", expectedReturn, actualReturn);

    }
}
