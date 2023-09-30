package klarna;

import com.exercises.klarna.challenge1.Smoothie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmoothieTest {
    @Test
    public void classicSmoothie() {
        assertEquals("banana,honey,mango,peach,pineapple,strawberry",
                Smoothie.ingredients("Classic"));
    }

    @Test
    public void classicSmoothieWithoutStrawberryAndPeanut() {
        assertEquals("banana,honey,mango,peach,pineapple",
                Smoothie.ingredients("Classic,-strawberry,-peanut"));
    }

    @Test
    public void faultyOrder() {
        IllegalArgumentException invalidInput = Assertions.assertThrows(IllegalArgumentException.class, () -> Smoothie.ingredients("   "));
        assertEquals("Order came in either faulty or empty!",
                invalidInput.getMessage());
    }

    @Test()
    public void classSmoothieWithAdditionalMango() {
        IllegalArgumentException invalidInput = Assertions.assertThrows(IllegalArgumentException.class, () -> Smoothie.ingredients("Classic,mango"));

        Assertions.assertEquals("Invalid input", invalidInput.getMessage());
    }
}
