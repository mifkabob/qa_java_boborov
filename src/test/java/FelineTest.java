import com.example.Animal;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    private Animal animal;


    @Test
    public void felineGetKittensDefaultNumberTest() {
        Feline feline = new Feline();
        assertEquals("Количество котят по умолчанию не равно 2", 1, feline.getKittens());
    }

    @Test
    public void felineGetKittensCustomNumberTest() {
        Feline feline = new Feline();
        assertEquals("values do not match", 10, feline.getKittens(10));
    }

    @Test
    public void felineGetFamilyTest() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void felineEatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> felineEats = feline.eatMeat();
        assertEquals("values do not match", expectedFood, felineEats);
    }
}
