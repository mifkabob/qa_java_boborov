import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class) //вот тут изменения
public class LionTest {
    private final String sex;

    public LionTest(String sex, Feline feline) {
            this.sex = sex;
            this.feline = feline;
        }

    @Mock
    private static Feline feline;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getKittensCorrectValue() throws Exception {
        Lion lion = new Lion(sex, feline);
        int expectedValue = 1;
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualValue = lion.getKittens();
        assertEquals("Value incorrect", expectedValue, actualValue);
    }

    @Test
            (expected = Exception.class)
    public void testConstructorException() throws Exception {
        try {
            Lion lion = new Lion(sex, feline);
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
            throw e;
        }
    }

    @Test
    public void lionGetFood() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> lionsFood = lion.getFood();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lionsFood);
    }



    @Parameterized.Parameters
    public static List<Object[]> lion() {
        return Arrays.asList(new Object[][] {
                {"Самка", feline},
                {"Самец", feline},
                {"Детеныш", feline}
        });
    }
        @Test
        public void lionHasMane() throws Exception {
            Lion lion = new Lion(sex, feline);
            boolean fact = lion.doesHaveMane();
            boolean expect = true;
            assertEquals("Кажется это девочка", expect, fact);
        }
    }

