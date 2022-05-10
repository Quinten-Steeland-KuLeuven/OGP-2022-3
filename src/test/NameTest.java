import static org.junit.Assert.*;
import org.junit.*;

public class NameTest {
    Name name1;
    String INVALID_NAMES[] = {"Sh", "To Short T", "Special Ch@r", "no Capital", "No capital", "To ManY CapItal", "Name With", "Mixed Name", "", "      "};
    String VALID_NAMES[] = {"Cor", "Co Rrect", "'co Rrect", "More And More Words"};

    @Before
    public void runBeforeTests() {
        name1 = new Name();
        name1.setSimpleName("Valid Name");
    }

    @Test
    public void TestSetSimpleName() {
        for(String NAME : INVALID_NAMES) {
            assertThrows(IllegalArgumentException.class, () -> {name1.setSimpleName(NAME);});
        }

        for(String NAME: VALID_NAMES) {
            name1.setSimpleName(NAME);
            assertEquals(NAME, name1.getSimpleName());
        }
    }

    @Test
    public void TestSetSpecialName() {
        for(String NAME : INVALID_NAMES) {
            assertThrows(IllegalArgumentException.class, () -> {name1.setSpecialName(NAME);});
        }

        for(String NAME: VALID_NAMES) {
            name1.setSimpleName(NAME);
            assertEquals(NAME, name1.getSpecialName());
        }
    }
}
