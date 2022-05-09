import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author  Robbe Vanslambrouck
 * @author  Quinten Steeland
 * @author  Wout Voet
 */

public class IngredientTypeTest {

    IngredientType inTyLiq1;
    IngredientType inTyPow1;

    @Before
    public void runBeforeTests() {
        inTyLiq1 = new IngredientType(new Name(), State.LIQUID, new Temperature(0, 0));
        inTyPow1 = new IngredientType(new Name(), State.POWDER, new Temperature(0, 0));
    }

    @Test
    public void constructorTest1() {
        assertEquals(inTyLiq1.getState(), State.LIQUID);
        assertEquals(inTyLiq1.getTemperature().getTemperature(), new ArrayList<>(Arrays.asList(0, 0)));
    }

}
