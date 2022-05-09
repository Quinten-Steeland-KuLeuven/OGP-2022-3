import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TemperatureTest {

    Temperature temp1;

    @Before
    public void testsBefore() {
        temp1 = new Temperature();
    }

    @Test
    public void testConstructor1() {
        assertEquals(temp1.getColdness() , 0);
        assertEquals(temp1.getHotness() , 0);
        assertEquals(temp1.getTemperature(), new ArrayList<>(Arrays.asList(0, 0)));
    }

    @Test
    public void testConstructor2() {
        Temperature tempLocal1 = new Temperature(10, 50);
        assertEquals(tempLocal1.getColdness() , 10);
        assertEquals(tempLocal1.getHotness() , 0);
        assertEquals(tempLocal1.getTemperature(), new ArrayList<>(Arrays.asList(10, 0)));
    }

    @Test
    public void testConstructor3() {
        Temperature tempLocal1 = new Temperature(1100, 0);
        assertEquals(tempLocal1.getColdness() , 0);
        assertEquals(tempLocal1.getHotness() , 0);
        assertEquals(tempLocal1.getTemperature(), new ArrayList<>(Arrays.asList(0, 0)));
    }

    @Test
    public void testConstructor4() {
        Temperature tempLocal1 = new Temperature(1100, 5000);
        assertEquals(tempLocal1.getColdness() , 0);
        assertEquals(tempLocal1.getHotness() , 0);
        assertEquals(tempLocal1.getTemperature(), new ArrayList<>(Arrays.asList(0, 0)));
    }

    @Test
    public void testConstructor5() {
        Temperature tempLocal1 = new Temperature(50, 40);
        assertEquals(tempLocal1.getColdness() , 0);
        assertEquals(tempLocal1.getHotness() , 40);
        assertEquals(tempLocal1.getTemperature(), new ArrayList<>(Arrays.asList(0, 40)));
    }

}
