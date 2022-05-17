import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Tests for the IngredientType class.
 *
 * @author  Robbe Vanslambrouck
 * @author  Quinten Steeland
 * @author  Wout Voet
 */

public class IngredientTypeTest {

    IngredientType inTyLiq1;
    IngredientType inTyPow1;

    IngredientType NameTest;

    String INVALID_NON_MIXED_NAMES[] = {"Sh", "To Short T", "Special Ch@r", "no Capital",
                                        "No capital", "To ManY CapItal", "Name With", "Mixed Name", "", "      "};
    String VALID_NON_MIXED_NAMES[] = {"Cor", "Co Rrect", "'co Rrect", "More And More Words"};
    String INVALID_MIXED_NAMES[] = {"Water mixed with Cola", "Cola mixed with Sugar and Water, Yogurt", "Cola and Sugar mixed with Water, Yogurt"};
    String VALID_MIXED_NAMES[] = {"Cola mixed with Water", "Cola mixed with Sugar, Water and Yogurt"};

    @Before
    public void runBeforeTests() {
        inTyLiq1 = new IngredientType("Liq", State.LIQUID, new Temperature(0, 0));
        inTyPow1 = new IngredientType("Pow", State.POWDER, new Temperature(0, 0));
        NameTest = new IngredientType("Name", State.LIQUID, new Temperature(0, 0));
    }

    @Test
    public void constructorTest1() {
        assertEquals(inTyLiq1.getState(), State.LIQUID);
        assertEquals(inTyLiq1.getTemperature(), new ArrayList<>(Arrays.asList(0, 0)));
    }

    @Test
    public void constructorTest2() {
        assertEquals(inTyPow1.getState(), State.POWDER);
        assertEquals(inTyPow1.getTemperature(), new ArrayList<>(Arrays.asList(0, 0)));
    }

    @Test
    public void TestSetSimpleName() {
        for(String NAME : INVALID_NON_MIXED_NAMES) {
            assertThrows(IllegalArgumentException.class, () -> {NameTest.setSimpleName(NAME);});
        }

        for(String NAME: VALID_NON_MIXED_NAMES) {
            NameTest.setSimpleName(NAME);
            assertEquals(NAME, NameTest.getSimpleName());
        }
    }

    @Test
    public void TestSetSimpleNameMixed() {
        for(String NAME : INVALID_MIXED_NAMES) {
            System.out.println(NAME);
            assertThrows(IllegalArgumentException.class, () -> {NameTest.setSimpleNameMixed(NAME);});
        }

        for(String NAME: VALID_MIXED_NAMES) {
            NameTest.setSimpleNameMixed(NAME);
            assertEquals(NAME, NameTest.getSimpleName());
        }
    }

    @Test
    public void TestSetSpecialName() {
        for(String NAME : INVALID_NON_MIXED_NAMES) {
            assertThrows(IllegalArgumentException.class, () -> {NameTest.setSpecialName(NAME);});
        }

        for(String NAME: VALID_NON_MIXED_NAMES) {
            NameTest.setSpecialName(NAME);
            assertEquals(NAME, NameTest.getSpecialName());
        }
    }

}
